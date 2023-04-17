package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.IDocumentInfo;

import java.io.IOException;

/**
 * <p>
 * This example demonstrates document info extraction
 * </p>
 */
public class GetFileInfo {
    public static void run(String inputFile) {
        try(final Annotator annotator = new Annotator(inputFile)) {
            IDocumentInfo info = null;
            try {
                info = annotator.getDocument().getDocumentInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(
                    "\nFile type: " + info.getFileType() + "\nNumber of pages: " + info.getPageCount() + "\nDocument size: " + info.getSize() + " bytes");

            System.out.println("\nDocument info extracted successfully.");
        }
    }
}
