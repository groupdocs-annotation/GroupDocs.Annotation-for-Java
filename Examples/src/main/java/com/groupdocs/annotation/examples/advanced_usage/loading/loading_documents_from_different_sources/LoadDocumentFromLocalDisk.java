package com.groupdocs.annotation.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates loading document from file path.
 * </p>
 */
public class LoadDocumentFromLocalDisk {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("LoadDocumentFromLocalDisk", FilenameUtils.getExtension(Constants.INPUT_PDF));

        final Annotator annotator = new Annotator(Constants.INPUT_PDF);

        AreaAnnotation area = new AreaAnnotation();
        area.setBox(new Rectangle(100, 100, 100, 100));
        area.setBackgroundColor(65535);
        annotator.add(area);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}