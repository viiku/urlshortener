package com.viiku.urlshortener.url.model.entity;

import com.viiku.urlshortener.common.model.entity.BaseEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "URLS")
public class UrlEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Ensure this is present
    private Long id;

    private String userId;
    private String originalUrl;
    private String shortUrl;
    private String customAlias;
    private Date expiryDate;
}
