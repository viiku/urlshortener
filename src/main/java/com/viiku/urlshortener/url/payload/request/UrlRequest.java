package com.viiku.urlshortener.url.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlRequest {

    @NotNull(message = "Url is mandatory")
    private String originalUrl;

    private String customAlias;
    private Date expiryDate;
}
