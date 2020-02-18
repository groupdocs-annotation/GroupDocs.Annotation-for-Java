package com.groupdocs.annotation.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import org.apache.commons.io.FilenameUtils;

import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * This example demonstrates loading document from FTP.
 * </p>
 */
public class LoadDocumentFromFtp {

    public static void run() {
        try {
            String outputPath = Constants.getOutputFilePath("LoadDocumentFromFtp", FilenameUtils.getExtension(Constants.INPUT));

            String filePath = "sample.pdf";
            String server = "localhost";

            final Annotator annotator = new Annotator(getFileFromFtp(server, filePath));

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

    private static InputStream getFileFromFtp(String server, String filePath) throws IOException {
        FTPClient client = new FTPClient();
        client.connect(server);
        InputStream inputStream = client.retrieveFileStream(filePath);
        client.disconnect();

        return inputStream;
    }
}
