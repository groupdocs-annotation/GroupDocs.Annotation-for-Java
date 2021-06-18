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
public class TextAnnotator extends AbstractSvgAnnotator {

    public TextAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = initAnnotationInfo();
        return textAnnotation;
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo textAnnotation = super.initAnnotationInfo();
        textAnnotation.setGuid(String.valueOf(annotationData.getId()));
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = initAnnotationInfo();
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = super.initAnnotationInfo();
        textAnnotation.setPageNumber(annotationData.getPageNumber());
        textAnnotation.setAnnotationPosition(new Point(1, 1));
        textAnnotation.setBox(new Rectangle(0, 0, 0, 0));
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = initAnnotationInfo();
        textAnnotation.getBox().setX((float) (annotationData.getLeft() / 4));
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        return initAnnotationInfo();
    }

    @Override
    public AnnotationInfo annotateDiagram() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

    @Override
    protected byte getType() {
        return AnnotationType.Text;
    }
}