package com.example.demo.exceptions;

public class NotAuthenticationException  extends RuntimeException{


    public NotAuthenticationException(String message) {
        super(message);
    }

    public NotAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
