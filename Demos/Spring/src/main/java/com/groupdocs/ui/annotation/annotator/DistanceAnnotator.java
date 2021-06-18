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
public class DistanceAnnotator extends AbstractBoxAnnotator {

    public DistanceAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        AnnotationInfo distanceAnnotation = initAnnotationInfo();
        return distanceAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        AnnotationInfo distanceAnnotation = initAnnotationInfo();
        return distanceAnnotation;
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
    public AnnotationInfo annotateImage() throws ParseException {
        // init annotation object
        AnnotationInfo distanceAnnotation = initAnnotationInfo();
        distanceAnnotation.setBackgroundColor(15988609);
        return distanceAnnotation;
    }


    @Override
    public AnnotationInfo annotateDiagram() throws ParseException {
        // init annotation object
        AnnotationInfo distanceAnnotation = initAnnotationInfo();
        distanceAnnotation.setBackgroundColor(15988609);
        return distanceAnnotation;
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo distanceAnnotation = super.initAnnotationInfo();
        // add replies
        String text = (annotationData.getText() == null) ? "" : annotationData.getText();
        CommentsEntity[] comments = annotationData.getComments();
        if (comments != null && comments.length != 0) {
            AnnotationReplyInfo reply = distanceAnnotation.getReplies()[0];
            if (reply != null) {
                reply.setMessage(String.format("%s %s", annotationData.getText(), reply.getMessage()));
            }
        } else {
            distanceAnnotation.setFieldText(text);
        }
        return distanceAnnotation;
    }

    @Override
    protected byte getType() {
        return AnnotationType.Distance;
    }
}