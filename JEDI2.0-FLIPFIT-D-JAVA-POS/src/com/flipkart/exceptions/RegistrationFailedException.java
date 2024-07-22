package com.flipkart.exceptions;

/**
 * Exception to check if registration failed
 * @author JEDI-04
 */

public class RegistrationFailedException extends RuntimeException {
    public RegistrationFailedException(String message) {
        super(message);
        System.out.println("Registration Failed, pls try again" + message);
    }
}