package com.charniauski.training.horsesrace.services.exception;

/**
 * Created by ivc4 on 31.10.2016.
 */
public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException() {
    }

    public NoSuchEntityException(String message) {
        super(message);
    }
}
