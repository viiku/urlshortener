package com.viiku.urlshortener.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Table(name = "url")
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure this is present
    private Long id;

    private String userId;
    private String originalUrl;
    private String shortUrl;
    private String customAlias;
    private Date creationDate;
    private Date expiryDate;

    public Url() {
    }

    public Url(String userId, String originalUrl, String shortUrl, String customAlias, Date creationDate, Date expiryDate) {
        this.userId = userId;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.customAlias = customAlias;
        this.creationDate = creationDate;
        this.expiryDate = expiryDate;
    }
}
