package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates how to remove annotations from document
 * </p>
 */
public class RemoveAnnotationFromDocument {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("RemoveAnnotationFromDocument", FilenameUtils.getExtension(Constants.INPUT_PDF));

        final Annotator annotator = new Annotator(Constants.ANNOTATED_AREA_REPLIES_5);

        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setAnnotationTypes(AnnotationType.NONE);
        annotator.save(outputPath, saveOptions);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
