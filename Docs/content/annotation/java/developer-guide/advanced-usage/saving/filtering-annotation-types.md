---
id: filtering-annotation-types
url: annotation/java/filtering-annotation-types
title: Filtering annotation types
weight: 1
description: "Learn this guide to check how to filter annotation types during saving document using GroupDocs.Annotation for Java API."
keywords: save specific annotation types, save annotations
productName: GroupDocs.Annotation for Java
hideChildren: False
---
This feature can be using when need to save only specific annotation types and ignore others.

The following are the steps how to filter exported annotations to document: 

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) objectwith input document path or stream;
    
*   Instantiate [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) objectand set [AnnotationType](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/AnnotationType) desired annotation type(s), that will presented in resultant document;
    
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream)) method with resultant document path or stream and [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) object;
    

Following code snippet shows how to save only pages with specific annotation type

**Java**

```csharp
String outputPath = "FilteringAnnotationTypes.pdf";

Annotator annotator = new Annotator("input.pdf");

AreaAnnotation area = new AreaAnnotation();
area.setBox(new Rectangle(100, 100, 100, 100));
area.setBackgroundColor(65535);
area.setPageNumber(1);

EllipseAnnotation ellipse = new EllipseAnnotation();
ellipse.setBox(new Rectangle(100, 100, 100, 100));
ellipse.setBackgroundColor(123456);
ellipse.setPageNumber(4);

List<AnnotationBase> tmp0 = new ArrayList<AnnotationBase>();
tmp0.add(area);
tmp0.add(ellipse);
annotator.add(tmp0);

SaveOptions tmp1 = new SaveOptions();
tmp1.setAnnotationTypes(AnnotationType.Ellipse);

annotator.save(outputPath, tmp1);
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
