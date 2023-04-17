package com.groupdocs.annotation.examples.advanced_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.exception.GroupDocsException;
import com.groupdocs.annotation.options.pagepreview.CreatePageStream;
import com.groupdocs.annotation.options.pagepreview.PreviewFormats;
import com.groupdocs.annotation.options.pagepreview.PreviewOptions;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * <p>
 * This example demonstrates annotating generating previews from document
 * </p>
 */
public class GenerateDocumentPagesPreview {

    public static void run(String inputFile) {
        try(final Annotator annotator = new Annotator(inputFile)) {
            PreviewOptions previewOptions = new PreviewOptions(new CreatePageStream() {
                @Override
                public OutputStream invoke(int pageNumber) {
                    try {
                        String fileName = Constants.getOutputFilePath("GenerateDocumentPagesPreview" + "_" + pageNumber, "png");
                        OutputStream result = new FileOutputStream(fileName);
                        return result;
                    } catch (Exception ex) {
                        throw new GroupDocsException(ex);
                    }
                }
            });

            previewOptions.setResolution(85);
            previewOptions.setPreviewFormat(PreviewFormats.PNG);
            previewOptions.setPageNumbers(new int[]{1, 2});
            annotator.getDocument().generatePreview(previewOptions);

            System.out.println("\nDocument previews generated successfully.\nCheck output in " + Constants.OutputPath);
        }
    }
}
