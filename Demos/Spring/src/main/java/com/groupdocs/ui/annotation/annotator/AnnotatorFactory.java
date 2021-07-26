package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.ui.exception.TotalGroupDocsException;

public class AnnotatorFactory {

    /**
     * <p>
     * Create annotator instance depending on type of annotation
     * </p>
     *
     * @return
     * @param annotationData AnnotationDataEntity
     * @param pageInfo PageInfo
     */
    public static BaseAnnotator createAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        AnnotationDataEntity roundedAnnotationData = roundCoordinates(annotationData);
        switch (roundedAnnotationData.getType().toLowerCase()) { // addev .toLowerCase()
            case "texthighlight": //textHighlight
                return new TextHighlightAnnotator(roundedAnnotationData, pageInfo);
            case "area":
                return new AreaAnnotator(roundedAnnotationData, pageInfo);
            case "point":
                return new PointAnnotator(roundedAnnotationData, pageInfo);
            case "textstrikeout": //textStrikeout
                return new TextStrikeoutAnnotator(roundedAnnotationData, pageInfo);
            case "polyline":
                return new PolylineAnnotator(roundedAnnotationData, pageInfo);
            case "textfield": //textField
                return new TextFieldAnnotator(roundedAnnotationData, pageInfo);
            case "watermark":
                return new WatermarkAnnotator(roundedAnnotationData, pageInfo);
            case "textreplacement": //textReplacement
                return new TextReplacementAnnotator(roundedAnnotationData, pageInfo);
            case "arrow":
                return new ArrowAnnotator(roundedAnnotationData, pageInfo);
            case "textredaction": //textRedaction
                return new TextRedactionAnnotator(roundedAnnotationData, pageInfo);
            case "resourcesredaction": //resourcesRedaction
                return new ResourceRedactionAnnotator(roundedAnnotationData, pageInfo);
            case "textunderline": //textUnderline
                return new TextUnderlineAnnotator(roundedAnnotationData, pageInfo);
            case "distance":
                return new DistanceAnnotator(roundedAnnotationData, pageInfo);
            default:
                throw new TotalGroupDocsException("Wrong annotation data without annotation type!");
        }
    }
    
    private static AnnotationDataEntity roundCoordinates(AnnotationDataEntity annotationData) {
        annotationData.setHeight((float) Math.round(annotationData.getHeight()));
        annotationData.setLeft((float) Math.round(annotationData.getLeft()));
        annotationData.setTop((float) Math.round(annotationData.getTop()));
        annotationData.setWidth((float) Math.round(annotationData.getWidth()));
        return annotationData;
    }
}