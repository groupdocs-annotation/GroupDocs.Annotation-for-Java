package com.groupdocs.examples.annotation.advanced_usage.saving;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.options.export.SaveOptions;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates saving result document with specified pages
 * </p>
 */
public class SavingSpecificPageRange {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SavingSpecificPageRange" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setFirstPage(2);
            saveOptions.setLastPage(4);
            annotator.save(outputPath.toString(), saveOptions);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        }
        return outputPath;
    }
}
