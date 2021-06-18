package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;

import java.text.ParseException;

/**
 * TextAnnotator
 * Annotates documents with the text annotation
 *
 * @author Aspose Pty Ltd
 */
public class PolylineAnnotator extends Annotator {

    public PolylineAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        return initAnnotationInfo();
    }


    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        AnnotationInfo polylineAnnotation = initAnnotationInfo();
        return polylineAnnotation;
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo polylineAnnotation = super.initAnnotationInfo();
        polylineAnnotation.setPenColor(1201033);
        polylineAnnotation.setPenWidth((byte) 2);
        polylineAnnotation.setSvgPath(annotationData.getSvgPath());
        return polylineAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        AnnotationInfo polylineAnnotation = initAnnotationInfo();
        fillCreatorName(polylineAnnotation);
        return polylineAnnotation;
    }

    /**
     * Fill creator name field in annotation info
     *
     * @param polylineAnnotation annotation info
     */
    protected void fillCreatorName(AnnotationInfo polylineAnnotation) {
        CommentsEntity[] comments = annotationData.getComments();
        if (comments != null && comments.length > 0 && comments[0] != null) {
            polylineAnnotation.setCreatorName(comments[0].getUserName());
        }
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        AnnotationInfo polylineAnnotation = initAnnotationInfo();
        fillCreatorName(polylineAnnotation);
        return polylineAnnotation;
    }

    @Override
    public AnnotationInfo annotateDiagram() throws ParseException {
        AnnotationInfo polylineAnnotation = initAnnotationInfo();
        fillCreatorName(polylineAnnotation);
        return polylineAnnotation;
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

    @Override
    protected byte getType() {
        return AnnotationType.Polyline;
    }
}