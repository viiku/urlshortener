package com.viiku.urlshortener.url.model.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class UrlRequest {

    @NotNull(message = "Original URL can not be blank")
    private String originalUrl;

    private String customAlias;
    private LocalDateTime expiryDate;
}
