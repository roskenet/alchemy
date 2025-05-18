package de.roskenet.jepubler;

import java.nio.file.Path;
import java.util.Map;

public class EpubBook {

    private final Path sourcePath;
    private final Map<String, byte[]> fileMap;

    public EpubBook(Path sourcePath, Map<String, byte[]> fileMap) {
        this.sourcePath = sourcePath;
        this.fileMap = fileMap;
    }

    public byte[] getFile(String path) {
        return fileMap.get(path);
    }

    public Map<String, byte[]> getAllFiles() {
        return fileMap;
    }

    public Path getSourcePath() {
        return sourcePath;
    }
}
