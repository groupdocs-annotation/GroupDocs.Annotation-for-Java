package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.WatermarkAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding watermark annotation.
 * </p>
 */
public class AddWatermarkAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddWatermarkAnnotation" + obtainExtension(inputFile));

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

            WatermarkAnnotation watermark = new WatermarkAnnotation();
            watermark.setAngle(75.0);
            watermark.setBox(new Rectangle(200, 200, 100, 50));
            watermark.setCreatedOn(Calendar.getInstance().getTime());
            watermark.setText("Watermark");
            watermark.setFontColor(65535);
            watermark.setFontSize(12d);
            watermark.setMessage("This is watermark annotation");
            watermark.setOpacity(0.7);
            watermark.setPageNumber(0);
            watermark.setReplies(replies);
            annotator.add(watermark);

            annotator.save(outputPath.toString());
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}