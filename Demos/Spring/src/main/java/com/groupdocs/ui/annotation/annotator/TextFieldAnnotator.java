package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

/**
 * TextAnnotator
 * Annotates documents with the text annotation
 *
 * @author Aspose Pty Ltd
 */
public class TextFieldAnnotator extends AbstractTextAnnotator {

    public TextFieldAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textFieldAnnotation = initAnnotationInfo();
        return textFieldAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // init possible types of annotations
        // Text field annotation
        AnnotationInfo textFieldAnnotation = initAnnotationInfo();
        textFieldAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        textFieldAnnotation.setBackgroundColor(16777215);
        return textFieldAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textFieldAnnotation = initAnnotationInfo();
        return textFieldAnnotation;
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textFieldAnnotation = initAnnotationInfo();
        return textFieldAnnotation;
    }

    @Override
    public AnnotationInfo annotateDiagram() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textFieldAnnotation = initAnnotationInfo();
        return textFieldAnnotation;
    }

    @Override
    protected byte getType() {
        return AnnotationType.TextField;
    }
}