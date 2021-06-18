package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationReplyInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;

import java.text.ParseException;

/**
 * TextAnnotator
 * Annotates documents with the text annotation
 *
 * @author Aspose Pty Ltd
 */
public class ArrowAnnotator extends AbstractBoxAnnotator {

    private boolean withGuid = false;

    public ArrowAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        withGuid = false;
        AnnotationInfo arrowAnnotation = initAnnotationInfo();
        return arrowAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        withGuid = false;
        AnnotationInfo arrowAnnotation = initAnnotationInfo();
        return arrowAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        withGuid = true;
        // init annotation object
        AnnotationInfo arrowAnnotation = initAnnotationInfo();
        arrowAnnotation.setBackgroundColor(15988609);
        return arrowAnnotation;
    }

    @Override
    public AnnotationInfo annotateImage() throws ParseException {
        withGuid = false;
        // init annotation object
        AnnotationInfo arrowAnnotation = initAnnotationInfo();
        arrowAnnotation.setBackgroundColor(-15988609);
        return arrowAnnotation;
    }

    @Override
    public AnnotationInfo annotateDiagram() throws ParseException {
        withGuid = false;
        // init annotation object
        AnnotationInfo arrowAnnotation = initAnnotationInfo();
        arrowAnnotation.setBackgroundColor(15988609);
        return arrowAnnotation;
    }

    @Override
    protected AnnotationReplyInfo getAnnotationReplyInfo(CommentsEntity comment) throws ParseException {
        AnnotationReplyInfo annotationReplyInfo = super.getAnnotationReplyInfo(comment);
        if (withGuid) {
            annotationReplyInfo.setParentReplyGuid(String.valueOf(annotationData.getId()));
        }
        return annotationReplyInfo;
    }

    @Override
    protected byte getType() {
        return AnnotationType.Arrow;
    }

}