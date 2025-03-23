package com.viiku.urlshortener.model;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class UrlRequestModel {

    @NotBlank(message = "UserId can not be blank")
    private String userId;

    @NotBlank(message = "Original URL can not be blank")
    private String originalUrl;

    private String customAlias;

    private Date expiryDate;

    public String getUserId() { return userId; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public void setCustomAlias(String customAlias) {
        this.customAlias = customAlias;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
