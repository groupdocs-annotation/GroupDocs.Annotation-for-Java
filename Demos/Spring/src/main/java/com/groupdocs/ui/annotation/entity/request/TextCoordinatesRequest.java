package com.groupdocs.ui.annotation.entity.request;

public class TextCoordinatesRequest extends PostedDataEntity {

    public final String getGuid_Rename_Namesake() {
        return guid;
    }

    public final void setQuid_Rename_Namesake(String value) {
        guid = value;
    }
    private String guid;

    public final String getPassword_Rename_Namesake() {
        return password;
    }

    public final void setPassword_Rename_Namesake(String value) {
        password = value;
    }
    private String password;

    public final int getPageNumber() {
        return pageNumber;
    }

    public final void setPageNumber(int value) {
        pageNumber = value;
    }
    private int pageNumber;
}