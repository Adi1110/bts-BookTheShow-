package com.codeOlogy.booktheshow.exceptionHandler;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message) {
        super(message);
    }
}
