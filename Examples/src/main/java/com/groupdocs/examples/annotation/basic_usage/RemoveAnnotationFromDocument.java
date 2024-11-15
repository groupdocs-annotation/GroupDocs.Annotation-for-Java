package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;

/**
 * <p>
 * This example demonstrates how to remove annotations from document
 * </p>
 */
public class RemoveAnnotationFromDocument {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemoveAnnotationFromDocument.pdf");

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setAnnotationTypes(AnnotationType.NONE);
            annotator.save(outputPath.toString(), saveOptions);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
