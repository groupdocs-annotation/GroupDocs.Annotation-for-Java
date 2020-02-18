package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.options.LoadOptions;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * This example demonstrates how to extract annotations
 * </p>
 */
public class ExtractAnnotationsFromDocument {

    public static void run() throws IOException {

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setImportAnnotations(true);
        final Annotator annotator = new Annotator(Constants.ANNOTATED_IMPORT, loadOptions);

        List<AnnotationBase> annotations = annotator.get();

        Iterator items = (annotations).iterator();
        while (items.hasNext()) {
            AnnotationBase annotation = (AnnotationBase) items.next();
            System.out.println(annotation.getMessage());
        }
        System.out.println("Annotations extracted successfully.");

        annotator.dispose();
    }
}
