package com.groupdocs.ui;

import com.groupdocs.annotation.common.license.License;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.IDocumentDataHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Properties;

public class Utils {
    static {
        // Load the license as early as possible
        loadLicense();
    }

    public static AnnotationImageHandler createAnnotationImageHandler() {
        AnnotationConfig cfg = new AnnotationConfig();
        cfg.setStoragePath(getStoragePath());
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
        return annotator;

    }

    public static Document findDocumentByName(String name) {
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        IDocumentDataHandler documentDataHandler = imageHandler.getDocumentDataHandler();
        Document doc = documentDataHandler.getDocument(name);
        if (doc != null) {
            return doc;
        }

        long documentId = imageHandler.createDocument(name);

        try (InputStream original = new FileInputStream(Utils.getStoragePath() + "/" + name)) {
            imageHandler.importAnnotations(original, ""+documentId);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
        return documentDataHandler.get(documentId);
    }

    public static void loadLicense() {
        License l = new License();
        if (Files.exists(FileSystems.getDefault().getPath(getProjectProperty("license.path")))) {
            l.setLicense(getProjectProperty("license.path"));
            if (!License.isValidLicense()) {
                throw new RuntimeException("Invalid license found.");
            }
        }
    }

    public static String getStoragePath() {
        return getProjectProperty("storage.path");
    }

    public static String getProjectProperty(String name) {
        Properties p = new Properties();
        try (InputStream i = Utils.class.getResourceAsStream("/project.properties")) {
            p.load(i);
        } catch (IOException e) {
            // Ignore
        }
        return p.getProperty(name);
    }
}
