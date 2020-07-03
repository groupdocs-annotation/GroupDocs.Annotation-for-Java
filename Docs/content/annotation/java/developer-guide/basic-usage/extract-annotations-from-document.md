---
id: extract-annotations-from-document
url: annotation/java/extract-annotations-from-document
title: Extract annotations from document
weight: 4
description: "Learn how to extract annotations from document when collaborate, edit and annotate documents using GroupDocs.Annotation for Java."
keywords: Extract annotations, annotate document, get document annotations
productName: GroupDocs.Annotation for Java
hideChildren: False
---
**[GroupDocs.Annotation](https://products.groupdocs.com/annotation/java)** provides an ability to extract annotations from document.  
To achieve this you should:

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with input document path or stream;
*   Instantiate [LoadOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/LoadOptions) object and call [setImportAnnotations](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/LoadOptions#setImportAnnotations(boolean)) with *true* argument;
*   Define variable with type *List<*[AnnotationBase](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase)*\>;*
*   Call [get](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#get()) method and return result to variable above.

The following code demonstrates how to extract annotations metadata from document:

```java
// for using this example input file ("annotated.pdf") must be with annotations
 
LoadOptions loadOptions = new LoadOptions();
loadOptions.setImportAnnotations(true);

final Annotator annotator = new Annotator("annotated.pdf", loadOptions);
List<AnnotationBase> annotations = annotator.get();
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
