package com.groupdocs.ui.annotation.importer;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.handler.AnnotationImageHandler;

import java.io.InputStream;

/**
 * Importer
 *
 * @author Aspose Pty Ltd
 */
public class Importer {
    protected InputStream documentStream;
    protected AnnotationImageHandler annotator;

    /**
     * Constructor
     *
     * @param documentStream
     */
    public Importer(InputStream documentStream, AnnotationImageHandler annotator) {
        this.documentStream = documentStream;
        this.annotator = annotator;
    }

    /**
     * Import the annotations from document
     *
     * @param docType the type of document
     * @return AnnotationInfo[] list of annotations
     */
    public AnnotationInfo[] importAnnotations(int docType) {
        AnnotationInfo[] annotations = annotator.importAnnotations(documentStream, docType);
        return annotations;
    }

}
