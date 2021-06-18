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
public class AreaAnnotator extends Annotator {

    public AreaAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // initiate AnnotationInfo object
        AnnotationInfo areaAnnotation = initAnnotationInfo();
        // set annotation X, Y position
        areaAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        // add replies
        return areaAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        return initAnnotationInfo();
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        return initAnnotationInfo();
    }

    @Override
    public AnnotationInfo annotateDiagram() throws ParseException {
        return initAnnotationInfo();
    }

    @Override
    protected byte getType() {
        return AnnotationType.Area;
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }
}