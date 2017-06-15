package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.AnnotationReplyInfo;
import com.groupdocs.annotation.domain.results.AddReplyResult;
import com.groupdocs.annotation.domain.results.GetAnnotationResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/replies")
public class RepliesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");

        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String guid = request.getParameter("guid");

        GetAnnotationResult annotationResult = imageHandler.getAnnotation(guid);
        if (annotationResult == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        long annotationId = annotationResult.getId();
        AnnotationReplyInfo[] list = imageHandler.listAnnotationReplies(annotationId).getReplies();

        new ObjectMapper().writeValue(response.getOutputStream(), list);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();

        AnnotationReplyInfo info = new ObjectMapper().readValue(request.getInputStream(), AnnotationReplyInfo.class);

        long annotationId = imageHandler.getAnnotation(info.getGuid()).getId();

        AddReplyResult result = imageHandler.createAnnotationReply(annotationId, "");
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}

