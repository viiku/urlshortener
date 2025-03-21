package com.viiku.urlshortener;

import java.util.Date;

public class CreateUrlShortener {
    String id;
    String userId;
    String originalUrl;
    String customAlias;
    Date expiryDate;

    public CreateUrlShortener(String id, String userId, String originalUrl, String customAlias, Date expiryDate) {
        this.id = id;
        this.userId = userId;
        this.originalUrl = originalUrl;
        this.customAlias = customAlias;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

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
