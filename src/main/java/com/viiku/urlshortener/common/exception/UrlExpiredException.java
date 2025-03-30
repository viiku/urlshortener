package com.viiku.urlshortener.common.exception;

public class UrlExpiredException extends RuntimeException {
    public UrlExpiredException(String shortUrl) {
        super("Short URL has expired: " + shortUrl);
    }
}
