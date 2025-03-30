package com.viiku.urlshortener.url.model;

import com.viiku.urlshortener.common.model.BaseDomainModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 */

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Url extends BaseDomainModel {

    private String id;
    private String originalUrl;
    private String shortUrl;
    private String customAlias;
    private String shortUrlCode;
    private Date expiryDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
