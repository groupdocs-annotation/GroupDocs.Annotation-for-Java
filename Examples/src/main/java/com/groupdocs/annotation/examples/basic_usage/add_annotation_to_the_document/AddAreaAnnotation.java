package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding area annotation.
 * </p>
 */
public class AddAreaAnnotation {

    public static void run() {
        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        String outputPath = Constants.getOutputFilePath("AddAreaAnnotation", FilenameUtils.getExtension(Constants.INPUT));

        final Annotator annotator = new Annotator(Constants.INPUT);

        AreaAnnotation area = new AreaAnnotation();
        area.setBackgroundColor(65535);
        area.setBox(new Rectangle(100, 100, 100, 100));
        area.setCreatedOn(Calendar.getInstance().getTime());
        area.setMessage("This is area annotation");
        area.setOpacity(0.7);
        area.setPageNumber(0);
        area.setPenColor(65535);
        area.setPenStyle(PenStyle.DOT);
        area.setPenWidth((byte) 3);
        area.setReplies(replies);
        annotator.add(area);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
