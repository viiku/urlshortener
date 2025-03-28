package com.viiku.urlshortener.url.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlResponseModel {
    private String originalUrl;
    private String shortUrl;
}
