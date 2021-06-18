package com.groupdocs.ui.annotation.util;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationReplyInfo;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper for annotation entities
 */
public class AnnotationMapper {
    /**
     * Instance of mapper
     */
    public static final AnnotationMapper instance = new AnnotationMapper();

    private AnnotationMapper() {
    }

    /**
     * Map AnnotationInfo instances into AnnotationDataEntity
     *
     * @param annotations list of AnnotationInfo instances
     * @param pageNumber number of page for mapping
     * @return list of AnnotationDataEntity instances
     */
    public AnnotationDataEntity[] mapForPage(AnnotationInfo[] annotations, int pageNumber) {
        // initiate annotations data array
        List<AnnotationDataEntity> pageAnnotations = new ArrayList<>();
        // set each annotation data - this functionality used since annotations data returned by the
        // GroupDocs.Annotation library are obfuscated
        for (int n = 0; n < annotations.length; n++) {
            AnnotationInfo annotationInfo = annotations[n];
            if(pageNumber == annotationInfo.getPageNumber() + 1) {
                AnnotationDataEntity annotation = mapAnnotationDataEntity(annotationInfo);
                pageAnnotations.add(annotation);
            }
        }
        AnnotationDataEntity[] ret = new AnnotationDataEntity[pageAnnotations.size()];
        return pageAnnotations.toArray(ret);
    }

    /**
     * Map AnnotationInfo instances into AnnotationDataEntity
     *
     * @param annotationInfo AnnotationInfo instance
     * @return AnnotationDataEntity instance
     */
    public AnnotationDataEntity mapAnnotationDataEntity(AnnotationInfo annotationInfo) {
        AnnotationDataEntity annotation = new AnnotationDataEntity();
        annotation.setFont(annotationInfo.getFontFamily());
        annotation.setFontColor(annotationInfo.getFontColor());
        annotation.setFontSize(annotationInfo.getFontSize());
        Rectangle box = annotationInfo.getBox();
        annotation.setHeight(box.getHeight());
        annotation.setLeft(box.getX());
        annotation.setTop(box.getY());
        annotation.setWidth(box.getWidth());
        annotation.setPageNumber(annotationInfo.getPageNumber() + 1);
        if (annotationInfo.getSvgPath() != null) {
            annotation.setSvgPath(annotationInfo.getSvgPath().replace("l", "L"));
        }
        String text = (annotationInfo.getText() == null) ? annotationInfo.getFieldText() : annotationInfo.getText();
        annotation.setText(text);
        annotation.setType(AnnotationTypes.instance.getAnnotationType(annotationInfo.getType()));
        setReplies(annotationInfo, annotation);
        return annotation;
    }

    public void setReplies(AnnotationInfo annotationInfo, AnnotationDataEntity annotation) {
        // set each reply data
        AnnotationReplyInfo[] replies = annotationInfo.getReplies();
        if (replies != null && replies.length > 0) {
            CommentsEntity[] comments = new CommentsEntity[replies.length];
            for (int m = 0; m < replies.length; m++) {
                CommentsEntity comment = new CommentsEntity();
                AnnotationReplyInfo reply = replies[m];
                comment.setText(reply.getMessage());
                DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
                comment.setTime(format.format(reply.getRepliedOn()));
                comment.setUserName(reply.getUserName());
                comments[m] = comment;
            }
            annotation.setComments(comments);
        }
    }
}
