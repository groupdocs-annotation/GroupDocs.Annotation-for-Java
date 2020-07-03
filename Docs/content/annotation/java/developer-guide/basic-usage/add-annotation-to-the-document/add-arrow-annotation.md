---
id: add-arrow-annotation
url: annotation/java/add-arrow-annotation
title: Add arrow annotation
weight: 2
description: "Learn what is arrow annotation and how to add it to a document programmatically using GroupDocs.Annotation for Java."
keywords: What is arrow annotation, how to add annotation, add arrow annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
**Arrow annotation** draws an arrow on the document like shown at the picture below. 

![](annotation/java/images/add-arrow-annotation.png)

There  is an ability to specify the next fields for [ArrowAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/ArrowAnnotation) type:

*   [Box](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getBox()) - defines annotation position at document page;
*   [Opacity](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getOpacity()) - allows to set annotation opacity;
*   [PenColor](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getPenColor()) - defines frame color;
*   [PenStyle](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getPenStyle()) - defines frame line style (solid, dash, dot etc.);
*   [PenWidth](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getPenWidth()) - defines frame line width in pixels.
    

Follow these steps to add Arrow annotation to document:
*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/ArrowAnnotation) object with input document path or stream;
*   Instantiate [ArrowAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/ArrowAnnotation) object with desired properties (position, page number, etc);
*   Call [add](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#add(com.groupdocs.annotation.models.annotationmodels.AnnotationBase)) method and pass [ArrowAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/ArrowAnnotation) object;
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream)) method with resultant document path or stream.
    

The following code demonstrates how to add [ArrowAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/ArrowAnnotation) to the document:

```java
String outputPath = Constants.getOutputFilePath("AddArrowAnnotation", FilenameUtils.getExtension(Constants.INPUT));
            final Annotator annotator = new Annotator(Constants.INPUT);
            try {
                Reply reply1 = new Reply();
                reply1.setComment("First comment");
                reply1.setRepliedOn(Calendar.getInstance().getTime());
                Reply reply2 = new Reply();
                reply2.setComment("Second comment");
                reply2.setRepliedOn(Calendar.getInstance().getTime());
                java.util.List<Reply> replies =  new ArrayList<Reply>();
                replies.add(reply1);
                replies.add(reply2);
                ArrowAnnotation arrow = new ArrowAnnotation();
                arrow.setBox(new Rectangle(100, 100, 100, 100));
                arrow.setCreatedOn(Calendar.getInstance().getTime());
                arrow.setMessage("This is arrow annotation");
                arrow.setOpacity(0.7);
                arrow.setPageNumber(0);
                arrow.setPenColor(65535);
                arrow.setPenStyle(PenStyle.Dot);
                arrow.setPenWidth((byte) 3);
                arrow.setReplies(replies);
                annotator.add(arrow);
                annotator.save(outputPath);
            } finally {
                if (annotator != null) {
                    annotator.dispose();
                }
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
