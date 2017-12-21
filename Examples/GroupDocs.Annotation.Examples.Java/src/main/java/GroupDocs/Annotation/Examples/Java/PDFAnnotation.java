package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.common.exception.AnnotatorException;
import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationReplyInfo;
import com.groupdocs.annotation.domain.AnnotationReviewerRights;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.annotation.domain.ReviewerInfo;
import com.groupdocs.annotation.domain.RowData;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.domain.results.CreateAnnotationResult;
import com.groupdocs.annotation.domain.results.GetCollaboratorsResult;
import com.groupdocs.annotation.domain.results.SetCollaboratorsResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.IDocumentDataHandler;
import com.groupdocs.annotation.handler.input.IUserDataHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;
import com.groupdocs.annotation.handler.input.dataobjects.User;

public class PDFAnnotation {
	
	// region initialize document name
		
	/*
	 * document name
	 */
	public static String fileName = "sample.pdf";
	
	// region Working with Annotations in PDF

	/*
	 * add text annotations in PDF
	 */
	public static void addTextAnnotationInPDF() {
		// ExStart:addTextAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// text annotation
			AnnotationInfo textAnnotation = new AnnotationInfo();
			textAnnotation.setBox(new Rectangle(68, 154, 102, 9));
			textAnnotation.setPageNumber(0);
			textAnnotation.setType(AnnotationType.Text);
			textAnnotation.setCreatorName("Anonym A.");
			annotations.add(textAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-text.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			e.printStackTrace();
		}
		// ExEnd:addTextAnnotationInPDF
	}
	
