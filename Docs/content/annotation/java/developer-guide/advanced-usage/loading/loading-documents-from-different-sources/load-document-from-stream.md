---
id: load-document-from-stream
url: annotation/java/load-document-from-stream
title: Load document from stream
weight: 2
description: "This article explains how to load PDF, Word, Excel, PowerPoint documents from stream when using GroupDocs.Annotation for Java."
keywords: Load document from stream, Load document with GroupDocs.Annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
There might be the case when source or target document is not physically located on the disk. Instead, you have the document in the form of a stream. In this case, to avoid the overhead of saving stream as a file on disk, [**GroupDocs.Annotation**](https://products.groupdocs.com/annotation/java) provides a way to work with document streams directly.   
The following are the steps to be followed:

*   Obtain document stream; 
*   Pass opened source document stream to [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator)class constructor.

Following code snippet describes this case.

**Java**

```csharp
String outputPath = "LoadDocumentFromStream.pdf";

InputStream stream = new FileInputStream("input.pdf");
final Annotator annotator = new Annotator(stream);

AreaAnnotation area = new AreaAnnotation();
area.setBox(new Rectangle(100, 100, 100, 100));
area.setBackgroundColor(65535);

annotator.add(area);
annotator.save(outputPath);
annotator.dispose();
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
