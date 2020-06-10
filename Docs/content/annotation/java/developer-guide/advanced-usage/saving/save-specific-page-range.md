---
id: save-specific-page-range
url: annotation/java/save-specific-page-range
title: Save specific page range
weight: 3
description: "This article demonstrates how to save specific page range when annotating documents with GroupDocs.Annotation for Java API."
keywords: Save specific annotated pages, save specific pages
productName: GroupDocs.Annotation for Java
hideChildren: False
---
In case of processing large documents (for example 100 pages or more) there is an ability to save only specific pages or desired pages range.   
  
The following are the steps how to export resultant specific page range: 

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) objectwith input document path or stream;
    
*   Instantiate [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) objectand use [setFirstPage](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions#setFirstPage(int))and high bound [setLastPage](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions#setLastPage(int))*for setting select borders*;
    
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream))method with resultant document path or stream and [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) object;
    

The following code demonstrates how to save the range of document page: 

```csharp
String outputPath = "SavingSpecificPageRange.pdf";

Annotator annotator = new Annotator("input.pdf");

SaveOptions saveOptions = new SaveOptions();
saveOptions.setFirstPage(2);
saveOptions.setLastPage(4);

annotator.save(outputPath, saveOptions);

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

Along with full-featured Java library we provide simple but powerful free Apps.

You are welcome to annotate your PDF, DOC or DOCX, XLS or XLSX, PPT or PPTX, PNG and other documents with free to use online **[GroupDocs Annotation App](https://products.groupdocs.app/annotation)**.
