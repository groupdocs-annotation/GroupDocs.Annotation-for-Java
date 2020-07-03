---
id: groupdocs-annotation-for-java-19-5-release-notes
url: annotation/java/groupdocs-annotation-for-java-19-5-release-notes
title: GroupDocs.Annotation for Java 19.5 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 19.5{{< /alert >}}

## Major Features

Below is the list of most notable changes in release of GroupDocs.Annotation for Java:

*   Fixed bug of impossibility to set the line width on Slides documents
*   Fixed issue with opening protected with password Words and PDF documents
*   Improved performance issues when processing Slides documents
*   Add possibility to cache page previews
*   Added ability to annotate documents of older formats for Slides, Words, Cells (.ppt, .doc, .xls)
*   Added ability to add text caption for distance annotation for Cells, Diagrams and Slides
*   Refactored logic for getting pages for Slides documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-823 | Add possibility to cache page previews | Feature |
| ANNOTATIONNET-830  | Implement possibility to display distance annotation caption for Slides format | Feature |
| ANNOTATIONNET-831  | Implement possibility to display distance annotation caption for Cells format | Feature |
| ANNOTATIONNET-832  | Implement possibility to display distance annotation caption for Diagram format | Feature |
| ANNOTATIONNET-840 | Add supporting processing older format for Slides (.ppt) | Feature |
| ANNOTATIONNET-841  | Add supporting processing older format for Cells (.xls) | Feature |
| ANNOTATIONNET-842  | Add supporting processing older format for Words (.doc) | Feature |
| ANNOTATIONNET-835 | Refactor logic for getting pages for Slides documents | Improvement |
| ANNOTATIONNET-837 | Refactor PdfToPng saver | Improvement |
| ANNOTATIONNET-844 | Line width not set in Slides | Bug |
| ANNOTATIONNET-808 | Application is consuming 100% resources usage while loading document | Bug |
| ANNOTATIONNET-849 | Issue when opening protected with password documents | Bug |
| ANNOTATIONNET-866 | AnnotationImageHandler.GetPages exception in trial mode (for documents with more than 2 pages) | Bug |
| ANNOTATIONNET-878 | Not closed stream when remove annotations | Bug |
| ANNOTATIONJAVA-1159 | Exception occurred while remove annotations from .xls file | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 19.5. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **ImageOptions for getPages() method**
    
    | Parameter | Type | Description |
    | --- | --- | --- |
    | CountPagesToConvert | int | Determines count of pages to convert. **PageNumber** should be greater than 0. |
    | PageNumber | int | Determines page number (index) to be converted. If PageNumber = 0 (by default) then all pages of document will be converted. |
    | PageNumbersToConvert | List<int> | Determines list of page numbers, that will be converted. For example, if need converted only 3, 5 and 7 pages. |
    | WithoutAnnotations | bool | Determines that image pages will be returned without annotations. |
    
    Priority – it’s what will be happen if all parameters are set:
    
    | Parameter | Priority | Description |
    | --- | --- | --- |
    | WithoutAnnotations | 1 | If this parameter is true, then document will be returned without annotations. |
    | PageNumbersToConvert | 2 | If this parameter not null and count of elements > 0, then only page numbers from PageNumbersToConvert parameter will be converted. PageNumber and CountPagesToConvert will be ignored. |
    | PageNumber | 3 | If this parameter = 0 (by default), then all pages of document will be converted. If parameter > 0, then will converted specified page. |
    | CountPagesToConvert | 4 | Working only if PageNumber > 0. If CountPagesToConvert = 1, then only one page will be converted (which is defined by PageNumber parameter). If CountPagesToConvert > 1, then will converted from Page number to PageNumber + CountPagesToConvert range. |
    
    | ImageOption | Result |
    | --- | --- |
    | new ImageOptions() | All pages of document will be converted. |
    | new ImageOptions() { WithoutAnnotations = true } | All pages of document will converted, but without annotations. |
    | new ImageOptions() { PageNumber = 5 } | Only 5 page of document will be converted. |
    | List<int> numberList = new List<int>() { 2, 5, 7};new ImageOptions(){ PageNumbersToConvert = numberList } | Only 2nd, 5th and 7th pages of document will be converted. |
    | new ImageOptions(){ PageNumber = 5, CountPagesToConvert = 2 } | Pages 5,6,7 of document will be converted. |
    
    **Note:**
    
    {{< alert style="warning" >}}In order to optimize getPages performance method, we do not check if PageNumber or PageNumbersToConvert elements is less than number of document pages, because this is additional computing costs per every GetPages method call. So, if PageNumber or PageNumbersToConvert will be greater than number of document pages, then you will get ArgumentOutOfRange or IndexOutOfRange exception. So, you must control this outside GetPages call.{{< /alert >}}
    
    You can get image representation of pages of your pdf document by using *GetPages* method of *AnnotationImageHandler* class.
    
    ```java
    List<PageImage> GetPages(Stream fileStream, ImageOptions options)
    List<PageImage> GetPages(string guid, ImageOptions options)
    List<PageImage> GetPages(string guid)
    ```
    
    Following example demonstrates how to use *GetPages* method:
    
    
    
    ```java
    using System.Collections.Generic;
    using System.IO;
    using GroupDocs.Annotation.Config;
    using GroupDocs.Annotation.Domain.Image;
    using GroupDocs.Annotation.Domain.Options;
    using GroupDocs.Annotation.Handler;
     
     
    namespace GetPagesSample
    {
        class Program
        {
            static void Main(string[] args)
            {
                Stream document = new FileStream("../../Clear.pdf", FileMode.Open);
                AnnotationConfig cfg = new AnnotationConfig();
                cfg.StoragePath = "StorageFolder";
     
                AnnotationImageHandler annotationHandler = new AnnotationImageHandler(cfg);
     
                List<PageImage> images = annotationHandler.GetPages(document, new ImageOptions());
     
                // Save result stream to file.
                using(FileStream fileStream = new FileStream("../../image.png", FileMode.Create))
                {
                    byte[] buffer = new byte[images[0].Stream.Length];
                    images[0].Stream.Seek(0, SeekOrigin.Begin);
                    images[0].Stream.Read(buffer, 0, buffer.Length);
                    fileStream.Write(buffer, 0, buffer.Length);
                    fileStream.Close();        
                }
            }
        }
    }
    ```
    
2.  **Enabling caching for opening same document pages**
    
    
    
    ```java
    ImageOptions imageOptions = new ImageOptions();
    imageOptions.CacheStoragePath = AnnotationImageHandler.GetFileDataStore().TempPath;
    imageOptions.EnableCaching = true;
    ```
