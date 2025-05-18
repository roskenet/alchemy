package de.roskenet.vocabbook.model;

import com.github.mertakdut.Reader;
import com.github.mertakdut.exception.ReadingException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Class that represents an EPUB publication loaded in memory.
 */
@Component
public class Publication {
    private Reader epubReader;
    private String filePath;
    private boolean isLoaded = false;
    private String title;
    private String author;
    private static final String CLEAN_CSS = "body { font-family: 'Georgia', serif; line-height: 1.5; margin: 2em; }\n" +
            "h1, h2, h3, h4, h5, h6 { font-family: 'Arial', sans-serif; margin-top: 1em; margin-bottom: 0.5em; }\n" +
            "p { margin-top: 0.5em; margin-bottom: 0.5em; text-align: justify; }\n" +
            "a { color: #0066cc; text-decoration: none; }\n" +
            "a:hover { text-decoration: underline; }\n" +
            "img { max-width: 100%; }\n" +
            ".chapter { margin-top: 2em; }\n" +
            ".footnote { font-size: 0.9em; color: #666; }\n";

    /**
     * Loads an EPUB file into memory.
     *
     * @param filePath Path to the EPUB file
     * @return true if the file was loaded successfully, false otherwise
     */
    public boolean loadEpub(String filePath) {
        try {
            this.filePath = filePath;
            this.epubReader = new Reader();
            this.epubReader.setFullContent(filePath);

            // Set default metadata values
            this.title = "Unknown Title";
            this.author = "Unknown Author";

            // Try to extract metadata from the EPUB file
            extractMetadata();

            this.isLoaded = true;
            return true;
        } catch (ReadingException e) {
            this.isLoaded = false;
            return false;
        }
    }

    /**
     * Extracts metadata (title and author) from the EPUB file.
     * This method attempts to parse the OPF file to find the metadata.
     */
    private void extractMetadata() {
        try {
            // Get the list of files in the EPUB
            List<String> files = getFiles();

            // Look for the OPF file (content.opf or package.opf)
            String opfFile = null;
            for (String file : files) {
                if (file.toLowerCase().endsWith(".opf")) {
                    opfFile = file;
                    break;
                }
            }

            if (opfFile != null) {
                // Extract the OPF file content
                try (ZipFile zipFile = new ZipFile(filePath)) {
                    ZipEntry entry = zipFile.getEntry(opfFile);
                    if (entry != null) {
                        try (InputStream is = zipFile.getInputStream(entry)) {
                            // Parse the OPF file as XML
                            Document doc = Jsoup.parse(is, "UTF-8", "", org.jsoup.parser.Parser.xmlParser());

                            // Extract title
                            Element titleElement = doc.select("metadata > dc\\:title").first();
                            if (titleElement != null && !titleElement.text().isEmpty()) {
                                this.title = titleElement.text();
                            }

                            // Extract author
                            Element authorElement = doc.select("metadata > dc\\:creator").first();
                            if (authorElement != null && !authorElement.text().isEmpty()) {
                                this.author = authorElement.text();
                            }
                        }
                    }
                }
            }

            // If we couldn't extract the metadata, use the filename as a fallback for the title
            if ("Unknown Title".equals(this.title)) {
                File file = new File(filePath);
                this.title = file.getName().replace(".epub", "");
            }
        } catch (Exception e) {
            // If metadata extraction fails, we'll use the default values
            e.printStackTrace();
        }
    }

    /**
     * Checks if an EPUB file is currently loaded.
     *
     * @return true if an EPUB file is loaded, false otherwise
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * Gets the path of the currently loaded EPUB file.
     *
     * @return the file path or null if no file is loaded
     */
    public String getFilePath() {
        return isLoaded ? filePath : null;
    }

    /**
     * Gets the list of files contained in the EPUB.
     *
     * @return List of file paths in the EPUB or empty list if no EPUB is loaded
     */
    public List<String> getFiles() {
        if (!isLoaded) {
            return new ArrayList<>();
        }

        List<String> files = new ArrayList<>();

        try (ZipFile zipFile = new ZipFile(filePath)) {
            // EPUB files are essentially ZIP files, so we can read them as such
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            // Iterate through all entries in the ZIP file
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (!entry.isDirectory()) {
                    files.add(entry.getName());
                }
            }

            return files;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Generates a random ID consisting of 5 characters (numbers and upper/lowercase letters).
     *
     * @return A random 5-character ID
     */
    private String generateRandomId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder id = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            id.append(characters.charAt(index));
        }

