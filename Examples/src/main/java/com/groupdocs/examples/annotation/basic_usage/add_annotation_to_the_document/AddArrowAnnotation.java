package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.ArrowAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * Demonstrates how to add an arrow annotation to a document.
 * </p>
 * This example shows how to create an instance of the `ArrowAnnotation` class, set its properties,
 * and then add it to a document using the `Annotator`.
 */
public class AddArrowAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddArrowAnnotation" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());

            java.util.List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            ArrowAnnotation arrowAnnotation = new ArrowAnnotation();
            arrowAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            arrowAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            arrowAnnotation.setMessage("This is arrow annotation");
            arrowAnnotation.setOpacity(0.7);
            arrowAnnotation.setPageNumber(0);
            arrowAnnotation.setPenColor(65535);
            arrowAnnotation.setPenStyle(PenStyle.DOT);
            arrowAnnotation.setPenWidth((byte) 3);
            arrowAnnotation.setReplies(replies);

            annotator.add(arrowAnnotation);

            annotator.save(outputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
