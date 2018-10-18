package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.handler.AnnotationImageHandler;

public class WordsAnnotation {
	
	// region initialize document name
	
	/*
	 * document name
	 */
	public static String fileName = "sample.docx";
	
	// region Working with annotation in Words

	/*
	 * add different annotations in words
	 */
	public static void addDifferentAnnotationInWords() {
		//ExStart:addDifferentAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// initialize possible types of annotations
			AnnotationInfo textAnnotation = new AnnotationInfo();
			textAnnotation.setPageNumber(1);
			textAnnotation.setSvgPath(
					"[{\"x\":186.698,\"y\":706.196},{\"x\":318.41201,\"y\":706.196},{\"x\":186.698,\"y\":697.196},{\"x\":318.41201,\"y\":697.196}]");
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
			strikeoutAnnotation.setSvgPath(
					"[{\"x\":208.392,\"y\":313.088},{\"x\":519.659,\"y\":313.088},{\"x\":208.392,\"y\":304.088},{\"x\":519.659,\"y\":304.088}]");
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
			textReplacementAnnotation.setSvgPath(
					"[{\"x\":251.224,\"y\":637.20401},{\"x\":327.89,\"y\":637.20401},{\"x\":251.224,\"y\":628.20401},{\"x\":327.89,\"y\":628.20401}]");
			textReplacementAnnotation.setPageNumber(1);
			textReplacementAnnotation.setType(AnnotationType.TextReplacement);
			AnnotationInfo arrowAnnotation = new AnnotationInfo();
			arrowAnnotation.setBox(new Rectangle(479f, 218f, -261f, -89f));
			arrowAnnotation.setPageNumber(1);
			arrowAnnotation.setType(AnnotationType.Arrow);
			AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
			textRedactionAnnotation.setPageNumber(2);
			textRedactionAnnotation.setSvgPath(
					"[{\"x\":72,\"y\":676.07},{\"x\":196.427,\"y\":676.074},{\"x\":72,\"y\":662.674},{\"x\":196.427,\"y\":662.674}]");
			textRedactionAnnotation.setType(AnnotationType.TextRedaction);
			AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
			resourceRedactionAnnotation.setBox(new Rectangle(69f, 337f, 449f, 118f));
			resourceRedactionAnnotation.setPageNumber(1);
			resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
			AnnotationInfo underlineAnnotation = new AnnotationInfo();
			underlineAnnotation.setPageNumber(2);
			underlineAnnotation.setSvgPath(
					"[{\"x\":415.17499,\"y\":628.874},{\"x\":511.85101,\"y\":628.874},{\"x\":415.17499,\"y\":619.874},{\"x\":511.85101,\"y\":619.874}]");
			underlineAnnotation.setType(AnnotationType.TextUnderline);
			// * annotations.add(textAnnotation);
			annotations.add(areaAnnnotation);
			// * annotations.add(strikeoutAnnotation);
			annotations.add(textFieldAnnotation);
			// ** annotations.add(textReplacementAnnotation);
			annotations.add(arrowAnnotation);
			// * annotations.add(textRedactionAnnotation);
			annotations.add(resourceRedactionAnnotation);
			// * annotations.add(underlineAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addDifferentAnnotationInWords
	}
	
