---
id: groupdocs-annotation-for-java-18-10-release-notes
url: annotation/java/groupdocs-annotation-for-java-18-10-release-notes
title: GroupDocs.Annotation for Java 18.10 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 18.10{{< /alert >}}

## Major Features

Below is the list of most notable changes in release of GroupDocs.Annotation for Java:

*   Fixed removing watermarks after cleanup in PDF
*   Fixed highlight color is not changed in footnotes for highlight annotations in words.
*   Added a font highlight color change for text annotations in word
*   Improved integration tests coverage
*   Implemented using metadata for storing annotations on Slides
*   Implemented support of adding new types of annotations for Diagrams (Watermark, Point)
*   Implemented support of adding new types of annotations for Words (Watermark, Point)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-666 | Add a font highlight color change for text annotations in word | New Feature |
| ANNOTATIONNET-714 | Implement support of metadata in Slides | New Feature |
| ANNOTATIONNET-713 | Implement Watermark annotation in Diagrams | New Feature |
| ANNOTATIONNET-706 | Implement adding Point annotation in Diagrams | New Feature |
| ANNOTATIONNET-704 | Implement Polyline annotation for Words | New Feature |
| ANNOTATIONNET-700 | Implement watermark annotation for Words | New Feature |
| ANNOTATIONNET-697 | Implement Point annotation for Words | New Feature |
| ANNOTATIONNET-684 | Cleanup in PDF doesn't remove watermarks | Bug |
| ANNOTATIONNET-677 | Highlight color is not changed in footnotes for highlight annotations in words. | Bug |
| ANNOTATIONJAVA-1109 | Exception while running project on macOS | Bug |
| ANNOTATIONJAVA-1089 | License.isValidLicense returns wrong status | Bug |
| ANNOTATIONJAVA-1111 | An exception raises while accessing the source document | Bug |
| ANNOTATIONJAVA-1105 | Licensing is not working | Bug |
| ANNOTATIONJAVA-1107 | isValidLicense() property of License class always returns false | Bug |
| ANNOTATIONJAVA-1097 | TIFF/Multi TIFF file is either corrupted or black and white when annotated | Bug |
| ANNOTATIONJAVA-1098 | Some annotations are missing while exporting to file | Bug |
| ANNOTATIONJAVA-1088 | StringIndexOutOfBoundsException in AnnotationImageHandler.exportAnnotationsToDocument while exporting Line and Distance annotation | Bug |
| ANNOTATIONJAVA-1069 | Unable to retrieve un-annotated page image from annotated document | Bug |
| ANNOTATIONNET-667 | Improve integration tests coverage | Task |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 18.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added new types of annotations for Diagrams (Watermark, Point)
    
    **Java**
    
    ```csharp
    AnnotationConfig cfg = new AnnotationConfig();
    cfg.setStoragePath(storagePath);
    AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
    InputStream cleanDiagramFile = new FileInputStream(storagePath + File.separator + fileName);
    //FileInputStream input = new FileInputStream("AddAnnotations.TestData."); //Assembly.GetExecutingAssembly().GetManifestResourceStream("AddAnnotations.TestData.");
    List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
    
    // Area annotation with 2 replies
    AnnotationInfo areaAnnnotation = new AnnotationInfo();
    areaAnnnotation.setCreatedOn(new Date());
    areaAnnnotation.setType(AnnotationType.Area);
    areaAnnnotation.setBox(new Rectangle(200, 114.5f, 282.3f, 103.7f));
    
    // Polyline annotation
    AnnotationInfo polylineAnnotation = new AnnotationInfo();
    polylineAnnotation.setCreatedOn(new Date());
    polylineAnnotation.setType(AnnotationType.Polyline);
    polylineAnnotation.setBox(new Rectangle(206.3f, 106.61f, 456.04f, 307.97f));
    polylineAnnotation.setSvgPath("M436.293427230047,148.06338028169014l0,-0.9870892018779343l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-4.935446009389671,-1.9741784037558685l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-1.9741784037558685,0l-3.948356807511737,0l-2.961267605633803,0l-3.948356807511737,0l-4.935446009389671,0l-3.948356807511737,0.9870892018779343l-4.935446009389671,0.9870892018779343l-6.90962441314554,0l-3.948356807511737,0.9870892018779343l-3.948356807511737,0l-2.961267605633803,1.9741784037558685l-3.948356807511737,0.9870892018779343l-6.90962441314554,1.9741784037558685l-6.90962441314554,0.9870892018779343l-12.832159624413146,2.961267605633803l-6.90962441314554,1.9741784037558685l-5.922535211267606,0.9870892018779343l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,0.9870892018779343l-4.935446009389671,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-4.935446009389671,1.9741784037558685l-5.922535211267606,2.961267605633803l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-4.935446009389671,3.948356807511737l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-3.948356807511737,5.922535211267606l-3.948356807511737,4.935446009389671l-3.948356807511737,5.922535211267606l-3.948356807511737,6.90962441314554l-3.948356807511737,7.896713615023474l-0.9870892018779343,6.90962441314554l-1.9741784037558685,7.896713615023474l-1.9741784037558685,6.90962441314554l-0.9870892018779343,7.896713615023474l0,12.832159624413146l0,7.896713615023474l0,7.896713615023474l0.9870892018779343,7.896713615023474l1.9741784037558685,5.922535211267606l2.961267605633803,5.922535211267606l0.9870892018779343,5.922535211267606l2.961267605633803,6.90962441314554l3.948356807511737,5.922535211267606l4.935446009389671,4.935446009389671l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l6.90962441314554,5.922535211267606l7.896713615023474,5.922535211267606l7.896713615023474,5.922535211267606l17.767605633802816,8.883802816901408l11.845070422535212,3.948356807511737l11.845070422535212,4.935446009389671l23.690140845070424,8.883802816901408l41.45774647887324,6.90962441314554l31.586854460093896,3.948356807511737l16.780516431924884,0l16.780516431924884,1.9741784037558685l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,-1.9741784037558685l14.806338028169014,-1.9741784037558685l14.806338028169014,-1.9741784037558685l12.832159624413146,-1.9741784037558685l10.857981220657276,-2.961267605633803l10.857981220657276,-2.961267605633803l8.883802816901408,-4.935446009389671l8.883802816901408,-4.935446009389671l6.90962441314554,-6.90962441314554l6.90962441314554,-6.90962441314554l8.883802816901408,-16.780516431924884l4.935446009389671,-7.896713615023474l3.948356807511737,-8.883802816901408l4.935446009389671,-7.896713615023474l4.935446009389671,-7.896713615023474l3.948356807511737,-13.81924882629108l1.9741784037558685,-18.754694835680752l0,-7.896713615023474l0,-12.832159624413146l-1.9741784037558685,-15.793427230046948l-1.9741784037558685,-15.793427230046948l-4.935446009389671,-15.793427230046948l-8.883802816901408,-15.793427230046948l-12.832159624413146,-23.690140845070424l-10.857981220657276,-10.857981220657276l-5.922535211267606,-3.948356807511737l-12.832159624413146,-8.883802816901408l-9.870892018779342,-8.883802816901408l-5.922535211267606,-3.948356807511737l-12.832159624413146,-5.922535211267606l-15.793427230046948,-8.883802816901408l-13.81924882629108,-4.935446009389671l-11.845070422535212,-2.961267605633803l-11.845070422535212,-3.948356807511737l-11.845070422535212,-3.948356807511737l-5.922535211267606,-1.9741784037558685l-11.845070422535212,-2.961267605633803l-11.845070422535212,-1.9741784037558685l-5.922535211267606,-0.9870892018779343l-10.857981220657276,-1.9741784037558685l-10.857981220657276,-2.961267605633803l-9.870892018779342,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l0,-0.9870892018779343l1.9741784037558685,0");
    
    // Text field annotation
    AnnotationInfo textFieldAnnotation = new AnnotationInfo();
    textFieldAnnotation.setCreatedOn(new Date());
    textFieldAnnotation.setType(AnnotationType.TextField);
    textFieldAnnotation.setBox(new Rectangle(162.87f, 267.5f, 91.8f, 42.45f));
    textFieldAnnotation.setBackgroundColor(-15988609);
    textFieldAnnotation.setFieldText("Annotation Text");
    
    // Arrow annotation
    AnnotationInfo arrowAnnotation = new AnnotationInfo();
    arrowAnnotation.setType(AnnotationType.Arrow);
    arrowAnnotation.setBox(new Rectangle(435.77464788732397f, 148.05164319248826f, -66.34389671361504f, 53.07511737089203f));
    
    // Distance annotation
    AnnotationInfo distanceAnnotation = new AnnotationInfo();
    distanceAnnotation.setCreatedOn(new Date());
    distanceAnnotation.setType(AnnotationType.Distance);
    distanceAnnotation.setBox(new Rectangle((float)248.73202514648438, (float)287.85653686523438, (float)115.9178466796875, (float)25.143020629882812));
    distanceAnnotation.setSvgPath("M248.73201877934272,295.5439436619718 l115.28309859154929,-4.192112676056338");
    
    // Point annotation
    AnnotationInfo pointAnnnotation = new AnnotationInfo();
    pointAnnnotation.setCreatedOn(new Date());
    pointAnnnotation.setType(AnnotationType.Point);
    pointAnnnotation.setBox(new Rectangle(150.32f, 99.22f, 0, 0));
    pointAnnnotation.setPageNumber(0);
    
    // Point annotation
    AnnotationInfo watermarkAnnnotation = new AnnotationInfo();
    watermarkAnnnotation.setCreatedOn(new Date());
    watermarkAnnnotation.setFieldText("Watermark text");
    watermarkAnnnotation.setFontColor(16711680);
    watermarkAnnnotation.setFontFamily("Microsoft Sans Serif");
    watermarkAnnnotation.setFontSize(17);
    watermarkAnnnotation.setOpacity(0.3);
    watermarkAnnnotation.setType(AnnotationType.Watermark);
    
    // Resource redaction annotation
    AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
    resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
    resourceRedactionAnnotation.setBox(new Rectangle(200, 114.5f, 282.3f, 103.7f));
    annotations.add(areaAnnnotation);
    annotations.add(polylineAnnotation);
    annotations.add(textFieldAnnotation);
    annotations.add(arrowAnnotation);
    annotations.add(resourceRedactionAnnotation);
    annotations.add(distanceAnnotation);
    annotations.add(pointAnnnotation);
    annotations.add(watermarkAnnnotation);
    
    // Add annotation to the document
    InputStream result = annotator.exportAnnotationsToDocument(cleanDiagramFile, annotations);
    
    // Save result stream to file.
    OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "Annotated.vsdx");
    IOUtils.copy(result, fileStream);
    ```
    
