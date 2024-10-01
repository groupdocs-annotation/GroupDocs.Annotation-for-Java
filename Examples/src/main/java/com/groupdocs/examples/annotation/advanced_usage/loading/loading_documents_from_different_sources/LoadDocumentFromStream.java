package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates loading document from stream.
 * </p>
 */
public class LoadDocumentFromStream {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("LoadDocumentFromStream" + obtainExtension(inputFile));

        try (InputStream stream = Files.newInputStream(inputFile);
             final Annotator annotator = new Annotator(stream)) {

            AreaAnnotation areaAnnotation = new AreaAnnotation();
            areaAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            areaAnnotation.setBackgroundColor(65535);

            annotator.add(areaAnnotation);

            annotator.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());

        return outputPath;
    }
}
