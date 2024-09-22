package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.groupdocs.examples.annotation.utils.FilesUtils.makeOutputPath;
import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates loading document from Amazon S3 storage.
 * </p>
 */
public class LoadDocumentFromAmazonS3 {

    public static Path run(String inputFile) {
        final Path outputPath = makeOutputPath("LoadDocumentFromAmazonS3" + obtainExtension(Paths.get(inputFile)));

//        try (final Annotator annotator = new Annotator(downloadFile(inputFile))) {
//            AreaAnnotation area = new AreaAnnotation();
//            area.setBox(new Rectangle(100, 100, 100, 100));
//            area.setBackgroundColor(65535);
//            annotator.add(area);
//
//            annotator.save(outputPath.toString());
//        }
//
//        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());

        return outputPath;
    }

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
