package com.groupdocs.ui.annotation.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.common.config.CommonConfiguration;
import com.groupdocs.ui.common.config.CommonConfigurationModel;

import javax.validation.Valid;

public class AnnotationConfigurationModel extends CommonConfigurationModel {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String defaultDocument;

    @Valid
    @JsonProperty
    private int preloadPageCount;

    @Valid
    @JsonProperty
    private String fontsDirectory;

    @Valid
    @JsonProperty
    private boolean textAnnotation;

    @Valid
    @JsonProperty
    private boolean areaAnnotation;

    @Valid
    @JsonProperty
    private boolean pointAnnotation;

    @Valid
    @JsonProperty
    private boolean textStrikeoutAnnotation;

    @Valid
    @JsonProperty
    private boolean polylineAnnotation;

    @Valid
    @JsonProperty
    private boolean textFieldAnnotation;

    @Valid
    @JsonProperty
    private boolean watermarkAnnotation;

    @Valid
    @JsonProperty
    private boolean textReplacementAnnotation;

    @Valid
    @JsonProperty
    private boolean arrowAnnotation;

    @Valid
    @JsonProperty
    private boolean textRedactionAnnotation;

    @Valid
    @JsonProperty
    private boolean resourcesRedactionAnnotation;

    @Valid
    @JsonProperty
    private boolean textUnderlineAnnotation;

    @Valid
    @JsonProperty
    private boolean distanceAnnotation;

    @Valid
    @JsonProperty
    private boolean downloadOriginal;

    @Valid
    @JsonProperty
    private boolean downloadAnnotated;

    @Valid
    @JsonProperty
    private boolean zoom;

    @Valid
    @JsonProperty
    private boolean fitWidth;

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getDefaultDocument() {
        return defaultDocument;
    }

    public void setDefaultDocument(String defaultDocument) {
        this.defaultDocument = defaultDocument;
    }

    public int getPreloadPageCount() {
        return preloadPageCount;
    }

    public void setPreloadPageCount(int preloadPageCount) {
        this.preloadPageCount = preloadPageCount;
    }

    public String getFontsDirectory() {
        return fontsDirectory;
    }

    public void setFontsDirectory(String fontsDirectory) {
        this.fontsDirectory = fontsDirectory;
    }

    public boolean isTextAnnotation() {
        return textAnnotation;
    }

    public void setTextAnnotation(boolean textAnnotation) {
        this.textAnnotation = textAnnotation;
    }

    public boolean isAreaAnnotation() {
        return areaAnnotation;
    }

    public void setAreaAnnotation(boolean areaAnnotation) {
        this.areaAnnotation = areaAnnotation;
    }

    public boolean isPointAnnotation() {
        return pointAnnotation;
    }

    public void setPointAnnotation(boolean pointAnnotation) {
        this.pointAnnotation = pointAnnotation;
    }

    public boolean isTextStrikeoutAnnotation() {
        return textStrikeoutAnnotation;
    }

    public void setTextStrikeoutAnnotation(boolean textStrikeoutAnnotation) {
        this.textStrikeoutAnnotation = textStrikeoutAnnotation;
    }

    public boolean isPolylineAnnotation() {
        return polylineAnnotation;
    }

    public void setPolylineAnnotation(boolean polylineAnnotation) {
        this.polylineAnnotation = polylineAnnotation;
    }

    public boolean isTextFieldAnnotation() {
        return textFieldAnnotation;
    }

    public void setTextFieldAnnotation(boolean textFieldAnnotation) {
        this.textFieldAnnotation = textFieldAnnotation;
    }

    public boolean isWatermarkAnnotation() {
        return watermarkAnnotation;
    }

    public void setWatermarkAnnotation(boolean watermarkAnnotation) {
        this.watermarkAnnotation = watermarkAnnotation;
    }

    public boolean isTextReplacementAnnotation() {
        return textReplacementAnnotation;
    }

