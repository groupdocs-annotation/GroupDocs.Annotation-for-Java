package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * <p>
 * This example demonstrates how to extract annotations
 * </p>
 */
public class ExtractAnnotationsFromDocument {
    public static List<AnnotationBase> run(Path inputFile) {
        try (final InputStream inputStream = Files.newInputStream(inputFile);
             final Annotator annotator = new Annotator(inputStream)) {
            List<AnnotationBase> annotations = annotator.get();

            for (AnnotationBase annotation : annotations) {
                System.out.println("\t" + annotation.getMessage());
            }
            System.out.println("Annotations extracted successfully.");
            return annotations;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
