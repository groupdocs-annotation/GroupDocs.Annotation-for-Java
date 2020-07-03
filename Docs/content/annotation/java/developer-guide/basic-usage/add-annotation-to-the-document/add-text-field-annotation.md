---
id: add-text-field-annotation
url: annotation/java/add-text-field-annotation
title: Add text field annotation
weight: 12
description: "Learn what is a text field annotation and how to add it to a document programmatically using GroupDocs.Annotation for Java."
keywords: What is a text field annotation, how to add annotation, add text field annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
**Text field** annotation adds rectangle with a text inside, like shown at the picture below. 

![](annotation/java/images/add-text-field-annotation.png)

There is an ability to specify the next fields for [TextFieldAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation) type:
*   [BackgroundColor](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getBackgroundColor()) - describes area background color;
*   [Box](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getBox()) - defines annotation position at document page;
*   [Text](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getText()) - text that will be appear in rectangle
*   [FontColor](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getFontColor()) - color of the text
*   [FontFamily](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getFontFamily()) - name of text font;
*   [FontSize](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getFontSize())  - size of text font;
*   [Opacity](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getOpacity()) - allows to set annotation opacity;
*   [PenColor](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getPenColor()) - defines frame color;
*   [PenStyle](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getPenStyle()) - defines frame line style (solid, dash, dot etc.);
*   [PenWidth](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getPenWidth()) -  defines frame line width in pixels.
    
Follow these steps to add *TextField* annotation to document:
*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with input document path or stream;
*   Instantiate [TextFieldAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation) object with desired properties (position, page number, etc);
*   Call [add](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#add(com.groupdocs.annotation.models.annotationmodels.AnnotationBase)) method and pass [TextFieldAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation) object;
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream)) method with resultant document path or stream.
    

The following code demonstrates how to add [TextFieldAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation) to the document:

```java
String outputPath = Constants.getOutputFilePath("AddTextStrikeoutAnnotation", FilenameUtils.getExtension(Constants.INPUT));
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
                Point point1 = new Point(80, 730);
                Point point2 = new Point(240, 730);
                Point point3 = new Point(80, 650);
                Point point4 = new Point(240, 650);
                List<Point> points = new ArrayList<Point>();
                points.add(point1);
                points.add(point2);
                points.add(point3);
                points.add(point4);
                StrikeoutAnnotation strikeout = new StrikeoutAnnotation();
                strikeout.setCreatedOn(Calendar.getInstance().getTime());
                strikeout.setFontColor(65535);
                strikeout.setMessage("This is strikeout annotation");
                strikeout.setOpacity(0.7);
                strikeout.setPageNumber(0);
                strikeout.setPoints(points);
                strikeout.setReplies(replies);
                annotator.add(strikeout);
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
