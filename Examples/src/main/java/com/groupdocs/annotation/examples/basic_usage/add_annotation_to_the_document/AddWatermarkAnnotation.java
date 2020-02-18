package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.WatermarkAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding watermark annotation.
 * </p>
 */
public class AddWatermarkAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddWatermarkAnnotation", FilenameUtils.getExtension(Constants.INPUT));

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

        WatermarkAnnotation watermark = new WatermarkAnnotation();
        watermark.setAngle((double) 75);
        watermark.setBox(new Rectangle(200, 200, 100, 50));
        watermark.setCreatedOn(Calendar.getInstance().getTime());
        watermark.setText("Watermark");
        watermark.setFontColor(65535);
        watermark.setFontSize((double) 12);
        watermark.setMessage("This is watermark annotation");
        watermark.setOpacity(0.7);
        watermark.setPageNumber(0);
        watermark.setReplies(replies);
        annotator.add(watermark);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}