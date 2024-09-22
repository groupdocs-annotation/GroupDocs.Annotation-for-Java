package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.ImageAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

public class AddImageAnnotation {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddImageAnnotation" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            ImageAnnotation imageAnnotation = new ImageAnnotation();
            imageAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            imageAnnotation.setOpacity(0.7);
            imageAnnotation.setPageNumber(0);
            imageAnnotation.setImagePath("www.google.com.ua/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
            imageAnnotation.setAngle(100.);

            annotator.add(imageAnnotation);

            annotator.save(outputPath.toString());
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath.getParent();
    }
}
