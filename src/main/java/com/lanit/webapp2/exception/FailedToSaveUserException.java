package com.lanit.webapp2.exception;

public class FailedToSaveUserException extends Exception {
    public FailedToSaveUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
