package de.roskenet.vocabbook.commands;

import de.roskenet.vocabbook.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.util.List;

/**
 * Shell commands for handling EPUB files.
 */
@ShellComponent
public class EpubCommands {

    private final Publication publication;

    @Autowired
    public EpubCommands(Publication publication) {
        this.publication = publication;
    }

    /**
     * Opens an EPUB file and loads it into memory.
     *
     * @param filePath Path to the EPUB file
     * @return Status message
     */
    @ShellMethod(key = "open-epub", value = "Open an EPUB file")
    public String openEpub(@ShellOption(help = "Path to the EPUB file") String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return "Error: File not found: " + filePath;
        }

        if (!file.isFile()) {
            return "Error: Not a file: " + filePath;
        }

        if (!filePath.toLowerCase().endsWith(".epub")) {
            return "Error: Not an EPUB file: " + filePath;
        }

        boolean success = publication.loadEpub(filePath);

        if (success) {
            return "Successfully opened EPUB: " + filePath;
        } else {
            return "Error: Failed to open EPUB: " + filePath;
        }
    }

    /**
     * Lists all files contained in the currently loaded EPUB.
     *
     * @return List of files or error message
     */
    @ShellMethod(key = "list-epub-files", value = "List files in the currently loaded EPUB")
    public String listEpubFiles() {
        if (!publication.isLoaded()) {
            return "Error: No EPUB file is currently loaded. Use 'open-epub' command first.";
        }

        List<String> files = publication.getFiles();

        if (files.isEmpty()) {
            return "No files found in the EPUB.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Files in ").append(publication.getFilePath()).append(":\n");

        for (int i = 0; i < files.size(); i++) {
            result.append(i + 1).append(". ").append(files.get(i)).append("\n");
        }

        return result.toString();
    }

    /**
     * Sanitizes the currently loaded EPUB file by:
     * 1. Cleaning up all XHTML files and removing unneeded tags and styles
     * 2. Replacing original CSS files with a clean, standard CSS for English language novels
     * 3. Adding a unique random ID to every paragraph (5 chars, alphanumeric with upper and lowercase letters)
     *
     * @return Status message
     */
    @ShellMethod(key = "sanitize", value = "Sanitize the currently loaded EPUB file")
    public String sanitizeEpub() {
        if (!publication.isLoaded()) {
            return "Error: No EPUB file is currently loaded. Use 'open-epub' command first.";
        }

        boolean success = publication.sanitize();

        if (success) {
            String originalPath = publication.getFilePath();
            String sanitizedPath = originalPath.replace(".epub", "_sanitized.epub");
            return "Successfully sanitized EPUB. Sanitized file saved as: " + sanitizedPath;
        } else {
            return "Error: Failed to sanitize EPUB.";
        }
    }

    /**
     * Saves the currently loaded EPUB file with a new name (original name + "_processed.epub").
     *
     * @return Status message
     */
    @ShellMethod(key = "save-epub", value = "Save the currently loaded EPUB file with a new name")
    public String saveEpub() {
        if (!publication.isLoaded()) {
            return "Error: No EPUB file is currently loaded. Use 'open-epub' command first.";
        }

        boolean success = publication.saveProcessedEpub();

        if (success) {
            String originalPath = publication.getFilePath();
            String processedPath = originalPath.replace(".epub", "_processed.epub");
            return "Successfully saved EPUB. File saved as: " + processedPath;
        } else {
            return "Error: Failed to save EPUB.";
        }
    }
}
