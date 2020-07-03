---
id: get-supported-file-formats
url: annotation/java/get-supported-file-formats
title: Get supported file formats
weight: 1
description: "This article explains how to obtain supported file formats list when annotate documents and images with GroupDocs.Annotation within your Java applications."
keywords: supported image formats, supported file formats, annotation, Groupdocs annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
**[GroupDocs.Annotation](https://products.groupdocs.com/annotation/java)** allows to get the list of all supported file formats by following the below steps:

*   Call [getSupportedFileTypes()](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/FileType#getSupportedFileTypes()) method of [FileType](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/FileType) class;
*   Enumerate through the collection of [FileType](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/FileType) objects.

The following code sample demonstrates how to get supported file formats list.

```java
		List<FileType> fileTypes = FileType.getSupportedFileTypes();
        //foreach to while statements conversion
        Iterator items = (fileTypes).iterator();
        while (items.hasNext()) {
            FileType fileType = (FileType) items.next();
            System.out.println(fileType.getExtension());
        }
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
