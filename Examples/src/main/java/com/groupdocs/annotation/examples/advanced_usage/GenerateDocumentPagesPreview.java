package com.groupdocs.annotation.examples.advanced_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.options.PreviewFormats;
import com.groupdocs.annotation.options.pagepreview.PreviewOptions;
import com.groupdocs.annotation.options.pagepreview.PageStreamFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>
 * This example demonstrates annotating generating previews from document
 * </p>
 */
public class GenerateDocumentPagesPreview {

    public static void run() {
        final Annotator annotator = new Annotator(Constants.INPUT);

        String outputPathFormat = Constants.getPagePreviewPathFormat("PagePreview_{0}.png");

        PreviewOptions previewOptions = new PreviewOptions(outputPathFormat);

        previewOptions.setPreviewFormat(PreviewFormats.PNG);

        previewOptions.setPageNumbers(new int[]{1, 2});
        annotator.getDocument().generatePreview(previewOptions);

        annotator.dispose();

        System.out.println("\nDocument previews generated successfully.\nCheck output in " + Constants.OutputPath);
    }
}
