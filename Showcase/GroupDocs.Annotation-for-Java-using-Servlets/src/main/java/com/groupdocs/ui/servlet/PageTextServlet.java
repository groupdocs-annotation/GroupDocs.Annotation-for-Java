package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.RowData;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/page/text")
public class PageTextServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler handler = Utils.createAnnotationImageHandler();

        int pageNumber = Integer.valueOf(request.getParameter("page"));
        String filename = request.getParameter("file");

        List<RowData> result = new ArrayList<>();
        DocumentInfoContainer documentInfoContainer = handler.getDocumentInfo(filename);
        for (PageData pageData : documentInfoContainer.getPages()) {
            if (pageData.getNumber() == pageNumber) {
                result = pageData.getRows();
                break;
            }
        }
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}
