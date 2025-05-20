package de.roskenet.jepubler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class EpubMetadataExtractor {

    private static final String DUBLIN_CORE_NAMESPACE = "http://purl.org/dc/elements/1.1/";
    private static final String CONTENT_OPF_PATH = "OEBPS/content.opf";

    /**
     * Extracts metadata from the content.opf file of an EPUB book.
     * 
     * @param book The EPUB book containing the content.opf file
     * @return A map of metadata key-value pairs
     * @throws Exception If there is an error parsing the content.opf file
     */
    public Map<String, String> extractMetadata(EpubBook book) throws Exception {
        Map<String, String> metadata = new HashMap<>();

        // Find the content.opf file
        byte[] contentOpfData = findContentOpfFile(book);
        if (contentOpfData == null) {
            throw new IllegalArgumentException("content.opf file not found in EPUB");
        }

        // Parse the content.opf file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // Enable namespace awareness
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new ByteArrayInputStream(contentOpfData)));

        // Extract metadata elements
        NodeList metadataNodes = doc.getElementsByTagName("metadata");
        if (metadataNodes.getLength() > 0) {
            Element metadataElement = (Element) metadataNodes.item(0);

            // Extract Dublin Core elements
            extractDublinCoreElement(metadataElement, "title", metadata);
            extractDublinCoreElement(metadataElement, "creator", metadata);
            extractDublinCoreElement(metadataElement, "language", metadata);
            extractDublinCoreElement(metadataElement, "identifier", metadata);
            extractDublinCoreElement(metadataElement, "publisher", metadata);
            extractDublinCoreElement(metadataElement, "date", metadata);
        }

        return metadata;
    }

    /**
     * Extracts a Dublin Core element from the metadata element and adds it to the metadata map.
     * 
     * @param metadataElement The metadata element containing Dublin Core elements
     * @param elementName The name of the Dublin Core element to extract
     * @param metadata The map to add the extracted metadata to
     */
    private void extractDublinCoreElement(Element metadataElement, String elementName, Map<String, String> metadata) {
        // Try with namespace
        NodeList elements = metadataElement.getElementsByTagNameNS(DUBLIN_CORE_NAMESPACE, elementName);

        // If not found with namespace, try without namespace
        if (elements.getLength() == 0) {
            elements = metadataElement.getElementsByTagName("dc:" + elementName);
        }

        // Extract the text content of each element
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            String value = element.getTextContent();

            // If there are multiple elements with the same name, append an index
            if (i == 0) {
                metadata.put(elementName, value);
            } else {
                metadata.put(elementName + "_" + i, value);
            }
        }
    }

    /**
     * Finds the content.opf file in the EPUB book.
     * 
     * @param book The EPUB book to search in
     * @return The content of the content.opf file, or null if not found
     */
    private byte[] findContentOpfFile(EpubBook book) {
        // First try the standard path
        byte[] contentOpf = book.getFile(CONTENT_OPF_PATH);

        // If not found, search through all files
        if (contentOpf == null) {
            for (String path : book.getAllFiles().keySet()) {
                if (path.endsWith("content.opf")) {
                    return book.getFile(path);
                }
            }
        }

        return contentOpf;
    }
}
