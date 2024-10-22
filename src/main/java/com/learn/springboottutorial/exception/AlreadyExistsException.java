package com.learn.springboottutorial.exception;

/**
 * @author anthonylee
 */
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
