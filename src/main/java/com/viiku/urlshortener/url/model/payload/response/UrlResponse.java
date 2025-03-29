package com.viiku.urlshortener.url.model.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlResponse {
    private String originalUrl;
    private String shortUrl;
}
