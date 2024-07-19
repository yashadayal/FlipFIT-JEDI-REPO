package com.flipkart.exceptions;
public class RegistrationFailedException extends RuntimeException {
    public RegistrationFailedException(String message) {
        super(message);
        System.out.println("Registration Failed, pls try again" + message);
    }
}