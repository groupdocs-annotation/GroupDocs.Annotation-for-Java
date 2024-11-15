package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates loading document from FTP.
 * </p>
 */
public class LoadDocumentFromFtp {

    public static Path run(String filePath, String server) {
        final Path outputPath = FilesUtils.makeOutputPath("LoadDocumentFromFtp" + obtainExtension(Paths.get(filePath)));

        try (final Annotator annotator = new Annotator(getFileFromFtp(server, filePath))) {

            AreaAnnotation area = new AreaAnnotation();
            area.setBox(new Rectangle(100, 100, 100, 100));
            area.setBackgroundColor(65535);
            annotator.add(area);

            annotator.save(outputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    private static InputStream getFileFromFtp(String server, String filePath) throws IOException {
        FTPClient client = new FTPClient();
        client.connect(server);
        InputStream inputStream = client.retrieveFileStream(filePath);
        client.disconnect();

        return inputStream;
    }
}
