package com.viiku.urlshortener.common.exception.url;

public class ShortCodeGenerationException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Got error when generting short code";

    public ShortCodeGenerationException() { super(DEFAULT_MESSAGE); }
}
