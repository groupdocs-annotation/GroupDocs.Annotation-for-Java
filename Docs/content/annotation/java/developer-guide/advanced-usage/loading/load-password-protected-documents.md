---
id: load-password-protected-documents
url: annotation/java/load-password-protected-documents
title: Load password-protected documents
weight: 1
description: "This article explains how to load password-protected PDF, Word, Excel, PowerPoint documents when using GroupDocs.Annotation for Java."
keywords: Load password-protected document, Load protected document with GroupDocs.Annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
[**GroupDocs.Annotation**](https://products.groupdocs.com/annotation/java) allows to annotate documents that are protected with a password.

The following are the steps to process password-protected documents.

*   Instantiate [LoadOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/LoadOptions) object and specify source document password;
*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with document path or stream and [LoadOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/LoadOptions) object created at previous step;
    

The following code sample shows how to work with password protected documents.

```java
String outputPath = "LoadPasswordProtectedDocuments.pdf";

LoadOptions loadOptions = new LoadOptions();
loadOptions.setPassword("1234");

Annotator annotator = new Annotator("input_protected.pdf", loadOptions);
AreaAnnotation area = new AreaAnnotation();
area.setBox(new Rectangle(100, 100, 100, 100));
area.setBackgroundColor(65535);

annotator.add(area);
annotator.save(outputPath);
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
