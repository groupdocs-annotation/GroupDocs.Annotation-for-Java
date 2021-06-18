package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

/**
 * TextAnnotator
 * Annotates documents with the text annotation
 *
 * @author Aspose Pty Ltd
 */
public class TextReplacementAnnotator extends AbstractSvgAnnotator {

    public TextReplacementAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textReplacementAnnotation = initAnnotationInfo();
        return textReplacementAnnotation;
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo textReplacementAnnotation = super.initAnnotationInfo();
        textReplacementAnnotation.setGuid(String.valueOf(annotationData.getId()));
        textReplacementAnnotation.setFieldText(annotationData.getText());
        return textReplacementAnnotation;
    }

    @Override
    protected String buildSvgPath() {
        double topPosition = pageData.getHeight() - annotationData.getTop();
        double leftPosition = pageData.getWidth() - annotationData.getLeft();
        double topRightX = annotationData.getLeft() + annotationData.getWidth();
        double bottomRightY = topPosition - annotationData.getHeight();
        return super.getSvgString(topPosition, leftPosition, topRightX, bottomRightY);
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textReplacementAnnotation = initAnnotationInfo();
        textReplacementAnnotation.setBox(new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight()));
        return textReplacementAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateImage() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateDiagram() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(0, 0, 0, 0);
    }

    @Override
    protected byte getType() {
        return AnnotationType.TextReplacement;
    }
}