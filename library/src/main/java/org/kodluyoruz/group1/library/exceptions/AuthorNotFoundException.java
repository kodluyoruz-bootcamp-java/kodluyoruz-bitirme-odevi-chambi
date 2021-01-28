package org.kodluyoruz.group1.library.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthorNotFoundException(String message) {
        super(message);
    }
}