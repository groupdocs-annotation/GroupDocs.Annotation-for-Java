package com.groupdocs.ui.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

public class CommonConfigurationModel {
    @Valid
    @JsonProperty
    private boolean pageSelector;

    @Valid
    @JsonProperty
    private boolean download;

    @Valid
    @JsonProperty
    private boolean upload;

    @Valid
    @JsonProperty
    private boolean print;

    @Valid
    @JsonProperty
    private boolean browse;

    @Valid
    @JsonProperty
    private boolean rewrite;

    @Valid
    @JsonProperty
    private boolean enableRightClick;

    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isBrowse() {
        return browse;
    }

    public void setBrowse(boolean browse) {
        this.browse = browse;
    }

    public boolean isRewrite() {
        return rewrite;
    }

    public void setRewrite(boolean rewrite) {
        this.rewrite = rewrite;
    }

    public boolean isEnableRightClick() {
        return enableRightClick;
    }

    public void setEnableRightClick(boolean enableRightClick) {
        this.enableRightClick = enableRightClick;
    }

    public void init(CommonConfiguration common) {
        this.setPageSelector(common.isPageSelector());
        this.setDownload(common.isDownload());
        this.setUpload(common.isUpload());
        this.setPrint(common.isPrint());
        this.setBrowse(common.isBrowse());
        this.setRewrite(common.isRewrite());
        this.setEnableRightClick(common.isEnableRightClick());
    }
}
