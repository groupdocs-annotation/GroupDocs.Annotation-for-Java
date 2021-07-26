package com.groupdocs.ui.annotation.entity.web;

public class AnnotationDataEntity {

    public final int getId() {
        return id;
    }

    public final void setId(int value) {
        id = value;
    }
    private int id;

    public final int getPageNumber() {
        return pageNumber;
    }

    public final void setPageNumber(int value) {
        pageNumber = value;
    }
    private int pageNumber;

    public final int getFontColor() {
        return fontColor;
    }

    public final void setFontColor(int value) {
        fontColor = value;
    }
    private int fontColor;

    public final Double getFontSize() {
        return fontSize;
    }

    public final void setFontSize(Double value) {
        fontSize = value;
    }
    private Double fontSize;

    public final float getLeft() {
        return left;
    }

    public final void setLeft(float value) {
        left = value;
    }
    private float left;

    public final float getTop() {
        return top;
    }

    public final void setTop(float value) {
        top = value;
    }
    private float top;

    public final float getWidth() {
        return width;
    }

    public final void setWidth(float value) {
        width = value;
    }
    private float width;

    public final float getHeight() {
        return height;
    }

    public final void setHeight(float value) {
        height = value;
    }
    private float height;

    public final String getSvgPath() {
        return svgPath;
    }

    public final void setSvgPath(String value) {
        svgPath = value;
    }
    private String svgPath;

    public final String getType() {
        return type;
    }

    public final void setType(String value) {
        type = value;
    }
    private String type;

    public final String getDocumentType() {
        return documentType;
    }

    public final void setDocumentType(String value) {
        documentType = value;
    }
    private String documentType;

    public final String getText() {
        return text;
    }

    public final void setText(String value) {
        text = value;
    }
    private String text;

    public final String getFont() {
        return font;
    }

    public final void setFont(String value) {
        font = value;
    }
    private String font;

    public final boolean getImported() {
        return imported;
    }

    public final void setImported(boolean value) {
        imported = value;
    }
    private boolean imported;

    public final CommentsEntity[] getComments() {
        return comments;
    }

    public final void setComments(CommentsEntity[] value) {
        comments = value;
    }
    private CommentsEntity[] comments;
}
