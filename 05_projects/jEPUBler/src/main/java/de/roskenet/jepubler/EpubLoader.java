package de.roskenet.jepubler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EpubLoader {

    public EpubBook load(Path epubPath) throws IOException {
        Map<String, byte[]> extractedFiles = new HashMap<>();

        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(epubPath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                zis.transferTo(out);
                extractedFiles.put(entry.getName(), out.toByteArray());
            }
        }

        return new EpubBook(epubPath, extractedFiles);
    }
}
