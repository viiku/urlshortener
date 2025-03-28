package com.viiku.urlshortener.url.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UrlRequestModel {

    @NotBlank(message = "UserId can not be blank")
    private String userId;

    @NotBlank(message = "Original URL can not be blank")
    private String originalUrl;

    private String customAlias;

    private Date expiryDate;
}
