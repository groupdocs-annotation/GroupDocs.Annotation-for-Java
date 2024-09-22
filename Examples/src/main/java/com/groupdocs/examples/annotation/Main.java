package com.groupdocs.examples.annotation;

import com.groupdocs.examples.annotation.advanced_usage.GenerateDocumentPagesPreview;
import com.groupdocs.examples.annotation.advanced_usage.loading.LoadPasswordProtectedDocuments;
import com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromLocalDisk;
import com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromStream;
import com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromUrl;
import com.groupdocs.examples.annotation.advanced_usage.saving.FilteringAnnotationTypes;
import com.groupdocs.examples.annotation.advanced_usage.saving.SavingOnlyPagesWithAnnotations;
import com.groupdocs.examples.annotation.advanced_usage.saving.SavingSpecificPageRange;
import com.groupdocs.examples.annotation.basic_usage.*;
import com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document.*;
import com.groupdocs.examples.annotation.licensing.SetLicenseFromStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/annotation/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        System.out.println("\nAll done.");
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
//            SetLicenseFromFile.run();
            SetLicenseFromStream.run();
//            SetMeteredLicense.run();
        }
        { // Get supported file formats
            GetSupportedFileFormats.run();
        }
        { // Get file info
            GetFileInfo.run(SampleFiles.INPUT_PDF);
            GetFileInfo.run(SampleFiles.INPUT_DOC);
            GetFileInfo.run(SampleFiles.INPUT_CELL);
        }
        { // Extract annotations from document
            ExtractAnnotationsFromDocument.run(SampleFiles.INPUT_PDF);
            ExtractAnnotationsFromDocument.run(SampleFiles.INPUT_DOC);
            ExtractAnnotationsFromDocument.run(SampleFiles.INPUT_CELL);
        }
        { // Remove annotation from document
            RemoveAnnotationFromDocument.run(SampleFiles.ANNOTATED_AREA_REPLIES_5);
        }
        { // Generate document pages preview
            GenerateDocumentPagesPreview.run(SampleFiles.INPUT_PDF);
            GenerateDocumentPagesPreview.run(SampleFiles.INPUT_DOC);
            GenerateDocumentPagesPreview.run(SampleFiles.INPUT_CELL);
        }
        { // Save pages
            SavingSpecificPageRange.run(SampleFiles.INPUT_PDF);
            SavingOnlyPagesWithAnnotations.run(SampleFiles.INPUT_PDF);
        }
        { // Filter annotation types
            FilteringAnnotationTypes.run(SampleFiles.INPUT_PDF);
        }
        { // Add annotation to the document
            AddAreaAnnotation.run(SampleFiles.INPUT_PDF);
            AddArrowAnnotation.run(SampleFiles.INPUT_PDF);
            AddDistanceAnnotation.run(SampleFiles.INPUT_PDF);
            AddEllipseAnnotation.run(SampleFiles.INPUT_PDF);
            AddLinkAnnotation.run(SampleFiles.INPUT_PDF);
            AddImageAnnotation.run(SampleFiles.INPUT_PDF);
            AddPointAnnotation.run(SampleFiles.INPUT_PDF);
            AddPolylineAnnotation.run(SampleFiles.INPUT_PDF);
            AddResourcesRedactionAnnotation.run(SampleFiles.INPUT_PDF);
            AddTextHighlightAnnotation.run(SampleFiles.INPUT_PDF);
            AddTextFieldAnnotation.run(SampleFiles.INPUT_PDF);
            AddTextRedactionAnnotation.run(SampleFiles.INPUT_PDF);
            AddTextReplacementAnnotation.run(SampleFiles.INPUT_PDF);
            AddTextStrikeoutAnnotation.run(SampleFiles.INPUT_PDF);
            AddTextUnderlineAnnotation.run(SampleFiles.INPUT_PDF);
            AddWatermarkAnnotation.run(SampleFiles.INPUT_PDF);
        }
        { // Replies
            AddReplies.run(SampleFiles.INPUT_PDF);
            RemoveReplies.run(SampleFiles.ANNOTATED_WITH_REPLIES_NEW);
            RemoveRepliesById.run(SampleFiles.ANNOTATED_AREA_REPLIES_5);
            RemoveRepliesByUserName.run(SampleFiles.ANNOTATED_AREA_REPLIES_5);
        }
        { // Update annotation
            UpdateAnnotation.run(SampleFiles.INPUT_PDF);
        }
        { // Load document
            LoadDocumentFromLocalDisk.run(SampleFiles.INPUT_PDF);
            LoadDocumentFromStream.run(SampleFiles.INPUT_PDF);
            final String url = "https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/blob/master/Examples/Resources/SampleFiles/input.pdf?raw=true";
            LoadDocumentFromUrl.run(url);
            LoadPasswordProtectedDocuments.run(SampleFiles.INPUT_PROTECTED);
//            LoadDocumentFromFtp.run("sample.pdf", "localhost");
//            LoadDocumentFromAmazonS3.run("sample.pdf");
//            LoadDocumentFromAzure.run("sample.pdf");

        }
        {
            MinimalAnnotation.run(SampleFiles.INPUT_DOC);
            AddUserRole.run(SampleFiles.INPUT_PDF);
        }
    }
}
