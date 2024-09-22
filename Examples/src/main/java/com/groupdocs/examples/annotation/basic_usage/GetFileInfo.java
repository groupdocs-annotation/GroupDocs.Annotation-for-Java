package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.Document;
import com.groupdocs.annotation.IDocumentInfo;

import java.io.IOException;
import java.nio.file.Path;

/**
 * <p>
 * This example demonstrates document info extraction
 * </p>
 */
public class GetFileInfo {
    public static IDocumentInfo run(Path inputFile) {
        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            final Document document = annotator.getDocument();
            IDocumentInfo info = document.getDocumentInfo();
            System.out.println(
                    "\nFile type: " + info.getFileType() +
                            "\nNumber of pages: " + info.getPageCount() +
                            "\nDocument size: " + info.getSize() + " bytes");

            System.out.println("\nDocument info extracted successfully.");

            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
