package com.groupdocs.annotation.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import org.apache.commons.io.FilenameUtils;
import java.net.URL;

/**
 * <p>
 * This example demonstrates loading document from URL.
 * </p>
 */
public class LoadDocumentFromUrl {

    public static void run() {
        try {
            String outputPath = Constants.getOutputFilePath("LoadDocumentFromUrl", FilenameUtils.getExtension(Constants.INPUT));

            String url = "https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/raw/api-v2/Examples/Resources/SampleFiles/input.pdf?raw=true";
            final Annotator annotator = new Annotator(new URL(url).openStream());

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
