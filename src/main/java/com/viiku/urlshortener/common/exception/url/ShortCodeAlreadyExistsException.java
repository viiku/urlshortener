package com.viiku.urlshortener.common.exception.url;

public class ShortCodeAlreadyExistsException extends RuntimeException {

    private static final String DEFAULT_MESSAGE =
            "The specified Short Code already exists";

    private static final String MESSAGE_TEMPLATE =
            "Short Code already exists: ";

    public ShortCodeAlreadyExistsException(String email) {
        super(MESSAGE_TEMPLATE.concat(email));
    }

    public ShortCodeAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }
}
