package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.*;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

/**
 * AreaAnnotator
 * Annotates documents with the area annotation
 *
 * @author Aspose Pty Ltd
 */
public class ResourceRedactionAnnotator extends Annotator {

    public ResourceRedactionAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        AnnotationInfo resourceRedactionAnnotation = initAnnotationInfo();
        return resourceRedactionAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // initiate AnnotationInfo object
        AnnotationInfo resourceRedactionAnnotation = initAnnotationInfo();
        // set annotation X, Y position
        resourceRedactionAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        return resourceRedactionAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        AnnotationInfo resourceRedactionAnnotation = initAnnotationInfo();
        return resourceRedactionAnnotation;
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        AnnotationInfo resourceRedactionAnnotation = initAnnotationInfo();
        return resourceRedactionAnnotation;
    }

    @Override
    public AnnotationInfo annotateDiagram() throws ParseException {
        // init annotation object
        AnnotationInfo resourceRedactionAnnotation = initAnnotationInfo();
        return resourceRedactionAnnotation;
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

    @Override
    protected byte getType() {
        return AnnotationType.ResourcesRedaction;
    }
}