2.  Added new types of annotations for Words (Polyline, Watermark, Point)
    
    **Java**
    
    ```csharp
    AnnotationConfig cfg = new AnnotationConfig();
    cfg.setStoragePath(storagePath);
    AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
     
    InputStream cleanDoc = new FileInputStream(storagePath + File.separator + "AddAnnotationsWords.TestData.Clear.docx");
    List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
     
    // init possible types of annotations
    AnnotationInfo textAnnotation = new AnnotationInfo();
    textAnnotation.setPageNumber(1);
    textAnnotation.setSvgPath("[{\"x\":186.698,\"y\":706.196},{\"x\":318.41201,\"y\":706.196},{\"x\":186.698,\"y\":697.196},{\"x\":318.41201,\"y\":697.196}]");
    textAnnotation.setType(AnnotationType.Text);
    textAnnotation.setText("Comment");
     
    AnnotationInfo areaAnnnotation = new AnnotationInfo();
    areaAnnnotation.setBackgroundColor(11111111);
    areaAnnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
    areaAnnnotation.setPageNumber(1);
    areaAnnnotation.setType(AnnotationType.Area);
     
    AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
    strikeoutAnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
    strikeoutAnnotation.setPageNumber(1);
    strikeoutAnnotation.setPenColor(1201033);
    strikeoutAnnotation.setSvgPath("[{\"x\":208.392,\"y\":313.088},{\"x\":519.659,\"y\":313.088},{\"x\":208.392,\"y\":304.088},{\"x\":519.659,\"y\":304.088}]");
    strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
     
    AnnotationInfo textFieldAnnotation = new AnnotationInfo();
    textFieldAnnotation.setFieldText("text in the box");
    textFieldAnnotation.setFontFamily("Arial");
    textFieldAnnotation.setFontSize(10);
    textFieldAnnotation.setBox(new Rectangle(92f, 73f, 106f, 45f));
    textFieldAnnotation.setPageNumber(1);
    textFieldAnnotation.setType(AnnotationType.TextField);
     
    AnnotationInfo textReplacementAnnotation = new AnnotationInfo();
    textReplacementAnnotation.setFieldText(" \"REPLACED TEXT\" ");
    textReplacementAnnotation.setFontSize(10);
    textReplacementAnnotation.setSvgPath("[{\"x\":251.224,\"y\":637.20401},{\"x\":327.89,\"y\":637.20401},{\"x\":251.224,\"y\":628.20401},{\"x\":327.89,\"y\":628.20401}]");
    textReplacementAnnotation.setPageNumber(0);
    textReplacementAnnotation.setType(AnnotationType.TextReplacement);
     
    AnnotationInfo arrowAnnotation = new AnnotationInfo();
    arrowAnnotation.setBox(new Rectangle(479f, 218f, -261f, -89f));
    arrowAnnotation.setPageNumber(1);
    arrowAnnotation.setType(AnnotationType.Arrow);
     
    AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
    textRedactionAnnotation.setPageNumber(2);
    textRedactionAnnotation.setSvgPath("[{\"x\":72,\"y\":676.07},{\"x\":196.427,\"y\":676.074},{\"x\":72,\"y\":662.674},{\"x\":196.427,\"y\":662.674}]");
    textRedactionAnnotation.setType(AnnotationType.TextRedaction);
     
    AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
    resourceRedactionAnnotation.setBox(new Rectangle(69f, 337f, 449f, 118f));
    resourceRedactionAnnotation.setPageNumber(1);
    resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
     
    AnnotationInfo underlineAnnotation = new AnnotationInfo();
    underlineAnnotation.setPageNumber(2);
    underlineAnnotation.setSvgPath("[{\"x\":415.17499,\"y\":628.874},{\"x\":511.85101,\"y\":628.874},{\"x\":415.17499,\"y\":619.874},{\"x\":511.85101,\"y\":619.874}]");
    underlineAnnotation.setType(AnnotationType.TextUnderline);
     
    // Polyline annotation
    AnnotationInfo polylineAnnotation = new AnnotationInfo();
    polylineAnnotation.setCreatedOn(new Date());
    polylineAnnotation.setType(AnnotationType.Polyline);
    polylineAnnotation.setBox(new Rectangle(206.3f, 106.61f, 456.04f, 307.97f));
    polylineAnnotation.setSvgPath("M436.293427230047,148.06338028169014l0,-0.9870892018779343l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-4.935446009389671,-1.9741784037558685l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-1.9741784037558685,0l-3.948356807511737,0l-2.961267605633803,0l-3.948356807511737,0l-4.935446009389671,0l-3.948356807511737,0.9870892018779343l-4.935446009389671,0.9870892018779343l-6.90962441314554,0l-3.948356807511737,0.9870892018779343l-3.948356807511737,0l-2.961267605633803,1.9741784037558685l-3.948356807511737,0.9870892018779343l-6.90962441314554,1.9741784037558685l-6.90962441314554,0.9870892018779343l-12.832159624413146,2.961267605633803l-6.90962441314554,1.9741784037558685l-5.922535211267606,0.9870892018779343l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,0.9870892018779343l-4.935446009389671,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-4.935446009389671,1.9741784037558685l-5.922535211267606,2.961267605633803l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-4.935446009389671,3.948356807511737l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-3.948356807511737,5.922535211267606l-3.948356807511737,4.935446009389671l-3.948356807511737,5.922535211267606l-3.948356807511737,6.90962441314554l-3.948356807511737,7.896713615023474l-0.9870892018779343,6.90962441314554l-1.9741784037558685,7.896713615023474l-1.9741784037558685,6.90962441314554l-0.9870892018779343,7.896713615023474l0,12.832159624413146l0,7.896713615023474l0,7.896713615023474l0.9870892018779343,7.896713615023474l1.9741784037558685,5.922535211267606l2.961267605633803,5.922535211267606l0.9870892018779343,5.922535211267606l2.961267605633803,6.90962441314554l3.948356807511737,5.922535211267606l4.935446009389671,4.935446009389671l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l6.90962441314554,5.922535211267606l7.896713615023474,5.922535211267606l7.896713615023474,5.922535211267606l17.767605633802816,8.883802816901408l11.845070422535212,3.948356807511737l11.845070422535212,4.935446009389671l23.690140845070424,8.883802816901408l41.45774647887324,6.90962441314554l31.586854460093896,3.948356807511737l16.780516431924884,0l16.780516431924884,1.9741784037558685l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,-1.9741784037558685l14.806338028169014,-1.9741784037558685l14.806338028169014,-1.9741784037558685l12.832159624413146,-1.9741784037558685l10.857981220657276,-2.961267605633803l10.857981220657276,-2.961267605633803l8.883802816901408,-4.935446009389671l8.883802816901408,-4.935446009389671l6.90962441314554,-6.90962441314554l6.90962441314554,-6.90962441314554l8.883802816901408,-16.780516431924884l4.935446009389671,-7.896713615023474l3.948356807511737,-8.883802816901408l4.935446009389671,-7.896713615023474l4.935446009389671,-7.896713615023474l3.948356807511737,-13.81924882629108l1.9741784037558685,-18.754694835680752l0,-7.896713615023474l0,-12.832159624413146l-1.9741784037558685,-15.793427230046948l-1.9741784037558685,-15.793427230046948l-4.935446009389671,-15.793427230046948l-8.883802816901408,-15.793427230046948l-12.832159624413146,-23.690140845070424l-10.857981220657276,-10.857981220657276l-5.922535211267606,-3.948356807511737l-12.832159624413146,-8.883802816901408l-9.870892018779342,-8.883802816901408l-5.922535211267606,-3.948356807511737l-12.832159624413146,-5.922535211267606l-15.793427230046948,-8.883802816901408l-13.81924882629108,-4.935446009389671l-11.845070422535212,-2.961267605633803l-11.845070422535212,-3.948356807511737l-11.845070422535212,-3.948356807511737l-5.922535211267606,-1.9741784037558685l-11.845070422535212,-2.961267605633803l-11.845070422535212,-1.9741784037558685l-5.922535211267606,-0.9870892018779343l-10.857981220657276,-1.9741784037558685l-10.857981220657276,-2.961267605633803l-9.870892018779342,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l0,-0.9870892018779343l1.9741784037558685,0");
             
             
    // Watermark annotation
    AnnotationInfo watermarkAnnnotation = new AnnotationInfo();
    watermarkAnnnotation.setCreatedOn(new Date());
    watermarkAnnnotation.setFieldText("Watermark text");
    watermarkAnnnotation.setFontColor(16711680);
    watermarkAnnnotation.setFontFamily("Microsoft Sans Serif");
    watermarkAnnnotation.setFontSize(17);
    watermarkAnnnotation.setOpacity(0.3);
    watermarkAnnnotation.setType(AnnotationType.Watermark);
    // Point annotation
    AnnotationInfo pointAnnnotation = new AnnotationInfo();
    pointAnnnotation.setCreatedOn(new Date());
    pointAnnnotation.setType(AnnotationType.Point);
    pointAnnnotation.setBox(new Rectangle(150.32f, 99.22f, 0, 0));
    pointAnnnotation.setPageNumber(0);
     
    annotations.add(textAnnotation);
    annotations.add(areaAnnnotation);
    annotations.add(strikeoutAnnotation);
    annotations.add(textFieldAnnotation);
    annotations.add(textReplacementAnnotation);
    annotations.add(arrowAnnotation);
    annotations.add(textRedactionAnnotation);
    annotations.add(resourceRedactionAnnotation);
    annotations.add(underlineAnnotation);
    annotations.add(polylineAnnotation);
    annotations.add(watermarkAnnnotation);
    annotations.add(pointAnnnotation);
     
    // Add annotation to the document
    InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
     
    // Save result stream to file.
    OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "words-annotated.docx");
    System.out.println(result.available());
    IOUtils.copy(result, fileStream);
    ```
