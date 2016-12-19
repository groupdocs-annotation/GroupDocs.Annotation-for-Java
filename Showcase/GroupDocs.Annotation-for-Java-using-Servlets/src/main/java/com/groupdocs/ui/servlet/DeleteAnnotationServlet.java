package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.results.DeleteAnnotationResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annotation/delete")
public class DeleteAnnotationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String filename = request.getParameter("file");
        long annotationId = Long.valueOf(request.getParameter("id"));

        DeleteAnnotationResult result = imageHandler.deleteAnnotation(annotationId);
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}
