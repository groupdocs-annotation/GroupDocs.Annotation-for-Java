package com.groupdocs.annotation.examples.advanced_usage.loading.loadingdocumentsfromdifferentsources;

/**
 * <p>
 * This example demonstrates loading document from Azure.
 * </p>
 */
public class LoadDocumentFromAzure {

//    public static void run() {
//        String outputPath = Path.Combine(Constants.getOutputDirectoryPath(), "result" + Path.GetExtension(Constants.INPUT));
//
//        String blobName = "sample.pdf";
//        final Annotator annotator = new Annotator(downloadFile(blobName));
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