    public void setTextReplacementAnnotation(boolean textReplacementAnnotation) {
        this.textReplacementAnnotation = textReplacementAnnotation;
    }

    public boolean isArrowAnnotation() {
        return arrowAnnotation;
    }

    public void setArrowAnnotation(boolean arrowAnnotation) {
        this.arrowAnnotation = arrowAnnotation;
    }

    public boolean isTextRedactionAnnotation() {
        return textRedactionAnnotation;
    }

    public void setTextRedactionAnnotation(boolean textRedactionAnnotation) {
        this.textRedactionAnnotation = textRedactionAnnotation;
    }

    public boolean isResourcesRedactionAnnotation() {
        return resourcesRedactionAnnotation;
    }

    public void setResourcesRedactionAnnotation(boolean resourcesRedactionAnnotation) {
        this.resourcesRedactionAnnotation = resourcesRedactionAnnotation;
    }

    public boolean isTextUnderlineAnnotation() {
        return textUnderlineAnnotation;
    }

    public void setTextUnderlineAnnotation(boolean textUnderlineAnnotation) {
        this.textUnderlineAnnotation = textUnderlineAnnotation;
    }

    public boolean isDistanceAnnotation() {
        return distanceAnnotation;
    }

    public void setDistanceAnnotation(boolean distanceAnnotation) {
        this.distanceAnnotation = distanceAnnotation;
    }

    public boolean isDownloadOriginal() {
        return downloadOriginal;
    }

    public void setDownloadOriginal(boolean downloadOriginal) {
        this.downloadOriginal = downloadOriginal;
    }

    public boolean isDownloadAnnotated() {
        return downloadAnnotated;
    }

    public void setDownloadAnnotated(boolean downloadAnnotated) {
        this.downloadAnnotated = downloadAnnotated;
    }

    public boolean isZoom() {
        return zoom;
    }

    public void setZoom(boolean zoom) {
        this.zoom = zoom;
    }

    public boolean isFitWidth() {
        return fitWidth;
    }

    public void setFitWidth(boolean fitWidth) {
        this.fitWidth = fitWidth;
    }

    public static AnnotationConfigurationModel createAnnotationConfiguration(AnnotationConfiguration annotation, CommonConfiguration common) {
        AnnotationConfigurationModel config = new AnnotationConfigurationModel();
        config.init(common);
        config.setFilesDirectory(annotation.getFilesDirectory());
        config.setDefaultDocument(annotation.getDefaultDocument());
        config.setPreloadPageCount(annotation.getPreloadPageCount());
        config.setFontsDirectory(annotation.getFontsDirectory());
        config.setTextAnnotation(annotation.getTextAnnotation());
        config.setAreaAnnotation(annotation.getAreaAnnotation());
        config.setPointAnnotation(annotation.getPointAnnotation());
        config.setTextStrikeoutAnnotation(annotation.getTextStrikeoutAnnotation());
        config.setPolylineAnnotation(annotation.getPolylineAnnotation());
        config.setTextFieldAnnotation(annotation.getTextFieldAnnotation());
        config.setTextReplacementAnnotation(annotation.getTextReplacementAnnotation());
        config.setTextRedactionAnnotation(annotation.getTextRedactionAnnotation());
        config.setTextUnderlineAnnotation(annotation.getTextUnderlineAnnotation());
        config.setWatermarkAnnotation(annotation.getWatermarkAnnotation());
        config.setArrowAnnotation(annotation.getArrowAnnotation());
        config.setDistanceAnnotation(annotation.getDistanceAnnotation());
        config.setResourcesRedactionAnnotation(annotation.getResourcesRedactionAnnotation());
        config.setZoom(annotation.getZoom());
        config.setFitWidth(annotation.getFitWidth());
        config.setDownloadOriginal(annotation.getDownloadOriginal());
        config.setDownloadAnnotated(annotation.getDownloadAnnotated());
        return config;
    }
}
