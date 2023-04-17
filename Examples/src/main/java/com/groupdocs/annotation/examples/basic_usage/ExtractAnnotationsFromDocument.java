package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * This example demonstrates how to extract annotations
 * </p>
 */
public class ExtractAnnotationsFromDocument {
    public static void run(String inputFile) {
        try (final InputStream inputStream = new FileInputStream(inputFile);
             final Annotator annotator = new Annotator(inputStream)){
            List<AnnotationBase> annotations = annotator.get();

            Iterator<AnnotationBase> items = (annotations).iterator();
            while (items.hasNext()) {
                AnnotationBase annotation = items.next();
                System.out.println(annotation.getMessage());
            }
            System.out.println("Annotations extracted successfully.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
