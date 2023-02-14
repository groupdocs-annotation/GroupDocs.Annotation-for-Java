package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.IDocumentInfo;
import com.groupdocs.annotation.examples.Constants;

import java.io.IOException;

/**
 * <p>
 * This example demonstrates document info extraction
 * </p>
 */
public class GetFileInfo {

    public static void run() {
        final Annotator annotator = new Annotator(Constants.INPUT);

        IDocumentInfo info = null;
        try {
            info = annotator.getDocument().getDocumentInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(
                "\nFile type: " + info.getFileType()
                + "\nNumber of pages: " + info.getPageCount()
                + "\nDocument size: " + info.getSize() + " bytes");

        annotator.dispose();
        System.out.println("\nDocument info extracted successfully.");
    }
}
