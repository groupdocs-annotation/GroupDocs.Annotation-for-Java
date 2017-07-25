package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.annotation.domain.RowData;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.domain.image.PageImage;
import com.groupdocs.annotation.domain.options.ImageOptions;
import com.groupdocs.annotation.handler.AnnotationImageHandler;

public class ImagesAnnotation {
	// ExStart:ImagesAnnotation
	/*
	 * document name
	 */
	// From version 17.1.0 you can work with images of EMF/WMF, CAD-files (DWG),
	// DICOM, DjVu, PNG, JPG, TIFF, BMP and GIF(static without animation) format
	// images
	public static void differentAnnotationsForImages(String fileName) throws Throwable {
		// ExStart:differentAnnotationsForImages
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

		FileInputStream cleanPresentation = new FileInputStream(Utilities.storagePath + File.separator + fileName);
		ArrayList<AnnotationInfo> annotations;
		annotations = new ArrayList<AnnotationInfo>();

		AnnotationInfo textAnnotation = new AnnotationInfo();
		textAnnotation.setBox(new Rectangle(50, 510.9f, 454.73f, 29.08f));
		textAnnotation.setPageNumber(0);
		textAnnotation.setSvgPath(
				"[{\"x\":200,\"y\":520.92},{\"x\":454.73,\"y\":520.92},{\"x\":200,\"y\":539.98},{\"x\":454.73,\"y\":539.98}]");
		textAnnotation.setType(AnnotationType.Text);
		textAnnotation.setCreatorName("Anonym A.");

		AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
		textRedactionAnnotation.setBox(new Rectangle(50, 510.9f, 454.73f, 29.08f));
		textRedactionAnnotation.setPageNumber(0);
		textRedactionAnnotation.setSvgPath(
				"[{\"x\":200,\"y\":545.92},{\"x\":454.73,\"y\":545.92},{\"x\":200,\"y\":564.98},{\"x\":454.73,\"y\":564.98}]");
		textRedactionAnnotation.setType(AnnotationType.TextRedaction);
		textRedactionAnnotation.setCreatorName("Anonym A.");

		AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
		strikeoutAnnotation.setBox(new Rectangle(0, 510.92f, 454.73f, 29.08f));
		strikeoutAnnotation.setPageNumber(0);
		strikeoutAnnotation.setSvgPath(
				"[{\"x\":120,\"y\":520.92},{\"x\":454.73,\"y\":520.92},{\"x\":120,\"y\":539.98},{\"x\":454.73,\"y\":539.98}]");
		strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
		strikeoutAnnotation.setCreatorName("Anonym A.");

		AnnotationInfo underlineAnnotation = new AnnotationInfo();
		underlineAnnotation.setBox(new Rectangle(0, 510.92f, 454.73f, 29.08f));
		underlineAnnotation.setPageNumber(0);
		underlineAnnotation.setSvgPath(
				"[{\"x\":120,\"y\":520.92},{\"x\":454.73,\"y\":520.92},{\"x\":120,\"y\":539.98},{\"x\":454.73,\"y\":539.98}]");
		underlineAnnotation.setType(AnnotationType.TextUnderline);
		underlineAnnotation.setCreatorName("Anonym A.");

		AnnotationInfo pointAnnotation = new AnnotationInfo();
		pointAnnotation.setPageNumber(0);
		pointAnnotation.setType(AnnotationType.Point);
		pointAnnotation.setBox(new Rectangle(100, 100, 0, 0));
		pointAnnotation.setFieldText("Hello!");
		pointAnnotation.setCreatorName("John");

		AnnotationInfo areaAnnotation = new AnnotationInfo();
		areaAnnotation.setCreatedOn(new Date());
		areaAnnotation.setType(AnnotationType.Area);
		areaAnnotation.setPageNumber(0);
		areaAnnotation.setBox(new Rectangle(200, 72.7f, 50, 50));
		areaAnnotation.setBackgroundColor(-15988609);

		AnnotationInfo polylineAnnotation = new AnnotationInfo();
		polylineAnnotation.setType(AnnotationType.Polyline);
		polylineAnnotation.setCreatedOn(new Date());
		polylineAnnotation.setBox(new Rectangle((float) 250.82807922363281, (float) 35.632957458496094,
				(float) 102.70676422119141, (float) 12.576337814331055));
		polylineAnnotation.setPageNumber(0);
		polylineAnnotation.setPenColor(65015);
		polylineAnnotation.setSvgPath(
				"M250.8280751173709,48.209295774647885l0.6986854460093896,0l0.6986854460093896, -1.3973708920187793l0.6986854460093896,"
						+ "0l0.6986854460093896,-1.3973708920187793l1.3973708920187793, -0.6986854460093896l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l2.096056338028169,"
						+ "-1.3973708920187793l3.493427230046948,-1.3973708920187793l0.6986854460093896,-0.6986854460093896l1.3973708920187793,"
						+ "-1.3973708920187793l0.6986854460093896,0l1.3973708920187793,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,"
						+ "-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l0,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,"
						+ "0l1.3973708920187793,0l0,-0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,"
						+ "0l0.6986854460093896,0l2.096056338028169,-0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,"
						+ "0l1.3973708920187793,0l1.3973708920187793,0l1.3973708920187793,0l2.096056338028169,0l5.589483568075117,0l1.3973708920187793,"
						+ "0l2.096056338028169,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,"
						+ "0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l2.096056338028169,1.3973708920187793l0.6986854460093896,0l0.6986854460093896,"
						+ "0l0,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0.6986854460093896l0,"
						+ "0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0.6986854460093896l1.3973708920187793,0.6986854460093896l3.493427230046948,"
						+ "0.6986854460093896l1.3973708920187793,0.6986854460093896l2.096056338028169,0.6986854460093896l1.3973708920187793,"
						+ "0.6986854460093896l1.3973708920187793,0l1.3973708920187793,0.6986854460093896l0.6986854460093896,0l0.6986854460093896,"
						+ "0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,"
						+ "0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,"
						+ "0l0.6986854460093896,0l2.7947417840375586,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,"
						+ "0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,"
						+ "0l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0");

		AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
		resourceRedactionAnnotation.setCreatedOn(new Date());
		resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
		resourceRedactionAnnotation.setPageNumber(0);
		resourceRedactionAnnotation.setBox(new Rectangle(100, 72.7f, 50, 50));

		AnnotationInfo textFieldAnnotation = new AnnotationInfo();
		textFieldAnnotation.setCreatedOn(new Date());
		textFieldAnnotation.setType(AnnotationType.TextField);
		textFieldAnnotation.setPageNumber(0);
		textFieldAnnotation.setBox(new Rectangle(100, 72.7f, 50, 50));
		textFieldAnnotation.setFontColor(-15988609);
		textFieldAnnotation.setFieldText("some text");
		textFieldAnnotation.setFontFamily("times new roman");

		AnnotationInfo watermarkAnnotation = new AnnotationInfo();
		watermarkAnnotation.setCreatedOn(new Date());
		watermarkAnnotation.setType(AnnotationType.Watermark);
		watermarkAnnotation.setFieldText("This is watermark");
		watermarkAnnotation.setFontFamily("arial");
		watermarkAnnotation.setBox(new Rectangle(200, 250, 50, 0));
		watermarkAnnotation.setFontSize(25);
		watermarkAnnotation.setFontColor(15988609);

		AnnotationInfo distanceAnnotation = new AnnotationInfo();
		distanceAnnotation.setCreatedOn(new Date());
		distanceAnnotation.setType(AnnotationType.Distance);
		distanceAnnotation.setBox(new Rectangle(20, 20, 250, 250));
		distanceAnnotation.setBackgroundColor(-15988609);
		distanceAnnotation.setText("500px");
		distanceAnnotation.setFontFamily("Arial");

		AnnotationInfo arrowAnnotation = new AnnotationInfo();
		arrowAnnotation.setCreatedOn(new Date());
		arrowAnnotation.setType(AnnotationType.Arrow);
		arrowAnnotation.setBox(new Rectangle(250, 72.7f, 0, 20));
		arrowAnnotation.setBackgroundColor(-15988609);

		annotations.add(textAnnotation);
		annotations.add(pointAnnotation);
		annotations.add(areaAnnotation);
		annotations.add(textRedactionAnnotation);
		annotations.add(resourceRedactionAnnotation);
		annotations.add(polylineAnnotation);
		annotations.add(watermarkAnnotation);
		annotations.add(textFieldAnnotation);
		annotations.add(strikeoutAnnotation);
		annotations.add(underlineAnnotation);
		annotations.add(distanceAnnotation);
		annotations.add(arrowAnnotation);

		InputStream result = annotator.exportAnnotationsToDocument(cleanPresentation, annotations, DocumentType.Images);

		try (OutputStream fileStream = new FileOutputStream(
				Utilities.outputPath + File.separator + "Image-annotated.png")) {
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		}
		// ExEnd:differentAnnotationsForImages
	}