        return id.toString();
    }

    /**
     * Cleans up an XHTML file by removing unnecessary tags and styles.
     *
     * @param xhtmlContent The content of the XHTML file
     * @return The cleaned up XHTML content with random IDs added to paragraphs
     */
    private String cleanupXhtml(String xhtmlContent) {
        Document doc = Jsoup.parse(xhtmlContent, "", org.jsoup.parser.Parser.xmlParser());

        // Remove all style attributes
        doc.select("[style]").removeAttr("style");

        // Remove all class attributes except for specific ones we want to keep
        Elements elementsWithClass = doc.select("[class]");
        for (Element element : elementsWithClass) {
            String classValue = element.attr("class");
            if (!classValue.equals("chapter") && !classValue.equals("footnote")) {
                element.removeAttr("class");
            }
        }

        // Add random IDs to paragraphs
        Elements paragraphs = doc.select("p");
        for (Element paragraph : paragraphs) {
            paragraph.attr("id", generateRandomId());
        }

        // Preserve the XML declaration and doctype
        String xmlDeclaration = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
        String doctype = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">";

        return xmlDeclaration + "\n" + doctype + "\n" + doc.outerHtml();
    }

    /**
     * Creates a basic title page with just title and author.
     *
     * @return The XHTML content for a basic title page
     */
    private String createBasicTitlePage() {
        // Create a new XHTML document
        Document doc = Jsoup.parse("", "", org.jsoup.parser.Parser.xmlParser());
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);

        // Add html element
        Element html = doc.appendElement("html");
        html.attr("xmlns", "http://www.w3.org/1999/xhtml");

        // Add head element
        Element head = html.appendElement("head");
        head.appendElement("title").text(title);
        head.appendElement("meta").attr("name", "generator").attr("content", "Bookmaker");
        head.appendElement("meta").attr("http-equiv", "Content-Type").attr("content", "application/xhtml+xml; charset=utf-8");

        // Add body element
        Element body = html.appendElement("body");

        // Add title and author
        Element titleDiv = body.appendElement("div").attr("style", "text-align: center; margin-top: 20%");
        titleDiv.appendElement("h1").text(title);
        titleDiv.appendElement("h2").text("by");
        titleDiv.appendElement("h2").text(author);

        // Preserve the XML declaration and doctype
        String xmlDeclaration = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
        String doctype = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">";

        return xmlDeclaration + "\n" + doctype + "\n" + doc.outerHtml();
    }

    /**
     * Checks if an XHTML file is likely to be a title page.
     *
     * @param entryName The name of the file
     * @param content The content of the file
     * @return true if the file is likely to be a title page, false otherwise
     */
    private boolean isTitlePage(String entryName, String content) {
        // Check if the filename contains indicators of a title page
        String lowerName = entryName.toLowerCase();
        if (lowerName.contains("title") || lowerName.contains("cover") || lowerName.contains("titlepage")) {
            return true;
        }

        // Parse the content and check for title page indicators
        Document doc = Jsoup.parse(content, "", org.jsoup.parser.Parser.xmlParser());

        // Check if the document contains the book title
        if (!title.equals("Unknown Title") && doc.text().contains(title)) {
            // If it contains the title and is a short document, it's likely a title page
            if (doc.text().length() < 1000) {
                return true;
            }
        }

        // Check for common title page elements
        if (doc.select("title").size() > 0 && doc.select("body").text().length() < 500) {
            return true;
        }

        return false;
    }

    /**
     * Sanitizes the EPUB file by cleaning up XHTML files, replacing CSS, adding random IDs to paragraphs,
     * and replacing the original title page with a basic one.
     *
     * @return true if the sanitization was successful, false otherwise
     */
    public boolean sanitize() {
        if (!isLoaded) {
            return false;
        }

        try {
            // Create a temporary directory to extract and modify the EPUB
            Path tempDir = Files.createTempDirectory("epub_sanitize_");

            // Flag to track if we've replaced a title page
            boolean titlePageReplaced = false;

            // Path to store the title page if we need to create one
            Path titlePagePath = null;

            // Extract the EPUB (ZIP) file
            try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(filePath))) {
                ZipEntry entry;
                while ((entry = zipIn.getNextEntry()) != null) {
                    String entryName = entry.getName();
                    Path filePath = tempDir.resolve(entryName);

                    // Create directories if needed
                    if (entry.isDirectory()) {
                        Files.createDirectories(filePath);
                    } else {
                        // Create parent directories if they don't exist
                        Files.createDirectories(filePath.getParent());

                        // Extract the file
                        Files.copy(zipIn, filePath, StandardCopyOption.REPLACE_EXISTING);

                        // Process XHTML files
                        if (entryName.toLowerCase().endsWith(".xhtml") || entryName.toLowerCase().endsWith(".html")) {
                            String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);

                            // Check if this is a title page
                            if (!titlePageReplaced && isTitlePage(entryName, content)) {
                                // Replace with our basic title page
                                String basicTitlePage = createBasicTitlePage();
                                Files.write(filePath, basicTitlePage.getBytes(StandardCharsets.UTF_8));
                                titlePageReplaced = true;
                            } else {
                                // Regular cleanup for non-title pages
                                String cleanedContent = cleanupXhtml(content);
                                Files.write(filePath, cleanedContent.getBytes(StandardCharsets.UTF_8));
                            }

                            // If this is the first XHTML file and we haven't found a title page yet,
                            // remember it as a potential location to add our title page
                            if (!titlePageReplaced && titlePagePath == null) {
                                titlePagePath = filePath;
                            }
                        }

                        // Replace CSS files
                        if (entryName.toLowerCase().endsWith(".css")) {
                            Files.write(filePath, CLEAN_CSS.getBytes(StandardCharsets.UTF_8));
                        }
                    }
                }
            }

            // If we didn't find and replace a title page, create one at the remembered location
            if (!titlePageReplaced && titlePagePath != null) {
                String basicTitlePage = createBasicTitlePage();
                Files.write(titlePagePath, basicTitlePage.getBytes(StandardCharsets.UTF_8));
            }

            // Create a new sanitized EPUB file
            String sanitizedFilePath = filePath.replace(".epub", "_sanitized.epub");
            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(sanitizedFilePath))) {
                Files.walk(tempDir)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        try {
                            String entryName = tempDir.relativize(path).toString().replace("\\", "/");
                            zipOut.putNextEntry(new ZipEntry(entryName));
                            Files.copy(path, zipOut);
                            zipOut.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            }

            // Clean up the temporary directory
            Files.walk(tempDir)
                .sorted(Comparator.reverseOrder())
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saves the EPUB file with a new name (original name + "_processed.epub").
     *
     * @return true if the save was successful, false otherwise
     */
    public boolean saveProcessedEpub() {
        if (!isLoaded) {
            return false;
        }

        try {
            // Create a temporary directory to extract the EPUB
            Path tempDir = Files.createTempDirectory("epub_save_");

            // Extract the EPUB (ZIP) file
            try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(filePath))) {
                ZipEntry entry;
                while ((entry = zipIn.getNextEntry()) != null) {
                    String entryName = entry.getName();
                    Path filePath = tempDir.resolve(entryName);

                    // Create directories if needed
                    if (entry.isDirectory()) {
                        Files.createDirectories(filePath);
                    } else {
                        // Create parent directories if they don't exist
                        Files.createDirectories(filePath.getParent());

                        // Extract the file
                        Files.copy(zipIn, filePath, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }

            // Create a new processed EPUB file
            String processedFilePath = filePath.replace(".epub", "_processed.epub");
            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(processedFilePath))) {
                Files.walk(tempDir)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        try {
                            String entryName = tempDir.relativize(path).toString().replace("\\", "/");
                            zipOut.putNextEntry(new ZipEntry(entryName));
                            Files.copy(path, zipOut);
                            zipOut.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            }

            // Clean up the temporary directory
            Files.walk(tempDir)
                .sorted(Comparator.reverseOrder())
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
