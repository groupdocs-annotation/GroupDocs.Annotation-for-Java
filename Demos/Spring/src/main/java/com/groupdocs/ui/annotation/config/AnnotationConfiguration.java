package com.groupdocs.ui.annotation.config;

import com.groupdocs.ui.config.CommonConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

import static com.groupdocs.ui.config.DefaultDirectories.defaultAnnotationDirectory;
import static com.groupdocs.ui.config.DefaultDirectories.relativePathToAbsolute;

/**
 * AnnotationConfiguration
 *
 * @author Aspose Pty Ltd
 */
@Component
public class AnnotationConfiguration extends CommonConfiguration {

    @Value("${annotation.filesDirectory}")
    private String filesDirectory;

    @Value("${annotation.defaultDocument}")
    private String defaultDocument;

    @Value("#{new Integer('${annotation.preloadPageCount}')}")
    private int preloadPageCount;

    @Value("${annotation.fontsDirectory}")
    private String fontsDirectory;

    @Value("#{new Boolean('${annotation.textAnnotation}')}")
    private boolean textAnnotation;

    @Value("#{new Boolean('${annotation.areaAnnotation}')}")
    private boolean areaAnnotation;

    @Value("#{new Boolean('${annotation.pointAnnotation}')}")
    private boolean pointAnnotation;

    @Value("#{new Boolean('${annotation.textStrikeoutAnnotation}')}")
    private boolean textStrikeoutAnnotation;

    @Value("#{new Boolean('${annotation.polylineAnnotation}')}")
    private boolean polylineAnnotation;

    @Value("#{new Boolean('${annotation.textFieldAnnotation}')}")
    private boolean textFieldAnnotation;

    @Value("#{new Boolean('${annotation.watermarkAnnotation}')}")
    private boolean watermarkAnnotation;

    @Value("#{new Boolean('${annotation.textReplacementAnnotation}')}")
    private boolean textReplacementAnnotation;

    @Value("#{new Boolean('${annotation.arrowAnnotation}')}")
    private boolean arrowAnnotation;

    @Value("#{new Boolean('${annotation.textRedactionAnnotation}')}")
    private boolean textRedactionAnnotation;

    @Value("#{new Boolean('${annotation.resourcesRedactionAnnotation}')}")
    private boolean resourcesRedactionAnnotation;

    @Value("#{new Boolean('${annotation.textUnderlineAnnotation}')}")
    private boolean textUnderlineAnnotation;

    @Value("#{new Boolean('${annotation.distanceAnnotation}')}")
    private boolean distanceAnnotation;

    @Value("#{new Boolean('${annotation.downloadOriginal}')}")
    private boolean downloadOriginal;

    @Value("#{new Boolean('${annotation.downloadAnnotated}')}")
    private boolean downloadAnnotated;

    @Value("#{new Boolean('${annotation.zoom}')}")
    private boolean zoom;

    @Value("#{new Boolean('${annotation.fitWidth}')}")
    private boolean fitWidth;

    @PostConstruct
    public void init() {
        this.filesDirectory = StringUtils.isEmpty(this.filesDirectory) ? defaultAnnotationDirectory() : relativePathToAbsolute(this.filesDirectory);
    }

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

    @Override
    public String toString() {
        return super.toString() +
                "AnnotationConfiguration{" +
                "filesDirectory='" + filesDirectory + '\'' +
                ", defaultDocument='" + defaultDocument + '\'' +
                ", preloadPageCount=" + preloadPageCount +
                ", fontsDirectory='" + fontsDirectory + '\'' +
                ", textAnnotation=" + textAnnotation +
                ", areaAnnotation=" + areaAnnotation +
                ", pointAnnotation=" + pointAnnotation +
                ", textStrikeoutAnnotation=" + textStrikeoutAnnotation +
                ", polylineAnnotation=" + polylineAnnotation +
                ", textFieldAnnotation=" + textFieldAnnotation +
                ", watermarkAnnotation=" + watermarkAnnotation +
                ", textReplacementAnnotation=" + textReplacementAnnotation +
                ", arrowAnnotation=" + arrowAnnotation +
                ", textRedactionAnnotation=" + textRedactionAnnotation +
                ", resourcesRedactionAnnotation=" + resourcesRedactionAnnotation +
                ", textUnderlineAnnotation=" + textUnderlineAnnotation +
                ", distanceAnnotation=" + distanceAnnotation +
                ", downloadOriginal=" + downloadOriginal +
                ", downloadAnnotated=" + downloadAnnotated +
                ", zoom=" + zoom +
                ", fitWidth=" + fitWidth +
                '}';
    }
}