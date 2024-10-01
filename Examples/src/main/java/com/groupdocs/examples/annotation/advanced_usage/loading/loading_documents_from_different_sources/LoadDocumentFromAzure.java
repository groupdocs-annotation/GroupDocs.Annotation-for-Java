package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates loading document from Azure.
 * </p>
 */
public class LoadDocumentFromAzure {

    public static Path run(String inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("LoadDocumentFromAzure" + obtainExtension(Paths.get(inputFile)));

//        try (final Annotator annotator = new Annotator(downloadFile(inputFile))) {
//            AreaAnnotation area = new AreaAnnotation();
//            area.setBox(new Rectangle(100, 100, 100, 100));
//            area.setBackgroundColor(65535);
//            annotator.add(area);
//
//            annotator.save(outputPath.toString());
//        } catch (Exception e) {
//            FailureRegister.getInstance().registerFailedSample(e);
//            return null;
//        }
//
//        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());

        return outputPath;
    }

//    public static Stream downloadFile(String blobName) {
//        CloudBlobContainer container = getContainer();
//        CloudBlob blob = container.GetBlobReference(blobName);
//        MemoryStream memoryStream = new MemoryStream();
//        blob.DownloadToStream(memoryStream);
//        memoryStream.setPosition(0);
//        return memoryStream;
//    }

//    private static CloudBlobContainer getContainer() {
//        String accountName = "***";
//        String accountKey = "***";
//        String endpoint = "https://{accountName}.blob.core.windows.net/";
//        String containerName = "***";
//        StorageCredentials storageCredentials = new StorageCredentials(accountName, accountKey);
//        CloudStorageAccount cloudStorageAccount = new CloudStorageAccount(
//                storageCredentials, new Uri(endpoint), null, null, null);
//        CloudBlobClient cloudBlobClient = cloudStorageAccount.CreateCloudBlobClient();
//        CloudBlobContainer container = cloudBlobClient.GetContainerReference(containerName);
//        container.CreateIfNotExists();
//        return container;
//    }
}
