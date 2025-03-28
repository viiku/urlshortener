package com.viiku.urlshortener.url.payload.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlResponse {

    private String id;
    private String originalUrl;
    private String shortUrl;
}
