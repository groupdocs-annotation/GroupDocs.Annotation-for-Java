package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.AnnotationReplyInfo;
import com.groupdocs.annotation.domain.results.DeleteReplyResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();

        String guid = request.getParameter("guid");

        DeleteReplyResult result = imageHandler.deleteAnnotationReply(guid);
        new ObjectMapper().writeValue(response.getOutputStream(), result);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String guid = request.getParameter("guid");
        String section = request.getParameter("section");

        switch (section) {
            case "message":
                AnnotationReplyInfo info = new ObjectMapper().readValue(request.getInputStream(), AnnotationReplyInfo.class);
                imageHandler.editAnnotationReply(guid, info.getMessage());
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }
}

