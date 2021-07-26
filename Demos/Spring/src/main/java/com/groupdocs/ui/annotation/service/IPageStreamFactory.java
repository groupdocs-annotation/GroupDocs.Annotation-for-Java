/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.ui.annotation.service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author AlexT
 */
public interface IPageStreamFactory {

    public OutputStream createPageStream(int pageNumber);

    public void closePageStream(int pageNumber, InputStream pageStream);
}
