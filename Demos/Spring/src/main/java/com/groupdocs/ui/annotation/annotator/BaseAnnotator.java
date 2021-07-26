package com.groupdocs.ui.annotation.annotator;


import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.User;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <p>
 * BaseSigner
 * </p>
 */
public abstract class BaseAnnotator {

    public String Message = "Annotation of type {0} for this file type is not supported";
    protected AnnotationDataEntity annotationData;
    protected PageInfo pageInfo;

    /**
     * <p>
     * Constructor
     * </p>
     *
     * @param annotationData
     * @param pageInfo
     */
    protected BaseAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        this.annotationData = annotationData;
        this.pageInfo = pageInfo;
    }

    /**
     * <p>
     * Add area annotation into the Word document
     * </p>
     *
     * @return AnnotationBase
     */
    public abstract AnnotationBase annotateWord();

    /**
     * <p>
     * Add area annotation into the pdf document
     * </p>
     *
     * @return AnnotationBase
     */
    public abstract AnnotationBase annotatePdf();

    ///// <summary>
    ///// Add area annotation into the Excel document
    ///// </summary>
    ///// <returns>AnnotationBase</returns>
    public abstract AnnotationBase annotateCells();

    /**
     * <p>
     * Add area annotation into the Power Point document
     * </p>
     *
     * @return AnnotationBase
     */
    public abstract AnnotationBase annotateSlides();

    /**
     * <p>
     * Add area annotation into the image document
     * </p>
     *
     * @return AnnotationBase
     */
    public abstract AnnotationBase annotateImage();

    /**
     * <p>
     * Add area annotation into the document
     * </p>
     *
     * @return AnnotationBase
     */
    public abstract AnnotationBase annotateDiagram();

    /**
     * <p>
     * Initial for annotation info
     * </p>
     *
     * @param annotationBase
     * @return AnnotationBase
     */    
    protected final AnnotationBase initAnnotationBase(AnnotationBase annotationBase) {
        // set page number to add annotation
        annotationBase.setPageNumber(annotationData.getPageNumber() - 1);
        // set annotation type
        annotationBase.setType(getType());
        annotationBase.setCreatedOn(Date.from(Instant.now()));
        annotationBase.setId(annotationData.getId());
        // add replies
        CommentsEntity[] comments = annotationData.getComments();
        if (comments != null && comments.length != 0) {
            java.util.List<Reply> replies = new ArrayList<>();
            for (int i = 0; i < comments.length; i++) {
                Reply reply = getAnnotationReplyInfo(comments[i]);
                replies.add(reply);
            }
            annotationBase.setReplies(replies);
        }
        return annotationBase;
    }

    /**
     * <p>
     * Initial for reply annotation info
     * </p>
     *
     * @return AnnotationReplyInfo
     * @param comment CommentsEntity
     */
    protected Reply getAnnotationReplyInfo(CommentsEntity comment) {
        Reply reply = new Reply();
        reply.setComment(comment.getText());
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
                try {
                    date = format.parse(comment.getTime());
                } catch (ParseException ex) {
                    throw new TotalGroupDocsException(ex);
                }
            }
        }
        reply.setRepliedOn(date);
        reply.setUser(new User());
        reply.getUser().setName(comment.getUserName());
        return reply;
    }

    /**
     * <p>
     * Get rectangle
     * </p>
     *
     * @return Rectangle
     */
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

    /**
     * <p>
     * Get type of annotation
     * </p>
     *
     * @return byte
     */
    protected abstract int getType();

    /**
     * <p>
     * Get Annotation info depending on document type
     * </p>
     *
     * @return AnnotationBase
     * @param documentType string
     */
    public final AnnotationBase getAnnotationBase(String documentType) {
        switch (documentType) {
            case "Portable Document Format":
                return annotatePdf();
            case "Microsoft Word":
            case "Open Document Text":
                return annotateWord();
            case "Rich Text Format":
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

    /**
     * <p>
     * Check if the current annotatin is supported
     * </p>
     *
     * @return
     * @param documentType string
     */
    public final boolean isSupported(String documentType) {
        try {
            AnnotatorFactory.createAnnotator(annotationData, pageInfo).getAnnotationBase(documentType);
            return true;
        } catch (java.lang.UnsupportedOperationException e) {
            Message += annotationData.getType();
            return false;
        }
    }
}