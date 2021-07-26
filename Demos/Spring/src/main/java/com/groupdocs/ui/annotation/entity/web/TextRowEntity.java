package com.groupdocs.ui.annotation.entity.web;

import java.util.List;

public class TextRowEntity {

    public final List<Double> getTextCoordinates() {
        return textCoordinates;
    }

    public final void setTextCoordinates(List<Double> value) {
        textCoordinates = value;
    }
    private List<Double> textCoordinates;

    public final double getLineTop() {
        return lineTop;
    }

    public final void setLineTop(double value) {
        lineTop = value;
    }
    private double lineTop;

    public final double getLineHeight() {
        return lineHeight;
    }

    public final void setLineHeight(double value) {
        lineHeight = value;
    }
    private double lineHeight;
}