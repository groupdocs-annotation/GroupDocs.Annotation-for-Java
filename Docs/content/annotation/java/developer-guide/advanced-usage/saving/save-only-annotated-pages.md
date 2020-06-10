---
id: save-only-annotated-pages
url: annotation/java/save-only-annotated-pages
title: Save only annotated pages
weight: 2
description: "This article demonstrates how to save only annotated pages when using GroupDocs.Annotation for Java API."
keywords: Save annotated pages, save annotations
productName: GroupDocs.Annotation for Java
hideChildren: False
---
Result document will contains only pages, which contains any annotation.

The following are the steps how to export to resultant document only annotated pages: 

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) objectwith input document path or stream;
    
*   Instantiate [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) objectand set [AnnotationType](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/AnnotationType) desired annotation type(s), that will presented in resultant document;
    
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream))method with resultant document path or stream and [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) object;
    

Following code snippet shows how to save only annotated pages of document

```csharp
String outputPath = "SavingOnlyPagesWithAnnotations.pdf";

Annotator annotator = new Annotator("input.pdf");

AreaAnnotation area = new AreaAnnotation();
area.setBox(new Rectangle(100, 100, 100, 100));
area.setBackgroundColor(65535);
area.setPageNumber(1);

EllipseAnnotation ellipse = new EllipseAnnotation();
ellipse.setBox(new Rectangle(100, 100, 100, 100));
ellipse.setBackgroundColor(123456);
ellipse.setPageNumber(2);

List<AnnotationBase> annotations = new ArrayList<AnnotationBase>();
annotations.add(area);
annotations.add(ellipse);

annotator.add(annotations);

SaveOptions saveOptions = new SaveOptions();
saveOptions.setOnlyAnnotatedPages(true);
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

Along with full-featured Java library we provide simple, but powerful free Apps.

You are welcome to annotate your PDF, DOC or DOCX, XLS or XLSX, PPT or PPTX, PNG and other documents with free to use online **[GroupDocs Annotation App](https://products.groupdocs.app/annotation)**.
