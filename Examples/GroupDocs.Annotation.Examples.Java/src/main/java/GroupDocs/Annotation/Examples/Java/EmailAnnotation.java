package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.handler.AnnotationImageHandler;

public class EmailAnnotation {
	public static void differentAnnotationsForEmail(String fileName) throws Throwable, Throwable{
		//ExStart:differentAnnotationsForEmail
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		//there can be also documents of Emlx Msg formats
		InputStream cleanDoc = new FileInputStream(Utilities.storagePath + File.separator + fileName); //"../../ClearEmailDocument.eml"
		 
		List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
		 
		AnnotationInfo textAnnotation = new AnnotationInfo();
		textAnnotation.setPageNumber(0);
		textAnnotation.setSvgPath("[{\"x\":186.698,\"y\":706.196},{\"x\":318.41201,\"y\":706.196},{\"x\":186.698,\"y\":697.196},{\"x\":318.41201,\"y\":697.196}]");
		textAnnotation.setType(AnnotationType.Text);
		 
		AnnotationInfo areaAnnnotation = new AnnotationInfo();
		areaAnnnotation.setBackgroundColor(11111111);
		areaAnnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
		areaAnnnotation.setPageNumber(0);
		areaAnnnotation.setType(AnnotationType.Area);
		 
		AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
		strikeoutAnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
		strikeoutAnnotation.setPageNumber(0);
		strikeoutAnnotation.setPenColor(1201033);
		strikeoutAnnotation.setSvgPath("[{\"x\":208.392,\"y\":313.088},{\"x\":519.659,\"y\":313.088},{\"x\":208.392,\"y\":304.088},{\"x\":519.659,\"y\":304.088}]");
		strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
		 
		AnnotationInfo textFieldAnnotation = new AnnotationInfo();
		textFieldAnnotation.setFieldText("text in the box");
		textFieldAnnotation.setFontFamily("Arial");
		textFieldAnnotation.setFontSize(10);
		textFieldAnnotation.setBox(new Rectangle(92f, 73f, 106f, 45f));
		textFieldAnnotation.setPageNumber(0);
		textFieldAnnotation.setType(AnnotationType.TextField);
		 
		AnnotationInfo textReplacementAnnotation = new AnnotationInfo();
		textReplacementAnnotation.setFieldText(" \"REPLACED TEXT\" ");
		textReplacementAnnotation.setFontSize(10);
		textReplacementAnnotation.setSvgPath("[{\"x\":251.224,\"y\":637.20401},{\"x\":327.89,\"y\":637.20401},{\"x\":251.224,\"y\":628.20401},{\"x\":327.89,\"y\":628.20401}]");
		textReplacementAnnotation.setPageNumber(0);
		textReplacementAnnotation.setType(AnnotationType.TextReplacement);
		 
		AnnotationInfo arrowAnnotation = new AnnotationInfo();
		arrowAnnotation.setBox(new Rectangle(479f, 218f, -261f, -89f));
		arrowAnnotation.setPageNumber(0);
		arrowAnnotation.setType(AnnotationType.Arrow);
		 
		AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
		textRedactionAnnotation.setPageNumber(0);
		textRedactionAnnotation.setSvgPath("[{\"x\":72,\"y\":676.07},{\"x\":196.427,\"y\":676.074},{\"x\":72,\"y\":662.674},{\"x\":196.427,\"y\":662.674}]");
		textRedactionAnnotation.setType(AnnotationType.TextRedaction);
		 
		AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
		resourceRedactionAnnotation.setBox(new Rectangle(69f, 337f, 449f, 118f));
		resourceRedactionAnnotation.setPageNumber(0);
		resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
		 
		AnnotationInfo underlineAnnotation = new AnnotationInfo();
		underlineAnnotation.setPageNumber(0);
		underlineAnnotation.setSvgPath("[{\"x\":415.17499,\"y\":628.874},{\"x\":511.85101,\"y\":628.874},{\"x\":415.17499,\"y\":619.874},{\"x\":511.85101,\"y\":619.874}]");
		underlineAnnotation.setType(AnnotationType.TextUnderline);
		 
		annotations.add(textAnnotation);
		annotations.add(areaAnnnotation);
		annotations.add(strikeoutAnnotation);
		annotations.add(textFieldAnnotation);
		annotations.add(textReplacementAnnotation);
		annotations.add(arrowAnnotation);
		annotations.add(textRedactionAnnotation);
		annotations.add(resourceRedactionAnnotation);
		annotations.add(underlineAnnotation);
		 
		// Add annotation to the document
		InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);
		 
		// Save result stream to file.
		try (OutputStream fileStream = new FileOutputStream(Utilities.outputPath + File.separator + "Annotated.eml")) { // "../../Annotated.eml"
		    System.out.println(result.available());
		    IOUtils.copy(result, fileStream);
		}
		//ExEnd:differentAnnotationsForEmail
	}
}
