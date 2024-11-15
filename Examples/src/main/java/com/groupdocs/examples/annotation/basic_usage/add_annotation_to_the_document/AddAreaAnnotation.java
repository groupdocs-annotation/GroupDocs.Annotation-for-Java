package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * <p>
 * This example demonstrates adding area annotation.
 * </p>
 */
public class AddAreaAnnotation {
    public static Path run(Path inputFile) {
        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<>();
        replies.add(reply1);
        replies.add(reply2);

        final Path outputPath = FilesUtils.makeOutputPath("AddAreaAnnotation" + FilesUtils.obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            AreaAnnotation areaAnnotation = new AreaAnnotation();
            areaAnnotation.setBackgroundColor(65535);
            areaAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            areaAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            areaAnnotation.setMessage("This is area annotation");
            areaAnnotation.setOpacity(0.7);
            areaAnnotation.setPageNumber(0);
            areaAnnotation.setPenColor(65535);
            areaAnnotation.setPenStyle(PenStyle.DOT);
            areaAnnotation.setPenWidth((byte) 3);
            areaAnnotation.setReplies(replies);

            annotator.add(areaAnnotation);

            annotator.save(outputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
