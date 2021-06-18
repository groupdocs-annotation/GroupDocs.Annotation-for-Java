package com.groupdocs.ui.annotation.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

import static com.groupdocs.ui.common.config.DefaultDirectories.defaultAnnotationDirectory;
import static com.groupdocs.ui.common.config.DefaultDirectories.relativePathToAbsolute;

/**
 * AnnotationConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class AnnotationConfiguration extends Configuration {

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
    private boolean  areaAnnotation;

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
    private boolean  downloadOriginal;

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
        this.filesDirectory = StringUtils.isEmpty(filesDirectory) ? defaultAnnotationDirectory() : relativePathToAbsolute(filesDirectory);
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

    public boolean getTextAnnotation() {
        return textAnnotation;
    }

    public void setTextAnnotation(boolean textAnnotation) {
        this.textAnnotation = textAnnotation;
    }

    public boolean getAreaAnnotation() {
        return areaAnnotation;
    }

    public void setAreaAnnotation(boolean areaAnnotation) {
        this.areaAnnotation = areaAnnotation;
    }

    public boolean getPointAnnotation() {
        return pointAnnotation;
    }

    public void setPointAnnotation(boolean pointAnnotation) {
        this.pointAnnotation = pointAnnotation;
    }

    public boolean getTextStrikeoutAnnotation() {
        return textStrikeoutAnnotation;
    }

    public void setTextStrikeoutAnnotation(boolean textStrikeoutAnnotation) {
        this.textStrikeoutAnnotation = textStrikeoutAnnotation;
    }

    public boolean getPolylineAnnotation() {
        return polylineAnnotation;
    }

    public void setPolylineAnnotation(boolean polylineAnnotation) {
        this.polylineAnnotation = polylineAnnotation;
    }

    public boolean getTextFieldAnnotation() {
        return textFieldAnnotation;
    }

    public void setTextFieldAnnotation(boolean textFieldAnnotation) {
        this.textFieldAnnotation = textFieldAnnotation;
    }

    public boolean getWatermarkAnnotation() {
        return watermarkAnnotation;
    }

    public void setWatermarkAnnotation(boolean watermarkAnnotation) {
        this.watermarkAnnotation = watermarkAnnotation;
    }

    public boolean getTextReplacementAnnotation() {
        return textReplacementAnnotation;
    }

    public void setTextReplacementAnnotation(boolean textReplacementAnnotation) {
        this.textReplacementAnnotation = textReplacementAnnotation;
    }

    public boolean getArrowAnnotation() {
        return arrowAnnotation;
    }

    public void setArrowAnnotation(boolean arrowAnnotation) {
        this.arrowAnnotation = arrowAnnotation;
    }

    public boolean getTextRedactionAnnotation() {
        return textRedactionAnnotation;
    }

    public void setTextRedactionAnnotation(boolean textRedactionAnnotation) {
        this.textRedactionAnnotation = textRedactionAnnotation;
    }

    public boolean getResourcesRedactionAnnotation() {
        return resourcesRedactionAnnotation;
    }

    public void setResourcesRedactionAnnotation(boolean resourcesRedactionAnnotation) {
        this.resourcesRedactionAnnotation = resourcesRedactionAnnotation;
    }

    public boolean getTextUnderlineAnnotation() {
        return textUnderlineAnnotation;
    }

    public void setTextUnderlineAnnotation(boolean textUnderlineAnnotation) {
        this.textUnderlineAnnotation = textUnderlineAnnotation;
    }

    public boolean getDistanceAnnotation() {
        return distanceAnnotation;
    }

    public void setDistanceAnnotation(boolean distanceAnnotation) {
        this.distanceAnnotation = distanceAnnotation;
    }

    public boolean getDownloadOriginal() {
        return downloadOriginal;
    }

    public void setDownloadOriginal(boolean downloadOriginal) {
        this.downloadOriginal = downloadOriginal;
    }

    public boolean getDownloadAnnotated() {
        return downloadAnnotated;
    }

    public void setDownloadAnnotated(boolean downloadAnnotated) {
        this.downloadAnnotated = downloadAnnotated;
    }

    public boolean getZoom() {
        return zoom;
    }

    public void setZoom(boolean zoom) {
        this.zoom = zoom;
    }

    public boolean getFitWidth() {
        return fitWidth;
    }

    public void setFitWidth(boolean fitWidth) {
        this.fitWidth = fitWidth;
    }
}