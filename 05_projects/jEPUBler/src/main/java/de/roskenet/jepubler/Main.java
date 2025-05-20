package de.roskenet.jepubler;

import java.nio.file.Path;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        EpubLoader loader = new EpubLoader();
        EpubBook book = loader.load(Path.of("/home/felix/Desktop/epub/Fahrenheit451.epub"));

        System.out.println("Dateien im EPUB:");
        book.getAllFiles().keySet().forEach(System.out::println);

        // Extract and display metadata
        System.out.println("\nMetadaten aus content.opf:");
        EpubMetadataExtractor metadataExtractor = new EpubMetadataExtractor();
        try {
            Map<String, String> metadata = metadataExtractor.extractMetadata(book);
            metadata.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (Exception e) {
            System.err.println("Fehler beim Extrahieren der Metadaten: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
