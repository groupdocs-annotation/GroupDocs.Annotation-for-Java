package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationReplyInfo;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Annotator
 * Abstract class contains general description for the annotating functionality
 *
 * @author Aspose Pty Ltd
 */
public abstract class Annotator {

    public static final String MESSAGE = "Annotation of type %s for this file type is not supported";

    protected AnnotationDataEntity annotationData;
    protected PageData pageData;

    /**
     * Constructor
     *
     * @param annotationData
     * @param pageData
     */
    public Annotator(AnnotationDataEntity annotationData, PageData pageData) {
        this.annotationData = annotationData;
        this.pageData = pageData;
    }

    /**
     * Add area annotation into the Word document
     *
     * @return
     * @throws UnsupportedOperationException Word document doesn't supported for the current annotation type
     * @throws ParseException                the date cannot be parsed
     */
    public abstract AnnotationInfo annotateWord() throws UnsupportedOperationException, ParseException;

    /**
     * Add area annotation into the pdf document
     *
     * @return
     * @throws UnsupportedOperationException pdf document doesn't supported for the current annotation type
     * @throws ParseException                the date cannot be parsed
     */
    public abstract AnnotationInfo annotatePdf() throws UnsupportedOperationException, ParseException;

    /**
     * Add area annotation into the Excel document
     *
     * @return
     * @throws UnsupportedOperationException the Excel document don't supported for the current annotation type
     * @throws ParseException                the date cannot be parsed
     */
    public abstract AnnotationInfo annotateCells() throws UnsupportedOperationException, ParseException;

    /**
     * Add area annotation into the Power Point document
     *
     * @return
     * @throws UnsupportedOperationException the Power Point document doesn't supported for the current annotation type
     * @throws ParseException                the date cannot be parsed
     */
    public abstract AnnotationInfo annotateSlides() throws UnsupportedOperationException, ParseException;

    /**
     * Add area annotation into the image document
     *
     * @return
     * @throws UnsupportedOperationException image doesn't supported for the current annotation type
     * @throws ParseException                the date cannot be parsed
     */
    public abstract AnnotationInfo annotateImage() throws UnsupportedOperationException, ParseException;

    /**
     * Add area annotation into the document
     *
     * @return
     * @throws UnsupportedOperationException diagram document doesn't supported for the current annotation type
     * @throws ParseException                the date cannot be parsed
     */
    public abstract AnnotationInfo annotateDiagram() throws UnsupportedOperationException, ParseException;

    /**
     * Initial for annotation info
     *
     * @return annotation info
     * @throws ParseException the date cannot be parsed
     */
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo areaAnnotation = new AnnotationInfo();
        // draw annotation options
        areaAnnotation.setBox(getBox());
        // set page number to add annotation
        areaAnnotation.setPageNumber(annotationData.getPageNumber() - 1);
        // set annotation type
        areaAnnotation.setType(getType());
        // add replies
        CommentsEntity[] comments = annotationData.getComments();
        if (comments != null && comments.length != 0) {
            AnnotationReplyInfo[] replies = new AnnotationReplyInfo[comments.length];
            for (int i = 0; i < comments.length; i++) {
                AnnotationReplyInfo reply = getAnnotationReplyInfo(comments[i]);
                replies[i] = reply;
            }
            areaAnnotation.setReplies(replies);
        }
        return areaAnnotation;
    }

    /**
     * Initial for reply annotation info
     *
     * @param comment annotation comment
     * @return annotation reply info
     * @throws ParseException the date cannot be parsed
     */
    protected AnnotationReplyInfo getAnnotationReplyInfo(CommentsEntity comment) throws ParseException {
        AnnotationReplyInfo reply = new AnnotationReplyInfo();
        reply.setMessage(comment.getText());
        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date;
        try {
            date = new Date(Long.parseLong(comment.getTime()));
        } catch (Exception e) {
            try {
                date = format.parse(comment.getTime());
            } catch (Exception exc) {
                format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
                date = format.parse(comment.getTime());
            }
        }
        reply.setRepliedOn(date);
        reply.setUserName(comment.getUserName());
        return reply;
    }

    /**
     * Get rectangle
     *
     * @return box
     */
    protected abstract Rectangle getBox();

    /**
     * Get type of annotation
     *
     * @return annotation type
     */
    protected abstract byte getType();

    /**
     * Get Annotation info depending on document type
     *
     * @throws ParseException the date cannot be parsed
     */
    public AnnotationInfo getAnnotationInfo(String documentType) throws ParseException {
        switch (documentType) {
            case "Portable Document Format":
                return annotatePdf();
            case "Microsoft Word":
                return annotateWord();
            case "Microsoft PowerPoint":
                return annotateSlides();
            case "image":
                return annotateImage();
            case "Microsoft Excel":
                return annotateCells();
            case "AutoCAD Drawing File Format":
                return annotateDiagram();
            default:
                throw new TotalGroupDocsException("Wrong annotation data without document type!");
        }
    }
}