	public static void getDocInfoForDiagram(String fileName) {
		// ExStart:getDocInfoForDiagram
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		DocumentInfoContainer documentInfoContainer = annotator.getDocumentInfo(fileName);

		// Go through all pages
		for (PageData pageData : documentInfoContainer.getPages()) {
			System.out.println("Page number: " + pageData.getNumber());
			// Go through all page rows
			for (int i = 0; i < pageData.getRows().size(); i++) {
				RowData rowData = pageData.getRows().get(i);
				// Write data to console
				System.out.println("Row: " + (i + 1));
				System.out.println("Text: " + rowData.getText());
				System.out.println("Text width: " + rowData.getLineWidth());
				System.out.println("Text height: " + rowData.getLineHeight());
				System.out.println("Distance from left: " + rowData.getLineLeft());
				System.out.println("Distance from top: " + rowData.getLineTop());
				// Get words
				String[] words = rowData.getText().split(" ");
				// Go through all word coordinates
				for (int j = 0; j < words.length; j++) {
					int coordinateIndex = j == 0 ? 0 : j + 1;
					// Write data to console
					System.out.println("Word: '" + words[j] + "'");
					System.out.println("Word distance from left: " + rowData.getTextCoordinates().get(coordinateIndex));
					System.out.println("Word width: " + rowData.getTextCoordinates().get(coordinateIndex + 1));
				}
			}
		}
		// ExEnd:getDocInfoForDiagram
	}

