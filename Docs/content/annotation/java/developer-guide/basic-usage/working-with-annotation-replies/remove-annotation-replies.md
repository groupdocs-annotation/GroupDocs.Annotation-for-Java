---
id: remove-annotation-replies
url: annotation/java/remove-annotation-replies
title: Remove annotation replies
weight: 2
description: "Check this guide to learn how to remove all or specific annotation replies when collaborate over document using GroupDocs.Annotation for Java API."
keywords: How to remove annotation reply, remove annotation reply, remove reply, reply to annotation, remove annotation comment
productName: GroupDocs.Annotation for Java
hideChildren: False
---
There is a quick and convenient way to remove specific or even all replies for some document annotation using **[GroupDocs.Annotation](https://products.groupdocs.com/annotation/java)** API. It is as easy as removing items from generic [List<T>](https://docs.microsoft.com/en-us/dotnet/api/system.collections.generic.list-1) collection. In common case you have to follow these steps to delete replies:

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) objectwith input document path or stream
    
*   Call [get](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#get()) method of [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object and obtain collection of document annotations;
    
*   Access desired annotation object and remove reply in a most suitable way:
    
    *   Call *annotations.get(index).getReplies().remove(*index*)* method with desired parameters;
        
    *   Call [AnnotationBase.getReplies()](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase#getReplies()) and remove replies that match desired criteria;
        
*   Call [update](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#update(java.util.List)) method of [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object and pass annotations collection into it;
    
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.lang.String)) method with resultant document path or stream;
    

## Remove specific annotation reply 

The easiest way for removing specific annotation reply is to delete by its index inside Replies collection. The following code sample demonstrates how to remove first annotation reply:

```csharp
LoadOptions loadOptions = new LoadOptions();
loadOptions.setImportAnnotations(true);

// NOTE: Input document already contain annotations with replies
final Annotator annotator = new Annotator("annotated_with_replies.pdf", loadOptions);

// Obtain annotations collection from document
List<AnnotationBase> annotations = annotator.get();

// Remove first reply
annotations.get(0).getReplies().remove(0);

// Save changes
annotator.update(annotations);
annotator.save("RemoveRepliesById.pdf");

annotator.dispose();
```

## Remove annotation replies by criteria

The following code demonstrates how to remove replies that were added by user with name Tom:

```csharp
LoadOptions loadOptions = new LoadOptions();
loadOptions.setImportAnnotations(true);
 
// NOTE: Input document already contain annotations with replies
final Annotator annotator = new Annotator("annotated_with_replies.pdf", loadOptions);
 
// Obtain annotations collection from document
List<AnnotationBase> annotations = annotator.get();
 
// Remove all replies where author name is "Tom"
for(int i = 0; i < annotations.get(0).getReplies().size(); i++) {
    if(annotations.get(0).getReplies().get(i).getUser().getName().toString().equals("Tom")) {
        annotations.get(0).getReplies().remove(i);
    }
}
 
// Save changes
annotator.update(annotations);
annotator.save("RemoveRepliesByUserName.pdf");
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

`String outputPath =` `"RemoveRepliesByUserName.pdf"``;`

`LoadOptions loadOptions =` `new` `LoadOptions();`

`loadOptions.setImportAnnotations(``true``);`

`// NOTE: Input document already contain annotations with replies`

`final` `Annotator annotator =` `new` `Annotator(``"annotated_with_replies.pdf"``, loadOptions);`

`// Obtain annotations collection from document`

`List<AnnotationBase> annotations = annotator.get();`

`// Remove all replies where author name is "Tom"`

`for``(``int` `i =` `0``; i < annotations.get(``0``).getReplies().size(); i++) {`

`if``(annotations.get(``0``).getReplies().get(i).getUser().getName().toString().equals(``"Tom"``)) {`

`annotations.get(``0``).getReplies().remove(i);`

`}`

`}`

`// Save changes`

`annotator.update(annotations);`

`annotator.save(outputPath);`

`annotator.dispose();`
