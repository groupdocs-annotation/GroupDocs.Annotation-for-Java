package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.*;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

/**
 * TextAnnotator
 * Annotates documents with the text annotation
 *
 * @author Aspose Pty Ltd
 */
public class PointAnnotator extends Annotator {

    public PointAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        return initAnnotationInfo();
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        return initAnnotationInfo();
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        // init annotation object
        AnnotationInfo pointAnnotation = super.initAnnotationInfo();
        // set annotation position
        pointAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        return pointAnnotation;
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
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

    @Override
    protected byte getType() {
        return AnnotationType.Point;
    }
}