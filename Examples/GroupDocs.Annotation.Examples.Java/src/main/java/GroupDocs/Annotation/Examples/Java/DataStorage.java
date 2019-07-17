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
import com.groupdocs.annotation.domain.AnnotationSizeInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.annotation.domain.ReviewerInfo;
import com.groupdocs.annotation.domain.TextFieldInfo;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.domain.results.AddReplyResult;
import com.groupdocs.annotation.domain.results.CreateAnnotationResult;
import com.groupdocs.annotation.domain.results.DeleteAnnotationResult;
import com.groupdocs.annotation.domain.results.DeleteReplyResult;
import com.groupdocs.annotation.domain.results.EditReplyResult;
import com.groupdocs.annotation.domain.results.GetAnnotationResult;
import com.groupdocs.annotation.domain.results.GetCollaboratorsResult;
import com.groupdocs.annotation.domain.results.ListAnnotationsResult;
import com.groupdocs.annotation.domain.results.ListRepliesResult;
import com.groupdocs.annotation.domain.results.MoveAnnotationResult;
import com.groupdocs.annotation.domain.results.ResizeAnnotationResult;
import com.groupdocs.annotation.domain.results.SaveAnnotationTextResult;
import com.groupdocs.annotation.domain.results.SetCollaboratorsResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.IDocumentDataHandler;
import com.groupdocs.annotation.handler.input.IUserDataHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;
import com.groupdocs.annotation.handler.input.dataobjects.User; 

public class DataStorage {

	// document name
	public static String fileName = "sample.pdf";

	// Creates a document data object in the storage
	public static void createDocument() {
		//ExStart:createDocument
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			System.out.println("Document ID: " + documentId);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:createDocument
	}

	// Assign document access rights
	public static void setDocumentAccessRights() {
		//ExStart:setDocumentAccessRights
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Set document access rights
			annotator.setDocumentAccessRights(documentId, AnnotationReviewerRights.All);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:setDocumentAccessRights
	}

	// Maps annotations and creates dcocument data object in the storage
	public static GetAnnotationResult createAndGetAnnotations() {
		//ExStart:createAndGetAnnotations
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo pointAnnotation = new AnnotationInfo();
			pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
			pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
			pointAnnotation.setType(AnnotationType.Point);
			pointAnnotation.setPageNumber(0);
			pointAnnotation.setCreatorName("Anonym A.");
			pointAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createPointAnnotationResult = annotator.createAnnotation(pointAnnotation);
			// Get annotation from storage
			GetAnnotationResult result = annotator.getAnnotation(createPointAnnotationResult.getGuid());
			return result;
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		//ExEnd:createAndGetAnnotations
	}

