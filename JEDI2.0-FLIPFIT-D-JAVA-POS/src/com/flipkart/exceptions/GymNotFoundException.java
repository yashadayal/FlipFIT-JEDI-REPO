package com.flipkart.exceptions;
public class GymNotFoundException extends RuntimeException {
    public GymNotFoundException(String message) {
        super(message);
        System.out.println("Centre not found" + message);
    }
}