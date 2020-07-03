---
id: get-file-info
url: annotation/java/get-file-info
title: Get file info
weight: 2
description: "This article explains how to detect document file type, size and calculate pages count when annotate documents or images with GroupDocs.Annotation."
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
**[GroupDocs.Annotation](https://products.groupdocs.com/annotation/java)** allows to get document information which includes following methods.

*   [getFileType](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/IDocumentInfo#getFileType())
*   [getPageCount](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/IDocumentInfo#getPageCount())
*   [getSize](https://apireference-qa.groupdocs.com/java/annotation/com.groupdocs.annotation/IDocumentInfo#getSize())

The following code sample demonstrates how to get information about document.

```java
Annotator annotator = new Annotator("input.pdf");
IDocumentInfo info = annotator.getDocument().getDocumentInfo();

System.out.println(
    "\nFile type: "        + info.getFileType()
    +"\nNumber of pages: " + info.getPageCount()
    +"\nDocument size: "   + info.getSize() + " bytes" 
);

annotator.dispose();
```

## More resources
### Advanced Usage Topics
To learn more about document annotating features, please refer to the [advanced usage section]({{< ref "annotation/java/developer-guide/advanced-usage/_index.md" >}}).

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
