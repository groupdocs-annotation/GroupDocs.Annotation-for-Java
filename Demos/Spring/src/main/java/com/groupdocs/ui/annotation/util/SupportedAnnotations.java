package com.groupdocs.ui.annotation.util;

/**
 * The list of supported annotation types for each document type
 */
public class SupportedAnnotations {
    public static String[] CELLS = {
            "text"
    };
    public static String[] DIAGRAM = {
            "area",
            "point",
            "polyline",
            "textField",
            "arrow",
            "textRedaction",
            "resourcesRedaction",
            "distance"
    };
    public static String[] WORD = {
            "point",
            "textStrikeout",
            "polyline",
            "textField",
            "watermark",
            "textReplacement",
            "arrow",
            "textRedaction",
            "resourcesRedaction",
            "textUnderline",
            "distance",
            "text"
    };
    public static String[] PDF = {
            "area",
            "point",
            "textStrikeout",
            "polyline",
            "textField",
            "watermark",
            "textReplacement",
            "arrow",
            "textRedaction",
            "resourcesRedaction",
            "textUnderline",
            "distance",
            "text"
    };
    public static String[] IMAGE = {
            "area",
            "point",
            "textStrikeout",
            "polyline",
            "textField",
            "watermark",
            "arrow",
            "textRedaction",
            "resourcesRedaction",
            "textUnderline",
            "distance",
            "text"
    };
    public static String[] SLIDES = {
            "area",
            "point",
            "textStrikeout",
            "polyline",
            "textField",
            "watermark",
            "arrow",
            "textRedaction",
            "resourcesRedaction",
            "textUnderline",
            "text"
    };

    public static String[] getSupportedAnnotations(String documentType) {
        switch (documentType) {
            case "Portable Document Format":
            case "PDF":
                return PDF;
            case "Microsoft Word":
            case "WORDS":
                return WORD;
            case "Microsoft PowerPoint":
            case "SLIDES":
                return SLIDES;
            case "image":
                return IMAGE;
            case "Microsoft Excel":
            case "CELLS":
                return CELLS;
            case "AutoCAD Drawing File Format":
            case "diagram":
                return DIAGRAM;
            default:
                return PDF;
        }
    }
}
