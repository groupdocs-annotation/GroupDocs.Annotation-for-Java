package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.ArrowAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

public class MinimalAnnotation {

    public static Path run(Path inputFile) {
        Path outputPath = FilesUtils.makeOutputPath("MinimalAnnotation" + obtainExtension(inputFile));
        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            final ArrowAnnotation arrowAnnotation = new ArrowAnnotation();
            arrowAnnotation.setBox(new Rectangle(100, 100, 200, 200));
            annotator.add(arrowAnnotation);
            annotator.save(outputPath.toString());
        }
        System.out.println("Document saved successfully. Check output: " + outputPath.getParent());
        return outputPath;
    }
}