	/*
	 * add area annotation in PDF
	 */
	public static void addAreaAnnotationInPDF() {
		// ExStart:addAreaAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Area annotation with 2 replies
			AnnotationInfo areaAnnnotation = new AnnotationInfo();
			areaAnnnotation.setAnnotationPosition(new Point(852.0, 59.0));
			final AnnotationReplyInfo[] annotationReplyInfos = { new AnnotationReplyInfo() {
				{
					setMessage("Hello!");
					setRepliedOn(Calendar.getInstance().getTime());
					setUserName("John");
				}
			}, new AnnotationReplyInfo() {
				{
					setMessage("Hi!");
					setRepliedOn(Calendar.getInstance().getTime());
					setUserName("Judy");
				}
			} };
			areaAnnnotation.setReplies(annotationReplyInfos);
			areaAnnnotation.setBackgroundColor(11111111);
			areaAnnnotation.setBox(new Rectangle(300f, 200f, 88f, 37f));
			areaAnnnotation.setPageNumber(0);
			areaAnnnotation.setPenColor(2222222);
			areaAnnnotation.setPenStyle((byte) 1);
			areaAnnnotation.setPenWidth((byte) 1);
			areaAnnnotation.setOpacity(0.5);
			areaAnnnotation.setType(AnnotationType.Area);
			areaAnnnotation.setCreatorName("Anonym A.");
			annotations.add(areaAnnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-area.pdf");
			IOUtils.copy(result, fileStream);

		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addAreaAnnotationInPDF
	}
	
	/*
	 * add point annotation in PDF
	 */
	public static void addPointAnnotationInPDF() {
		//ExStart:addPointAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Point annotation
			AnnotationInfo pointAnnotation = new AnnotationInfo();
			pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
			pointAnnotation.setBox(new Rectangle(212f, 81f, 35f, 0.0f));
			pointAnnotation.setPageNumber(0);
			pointAnnotation.setType(AnnotationType.Point);
			pointAnnotation.setCreatorName("Anonym A.");
			annotations.add(pointAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-point.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addPointAnnotationInPDF
	}
	
	/*
	 * add strike out annotation in PDF
	 */
	public static void addStrikeOutAnnotationInPDF() {
		//ExStart:addStrikeOutAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Text strikeout annotation
			AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
			strikeoutAnnotation.setAnnotationPosition(new Point(852.0, 154.31));
			strikeoutAnnotation.setBox(new Rectangle(68, 154, 102, 9));
			strikeoutAnnotation.setPageNumber(0);
			strikeoutAnnotation.setPenColor(0);
			strikeoutAnnotation.setOpacity(0.5);
			strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
			strikeoutAnnotation.setCreatorName("Anonym A.");
			annotations.add(strikeoutAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-strikeout.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addStrikeOutAnnotationInPDF
	}
	
	/*
	 * add polyline annotation in PDF
	 */
	public static void addPolyLineAnnotationInPDF() {
		//ExStart:addPolyLineAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Polyline annotation
			AnnotationInfo polylineAnnotation = new AnnotationInfo();
			polylineAnnotation.setAnnotationPosition(new Point(852.0, 35.0));
			polylineAnnotation.setBox(new Rectangle(250f, 35f, 102f, 12f));
			polylineAnnotation.setPageNumber(0);
			polylineAnnotation.setPenColor(1201033);
			polylineAnnotation.setPenWidth((byte) 2);
			polylineAnnotation.setSvgPath(
					"M250.8280751173709,48.209295774647885l0.6986854460093896,0l0.6986854460093896,-1.3973708920187793l0.6986854460093896,0l0.6986854460093896,-1.3973708920187793l1.3973708920187793,-0.6986854460093896l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l2.096056338028169,-1.3973708920187793l3.493427230046948,-1.3973708920187793l0.6986854460093896,-0.6986854460093896l1.3973708920187793,-1.3973708920187793l0.6986854460093896,0l1.3973708920187793,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l0,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l0,-0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l2.096056338028169,-0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,0l1.3973708920187793,0l2.096056338028169,0l5.589483568075117,0l1.3973708920187793,0l2.096056338028169,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l2.096056338028169,1.3973708920187793l0.6986854460093896,0l0.6986854460093896,0l0,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0.6986854460093896l0,0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0.6986854460093896l1.3973708920187793,0.6986854460093896l3.493427230046948,0.6986854460093896l1.3973708920187793,0.6986854460093896l2.096056338028169,0.6986854460093896l1.3973708920187793,0.6986854460093896l1.3973708920187793,0l1.3973708920187793,0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l2.7947417840375586,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0");
			polylineAnnotation.setType(AnnotationType.Polyline);
			polylineAnnotation.setCreatorName("Anonym A.");
			annotations.add(polylineAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-polyline.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addPolyLineAnnotationInPDF
	}
	
	/*
	 * add text field annotation in PDF
	 */
	public static void addTextFieldAnnotationInPDF() {
		//ExStart:addTextFieldAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Text field annotation
			AnnotationInfo textFieldAnnotation = new AnnotationInfo();
			textFieldAnnotation.setAnnotationPosition(new Point(852.0, 201.0));
			textFieldAnnotation.setFieldText("text in the box");
			textFieldAnnotation.setFontFamily("Arial");
			textFieldAnnotation.setFontSize(10);
			textFieldAnnotation.setBox(new Rectangle(66f, 201f, 64f, 37f));
			textFieldAnnotation.setPageNumber(0);
			textFieldAnnotation.setType(AnnotationType.TextField);
			textFieldAnnotation.setCreatorName("Anonym A.");
			annotations.add(textFieldAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-textfield.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextFieldAnnotationInPDF
	}
	
	/*
	 * add watermark annotation in PDF
	 */
	public static void addWatermarkAnnotationInPDF() {
		//ExStart:addWatermarkAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Watermark annotation
			AnnotationInfo watermarkAnnotation = new AnnotationInfo();
			watermarkAnnotation.setAnnotationPosition(new Point(852.0, 300.0));
			watermarkAnnotation.setFieldText("TEXT STAMP");
			watermarkAnnotation.setFontFamily("Microsoft Sans Serif");
			watermarkAnnotation.setFontSize(10);
			watermarkAnnotation.setFontColor(2222222);
			watermarkAnnotation.setBox(new Rectangle(430f, 272f, 66f, 51f));
			watermarkAnnotation.setPageNumber(0);
			watermarkAnnotation.setType(AnnotationType.TextField);
			watermarkAnnotation.setCreatorName("Anonym A.");
			annotations.add(watermarkAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-watermark.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addWatermarkAnnotationInPDF
	}
	
	/*
	 * add text replacement annotation in PDF
	 */
	public static void addTextReplacementAnnotationInPDF() {
		//ExStart:addTextReplacementAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Text replacement annotation
			AnnotationInfo textReplacementAnnotation = new AnnotationInfo();
			textReplacementAnnotation.setAnnotationPosition(new Point(852.0, 172.0));
			textReplacementAnnotation.setFieldText("Replaced text");
			textReplacementAnnotation.setFontSize(10);
			textReplacementAnnotation.setBox(new Rectangle(68f, 154f, 102f, 9f));
			textReplacementAnnotation.setPageNumber(0);
			textReplacementAnnotation.setType(AnnotationType.TextReplacement);
			textReplacementAnnotation.setCreatorName("Anonym A.");
			annotations.add(textReplacementAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-textreplacement.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextReplacementAnnotationInPDF
	}
	
	/*
	 * add arrow annotation in PDF
	 */
	public static void addArrowAnnotationInPDF() {
		//ExStart:addArrowAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Arrow annotation
			AnnotationInfo arrowAnnotation = new AnnotationInfo();
			arrowAnnotation.setAnnotationPosition(new Point(852.0, 252.0));
			arrowAnnotation.setBox(new Rectangle(279.4742f, 252.9241f, 129.9555f, -9.781596f));
			arrowAnnotation.setPageNumber(0);
			arrowAnnotation.setPenColor(1201033);
			arrowAnnotation.setPenStyle((byte) 0);
			arrowAnnotation.setPenWidth((byte) 1);
			arrowAnnotation.setSvgPath("M279.47417840375584,252.92413145539905 L129.9554929577465,-9.781596244131455");
			arrowAnnotation.setType(AnnotationType.Arrow);
			arrowAnnotation.setCreatorName("Anonym A.");
			annotations.add(arrowAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-arrow.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addArrowAnnotationInPDF
	}
	
	/*
	 * add text redaction annotation in PDF
	 */
	public static void addTextRedactionAnnotationInPDF() {
		//ExStart:
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Text redaction annotation
			AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
			textRedactionAnnotation.setAnnotationPosition(new Point(852.0, 154.0));
			textRedactionAnnotation.setBox(new Rectangle(68f, 154f, 102f, 9f));
			textRedactionAnnotation.setPageNumber(0);
			textRedactionAnnotation.setType(AnnotationType.TextRedaction);
			textRedactionAnnotation.setCreatorName("Anonym A.");
			annotations.add(textRedactionAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-textredaction.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exceptino:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextRedactionAnnotationInPDF
	}
	
	/*
	 * add resource redaction annotation in PDF
	 */
	public static void addResourceRedactionAnnotationInPDF() {
		//ExStart:addResourceRedactionAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Resource redaction annotation
			AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
			resourceRedactionAnnotation.setAnnotationPosition(new Point(852.0, 271.78));
			resourceRedactionAnnotation.setBackgroundColor(3355443);
			resourceRedactionAnnotation.setBox(new Rectangle(466f, 271f, 69f, 62f));
			resourceRedactionAnnotation.setPageNumber(0);
			resourceRedactionAnnotation.setPenColor(3355443);
			resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
			resourceRedactionAnnotation.setCreatorName("Anonym A.");
			annotations.add(resourceRedactionAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-resourceredaction.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addResourceRedactionAnnotationInPDF
	}
	
	/*
	 * add underline annotation in PDF
	 */
	public static void addUnderlineAnnotationInPDF() {
		//ExStart:addUnderlineAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Underline annotation
			AnnotationInfo underlineAnnotation = new AnnotationInfo();
			underlineAnnotation.setAnnotationPosition(new Point(852.0, 154.3131));
			underlineAnnotation.setBox(new Rectangle(68f, 154f, 102f, 9f));
			underlineAnnotation.setPageNumber(0);
			underlineAnnotation.setPenColor(1201033);
			underlineAnnotation.setOpacity(0.5);
			underlineAnnotation.setType(AnnotationType.TextUnderline);
			underlineAnnotation.setCreatorName("Anonym A.");
			annotations.add(underlineAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-underline.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.print("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addUnderlineAnnotationInPDF
	}
	
	/*
	 * add distance annotation in PDF
	 */
	public static void addDistanceAnnotationInPDF() {
		//ExStart:addDistanceAnnotationInPDF
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			annotator.getDocumentDataHandler();
			InputStream cleanPdf = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Distance annotation
			AnnotationInfo distanceAnnotation = new AnnotationInfo();
			distanceAnnotation.setAnnotationPosition(new Point(852.0, 287.0));
			distanceAnnotation.setBox(new Rectangle(248f, 287f, 115f, 25f));
			distanceAnnotation.setPageNumber(0);
			distanceAnnotation.setPenColor(1201033);
			distanceAnnotation.setPenStyle((byte) 0);
			distanceAnnotation.setPenWidth((byte) 1);
			distanceAnnotation
					.setSvgPath("M248.73201877934272,295.5439436619718 l115.28309859154929,-4.192112676056338");
			distanceAnnotation.setFieldText("\r\nAnonym A.: 115px");
			distanceAnnotation.setType(AnnotationType.Distance);
			distanceAnnotation.setCreatorName("Anonym A.");
			annotations.add(distanceAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "annotated-distance.pdf");
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addDistanceAnnotationInPDF
	}
	
	public static void usersWithDifferentRights(){
		//ExStart:usersWithDifferentRights
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		IUserDataHandler userRepository = annotator.getUserDataHandler();
		IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
		 
		// Create storage folder
		if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
		{
		    System.out.println("Can't create directory!");
		}
		 
		// Create owner.
		User johnOwner = userRepository.getUserByEmail("john@doe.com");
		 
		if(johnOwner == null)
		{
		    final User user = new User();
		    user.setFirstName("John");
		    user.setLastName("Doe");
		    user.setEmail("john@doe.com");
		    userRepository.add(user);
		    johnOwner = userRepository.getUserByEmail("john@doe.com");
		}
		 
		// Create document data object in storage
		Document document = documentRepository.getDocument(fileName);
		long documentId = document == null ? annotator.createDocument(fileName, DocumentType.Pdf, johnOwner.getId()) : document.getId();
		 
		// Create reviewer.
		ReviewerInfo reviewerInfo = new ReviewerInfo();
		reviewerInfo.setPrimaryEmail("judy@doe.com");
		reviewerInfo.setFirstName("Judy");
		reviewerInfo.setLastName("Doe");
		reviewerInfo.setAccessRights(AnnotationReviewerRights.CanView);
		 
		// Add collaboorator to the document. If user with UserName equals to reviewers PrimaryEmail is absent it will be created.
		SetCollaboratorsResult addCollaboratorResult = annotator.addCollaborator(documentId, reviewerInfo);
		System.out.println(addCollaboratorResult);
		 
		// Get document collaborators
		GetCollaboratorsResult getCollaboratorsResult = annotator.getCollaborators(documentId);
		System.out.println(getCollaboratorsResult);
		User judy = userRepository.getUserByEmail("judy@doe.com");
		 
		// Create annotation object
		AnnotationInfo pointAnnotation = new AnnotationInfo();
		pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
		pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
		pointAnnotation.setType(AnnotationType.Point);
		pointAnnotation.setPageNumber(0);
		pointAnnotation.setCreatorName("Anonym A.");
		 
		// John try to add annotations
		CreateAnnotationResult johnResult = annotator.createAnnotation(pointAnnotation, documentId, johnOwner.getId());
		System.out.println(johnResult);
		 
		// Judy try to add annotations
		try {
		    CreateAnnotationResult judyResult = annotator.createAnnotation(pointAnnotation, documentId, judy.getId());
		    System.out.println(judyResult);
		} catch (AnnotatorException e) {
		    System.out.println(e.getMessage());
		}
		 
		// Allow Judy create annotations.
		reviewerInfo.setAccessRights(AnnotationReviewerRights.CanAnnotate);
		SetCollaboratorsResult updateCollaboratorResult = annotator.updateCollaborator(documentId, reviewerInfo);
		System.out.println(updateCollaboratorResult);
		 
		// Judy try to add annotations
		CreateAnnotationResult judyResultCanAnnotate = annotator.createAnnotation(pointAnnotation, documentId, judy.getId());
		System.out.println(judyResultCanAnnotate);
		//ExEnd:usersWithDifferentRights
	}
	public static void gettingTextCoordinates(String fileName){
		//ExStart:gettingTextCoordinates
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		annotator.createDocument(fileName);
		DocumentInfoContainer documentInfoContainer = annotator.getDocumentInfo(fileName);
		 
		// Go through all pages
		for (PageData pageData : documentInfoContainer.getPages())
		{
		    System.out.println("Page number: " + pageData.getNumber());
		 
		    //Go through all page rows
		    for(int i = 0; i < pageData.getRows().size(); i++)
		    {
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
		        for(int j = 0; j < words.length; j++)
		        {
		            int coordinateIndex = j == 0 ? 0 : j + 1;
		            // Write data to console
		            System.out.println();
		            System.out.println("Word:'" + words[j] + "'");
		            System.out.println("Word distance from left: " + rowData.getTextCoordinates().get(coordinateIndex));
		            System.out.println("Word width: " + rowData.getTextCoordinates().get(coordinateIndex + 1));
		            System.out.println();
		        }
		    }
		}
		//ExEnd:gettingTextCoordinates
	}
}
