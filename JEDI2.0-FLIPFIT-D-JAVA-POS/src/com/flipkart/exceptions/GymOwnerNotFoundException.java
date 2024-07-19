package com.flipkart.exceptions;

public class GymOwnerNotFoundException extends Exception{
    public GymOwnerNotFoundException(String message) {
        super(message);
        System.out.println("GymOwnerNotFoundException" + message);
    }
}