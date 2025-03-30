package com.viiku.urlshortener.common.exception.user;

import java.io.Serial;

/**
 * Exception class named {@link EmailAlreadyExistsException} thrown
 * when an email already exist in system
 */

public class EmailAlreadyExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -6856741036475854853L;

    private static final String DEFAULT_MESSAGE =
            "The specified email already exists";

    private static final String MESSAGE_TEMPLATE =
            "Email already exists: ";

    public EmailAlreadyExistsException(String email) {
        super(MESSAGE_TEMPLATE.concat(email));
    }

    public EmailAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }
}
