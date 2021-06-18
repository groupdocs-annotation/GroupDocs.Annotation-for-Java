package com.groupdocs.ui.annotation.entity.web;

/**
 * AnnotationDataEntity
 *
 * @author Aspose Pty Ltd
 */
public class AnnotationDataEntity {
    /**
     * Annotation Id
     */
    private Integer id;
    /**
     * The number of page in document
     */
    private Integer pageNumber;
    /**
     * The size of font of annotation
     */
    private Double fontSize;
    /**
     * Annotation position. Left position.
     */
    private double left;
    /**
     * Annotation position. Top position.
     */
    private double top;
    /**
     * Annotation position. Width of annotation.
     */
    private double width;
    /**
     * Annotation position. Height of annotation.
     */
    private double height;
    /**
     * SVG path
     */
    private String svgPath;
    /**
     * The type of annotation (text, watermark, ect)
     */
    private String type;
    /**
     * Annotation text
     */
    private String text;
    /**
     * The annotation font
     */
    private String font;
    /**
     * List of comments in annotation
     */
    private CommentsEntity[] comments;
    /**
     * Imported annotations
     */
    private boolean imported;
    /**
     * font color
     */
    private Integer fontColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Double getFontSize() {
        return fontSize;
    }

    public void setFontSize(Double fontSize) {
        this.fontSize = fontSize;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSvgPath() {
        return svgPath;
    }

    public void setSvgPath(String svgPath) {
        this.svgPath = svgPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public CommentsEntity[] getComments() {
        return comments;
    }

    public void setComments(CommentsEntity[] comments) {
        this.comments = comments;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public Integer getFontColor() {
        return fontColor;
    }

    public void setFontColor(Integer fontColor) {
        this.fontColor = fontColor;
    }
}
