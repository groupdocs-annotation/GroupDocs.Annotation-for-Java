---
id: load-document-from-ftp
url: annotation/java/load-document-from-ftp
title: Load document from FTP
weight: 4
description: "This article explains how to load PDF, Word, Excel, PowerPoint documents from FTP when using GroupDocs.Annotation for Java."
keywords: Load document from URL, Load document by FTP GroupDocs.Annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
Following example demonstrates how to annotate document from FTP.

```csharp
import org.apache.commons.net.ftp.FTPClient;

public static void main() {
    String outputPath = "LoadDocumentFromFtp.pdf";
    String filePath = "sample.pdf";
    String server = "localhost";
    
	Annotator annotator = new Annotator(getFileFromFtp(server, filePath));
    
	AreaAnnotation area = new AreaAnnotation();
    area.setBox(new Rectangle(100, 100, 100, 100));
    area.setBackgroundColor(65535);

	annotator.add(area);
    annotator.save(outputPath);    
	annotator.dispose();
}

private static InputStream getFileFromFtp(String server, String filePath) throws IOException {
    FTPClient client = new FTPClient();
    client.connect(server);
    InputStream inputStream = client.retrieveFileStream(filePath);
    client.disconnect();
    return inputStream;
}
```

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Annotation for .NET examples, plugins, and showcase](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-.NET)
    
*   [GroupDocs.Annotation for Java examples, plugins, and showcase](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java)
    
*   [Document Annotation for .NET MVC UI Example](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-.NET-MVC) 
    
*   [Document Annotation for .NET App WebForms UI Modern Example](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-.NET-WebForms)
    
*   [Document Annotation for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java-Dropwizard)
    
*   [Document Annotation for Java Spring UI Example](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java-Spring)
    

### Free Online App

Along with full-featured Java library we provide simple, but powerful free Apps.

You are welcome to annotate your PDF, DOC or DOCX, XLS or XLSX, PPT or PPTX, PNG and other documents with free to use online **[GroupDocs Annotation App](https://products.groupdocs.app/annotation)**.
