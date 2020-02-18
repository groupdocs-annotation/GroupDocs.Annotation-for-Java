package com.groupdocs.annotation.examples.advanced_usage.loading;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.annotation.options.LoadOptions;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates annotating documents that are protected with a
 * password.
 * </p>
 */
public class LoadPasswordProtectedDocuments {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("LoadPasswordProtectedDocuments", FilenameUtils.getExtension(Constants.INPUT));

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234");
        final Annotator annotator = new Annotator(Constants.INPUT_PROTECTED, loadOptions);

        AreaAnnotation area = new AreaAnnotation();
        area.setBox(new Rectangle(100, 100, 100, 100));
        area.setBackgroundColor(65535);
        annotator.add(area);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
