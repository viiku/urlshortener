package com.viiku.urlshortener.common.exception.url;

import com.viiku.urlshortener.common.exception.NotFoundException;

public class ShortUrlNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE =
            "The specified url is not found";

    private static final String MESSAGE_TEMPLATE =
            "No url was found with ID: ";

    public ShortUrlNotFoundException(String id) {
        super(MESSAGE_TEMPLATE.concat(id));
    }

    public ShortUrlNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
