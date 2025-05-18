package de.roskenet.vocabbook.model;

import com.github.mertakdut.Reader;
import com.github.mertakdut.exception.ReadingException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Class that represents an EPUB publication loaded in memory.
 */
@Component
public class Publication {
    private Reader epubReader;
    private String filePath;
    private boolean isLoaded = false;

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
            this.isLoaded = true;
            return true;
        } catch (ReadingException e) {
            this.isLoaded = false;
            return false;
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
}
