package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.TextFieldAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding text field annotation.
 * </p>
 */
public class AddTextFieldAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddTextFieldAnnotation", FilenameUtils.getExtension(Constants.INPUT));

        final Annotator annotator = new Annotator(Constants.INPUT);

        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        TextFieldAnnotation textField = new TextFieldAnnotation();
        textField.setBackgroundColor(65535);
        textField.setBox(new Rectangle(100, 100, 100, 100));
        textField.setCreatedOn(Calendar.getInstance().getTime());
        textField.setText("Some text");
        textField.setFontColor(65535);
        textField.setFontSize((double) 12);
        textField.setMessage("This is text field annotation");
        textField.setOpacity(0.7);
        textField.setPageNumber(0);
        textField.setPenStyle(PenStyle.DOT);
        textField.setPenWidth((byte) 3);
        textField.setReplies(replies);
        annotator.add(textField);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
