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
 * Currently this class has no use, we're mapping UrlResponse from this
 * We can keep this class some other purpose, if we want to add more
 * features then this can be used, right now it is being used to map
 * UrlResponse, which we can obviously do without using it.
 */

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Url extends BaseDomainModel {

//    private String id;
    private String originalUrl;
    private String shortUrl;
    private String customAlias;
    private String shortCode;
    private LocalDateTime createdAt;
    private LocalDateTime expiryDate;
}
