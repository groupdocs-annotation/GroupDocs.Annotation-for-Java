package com.groupdocs.ui.annotation.util;

import java.util.HashMap;
import java.util.Map;

/**
 * AnnotationTypes
 * Contains all annotations types
 *
 * @author Aspose Pty Ltd
 */
public class AnnotationTypes {

    /**
     * Map annotation types from byte into string
     */
    private static final Map<Byte, String> types = new HashMap<>();

    // init map values
    {
        types.put((byte) 0, "text");
        types.put((byte) 1, "area");
        types.put((byte) 2, "point");
        types.put((byte) 3, "textStrikeout");
        types.put((byte) 4, "polyline");
        types.put((byte) 5, "textField");
        types.put((byte) 6, "watermark");
        types.put((byte) 7, "textReplacement");
        types.put((byte) 8, "arrow");
        types.put((byte) 9, "textRedaction");
        types.put((byte) 10, "resourcesRedaction");
        types.put((byte) 11, "textUnderline");
        types.put((byte) 12, "distance");
    }

    /**
     * Instance of AnnotationTypes
     */
    public static final AnnotationTypes instance = new AnnotationTypes();

    /**
     * Private constructor, for using only in this class
     */
    private AnnotationTypes() {
    }

    /**
     * Get string value of annotation type
     *
     * @param type byte value of annotation type
     * @return string value of annotation type
     */
    public String getAnnotationType(byte type) {
        return types.get(type);
    }
}

