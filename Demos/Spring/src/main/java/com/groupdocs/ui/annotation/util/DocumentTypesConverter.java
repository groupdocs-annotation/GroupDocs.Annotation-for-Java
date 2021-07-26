package com.groupdocs.ui.annotation.util;

import com.groupdocs.annotation.models.DocumentType;
import java.util.List;
import com.google.common.collect.Lists;
import static com.groupdocs.ui.util.Utils.parseFileExtension;

public class DocumentTypesConverter {

    private static final List<String> supportedImageFormats = Lists.newArrayList("bmp", "jpeg", "jpg", "tiff", "tif", "png", "gif", "emf", "wmf", "dwg", "dicom", "djvu");
    private static final List<String> supportedDiagramFormats = Lists.newArrayList(".vsd", ".vdx", ".vss", ".vsx", ".vst", ".vtx", ".vsdx", ".vdw", ".vstx", ".vssx");
    
    /**
     * <p>
     * Convert document type from string into int
     * </p>
     *
     * @return int
     * @param documentType string
     */
    public static int getDocumentType(String documentType) {
        switch (documentType) {
            case "Portable Document Format":
            case "PDF":
                return DocumentType.Pdf;
            case "Microsoft Word":
            case "WORDS":
            case "Microsoft Word Open XML format (.docx)":
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
    
    /**
     * Check image and diagram document types
     *
     * @param documentGuid document name
     * @param documentType string value of document type
     * @return correct document type
     */
    public static String checkedDocumentType(String documentGuid, String documentType) {
        String fileExtension = parseFileExtension(documentGuid);
        // check if document type is image
        if (supportedImageFormats.contains(fileExtension)) {
            documentType = "image";
        } else if (supportedDiagramFormats.contains(fileExtension)) {
            documentType = "diagram";
        }
        return documentType;
    }
}