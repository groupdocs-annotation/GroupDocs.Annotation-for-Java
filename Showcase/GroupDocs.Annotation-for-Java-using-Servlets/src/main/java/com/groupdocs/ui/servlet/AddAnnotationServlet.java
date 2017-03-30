package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.results.CreateAnnotationResult;
import com.groupdocs.annotation.domain.results.ListAnnotationsResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.IDocumentDataHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annotation/add")
public class AddAnnotationServlet
        extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        IDocumentDataHandler documentDataHandler = imageHandler.getDocumentDataHandler();

        String filename = request.getParameter("file");
        Document doc = documentDataHandler.getDocument(filename);
        long documentId = doc != null ? doc.getId() : imageHandler.createDocument(filename);

        AnnotationInfo annotation = new ObjectMapper().readValue(request.getInputStream(), AnnotationInfo.class);
        annotation.setDocumentGuid(documentId);
        CreateAnnotationResult result = imageHandler.createAnnotation(annotation);
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}
