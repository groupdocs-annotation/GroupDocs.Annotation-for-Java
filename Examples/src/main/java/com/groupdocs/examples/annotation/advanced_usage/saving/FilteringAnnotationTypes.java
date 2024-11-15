package com.groupdocs.examples.annotation.advanced_usage.saving;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.annotation.models.annotationmodels.EllipseAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates saving result document with specified annotations
 * </p>
 */
public class FilteringAnnotationTypes {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("FilteringAnnotationTypes" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            AreaAnnotation areaAnnotation = new AreaAnnotation();
            areaAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            areaAnnotation.setBackgroundColor(65535);
            areaAnnotation.setPageNumber(1);

            EllipseAnnotation ellipseAnnotation = new EllipseAnnotation();
            ellipseAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            ellipseAnnotation.setBackgroundColor(123456);
            ellipseAnnotation.setPageNumber(2);

            List<AnnotationBase> annotations = new ArrayList<>();
            annotations.add(areaAnnotation);
            annotations.add(ellipseAnnotation);

            annotator.add(annotations);

            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setAnnotationTypes(AnnotationType.ELLIPSE);
            annotator.save(outputPath.toString(), saveOptions);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
