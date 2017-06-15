package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.annotation.domain.TextFieldInfo;
import com.groupdocs.annotation.domain.results.DeleteAnnotationResult;
import com.groupdocs.annotation.domain.results.MoveAnnotationResult;
import com.groupdocs.annotation.domain.results.SaveAnnotationTextResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annotation")
public class AnnotationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");

        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String guid = request.getParameter("guid");

        new ObjectMapper().writeValue(response.getOutputStream(), imageHandler.getAnnotation(guid).getAnnotation());
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();

        String guid = request.getParameter("guid");
        long annotationId = imageHandler.getAnnotation(guid).getId();

        DeleteAnnotationResult result = imageHandler.deleteAnnotation(annotationId);
        new ObjectMapper().writeValue(response.getOutputStream(), result);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String guid = request.getParameter("guid");
        String section = request.getParameter("section");
        AnnotationInfo annotationInfo = imageHandler.getAnnotation(guid).getAnnotation();
        long annotationId = imageHandler.getAnnotation(guid).getId();

        switch (section) {
            case "fieldtext":
                TextFieldInfo info = new ObjectMapper().readValue(request.getInputStream(), TextFieldInfo.class);
                SaveAnnotationTextResult result = imageHandler.saveTextField(annotationId, info);
                new ObjectMapper().writeValue(response.getOutputStream(), result);
                break;
            case "position":
                Point point = new ObjectMapper().readValue(request.getInputStream(), Point.class);
                imageHandler.moveAnnotationMarker(annotationId, point, annotationInfo.getPageNumber());
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }
}

