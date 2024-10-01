package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.TextFieldAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding text field annotation.
 * </p>
 */
public class AddTextFieldAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddTextFieldAnnotation" + obtainExtension(inputFile));

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

            TextFieldAnnotation textFieldAnnotation = new TextFieldAnnotation();
            textFieldAnnotation.setBackgroundColor(65535);
            textFieldAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            textFieldAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            textFieldAnnotation.setText("Some text");
            textFieldAnnotation.setFontColor(65535);
            textFieldAnnotation.setFontSize(12d);
            textFieldAnnotation.setMessage("This is text field annotation");
            textFieldAnnotation.setOpacity(0.7);
            textFieldAnnotation.setPenStyle(PenStyle.DOT);
            textFieldAnnotation.setPenWidth((byte) 3);
            textFieldAnnotation.setReplies(replies);

            annotator.add(textFieldAnnotation);

            annotator.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
