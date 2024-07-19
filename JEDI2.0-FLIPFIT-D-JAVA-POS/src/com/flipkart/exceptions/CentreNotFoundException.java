package com.flipkart.exceptions;

public class CentreNotFoundException extends RuntimeException {
    public CentreNotFoundException(String message) {
        super(message);
        System.out.println("Centre not found: " + message);
    }
}
