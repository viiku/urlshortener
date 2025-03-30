package com.viiku.urlshortener.url.model.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrlResponse {
    private String originalUrl;
    private String shortUrl;
    private String shortUrlCode;
}
