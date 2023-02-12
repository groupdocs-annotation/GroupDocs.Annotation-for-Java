package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.UnderlineAnnotation;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding text underline annotation.
 * </p>
 */
public class AddTextUnderlineAnnotation {

    public static void run() {
        //String outputPath = Constants.getOutputFilePath("sample", "docx");
        String outputPath = Constants.getOutputFilePath("AddTextUnderlineAnnotation", FilenameUtils.getExtension(Constants.INPUT));

        Annotator annotator = new Annotator(/*Constants.PROJECT_PATH + Constants.SamplesPath + "sample.docx"*/Constants.INPUT);

        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        Point point1 = new Point(80, 730);
        Point point2 = new Point(240, 730);
        Point point3 = new Point(80, 650);
        Point point4 = new Point(240, 650);

        List<Point> points = new ArrayList<Point>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        UnderlineAnnotation underline = new UnderlineAnnotation();
        underline.setCreatedOn(Calendar.getInstance().getTime());
        underline.setFontColor(65535);
        underline.setMessage("This is underline annotation");
        underline.setOpacity(0.7);
        underline.setPageNumber(0);
        underline.setPoints(points);
        underline.setReplies(replies);
        annotator.add(underline);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);

        annotator = new Annotator(outputPath);

        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setAnnotationTypes(AnnotationType.NONE);

        String noneAnnotation = Paths.get(outputPath).resolveSibling("none-annotation.pdf").toString();

        annotator.save(noneAnnotation, saveOptions);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + noneAnnotation);
//        String outputPath = Constants.getOutputFilePath("AddTextUnderlineAnnotation", FilenameUtils.getExtension(Constants.INPUT));
//
//        final Annotator annotator = new Annotator(Constants.INPUT);
//
//        Reply reply1 = new Reply();
//        reply1.setComment("First comment");
//        reply1.setRepliedOn(Calendar.getInstance().getTime());
//
//        Reply reply2 = new Reply();
//        reply2.setComment("Second comment");
//        reply2.setRepliedOn(Calendar.getInstance().getTime());
//
//        java.util.List<Reply> replies = new ArrayList<Reply>();
//        replies.add(reply1);
//        replies.add(reply2);
//
//        Point point1 = new Point(80, 730);
//        Point point2 = new Point(240, 730);
//        Point point3 = new Point(80, 650);
//        Point point4 = new Point(240, 650);
//
//        List<Point> points = new ArrayList<Point>();
//        points.add(point1);
//        points.add(point2);
//        points.add(point3);
//        points.add(point4);
//
//        UnderlineAnnotation underline = new UnderlineAnnotation();
//        underline.setCreatedOn(Calendar.getInstance().getTime());
//        underline.setFontColor(65535);
//        underline.setMessage("This is underline annotation");
//        underline.setOpacity(0.7);
//        underline.setPageNumber(0);
//        underline.setPoints(points);
//        underline.setReplies(replies);
//        annotator.add(underline);
//        annotator.save(outputPath);
//
//        annotator.dispose();
//
//        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}