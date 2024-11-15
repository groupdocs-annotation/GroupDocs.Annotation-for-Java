package com.groupdocs.examples.annotation.advanced_usage.loading;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.annotation.options.LoadOptions;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates annotating documents that are protected with a
 * password.
 * </p>
 */
public class LoadPasswordProtectedDocuments {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("LoadPasswordProtectedDocuments" + obtainExtension(inputFile));
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234");

        try (final Annotator annotator = new Annotator(inputFile.toString(), loadOptions)) {

            AreaAnnotation area = new AreaAnnotation();
            area.setBox(new Rectangle(100, 100, 100, 100));
            area.setBackgroundColor(65535);
            annotator.add(area);

            annotator.save(outputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