	// Gets annotations from the storage file
	public static void getAllAnnotations() {
		//ExStart:getAllAnnotations
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo pointAnnotation = new AnnotationInfo();
			pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
			pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
			pointAnnotation.setType(AnnotationType.Point);
			pointAnnotation.setPageNumber(0);
			pointAnnotation.setCreatorName("Anonym A.");
			pointAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createPointAnnotationResult = annotator.createAnnotation(pointAnnotation);
			System.out.println(createPointAnnotationResult);
			// Get all annotations from storage
			ListAnnotationsResult listAnnotationsResult = annotator.getAnnotations(documentId);
			System.out.println(listAnnotationsResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:getAllAnnotations
	}

	// Resize annotation result
	public static void resizeAnnotationResult() {
		//ExStart:resizeAnnotationResult
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage.
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo areaAnnotation = new AnnotationInfo();
			areaAnnotation.setAnnotationPosition(new Point(852.0, 271.7));
			areaAnnotation.setBackgroundColor(3355443);
			areaAnnotation.setBox(new Rectangle(466f, 271f, 69f, 62f));
			areaAnnotation.setPageNumber(0);
			areaAnnotation.setPenColor(3355443);
			areaAnnotation.setType(AnnotationType.Area);
			areaAnnotation.setCreatorName("Anonym A.");
			areaAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createAreaAnnotationResult = annotator.createAnnotation(areaAnnotation);
			// Resize annotation
			final AnnotationSizeInfo annotationSizeInfo = new AnnotationSizeInfo();
			annotationSizeInfo.setHeight(80);
			annotationSizeInfo.setWidth(60);
			ResizeAnnotationResult resizeResult = annotator.resizeAnnotation(createAreaAnnotationResult.getId(),
					annotationSizeInfo);
			System.out.println(resizeResult);
			// Check data
			GetAnnotationResult resizedAnnotation = annotator.getAnnotation(createAreaAnnotationResult.getGuid());
			System.out.println(resizedAnnotation);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:resizeAnnotationResult
	}

	// Moves annotation marker
	public static void moveAnnotationResult() {
		//ExStart:moveAnnotationResult
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage.
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo areaAnnotation = new AnnotationInfo();
			areaAnnotation.setAnnotationPosition(new Point(852.0, 271.7));
			areaAnnotation.setBackgroundColor(3355443);
			areaAnnotation.setBox(new Rectangle(466f, 271f, 69f, 62f));
			areaAnnotation.setPageNumber(0);
			areaAnnotation.setPenColor(3355443);
			areaAnnotation.setType(AnnotationType.Area);
			areaAnnotation.setCreatorName("Anonym A.");
			areaAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createAreaAnnotationResult = annotator.createAnnotation(areaAnnotation);
			// Move annotation marker
			MoveAnnotationResult moveAnnotationResult = annotator.moveAnnotationMarker(
					createAreaAnnotationResult.getId(), new Point(200, 200), /* NewPageNumber */ 1);
			System.out.println(moveAnnotationResult);
			System.out.println(moveAnnotationResult);
			// Check data
			GetAnnotationResult resizedAnnotation = annotator.getAnnotation(createAreaAnnotationResult.getGuid());
			System.out.println(resizedAnnotation);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:moveAnnotationResult
	}

	// Sets background color of annotation
	public static void setBackgroundColor() {
		//ExStart:setBackgroundColor
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage.
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo areaAnnotation = new AnnotationInfo();
			areaAnnotation.setAnnotationPosition(new Point(852.0, 271.7));
			areaAnnotation.setBackgroundColor(3355443);
			areaAnnotation.setBox(new Rectangle(466f, 271f, 69f, 62f));
			areaAnnotation.setPageNumber(0);
			areaAnnotation.setPenColor(3355443);
			areaAnnotation.setType(AnnotationType.Area);
			areaAnnotation.setCreatorName("Anonym A.");
			areaAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createAreaAnnotationResult = annotator.createAnnotation(areaAnnotation);
			// Set background color of annotation
			SaveAnnotationTextResult setBackgroundColorResult = annotator
					.setAnnotationBackgroundColor(createAreaAnnotationResult.getId(), 16711680);
			System.out.println(setBackgroundColorResult);
			// Check data
			GetAnnotationResult resizedAnnotation = annotator.getAnnotation(createAreaAnnotationResult.getGuid());
			System.out.println(resizedAnnotation);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:setBackgroundColor
	}

	// Updates the text in the annotation
	
	public static void editTextFieldAnnotations() {
		//ExStart:editTextFieldAnnotations
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage.
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo textFieldAnnotation = new AnnotationInfo();
			textFieldAnnotation.setAnnotationPosition(new Point(852.0, 201.0));
			textFieldAnnotation.setFieldText("text in the box");
			textFieldAnnotation.setFontFamily("Arial");
			textFieldAnnotation.setFontSize(10D);
			textFieldAnnotation.setBox(new Rectangle(66f, 201f, 64f, 37f));
			textFieldAnnotation.setPageNumber(0);
			textFieldAnnotation.setType(AnnotationType.TextField);
			textFieldAnnotation.setCreatorName("Anonym A.");
			textFieldAnnotation.setDocumentGuid(documentId);
			final CreateAnnotationResult createTextFieldAnnotationResult = annotator
					.createAnnotation(textFieldAnnotation);
			// Update text in the annotation
			final TextFieldInfo textFieldInfo = new TextFieldInfo();
			textFieldInfo.setFieldText("new text");
			textFieldInfo.setFontFamily("Colibri");
			textFieldInfo.setFontSize(12D);
			SaveAnnotationTextResult saveTextFieldResult = annotator
					.saveTextField(createTextFieldAnnotationResult.getId(), textFieldInfo);
			System.out.println(saveTextFieldResult);
			// Set text field color
			SaveAnnotationTextResult saveTextFieldColorResult = annotator
					.setTextFieldColor(createTextFieldAnnotationResult.getId(), 16753920);
			System.out.println(saveTextFieldColorResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:editTextFieldAnnotations
	}

	// Removes annotations
	public static void removeAnnotation() {
		//ExStart:removeAnnotation
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage.
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo pointAnnotation = new AnnotationInfo();
			pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
			pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
			pointAnnotation.setType(AnnotationType.Point);
			pointAnnotation.setPageNumber(0);
			pointAnnotation.setCreatorName("Anonym A.");
			pointAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createPointAnnotationResult = annotator.createAnnotation(pointAnnotation);
			// Get all annotations from storage
			ListAnnotationsResult listAnnotationsResult = annotator.getAnnotations(documentId);
			// Get annotation
			GetAnnotationResult annotation = annotator
					.getAnnotation(listAnnotationsResult.getAnnotations()[0].getGuid());
			// Delete annotation
			DeleteAnnotationResult deleteAnnotationResult = annotator.deleteAnnotation(annotation.getId());
			// Delete all annotations
			annotator.deleteAnnotations(documentId);
			System.out.println(deleteAnnotationResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:removeAnnotation
	}

	// Adds reply to the annotation, edits reply, creates child reply
	public static void addAnnotationReply() {
		//ExStart:addAnnotationReply
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create document data object in storage
			final Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName) : document.getId();
			// Create annotation object
			AnnotationInfo pointAnnotation = new AnnotationInfo();
			pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
			pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
			pointAnnotation.setType(AnnotationType.Point);
			pointAnnotation.setPageNumber(0);
			pointAnnotation.setCreatorName("Anonym A.");
			pointAnnotation.setDocumentGuid(documentId);
			// Add annotation to storage
			CreateAnnotationResult createPointAnnotationResult = annotator.createAnnotation(pointAnnotation);
			// Add simple reply to created annotation
			AddReplyResult addSimpleReplyResult = annotator.createAnnotationReply(createPointAnnotationResult.getId(),
					"first question");
			// Edit created reply
			EditReplyResult editReplyResult = annotator.editAnnotationReply(addSimpleReplyResult.getReplyGuid(),
					"changed question");
			System.out.println(editReplyResult);
			// Create child reply. This reply will be linked to previously
			// created reply.
			AddReplyResult addChildReplyResult = annotator.createAnnotationReply(createPointAnnotationResult.getId(),
					"answer", addSimpleReplyResult.getReplyGuid());
			System.out.println(addChildReplyResult);
			// Delete annotation reply by guid
			DeleteReplyResult deleteReplyResult = annotator.deleteAnnotationReply(addChildReplyResult.getReplyGuid());
			System.out.println(deleteReplyResult);
			// Delete all replies from annotation
			annotator.deleteAnnotationReplies(createPointAnnotationResult.getId());
			// List of replies after deleting all replies
			ListRepliesResult listRepliesResultAfterDeleteAll = annotator
					.listAnnotationReplies(createPointAnnotationResult.getId());
			System.out.println(listRepliesResultAfterDeleteAll);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addAnnotationReply
	}

	// Adds document collaborator
	public static void addCollaborator() {
		//ExStart:addCollaborator
		try {
			// Create instance of the annotation handler
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IUserDataHandler userRepository = annotator.getUserDataHandler();
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create owner.
			User owner = userRepository.getUserByEmail("john@doe.com");
			if (owner == null) {
				final User user = new User();
				user.setFirstName("John");
				user.setLastName("Doe");
				user.setEmail("john@doe.com");
				userRepository.add(user);
				owner = userRepository.getUserByEmail("john@doe.com");
			}
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			if (document != null && document.getOwnerId() != owner.getId()) {
				documentRepository.remove(document);
				document = null;
			}
			long documentId = document == null ? annotator.createDocument(fileName, DocumentType.Pdf, owner.getId())
					: document.getId();
			// Create reviewer.
			ReviewerInfo reviewerInfo = new ReviewerInfo();
			reviewerInfo.setPrimaryEmail("judy@doe.com");
			reviewerInfo.setFirstName("Judy");
			reviewerInfo.setLastName("Doe");
			reviewerInfo.setAccessRights(AnnotationReviewerRights.All);
			// Add collaborator to the document. If user with UserName equals to
			// reviewers PrimaryEmail is absent it will be created.
			SetCollaboratorsResult addCollaboratorResult = annotator.addCollaborator(documentId, reviewerInfo);
			System.out.println(addCollaboratorResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addCollaborator
	}

	// Gets document collaborator
	public static void getCollaborator() {
		//ExStart:getCollaborator
		try {
			// Create instance of the annotation handler
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IUserDataHandler userRepository = annotator.getUserDataHandler();
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create owner.
			User owner = userRepository.getUserByEmail("john@doe.com");
			if (owner == null) {
				final User user = new User();
				user.setFirstName("John");
				user.setLastName("Doe");
				user.setEmail("john@doe.com");
				userRepository.add(user);
				owner = userRepository.getUserByEmail("john@doe.com");
			}
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			if (document != null && document.getOwnerId() != owner.getId()) {
				documentRepository.remove(document);
				document = null;
			}
			long documentId = document == null ? annotator.createDocument(fileName, DocumentType.Pdf, owner.getId())
					: document.getId();
			// Create reviewer.
			ReviewerInfo reviewerInfo = new ReviewerInfo();
			reviewerInfo.setPrimaryEmail("judy@doe.com");
			reviewerInfo.setFirstName("Judy");
			reviewerInfo.setLastName("Doe");
			reviewerInfo.setAccessRights(AnnotationReviewerRights.All);
			// Get document collaborators
			GetCollaboratorsResult getCollaboratorsResult = annotator.getCollaborators(documentId);
			System.out.println(getCollaboratorsResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:getCollaborator
	}

	// Updates document collaborator
	
	public static void updateCollaborator() {
		//ExStart:updateCollaborator
		try {
			// Create instance of the annotation handler
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IUserDataHandler userRepository = annotator.getUserDataHandler();
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create owner.
			User owner = userRepository.getUserByEmail("john@doe.com");
			if (owner == null) {
				final User user = new User();
				user.setFirstName("John");
				user.setLastName("Doe");
				user.setEmail("john@doe.com");
				userRepository.add(user);
				owner = userRepository.getUserByEmail("john@doe.com");
			}
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			if (document != null && document.getOwnerId() != owner.getId()) {
				documentRepository.remove(document);
				document = null;
			}
			long documentId = document == null ? annotator.createDocument(fileName, DocumentType.Pdf, owner.getId())
					: document.getId();
			// Create reviewer.
			ReviewerInfo reviewerInfo = new ReviewerInfo();
			reviewerInfo.setPrimaryEmail("judy@doe.com");
			reviewerInfo.setFirstName("Judy");
			reviewerInfo.setLastName("Doe");
			reviewerInfo.setAccessRights(AnnotationReviewerRights.All);
			// Update collaborator. Only color and access rights will be
			// updated.
			reviewerInfo.setColor(3355443);
			SetCollaboratorsResult updateCollaboratorResult = annotator.updateCollaborator(documentId, reviewerInfo);
			System.out.println(updateCollaboratorResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:updateCollaborator
	}

	// Deletes document collaborator
	public static void deleteCollaborator() {
		//ExStart:deleteCollaborator
		try {
			// Create instance of the annotation handler
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IUserDataHandler userRepository = annotator.getUserDataHandler();
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create owner.
			User owner = userRepository.getUserByEmail("john@doe.com");
			if (owner == null) {
				final User user = new User();
				user.setFirstName("John");
				user.setLastName("Doe");
				user.setEmail("john@doe.com");
				userRepository.add(user);
				owner = userRepository.getUserByEmail("john@doe.com");
			}
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			if (document != null && document.getOwnerId() != owner.getId()) {
				documentRepository.remove(document);
				document = null;
			}
			long documentId = document == null ? annotator.createDocument(fileName, DocumentType.Pdf, owner.getId())
					: document.getId();
			// Create reviewer.
			ReviewerInfo reviewerInfo = new ReviewerInfo();
			reviewerInfo.setPrimaryEmail("judy@doe.com");
			reviewerInfo.setFirstName("Judy");
			reviewerInfo.setLastName("Doe");
			reviewerInfo.setAccessRights(AnnotationReviewerRights.All);
			// Delete collaborator
			SetCollaboratorsResult deleteCollaboratorResult = annotator.deleteCollaborator(documentId,
					reviewerInfo.getPrimaryEmail());
			System.out.println(deleteCollaboratorResult);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:deleteCollaborator
	}

	// Manages user rights
	public static void managesCollaboratorRights() {
		//ExStart:managesCollaboratorRights
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			IUserDataHandler userRepository = annotator.getUserDataHandler();
			IDocumentDataHandler documentRepository = annotator.getDocumentDataHandler();
			// Create owner.
			User johnOwner = userRepository.getUserByEmail("john@doe.com");
			if (johnOwner == null) {
				final User user = new User();
				user.setFirstName("John");
				user.setLastName("Doe");
				user.setEmail("john@doe.com");
				userRepository.add(user);
				johnOwner = userRepository.getUserByEmail("john@doe.com");
			}
			// Create document data object in storage
			Document document = documentRepository.getDocument(fileName);
			long documentId = document == null ? annotator.createDocument(fileName, DocumentType.Pdf, johnOwner.getId())
					: document.getId();
			// Create reviewer.
			ReviewerInfo reviewerInfo = new ReviewerInfo();
			reviewerInfo.setPrimaryEmail("judy@doe.com");
			reviewerInfo.setFirstName("Judy");
			reviewerInfo.setLastName("Doe");
			reviewerInfo.setAccessRights(AnnotationReviewerRights.CanView);
			// Add collaborator to the document. If user with UserName equals
			// to reviewers PrimaryEmail is absent it will be created.
			SetCollaboratorsResult addCollaboratorResult = annotator.addCollaborator(documentId, reviewerInfo);
			// Get document collaborators
			GetCollaboratorsResult getCollaboratorsResult = annotator.getCollaborators(documentId);
			User judy = userRepository.getUserByEmail("judy@doe.com");
			// Create annotation object
			AnnotationInfo pointAnnotation = new AnnotationInfo();
			pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
			pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
			pointAnnotation.setType(AnnotationType.Point);
			pointAnnotation.setPageNumber(0);
			pointAnnotation.setCreatorName("Anonym A.");
			// John try to add annotations
			CreateAnnotationResult johnResult = annotator.createAnnotation(pointAnnotation, documentId,
					johnOwner.getId());
			System.out.println(johnResult);
			// Judy try to add annotations
			try {
				CreateAnnotationResult judyResult = annotator.createAnnotation(pointAnnotation, documentId,
						judy.getId());
				System.out.println(judyResult);
			} catch (AnnotatorException e) {
				System.out.println(e.getMessage());
			}
			// Allow Judy create annotations.
			reviewerInfo.setAccessRights(AnnotationReviewerRights.CanAnnotate);
			SetCollaboratorsResult updateCollaboratorResult = annotator.updateCollaborator(documentId, reviewerInfo);
			System.out.println(updateCollaboratorResult);
			// Judy try to add annotations
			CreateAnnotationResult judyResultCanAnnotate = annotator.createAnnotation(pointAnnotation, documentId,
					judy.getId());
			System.out.println(judyResultCanAnnotate);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:managesCollaboratorRights
	}

	// Export Annotations
	public static void exportAnnotations() {
		//ExStart:exportAnnotations
		try {
			// Create instance of annotator.
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			// Get stream of document(in code sample document previously was
			// added to embedded
			// resources of the assembly. You can get stream of the document in
			// other ways.)
			InputStream manifestResourceStream = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Area annotation with 2 replies
			AnnotationInfo areaAnnnotation = new AnnotationInfo();
			areaAnnnotation.setAnnotationPosition(new Point(852.0, 59.0));
			AnnotationReplyInfo[] annotationReplyInfos = new AnnotationReplyInfo[2];
			annotationReplyInfos[0] = new AnnotationReplyInfo();
			annotationReplyInfos[0].setMessage("Hello!");
			annotationReplyInfos[0].setRepliedOn(Calendar.getInstance().getTime());
			annotationReplyInfos[0].setUserEmail("John");
			annotationReplyInfos[1] = new AnnotationReplyInfo();
			annotationReplyInfos[1].setMessage("Hi!");
			annotationReplyInfos[1].setRepliedOn(Calendar.getInstance().getTime());
			annotationReplyInfos[1].setUserEmail("Judy");
			areaAnnnotation.setReplies(annotationReplyInfos);
			areaAnnnotation.setBackgroundColor(11111111);
			areaAnnnotation.setBox(new Rectangle(300f, 200f, 88f, 37f));
			areaAnnnotation.setPageNumber(0);
			areaAnnnotation.setPenColor(2222222);
			areaAnnnotation.setPenStyle((byte) 1);
			areaAnnnotation.setPenWidth((byte) 1);
			areaAnnnotation.setType(AnnotationType.Area);
			areaAnnnotation.setCreatorName("Anonym A.");
			annotations.add(areaAnnnotation);
			// Add annotation to the document. Annotator will return stream with
			// annotated document.
			InputStream stream = annotator.exportAnnotationsToDocument(manifestResourceStream, annotations,
					DocumentType.Pdf);
			// Save result stream to file.
			OutputStream fileStream = new FileOutputStream(
					Utilities.outputPath + File.separator + "document-annotated.pdf");
			IOUtils.copy(stream, fileStream);
			System.out.println("Document exported!");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:exportAnnotations
	}
}
