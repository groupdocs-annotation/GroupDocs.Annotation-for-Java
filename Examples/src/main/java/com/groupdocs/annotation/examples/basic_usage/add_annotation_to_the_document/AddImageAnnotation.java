package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.ImageAnnotation;

public class AddImageAnnotation {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_PDF)){
            ImageAnnotation imageAnnotation = new ImageAnnotation();
            imageAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            imageAnnotation.setOpacity(0.7);
            imageAnnotation.setPageNumber(0);
            imageAnnotation.setImagePath("www.google.com.ua/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
            imageAnnotation.setAngle(100.);
            annotator.add(imageAnnotation);
            annotator.save("result_image_annotation.pdf");
        }
    }
}
