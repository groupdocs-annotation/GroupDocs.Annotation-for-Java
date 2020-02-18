package com.groupdocs.annotation.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates loading document from stream.
 * </p>
 */
public class LoadDocumentFromStream {

    public static void run() {
        try {
            String outputPath = Constants.getOutputFilePath("LoadDocumentFromStream", FilenameUtils.getExtension(Constants.INPUT));

            InputStream stream = new FileInputStream(Constants.INPUT);
            final Annotator annotator = new Annotator(stream);

            AreaAnnotation area = new AreaAnnotation();
            area.setBox(new Rectangle(100, 100, 100, 100));
            area.setBackgroundColor(65535);
            annotator.add(area);
            annotator.save(outputPath);

            annotator.dispose();

            System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
        } catch (Throwable e) {
            e.getMessage();
        }
    }
}
