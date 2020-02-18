package com.groupdocs.annotation.examples.advanced_usage.loading.loadingdocumentsfromdifferentsources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;

/**
 * <p>
 * This example demonstrates loading document from Amazon S3 storage.
 * </p>
 */
public class LoadDocumentFromAmazonS3 {

//    public static void run() {
//        String outputPath = Path.Combine(Constants.getOutputDirectoryPath(), "result" + Path.GetExtension(Constants.INPUT));
//
//        String key = "sample.pdf";
//        final Annotator annotator = new Annotator(downloadFile(key));
//        try {
//            AreaAnnotation area = new AreaAnnotation();
//            area.setBox(new Rectangle(100, 100, 100, 100);
//            area.setBackgroundColor(65535;
//            annotator.add(area);
//            annotator.save(outputPath);
//        } finally {
//            if (annotator != null) {
//                annotator.dispose();
//            }
//        }
//        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
//    }

//    private static Stream downloadFile(String key) {
//        AmazonS3Client client = new AmazonS3Client();
//        String bucketName = "my-bucket";
//        GetObjectRequest request = new GetObjectRequest();
//        request.Key = key;
//        request.BucketName = bucketName;
//        final GetObjectResponse response = client.GetObject(request);
//        try {
//            MemoryStream stream = new MemoryStream();
//            response.ResponseStream.CopyTo(stream);
//            stream.setPosition(0);
//            return stream;
//        } finally {
//            if (response != null) {
//                ((IDisposable) response).dispose();
//            }
//        }
//    }
}
