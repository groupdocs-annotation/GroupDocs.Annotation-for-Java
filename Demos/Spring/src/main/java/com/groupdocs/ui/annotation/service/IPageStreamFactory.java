package com.groupdocs.ui.annotation.service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author AlexT
 */
public interface IPageStreamFactory {
    OutputStream createPageStream(int pageNumber);
    void closePageStream(int pageNumber, InputStream pageStream);
}
