package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.ArrowAnnotation;
import org.apache.commons.io.FilenameUtils;

public class MinimalAnnotation {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_DOC)){
            String outputPath = Constants.getOutputFilePath("MinimalAnnotation", FilenameUtils.getExtension(Constants.INPUT_DOC));
            final ArrowAnnotation arrowAnnotation = new ArrowAnnotation();
            arrowAnnotation.setBox(new Rectangle(100, 100, 200, 200));
            annotator.add(arrowAnnotation);
            annotator.save(outputPath);
        }
    }
}
