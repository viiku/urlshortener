package com.viiku.urlshortener.url.model.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UrlRequest {

//    @NotBlank(message = "UserId can not be blank")
//    private String userId;

    @NotNull(message = "Original URL can not be blank")
    private String originalUrl;

    private String customAlias;

    private Date expiryDate;
}
