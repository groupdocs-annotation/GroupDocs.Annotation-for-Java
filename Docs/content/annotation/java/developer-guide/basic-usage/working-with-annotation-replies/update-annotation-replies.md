---
id: update-annotation-replies
url: annotation/java/update-annotation-replies
title: Update annotation replies
weight: 3
description: "Check this guide to learn how to update annotation replies when collaborate over document using GroupDocs.Annotation for Java API."
keywords: How to change or remove annotation reply, update annotation reply, remove reply, reply to annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
[**GroupDocs.Annotation**](https://products.groupdocs.com/annotation/java) provides and ability to programmatically update annotation replies by accessing them by their index inside [Replies](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase#getReplies()) collection.

Here is a steps to update annotation reply (considered that we already have some reply added to annotation)
*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with input document path or stream with instantiated [LoadOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options/LoadOptions) with *ImportAnnotations = true;*
*   Call [get](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#get()) method of [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object and import annotations;
*   Access desired reply object via [getReplies](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase#getReplies()) method collection by its index (zero-based) and update its properties as needed;
*   Call [update](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#update(java.util.List)) method of Annotator object with passed annotations;
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream)) method with resultant document path or stream and [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) object;

The following code demonstrates how to update reply by index:

```java
LoadOptions loadOptions = new LoadOptions();
loadOptions.setImportAnnotations(true);

// NOTE: Input document already contain annotations with replies
final Annotator annotator = new Annotator("annotated_with_replies.pdf", loadOptions);

// Obtain annotations collection from document
List<AnnotationBase> annotations = annotator.get();

// Update first annotation first reply
annotations.get(0).getReplies().get(0).setComment("Updated comment");

// Save changes
annotator.update(annotations);
annotator.save("RemoveRepliesById.pdf");

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
You are welcome to annotate your PDF, DOC or DOCX, XLS or XLSX, PPT or PPTX, PNG and other documents with free to use online [**GroupDocs Annotation App**](https://products.groupdocs.app/annotation).
