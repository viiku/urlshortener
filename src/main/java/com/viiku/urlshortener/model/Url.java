package com.viiku.urlshortener.model;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "url")
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure this is present
    private Long id;

    private String userId;
    private String originalUrl;
    private String customAlias;
    private Date expiryDate;

    public Url() {
    }

    public Url(String userId, String originalUrl, String customAlias, Date expiryDate) {
        this.userId = userId;
        this.originalUrl = originalUrl;
        this.customAlias = customAlias;
        this.expiryDate = expiryDate;
    }
}
