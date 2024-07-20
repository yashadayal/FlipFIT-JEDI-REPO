package com.flipkart.exceptions;

public class GymCentreNotFoundException extends RuntimeException {
    public GymCentreNotFoundException(String message) {
        super(message);
        System.out.println("Centre not found: " + message);
    }
}
