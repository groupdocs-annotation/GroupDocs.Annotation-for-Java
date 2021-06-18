package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

/**
 * WatermarkAnnotator
 * Annotates documents with the watermark annotation
 *
 * @author Aspose Pty Ltd
 */
public class WatermarkAnnotator extends AbstractTextAnnotator {

    public WatermarkAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        AnnotationInfo watermarkAnnotation = initAnnotationInfo();
        watermarkAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        return watermarkAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // init possible types of annotations
        AnnotationInfo watermarkAnnotation = initAnnotationInfo();
        watermarkAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        return watermarkAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        // init possible types of annotations
        AnnotationInfo watermarkAnnotation = initAnnotationInfo();
        return watermarkAnnotation;
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        // init possible types of annotations
        AnnotationInfo watermarkAnnotation = initAnnotationInfo();
        return watermarkAnnotation;
    }

    @Override
    public AnnotationInfo annotateDiagram() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    protected byte getType() {
        return AnnotationType.Watermark;
    }
}