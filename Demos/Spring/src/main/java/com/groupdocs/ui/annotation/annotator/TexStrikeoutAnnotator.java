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
public class TexStrikeoutAnnotator extends AbstractSvgAnnotator {

    public TexStrikeoutAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        // init possible types of annotations
        AnnotationInfo strikeoutAnnotation = initAnnotationInfo();
        fixBox(strikeoutAnnotation);
        return strikeoutAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        AnnotationInfo strikeoutAnnotation = initAnnotationInfo();
        strikeoutAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        strikeoutAnnotation.setPenColor(0);
        strikeoutAnnotation.setGuid(String.valueOf(annotationData.getId()));
        return strikeoutAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        AnnotationInfo strikeoutAnnotation = initAnnotationInfo();
        fixBox(strikeoutAnnotation);
        strikeoutAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        strikeoutAnnotation.setPenColor(0);
        return strikeoutAnnotation;
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
    protected byte getType() {
        return AnnotationType.TextStrikeout;
    }
}