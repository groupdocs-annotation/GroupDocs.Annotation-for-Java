---
id: update-annotations
url: annotation/java/update-annotations
title: Update annotations
weight: 6
description: "Check this article and learn how to edit annotation properties - change annotation position, size, appearance etc. when annotate documents using GroupDocs.Annotation for Java."
keywords: Update annotations, Edit annotation, Change annotation properties
productName: GroupDocs.Annotation for Java
hideChildren: False
---
That case can be used when need to update some annotation properties (move, resize, change color and so on) or even annotation. Note, that for using this case is necessary need to set annotation Id property. It’s need because **[GroupDocs.Annotation](https://products.groupdocs.com/annotation/java)** must know which annotation must be changed. Or you can pass list of annotations. In that case all previous annotation collection will be replaced from new list.

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with input document path or stream with instantiated [LoadOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/LoadOptions) with *ImportAnnotations = true;*
*   Create some [AnnotationBase](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase) implementation and set Id of existed annotation (if annotation with that Id not found, nothing will be changed) or path list of annotations (all existed annotations will be removed);
*   Call [update](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#update(java.util.List)) method of [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with passed annotations;
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream)) method with resultant document path or stream and [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) object;
    

The following code demonstrates how to update annotations:

```java
String outputPath = "UpdateAnnotation.pdf";
Annotator annotator = new Annotator("input.pdf");

Reply reply1 = new Reply();
reply1.setComment("Original first comment");
reply1.setRepliedOn(Calendar.getInstance().getTime());

Reply reply2 = new Reply();
reply2.setComment("Original second comment");
reply2.setRepliedOn(Calendar.getInstance().getTime());

java.util.List<Reply> replies = new ArrayList<Reply>();
replies.add(reply1);
replies.add(reply2);

AreaAnnotation original = new AreaAnnotation();
original.setId(1);
original.setBackgroundColor(65535);
original.setBox(new Rectangle(100, 100, 100, 100));
original.setCreatedOn(Calendar.getInstance().getTime());
original.setMessage("This is original annotation");
original.setReplies(replies);

// add original annotation
annotator.add(original);
annotator.save(outputPath);
annotator.dispose();

LoadOptions loadOptions = new LoadOptions();
loadOptions.setImportAnnotations(true);

// open annotated document
Annotator annotator1 = new Annotator(outputPath, loadOptions);

Reply reply3 = new Reply();
reply3.setComment("Updated first comment");
reply3.setRepliedOn(Calendar.getInstance().getTime());

Reply reply4 = new Reply();
reply4.setComment("Updated second comment");
reply4.setRepliedOn(Calendar.getInstance().getTime());

java.util.List<Reply> replies1 = new ArrayList<Reply>();
replies1.add(reply3);
replies1.add(reply4);

// suggest we want change some properties of existed annotation
AreaAnnotation updated = new AreaAnnotation();
updated.setId(1);
updated.setBackgroundColor(255);
updated.setBox(new Rectangle(0, 0, 50, 200));
updated.setCreatedOn(Calendar.getInstance().getTime());
updated.setMessage("This is updated annotation");
updated.setReplies(replies1);

// update annotation
annotator1.update(updated);
annotator1.save(outputPath);
annotator1.dispose();
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
