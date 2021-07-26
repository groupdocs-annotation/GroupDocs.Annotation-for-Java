package com.groupdocs.ui.annotation.util;

import com.groupdocs.annotation.internal.c.a.ms.System.Convert;
import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.IBox;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.IFontColor;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.IFontFamily;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.IFontSize;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.IPoints;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.ISvgPath;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.IText;
import com.groupdocs.annotation.models.annotationmodels.interfaces.properties.ITextToReplace;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class AnnotationMapper {

    private AnnotationMapper() {
    }

    /**
     * <p>
     * Map AnnotationInfo instances into AnnotationDataEntity
     * </p>
     *
     * @param pageInfo
     * @return
     * @param annotations AnnotationInfo[]
     * @param pageNumber int
     */
    // AnnotationDataEntity[] => List<AnnotationDataEntity>
    public static List<AnnotationDataEntity> mapForPage(List<AnnotationBase> annotations, int pageNumber, PageInfo pageInfo) { //AnnotationBase[] => List<AnnotationBase> 
        // initiate annotations data array
        List<AnnotationDataEntity> pageAnnotations = new ArrayList<>();
        //  each annotation data - this functionality used since annotations data returned by the
        // GroupDocs.Annotation library are obfuscated
        for (int n = 0; n < annotations.size(); n++) {
            AnnotationBase annotationInfo = annotations.get(n);
            if (pageNumber == annotationInfo.getPageNumber() + 1) {
                AnnotationDataEntity annotation = mapAnnotationDataEntity(annotationInfo, pageInfo);
                pageAnnotations.add(annotation);
            }
        }

        return pageAnnotations;
    }

    /**
     * <p>
     * Map AnnotationInfo instances into AnnotationDataEntity
     * </p>
     *
     * @param pageInfo
     * @return AnnotationDataEntity
     * @param annotationInfo AnnotationInfo
     */
    public static AnnotationDataEntity mapAnnotationDataEntity(AnnotationBase annotationInfo, PageInfo pageInfo) {
        String annotationTypeName = AnnotationType.getName(annotationInfo.getType()); //getAnnotationType(annotationInfo.getType()); //Enum.GetName(Operators.typeOf(AnnotationType.class), annotationInfo.getType());
        float maxY = 0, minY = 0, maxX = 0, minX = 0;
        float boxX = 0, boxY = 0, boxHeight = 0, boxWidth = 0;
        String svgPath = "";
        //annotationTypeName (java.lang.String) "Watermark"
        if (annotationInfo instanceof IPoints) {
            List<Point> points = ((IPoints)annotationInfo).getPoints();
            for (Point point : points) {
                maxY = point.getY() > maxY ? point.getY(): maxY;
                maxX = point.getX() > maxX ? point.getX(): maxX;
                minY = point.getY() < minY ? point.getY(): minY;
                minX = point.getX() < minX ? point.getX(): minX;
            }
        }

        if (annotationInfo instanceof IBox) {
            Rectangle box = ((IBox)annotationInfo).getBox();
            boxX = box.getX();
            boxY = box.getY();
            boxHeight = box.getHeight();
            boxWidth = box.getWidth();

            StringBuilder builder = new StringBuilder().
            append("M").append(box.getX()).
            append(",").append(box.getY()).
            append("L").append(box.getWidth()).
            append(",").append(box.getHeight());

            svgPath = builder.toString();
        }
            
        AnnotationDataEntity annotation = new AnnotationDataEntity();
        annotation.setFont(annotationInfo instanceof IFontFamily ? ((IFontFamily)annotationInfo).getFontFamily() : "");

        Double fontSize = annotationInfo instanceof IFontSize ? (((IFontSize)annotationInfo).getFontSize() == null) ? 0.0 : ((IFontSize)annotationInfo).getFontSize() : 0.0;

        annotation.setFontSize(fontSize);
                
        annotation.setFontColor(
            annotationInfo instanceof IFontColor ? 
                ((((IFontColor) annotationInfo).getFontColor() == null) ? 0 : (int)((IFontColor) annotationInfo).getFontColor()) 
                : 0
        );
        annotation.setHeight(annotationInfo instanceof IBox ? boxHeight : (annotationInfo instanceof IPoints ? (maxY - minY) : 0));
        annotation.setLeft(annotationInfo instanceof IBox ? boxX : (annotationInfo instanceof IPoints ? minX : 0));
        
        annotation.setPageNumber((int)annotationInfo.getPageNumber() + 1);
        annotation.setSvgPath(annotationInfo instanceof ISvgPath ? (((ISvgPath)annotationInfo).getSvgPath().replace("l", "L")) : svgPath);
        
        String text = "";
        if (annotationInfo.getMessage() == null && annotationInfo instanceof ITextToReplace) {
            text = ((ITextToReplace) annotationInfo).getTextToReplace();
        } else if (annotationInfo.getMessage() != null) {
            text = annotationInfo.getMessage();
        }
        annotation.setText(text);
        
        // TODO: remove comment after check all annotations types on main formats
        annotation.setTop(annotationInfo instanceof IBox ? boxY : (annotationInfo instanceof IPoints ? pageInfo.getHeight() - maxY : 0));
        //annotation.setType(char.ToLowerInvariant(annotationTypeName[0]) + annotationTypeName.Substring(1)); !!!
        annotation.setType(annotationTypeName.toUpperCase()); 
        annotation.setWidth(annotationInfo instanceof IBox ? boxWidth : (annotationInfo instanceof IPoints ? (maxX - minX) : 0));
        //  each reply data
        List<Reply> replies = annotationInfo.getReplies();
        if (replies != null && replies.size() > 0) {
            CommentsEntity[] comments = new CommentsEntity[replies.size()];
            for (int m = 0; m < replies.size(); m++) {
                CommentsEntity comment = new CommentsEntity();
                Reply reply = replies.get(m);
                comment.setText(reply.getComment());
                DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss"); //"yyyy-MM-dd HH:mm:ss"
                comment.setTime(format.format(reply.getRepliedOn()));

                comment.setUserName(reply.getUser().getName());
                comments[m] = comment;
            }
            annotation.setComments(comments);
        }
        
        return annotation;
    }
}