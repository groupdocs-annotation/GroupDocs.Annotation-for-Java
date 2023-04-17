package com.groupdocs.annotation.examples.advanced_usage.saving;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.options.export.SaveOptions;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates saving result document with specified pages
 * </p>
 */
public class SavingSpecificPageRange {

    public static void run(String inputFile) {
        String outputPath = Constants.getOutputFilePath("SavingSpecificPageRange", FilenameUtils.getExtension(inputFile));

        try(final Annotator annotator = new Annotator(inputFile)) {
            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setFirstPage(2);
            saveOptions.setLastPage(4);
            annotator.save(outputPath, saveOptions);

            System.out.println("\nDocument saved successfully.\nCheck output in {outputPath}.");
        }
    }
}
