package com.groupdocs.ui.servlet;

import com.groupdocs.annotation.domain.image.PageImage;
import com.groupdocs.annotation.domain.options.ImageOptions;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Query String parameters:
 * width: Integer: The width of output image.
 * height: Integer: The height of output image.
 * page: Integer: The page number that needs to be converted.
 */
@WebServlet("/page/image")
public class PageImageServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-Type", "image/png");
        AnnotationImageHandler handler = Utils.createAnnotationImageHandler();

        ImageOptions o = new ImageOptions();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        o.setPageNumbersToConvert(Arrays.asList(pageNumber - 1));
        o.setPageNumber(pageNumber - 1);
        o.setCountPagesToConvert(1);
        if (request.getParameterMap().containsKey("width")) {
            o.setWidth(Integer.valueOf(request.getParameter("width")));
        }
        if (request.getParameterMap().containsKey("height")) {
            o.setHeight(Integer.valueOf(request.getParameter("height")));
        }

        String filename = request.getParameter("file");

        for (PageImage pageImage: handler.getPages(filename, o)) {
            if (pageImage.getPageNumber() == pageNumber - 1) {
                IOUtils.copy(pageImage.getStream(), response.getOutputStream());
                break;
            }
        }
    }
}
