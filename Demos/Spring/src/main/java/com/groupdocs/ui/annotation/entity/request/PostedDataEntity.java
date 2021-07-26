package com.groupdocs.ui.annotation.entity.request;

import java.util.List;

/**
 * <p>
 * DTO-class, representes document with its pages posted from the front-end.
 * </p>
 */
public class PostedDataEntity {

    /**
     * <p>
     * Absolute path to the posted document.
     * </p>
     * @return 
     */
    public String getPath() {
        return path;
    }

    /**
     * <p>
     * Absolute path to the posted document.
     * </p>
     * @param value
     */
    public void setPath(String value) {
        path = value;
    }
    private String path;

    /**
     * <p>
     * Absolute path to the document.
     * </p>
     * @return 
     */
    public String getGuid() {
        return guid;
    }

    /**
     * <p>
     * Absolute path to the document.
     * </p>
     * @param value
     */
    public void setGuid(String value) {
        guid = value;
    }
    private String guid;

    /**
     * <p>
     * Document password.
     * </p>
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>
     * Document password.
     * </p>
     * @param value
     */
    public void setPassword(String value) {
        password = value;
    }
    private String password;

    /**
     * <p>
     * Url of the posted file.
     * </p>
     * @return 
     */
    public String getUrl() {
        return url;
    }

    /**
     * <p>
     * Url of the posted file.
     * </p>
     * @param value
     */
    public void setUrl(String value) {
        url = value;
    }
    private String url;

    /**
     * <p>
     * Page number.
     * </p>
     * @return 
     */
    public int getPage() {
        return page;
    }

    /**
     * <p>
     * Page number.
     * </p>
     * @param value
     */
    public void setPage(int value) {
        page = value;
    }
    private int page;

    /**
     * <p>
     * Page rotation angle.
     * </p>
     * @return 
     */
    public int getAngle() {
        return angle;
    }

    /**
     * <p>
     * Page rotation angle.
     * </p>
     * @param value
     */
    public void setAngle(int value) {
        angle = value;
    }
    private int angle;

    /**
     * <p>
     * Collection of the document pages with their data.
     * </p>
     * @return 
     */
    public List<Integer> getPages() {
        return pages;
    }

    /**
     * <p>
     * Collection of the document pages with their data.
     * </p>
     * @param value
     */
    public void setPages(List<Integer> value) {
        pages = value;
    }

    private List<Integer> pages;

    /**
     * <p>
     * Flag indicating whether the file should be overwritten.
     * </p>
     * @return 
     */
    public boolean getRewrite() {
        return rewrite;
    }

    /**
     * <p>
     * Flag indicating whether the file should be overwritten.
     * </p>
     * @param value
     */
    public void setRewrite(boolean value) {
        rewrite = value;
    }
    private boolean rewrite;
}