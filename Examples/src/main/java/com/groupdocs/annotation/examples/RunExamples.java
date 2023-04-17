package com.groupdocs.annotation.examples;

import com.groupdocs.annotation.examples.advanced_usage.*;
import com.groupdocs.annotation.examples.advanced_usage.loading.*;
import com.groupdocs.annotation.examples.advanced_usage.loading.loading_documents_from_different_sources.*;
import com.groupdocs.annotation.examples.advanced_usage.saving.*;
import com.groupdocs.annotation.examples.basic_usage.*;
import com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document.*;
import com.groupdocs.annotation.examples.quick_start.*;
import java.io.IOException;


public class RunExamples {

    public static void main(String[] args) throws IOException {
        System.out.println("Open RunExamples.java. \nIn Main() method uncomment the example that you want to run.");
        System.out.println("=====================================================");
        
        //NOTE: Please uncomment the example you want to try out
        //  Quick Start
        SetLicenseFromFile.run();
        SetLicenseFromStream.run();
//        SetMeteredLicense.run();

        //  Get supported file formats
        GetSupportedFileFormats.run();

        //  Get file info
        GetFileInfo.run(Constants.INPUT_PDF);
        GetFileInfo.run(Constants.INPUT_DOC);
        GetFileInfo.run(Constants.INPUT_CELL);

        //  Extract annotations from document
       ExtractAnnotationsFromDocument.run(Constants.INPUT_PDF);
//       ExtractAnnotationsFromDocument.run(Constants.INPUT_DOC);
//       ExtractAnnotationsFromDocument.run(Constants.INPUT_CELL);

        //  Remove annotation from document
//        RemoveAnnotationFromDocument.run();

        //  Generate document pages preview
        GenerateDocumentPagesPreview.run(Constants.INPUT_PDF);
//        GenerateDocumentPagesPreview.run(Constants.INPUT_DOC);
//        GenerateDocumentPagesPreview.run(Constants.INPUT_CELL);

        //  Saving specific page range
        SavingSpecificPageRange.run(Constants.INPUT_PDF);

        //  Saving only pages with annotations
        SavingOnlyPagesWithAnnotations.run(Constants.INPUT_PDF);

        //  Filtering annotation types
        FilteringAnnotationTypes.run(Constants.INPUT_PDF);

        //  Add area annotation
        AddAreaAnnotation.run();

        //  Add arrow annotation
        AddArrowAnnotation.run();

        //  Add distance annotation
        AddDistanceAnnotation.run();

        //  Add ellipse annotation
        AddEllipseAnnotation.run();

        //  Add link annotation
        AddLinkAnnotation.run();

        //  Add point annotation
        AddPointAnnotation.run();

        //  Add resources redaction annotation
        AddResourcesRedactionAnnotation.run();

        //  Add text highlight annotation
        AddTextHighlightAnnotation.run();

        //  Add text field annotation
        AddTextFieldAnnotation.run();

        //  Add text redaction annotation
        AddTextRedactionAnnotation.run();

        //  Add text replacement annotation
        AddTextReplacementAnnotation.run();

        //  Add text strikeout annotation
        AddTextStrikeoutAnnotation.run();

        //  Add polyline annotation
        AddPolylineAnnotation.run();

        //  Add underline annotation
        AddTextUnderlineAnnotation.run();

        //  Add watermark annotation
        AddWatermarkAnnotation.run();

        //  Add replies annotation
        AddReplies.run();

        //  Remove replies
        RemoveReplies.run();

        //  Remove replies by Id
//        RemoveRepliesById.run();

        //  Remove replies by user name
//        RemoveRepliesByUserName.run();

        //  Update annotation
        UpdateAnnotation.run();

        //  Load document from local disk
        LoadDocumentFromLocalDisk.run();

         //  Load document from stream
         LoadDocumentFromStream.run();

         //  Load password-protected documents
         LoadPasswordProtectedDocuments.run();

         //  Load document from url
         LoadDocumentFromUrl.run();

         //  Load document from FTP
         LoadDocumentFromFtp.run();

         //  Load document from AmazonS3
//         LoadDocumentFromAmazonS3.run();

         //  Load document from Azure
//         LoadDocumentFromAzure.run();

        MinimalAnnotation.run();

        AddUserRole.run();
         
        System.out.println();
        System.out.println("All done.");
    }
}
