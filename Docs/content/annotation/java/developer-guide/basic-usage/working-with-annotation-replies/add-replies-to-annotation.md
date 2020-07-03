---
id: add-replies-to-annotation
url: annotation/java/add-replies-to-annotation
title: Add replies to annotation
weight: 1
description: "Check this guide to learn how to add annotation replies when collaborate over document using GroupDocs.Annotation for Java API."
keywords: How to add annotation reply, add annotation reply, add reply, reply to annotation
productName: GroupDocs.Annotation for Java
hideChildren: False
---
[**GroupDocs.Annotation**](https://products.groupdocs.com/annotation/java) provides ability for several users to collaborate over document via annotation replies. Adding reply to an annotation via code is as easy as specifying reply content and related user object.  
Here are the steps to add annotation replies:

*   Instantiate [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with input document path or stream;
*   Instantiate [User](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models/User) object;
*   Instantiate [Reply](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models/Reply) object(s);
*   Instantiate some of [AnnotationBase](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase) implementation object;
*   Assign [User](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models/User) object to Reply.User property (or by default will be "Guest");
*   Assign [Reply](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models/Reply) object(s) to implementation of [AnnotationBase](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.models.annotationmodels/AnnotationBase) object Replies property;
*   Call [add](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#add(com.groupdocs.annotation.models.annotationmodels.AnnotationBase)) method of [Annotator](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator) object with passed annotations;
*   Call [save](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation/Annotator#save(java.io.InputStream)) method with resultant document path or stream and [SaveOptions](https://apireference.groupdocs.com/java/annotation/com.groupdocs.annotation.options.export/SaveOptions) object;
    
The following code demonstrates how to add replies to annotation:

```java
String outputPath = "AddReplies.pdf";

Annotator annotator = new Annotator("input.pdf");

User user1 = new User();
user1.setId(1);
user1.setName("Tom");
user1.setEmail("somemail@mail.com");

User user2 = new User();
user2.setId(2);
user2.setName("Jack");
user2.setEmail("somebody@mail.com");

AreaAnnotation area = new AreaAnnotation();
area.setBackgroundColor(65535);
area.setBox(new Rectangle(100, 100, 100, 100));
area.setCreatedOn(Calendar.getInstance().getTime());
area.setMessage("This is area annotation");
area.setOpacity(0.7);
area.setPageNumber(0);
area.setPenColor(65535);
area.setPenStyle(PenStyle.Dot);
area.setPenWidth((byte) 3);

Reply reply1 = new Reply();
reply1.setId(1);
reply1.setComment("First comment");
reply1.setRepliedOn(Calendar.getInstance().getTime());
reply1.setUser(user1);

Reply reply2 = new Reply();
reply2.setId(2);
reply2.setComment("Second comment");
reply2.setRepliedOn(Calendar.getInstance().getTime());
reply2.setUser(user2);

Reply reply3 = new Reply();
reply3.setId(3);
reply3.setComment("Third comment");
reply3.setRepliedOn(Calendar.getInstance().getTime());
reply3.setUser(user1);

Reply reply4 = new Reply();
reply4.setId(4);
reply4.setComment("Fourth comment");
reply4.setRepliedOn(Calendar.getInstance().getTime());
reply4.setUser(user2);
java.util.List<Reply> replies =  new ArrayList<Reply>();
replies.add(reply1);
replies.add(reply2);
replies.add(reply3);
replies.add(reply4);
area.setReplies(replies);
annotator.add(area);
annotator.save(outputPath);

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
