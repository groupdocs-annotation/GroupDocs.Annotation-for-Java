---
id: add-watermark-annotation
url: annotation/java/add-watermark-annotation
title: Add watermark annotation
weight: 15
description: "Learn what is a watermark annotation and how to add it to a document programmatically using GroupDocs.Annotation for Java."
keywords: What is a watermark annotation, how to add annotation, add watermark annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
**Watermark** annotation adds text watermark like shown at the picture below. 

![](annotation/java/images/add-watermark-annotation.png)

There is an ability to specify the next fields for [WatermarkAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/WatermarkAnnotation) type:

*   [Box](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/PointAnnotation#getBox()) - defines annotation position at document page;
    
*   [Text](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getText()) - text of watermark;
    
*   [FontColor](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/HighlightAnnotation#getFontColor())  - color of annotation text;
    
*   [FontFamily](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getFontFamily()) - name of text font;
    
*   [FontSize](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/TextFieldAnnotation#getFontSize())  - size of text font;
    
*   [Opacity](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/AreaAnnotation#getOpacity()) - allows to set annotation opacity;
    
*   [Angle](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.models.annotationmodels/WatermarkAnnotation#getAngle()) - watermark text angle.
    

Follow these steps to add Watermark annotation to document: 

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) objectwith input document path or stream;
    
*   Instantiate [WatermarkAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/WatermarkAnnotation) objectwith desired properties (position, color, etc);
    
*   Call [add](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#add(com.groupdocs.annotation.models.annotationmodels.AnnotationBase))method and pass [WatermarkAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/WatermarkAnnotation) object;
    
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream))method with resultant document path or stream.
    

The following code demonstrates how to add [WatermarkAnnotation](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/WatermarkAnnotation) to the document:

```csharp
String outputPath = Constants.getOutputFilePath("AddWatermarkAnnotation", FilenameUtils.getExtension(Constants.INPUT));
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
                WatermarkAnnotation watermark = new WatermarkAnnotation();
                watermark.setAngle((double) 75);
                watermark.setBox(new Rectangle(200, 200, 100, 50));
                watermark.setCreatedOn(Calendar.getInstance().getTime());
                watermark.setText("Watermark");
                watermark.setFontColor(65535);
                watermark.setFontSize((double) 12);
                watermark.setMessage("This is watermark annotation");
                watermark.setOpacity(0.7);
                watermark.setPageNumber(0);
                watermark.setReplies(replies);
                annotator.add(watermark);
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

Along with full-featured Java library we provide simple, but powerful free Apps.

You are welcome to annotate your PDF, DOC or DOCX, XLS or XLSX, PPT or PPTX, PNG and other documents with free to use online **[GroupDocs Annotation App](https://products.groupdocs.app/annotation)**.
