package com.flipkart.exceptions;

/**
 * Exception to check if gym center present or not
 * @author JEDI-04
 */

public class GymCentreNotFoundException extends RuntimeException {
    public GymCentreNotFoundException(String message) {
        super(message);
        System.out.println("Centre not found: " + message);
    }
}
