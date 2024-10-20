package com.learn.springboottutorial.exception;

/**
 * @author anthonylee
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