	/*
	 * add text annotation in words
	 */
	public static void addTextAnnotationInWords() {
		//ExStart:addTextAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init possible types of annotations
			AnnotationInfo textAnnotation = new AnnotationInfo();
			textAnnotation.setPageNumber(1);
			textAnnotation.setSvgPath(
					"[{\"x\":186.698,\"y\":706.196},{\"x\":318.41201,\"y\":706.196},{\"x\":186.698,\"y\":697.196},{\"x\":318.41201,\"y\":697.196}]");
			textAnnotation.setType(AnnotationType.Text);
			textAnnotation.setText("Comment");
			annotations.add(textAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextAnnotationInWords
	}
	
	/*
	 * add area annotation with replies in words
	 */
	public static void addAreaAnnotationWithRepliesInWords() {
		//ExStart:addAreaAnnotationWithRepliesInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// initialize possible types of annotations
			AnnotationInfo areaAnnnotation = new AnnotationInfo();
			areaAnnnotation.setBackgroundColor(11111111);
			areaAnnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
			areaAnnnotation.setPageNumber(1);
			areaAnnnotation.setType(AnnotationType.Area);
			annotations.add(areaAnnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addAreaAnnotationWithRepliesInWords
	}
	
	/*
	 * add strikeout annotation in words
	 */
	public static void addStrikeoutAnnotationInWords() {
		//ExStart:addStrikeoutAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init strikeout annotations
			AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
			strikeoutAnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
			strikeoutAnnotation.setPageNumber(1);
			strikeoutAnnotation.setPenColor(1201033);
			strikeoutAnnotation.setSvgPath(
					"[{\"x\":208.392,\"y\":313.088},{\"x\":519.659,\"y\":313.088},{\"x\":208.392,\"y\":304.088},{\"x\":519.659,\"y\":304.088}]");
			strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
			annotations.add(strikeoutAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addStrikeoutAnnotationInWords
	}
	
	/*
	 * add text field annotation in words
	 */
	public static void addTextFieldAnnotationInWords() {
		//ExStart:addTextFieldAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init text Field annotations
			AnnotationInfo textFieldAnnotation = new AnnotationInfo();
			textFieldAnnotation.setFieldText("text in the box");
			textFieldAnnotation.setFontFamily("Arial");
			textFieldAnnotation.setFontSize(10);
			textFieldAnnotation.setBox(new Rectangle(92f, 73f, 106f, 45f));
			textFieldAnnotation.setPageNumber(1);
			textFieldAnnotation.setType(AnnotationType.TextField);
			annotations.add(textFieldAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextFieldAnnotationInWords
	}
	
	/*
	 * add text replacement annotation in words
	 */
	public static void addTextReplacementAnnotationInWords() {
		//ExStart:addTextReplacementAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init text replacement annotations
			AnnotationInfo textReplacementAnnotation = new AnnotationInfo();
			textReplacementAnnotation.setFieldText(" \"REPLACED TEXT\" ");
			textReplacementAnnotation.setFontSize(10);
			textReplacementAnnotation.setSvgPath(
					"[{\"x\":251.224,\"y\":637.20401},{\"x\":327.89,\"y\":637.20401},{\"x\":251.224,\"y\":628.20401},{\"x\":327.89,\"y\":628.20401}]");
			textReplacementAnnotation.setPageNumber(1);
			textReplacementAnnotation.setType(AnnotationType.TextReplacement);
			annotations.add(textReplacementAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextReplacementAnnotationInWords
	}
	
	/*
	 * add arrow annotation in words
	 */
	public static void addArrowAnnotationInWords() {
		//ExStart:addArrowAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init arrow annotations
			AnnotationInfo arrowAnnotation = new AnnotationInfo();
			arrowAnnotation.setBox(new Rectangle(479f, 218f, -261f, -89f));
			arrowAnnotation.setPageNumber(1);
			arrowAnnotation.setType(AnnotationType.Arrow);
			annotations.add(arrowAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addArrowAnnotationInWords
	}
	
	/*
	 * add text redaction annotation in words
	 */
	public static void addTextRedactionAnnotationInWords() {
		//ExStart:addTextRedactionAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init text redaction annotations
			AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
			textRedactionAnnotation.setPageNumber(2);
			textRedactionAnnotation.setSvgPath(
					"[{\"x\":72,\"y\":676.07},{\"x\":196.427,\"y\":676.074},{\"x\":72,\"y\":662.674},{\"x\":196.427,\"y\":662.674}]");
			textRedactionAnnotation.setType(AnnotationType.TextRedaction);
			annotations.add(textRedactionAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addTextRedactionAnnotationInWords
	}
	
	/*
	 * add resource redaction annotation in words
	 */
	public static void addResourceRedactionAnnotationInWords() {
		//ExStart:addResourceRedactionAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init possible types of annotations
			AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
			resourceRedactionAnnotation.setBox(new Rectangle(69f, 337f, 449f, 118f));
			resourceRedactionAnnotation.setPageNumber(1);
			resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
			annotations.add(resourceRedactionAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addResourceRedactionAnnotationInWords
	}

	/*
	 * add underline annotation in words
	 */
	public static void addUnderlineAnnotationInWords() {
		//ExStart:addUnderlineAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// init underline annotations
			AnnotationInfo underlineAnnotation = new AnnotationInfo();
			underlineAnnotation.setPageNumber(2);
			underlineAnnotation.setSvgPath(
					"[{\"x\":415.17499,\"y\":628.874},{\"x\":511.85101,\"y\":628.874},{\"x\":415.17499,\"y\":619.874},{\"x\":511.85101,\"y\":619.874}]");
			underlineAnnotation.setType(AnnotationType.TextUnderline);
			annotations.add(underlineAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addUnderlineAnnotationInWords
	}
	/*
	 * import annotations from word docs
	 */
	public static void importingAnnotationsFromWordDoc() throws Throwable{
		//ExStart:importingAnnotationsFromWordDoc
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		// Importing annotations from Words document
		FileInputStream stream = new FileInputStream(Utilities.storagePath + File.separator + fileName);
		AnnotationInfo[] annotations = annotator.importAnnotations(stream, DocumentType.Words);
		 
		// Export imported annotation to another document 
		InputStream clearDocument = new FileInputStream(Utilities.storagePath + File.separator + "Clear.docx");
		InputStream output = annotator.exportAnnotationsToDocument(clearDocument, Arrays.asList(annotations), DocumentType.Words);
		 
		// Save results after export
		OutputStream fileStream = new FileOutputStream(
				Utilities.outputPath + File.separator + "words-annotated.docx");
		System.out.println(output.available());
		IOUtils.copy(output, fileStream);
		//ExEnd:importingAnnotationsFromWordDoc
	}
	
	public static void addDistanceAnnotationInWords() {
		//ExStart:addDistanceAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Distance annotation
			AnnotationInfo distanceAnnotation = new AnnotationInfo();
			distanceAnnotation.setCreatedOn(new Date());
			distanceAnnotation.setType(AnnotationType.Distance);
			distanceAnnotation.setBox(new Rectangle((float)248.73202514648438, (float)287.85653686523438, (float)115.9178466796875, (float)25.143020629882812));
			distanceAnnotation.setSvgPath("M248.73201877934272,295.5439436619718 l115.28309859154929,-4.192112676056338");
			
			annotations.add(distanceAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addDistanceAnnotationInWords
	}
	
	public static void addPolylineAnnotationInWords() {
		//ExStart:addPolylineAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Polyline annotation
			AnnotationInfo polylineAnnotation = new AnnotationInfo();
			polylineAnnotation.setCreatedOn(new Date());
			polylineAnnotation.setType(AnnotationType.Polyline);
			polylineAnnotation.setBox(new Rectangle(206.3f, 106.61f, 456.04f, 307.97f));
			polylineAnnotation.setSvgPath("M436.293427230047,148.06338028169014l0,-0.9870892018779343l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-0.9870892018779343,-0.9870892018779343l-1.9741784037558685,-0.9870892018779343l-0.9870892018779343,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-4.935446009389671,-1.9741784037558685l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-1.9741784037558685,0l-1.9741784037558685,-0.9870892018779343l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-2.961267605633803,0l-1.9741784037558685,0l-3.948356807511737,0l-2.961267605633803,0l-3.948356807511737,0l-4.935446009389671,0l-3.948356807511737,0.9870892018779343l-4.935446009389671,0.9870892018779343l-6.90962441314554,0l-3.948356807511737,0.9870892018779343l-3.948356807511737,0l-2.961267605633803,1.9741784037558685l-3.948356807511737,0.9870892018779343l-6.90962441314554,1.9741784037558685l-6.90962441314554,0.9870892018779343l-12.832159624413146,2.961267605633803l-6.90962441314554,1.9741784037558685l-5.922535211267606,0.9870892018779343l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,0.9870892018779343l-4.935446009389671,1.9741784037558685l-5.922535211267606,1.9741784037558685l-5.922535211267606,1.9741784037558685l-4.935446009389671,1.9741784037558685l-5.922535211267606,2.961267605633803l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-4.935446009389671,3.948356807511737l-5.922535211267606,3.948356807511737l-5.922535211267606,3.948356807511737l-3.948356807511737,5.922535211267606l-3.948356807511737,4.935446009389671l-3.948356807511737,5.922535211267606l-3.948356807511737,6.90962441314554l-3.948356807511737,7.896713615023474l-0.9870892018779343,6.90962441314554l-1.9741784037558685,7.896713615023474l-1.9741784037558685,6.90962441314554l-0.9870892018779343,7.896713615023474l0,12.832159624413146l0,7.896713615023474l0,7.896713615023474l0.9870892018779343,7.896713615023474l1.9741784037558685,5.922535211267606l2.961267605633803,5.922535211267606l0.9870892018779343,5.922535211267606l2.961267605633803,6.90962441314554l3.948356807511737,5.922535211267606l4.935446009389671,4.935446009389671l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l3.948356807511737,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l5.922535211267606,5.922535211267606l6.90962441314554,5.922535211267606l7.896713615023474,5.922535211267606l7.896713615023474,5.922535211267606l17.767605633802816,8.883802816901408l11.845070422535212,3.948356807511737l11.845070422535212,4.935446009389671l23.690140845070424,8.883802816901408l41.45774647887324,6.90962441314554l31.586854460093896,3.948356807511737l16.780516431924884,0l16.780516431924884,1.9741784037558685l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,0l16.780516431924884,-1.9741784037558685l14.806338028169014,-1.9741784037558685l14.806338028169014,-1.9741784037558685l12.832159624413146,-1.9741784037558685l10.857981220657276,-2.961267605633803l10.857981220657276,-2.961267605633803l8.883802816901408,-4.935446009389671l8.883802816901408,-4.935446009389671l6.90962441314554,-6.90962441314554l6.90962441314554,-6.90962441314554l8.883802816901408,-16.780516431924884l4.935446009389671,-7.896713615023474l3.948356807511737,-8.883802816901408l4.935446009389671,-7.896713615023474l4.935446009389671,-7.896713615023474l3.948356807511737,-13.81924882629108l1.9741784037558685,-18.754694835680752l0,-7.896713615023474l0,-12.832159624413146l-1.9741784037558685,-15.793427230046948l-1.9741784037558685,-15.793427230046948l-4.935446009389671,-15.793427230046948l-8.883802816901408,-15.793427230046948l-12.832159624413146,-23.690140845070424l-10.857981220657276,-10.857981220657276l-5.922535211267606,-3.948356807511737l-12.832159624413146,-8.883802816901408l-9.870892018779342,-8.883802816901408l-5.922535211267606,-3.948356807511737l-12.832159624413146,-5.922535211267606l-15.793427230046948,-8.883802816901408l-13.81924882629108,-4.935446009389671l-11.845070422535212,-2.961267605633803l-11.845070422535212,-3.948356807511737l-11.845070422535212,-3.948356807511737l-5.922535211267606,-1.9741784037558685l-11.845070422535212,-2.961267605633803l-11.845070422535212,-1.9741784037558685l-5.922535211267606,-0.9870892018779343l-10.857981220657276,-1.9741784037558685l-10.857981220657276,-2.961267605633803l-9.870892018779342,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l-0.9870892018779343,0l0,-0.9870892018779343l1.9741784037558685,0");
			
			annotations.add(polylineAnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addPolylineAnnotationInWords
	}
	
	public static void addWatermarkAnnotationInWords() {
		//ExStart:addWatermarkAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Watermark annotations
			AnnotationInfo watermarkAnnnotation = new AnnotationInfo();
			watermarkAnnnotation.setCreatedOn(new Date());
			watermarkAnnnotation.setFieldText("Watermark text");
			watermarkAnnnotation.setFontColor(16711680);
			watermarkAnnnotation.setFontFamily("Microsoft Sans Serif");
			watermarkAnnnotation.setFontSize(17);
			watermarkAnnnotation.setOpacity(0.3);
			watermarkAnnnotation.setType(AnnotationType.Watermark);
			
			annotations.add(watermarkAnnnotation);
			
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addWatermarkAnnotationInWords
	}
	
	public static void addPointAnnotationInWords() {
		//ExStart:addPointAnnotationInWords
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Point annotation
			AnnotationInfo pointAnnnotation = new AnnotationInfo();
			pointAnnnotation.setCreatedOn(new Date());
			pointAnnnotation.setType(AnnotationType.Point);
			pointAnnnotation.setBox(new Rectangle(150.32f, 99.22f, 0, 0));
			pointAnnnotation.setPageNumber(0);
			
			annotations.add(pointAnnnotation);
			// Add annotation to the document
			InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "words-annotated.docx");
			System.out.println(result.available());
			IOUtils.copy(result, fileStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addPointAnnotationInWords
	}
}