	public static void getPageImagesForDiagramDocs(String fileName) throws Throwable {
		// ExStart:getPageImagesForDiagramDocs
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		List<PageImage> images = annotator.getPages(fileName, new ImageOptions());
		for (int i = 0; i < images.size(); i++) {
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "image_" + i + ".png");

			final PageImage pageImage = images.get(i);
			IOUtils.copy(pageImage.getStream(), fileStream);
		}
		// ExEnd:getPageImagesForDiagramDocs
	}

	public static void addAnnotationDiagrams(String fileName) throws Throwable {
		// ExStart:addAnnotationDiagrams
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		InputStream cleanDiagramFile = new FileInputStream(Utilities.storagePath + File.separator + fileName);
		// FileInputStream input = new
		// FileInputStream("AddAnnotations.TestData.");
		// //Assembly.GetExecutingAssembly().GetManifestResourceStream("AddAnnotations.TestData.");
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
		polylineAnnotation.setSvgPath(
				"M436.293427230047,148.06338028169014l0,-0.9870892018779343l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-4.935446009389671,-1.9741784037558685l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-1.9741784037558685,0l-3.948356807511737,0l-2.961267605633803,0l-3.948356807511737,0l-4.935446009389671,0l-3.948356807511737,0.9870892018779343l-4.935446009389671,0.9870892018779343l-6.90962441314554,0l-3.948356807511737,0.9870892018779343l-3.948356807511737,0l-2.961267605633803,1.9741784037558685l-3.948356807511737,0.9870892018779343l-6.90962441314554,1.9741784037558685l-6.90962441314554,0.9870892018779343l-12.832159624413146,2.961267605633803l-6.90962441314554,1.9741784037558685l-5.922535211267606,0.9870892018779343l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,0.9870892018779343l-4.935446009389671,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-4.935446009389671,1.9741784037558685l-5.922535211267606,2.961267605633803l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-4.935446009389671,3.948356807511737l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-3.948356807511737,5.922535211267606l-3.948356807511737,4.935446009389671l-3.948356807511737,5.922535211267606l-3.948356807511737,6.90962441314554l-3.948356807511737,7.896713615023474l-0.9870892018779343,6.90962441314554l-1.9741784037558685,7.896713615023474l-1.9741784037558685,6.90962441314554l-0.9870892018779343,7.896713615023474l0,12.832159624413146l0,7.896713615023474l0,7.896713615023474l0.9870892018779343,7.896713615023474l1.9741784037558685,5.922535211267606l2.961267605633803,5.922535211267606l0.9870892018779343,5.922535211267606l2.961267605633803,6.90962441314554l3.948356807511737,5.922535211267606l4.935446009389671,4.935446009389671l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l6.90962441314554,5.922535211267606l7.896713615023474,5.922535211267606l7.896713615023474,5.922535211267606l17.767605633802816,8.883802816901408l11.845070422535212,3.948356807511737l11.845070422535212,4.935446009389671l23.690140845070424,8.883802816901408l41.45774647887324,6.90962441314554l31.586854460093896,3.948356807511737l16.780516431924884,0l16.780516431924884,1.9741784037558685l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,-1.9741784037558685l14.806338028169014,-1.9741784037558685l14.806338028169014,-1.9741784037558685l12.832159624413146,-1.9741784037558685l10.857981220657276,-2.961267605633803l10.857981220657276,-2.961267605633803l8.883802816901408,-4.935446009389671l8.883802816901408,-4.935446009389671l6.90962441314554,-6.90962441314554l6.90962441314554,-6.90962441314554l8.883802816901408,-16.780516431924884l4.935446009389671,-7.896713615023474l3.948356807511737,-8.883802816901408l4.935446009389671,-7.896713615023474l4.935446009389671,-7.896713615023474l3.948356807511737,-13.81924882629108l1.9741784037558685,-18.754694835680752l0,-7.896713615023474l0,-12.832159624413146l-1.9741784037558685,-15.793427230046948l-1.9741784037558685,-15.793427230046948l-4.935446009389671,-15.793427230046948l-8.883802816901408,-15.793427230046948l-12.832159624413146,-23.690140845070424l-10.857981220657276,-10.857981220657276l-5.922535211267606,-3.948356807511737l-12.832159624413146,-8.883802816901408l-9.870892018779342,-8.883802816901408l-5.922535211267606,-3.948356807511737l-12.832159624413146,-5.922535211267606l-15.793427230046948,-8.883802816901408l-13.81924882629108,-4.935446009389671l-11.845070422535212,-2.961267605633803l-11.845070422535212,-3.948356807511737l-11.845070422535212,-3.948356807511737l-5.922535211267606,-1.9741784037558685l-11.845070422535212,-2.961267605633803l-11.845070422535212,-1.9741784037558685l-5.922535211267606,-0.9870892018779343l-10.857981220657276,-1.9741784037558685l-10.857981220657276,-2.961267605633803l-9.870892018779342,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l0,-0.9870892018779343l1.9741784037558685,0");

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
		arrowAnnotation.setBox(
				new Rectangle(435.77464788732397f, 148.05164319248826f, -66.34389671361504f, 53.07511737089203f));

		// Resource redaction annotation
		AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
		resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
		resourceRedactionAnnotation.setBox(new Rectangle(200, 114.5f, 282.3f, 103.7f));
		annotations.add(areaAnnnotation);
		annotations.add(polylineAnnotation);
		annotations.add(textFieldAnnotation);
		annotations.add(arrowAnnotation);
		annotations.add(resourceRedactionAnnotation);

		// Add annotation to the document
		InputStream result = annotator.exportAnnotationsToDocument(cleanDiagramFile, annotations);

		// Save result stream to file.
		OutputStream fileStream = new FileOutputStream(Utilities.outputPath + File.separator + "Annotated.vsdx");
		IOUtils.copy(result, fileStream);
		// ExEnd:addAnnotationDiagrams
	}
}
