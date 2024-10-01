package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates loading document from URL.
 * </p>
 */
public class LoadDocumentFromUrl {

    public static Path run(String urlStr) {
        try {
            final URL url = new URL(urlStr);
            Path outputPath = FilesUtils.makeOutputPath("LoadDocumentFromUrl" + obtainExtension(Paths.get(url.getPath())));
            try (final Annotator annotator = new Annotator(url.openStream())) {

                AreaAnnotation area = new AreaAnnotation();
                area.setBox(new Rectangle(100, 100, 100, 100));
                area.setBackgroundColor(65535);

                annotator.add(area);

                annotator.save(outputPath.toString());
            }

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());

            return outputPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
