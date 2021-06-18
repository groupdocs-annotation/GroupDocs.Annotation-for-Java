package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;

/**
 * Creator for annotator instances
 */
public class AnnotatorFactory {

    /**
     * Create annotator instance depending on type of annotation
     *
     * @param annotationData annotation
     * @param pageData   document
     * @return annotator instance
     */
    public static Annotator createAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        switch (annotationData.getType()) {
            case "text":
                return new TextAnnotator(annotationData, pageData);
            case "area":
                return new AreaAnnotator(annotationData, pageData);
            case "point":
                return new PointAnnotator(annotationData, pageData);
            case "textStrikeout":
                return new TexStrikeoutAnnotator(annotationData, pageData);
            case "polyline":
                return new PolylineAnnotator(annotationData, pageData);
            case "textField":
                return new TextFieldAnnotator(annotationData, pageData);
            case "watermark":
                return new WatermarkAnnotator(annotationData, pageData);
            case "textReplacement":
                return new TextReplacementAnnotator(annotationData, pageData);
            case "arrow":
                return new ArrowAnnotator(annotationData, pageData);
            case "textRedaction":
                return new TextRedactionAnnotator(annotationData, pageData);
            case "resourcesRedaction":
                return new ResourceRedactionAnnotator(annotationData, pageData);
            case "textUnderline":
                return new TexUnderlineAnnotator(annotationData, pageData);
            case "distance":
                return new DistanceAnnotator(annotationData, pageData);
            default:
                throw new TotalGroupDocsException("Wrong annotation data without annotation type!");
        }
    }
}
