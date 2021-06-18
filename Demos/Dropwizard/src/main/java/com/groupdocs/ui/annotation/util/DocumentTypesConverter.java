package com.groupdocs.ui.annotation.util;

import com.groupdocs.annotation.domain.DocumentType;

/**
 * Converter for document types
 */
public class DocumentTypesConverter {
    /**
     * Convert document type from string into int
     *
     * @param documentType string value of document type
     * @return int doc type
     */
    public static final int getDocumentType(String documentType) {
        switch (documentType) {
            case "Portable Document Format":
            case "PDF":
                return DocumentType.Pdf;
            case "Microsoft Word":
            case "WORDS":
                return DocumentType.Words;
            case "Microsoft PowerPoint":
            case "SLIDES":
                return DocumentType.Slides;
            case "image":
                return DocumentType.Images;
            case "Microsoft Excel":
            case "CELLS":
                return DocumentType.Cells;
            case "AutoCAD Drawing File Format":
            case "diagram":
                return DocumentType.Diagram;
            default:
                return DocumentType.Undefined;
        }
    }
}