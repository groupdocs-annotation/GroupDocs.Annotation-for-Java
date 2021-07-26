package com.groupdocs.ui.annotation.util;

import com.groupdocs.annotation.entity.Annotations;

public class SupportedAnnotations {

    public static final String[] getSupportedAnnotations(String documentType) {
        Annotations annotations = new Annotations();
        switch (documentType) {
            case "Portable Document Format":
            case "PDF":
                return annotations.Pdf;
            case "Microsoft Word":
            case "WORDS":
                return annotations.Word;
            case "Microsoft PowerPoint":
            case "SLIDES":
                return annotations.Slides;
            case "image":
                return annotations.Image;
            case "Microsoft Excel":
            case "CELLS":
                return annotations.Cells;
            case "AutoCAD Drawing File Format":
            case "diagram":
                return annotations.Diagram;
            default:
                return annotations.Pdf;
        }
    }
}