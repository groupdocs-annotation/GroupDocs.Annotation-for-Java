package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.UnderlineAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding text underline annotation.
 * </p>
 */
public class AddTextUnderlineAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPathWithAnnotations = FilesUtils.makeOutputPath("AddTextUnderlineAnnotation-with-annotations" + obtainExtension(inputFile));

        try (Annotator annotator = new Annotator(inputFile.toString())) {

            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());

            java.util.List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            Point point1 = new Point(80, 730);
            Point point2 = new Point(240, 730);
            Point point3 = new Point(80, 650);
            Point point4 = new Point(240, 650);

            java.util.List<Point> points = Arrays.asList(point1, point2, point3, point4);

            UnderlineAnnotation underline = new UnderlineAnnotation();
            underline.setCreatedOn(Calendar.getInstance().getTime());
            underline.setFontColor(65535);
            underline.setMessage("This is underline annotation");
            underline.setOpacity(0.7);
            underline.setPageNumber(0);
            underline.setPoints(points);
            underline.setReplies(replies);

            annotator.add(underline);

            annotator.save(outputPathWithAnnotations.toString());

        }

        final Path outputPathNoneAnnotations = FilesUtils.makeOutputPath("AddTextUnderlineAnnotation-none-annotations" + obtainExtension(inputFile));

        try (Annotator annotator = new Annotator(outputPathWithAnnotations.toString())) {

            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setAnnotationTypes(AnnotationType.NONE);

            annotator.save(outputPathNoneAnnotations.toString(), saveOptions);

        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPathWithAnnotations.getParent());
        return outputPathWithAnnotations;
    }
}