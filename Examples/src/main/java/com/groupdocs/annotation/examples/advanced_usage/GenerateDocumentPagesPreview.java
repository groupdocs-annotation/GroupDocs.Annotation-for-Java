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

    public static void run() {
        final Annotator annotator = new Annotator(Constants.INPUT_NEW);
        
        PreviewOptions previewOptions = new PreviewOptions(new CreatePageStream() {
            @Override
            public OutputStream invoke(int pageNumber) {
                try {
                    //String OutputPath = "//Resources//Output/";
                    String fileName = Constants.getOutputFilePath("GenerateDocumentPagesPreview_"+pageNumber, "png");//OutputPath + "GenerateDocumentPagesPreview_"+pageNumber+".png";
                    OutputStream result = new FileOutputStream(fileName);
                    return result;
                } catch (Exception ex) {
                    throw new GroupDocsException(ex);
                }
            }
        });

        previewOptions.setResolution(50);

        previewOptions.setPreviewFormat(PreviewFormats.PNG);

        previewOptions.setPageNumbers(new int[]{1, 2});
        annotator.getDocument().generatePreview(previewOptions);

        annotator.dispose();

        System.out.println("\nDocument previews generated successfully.\nCheck output in " + Constants.OutputPath);
    }
}
