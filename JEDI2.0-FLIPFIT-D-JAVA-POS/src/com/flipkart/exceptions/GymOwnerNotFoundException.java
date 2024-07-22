package com.flipkart.exceptions;

/**
 * Exception to check if gym owner is found
 * @author JEDI-04
 */

public class GymOwnerNotFoundException extends Exception {
    public GymOwnerNotFoundException() {
        super("Gym Owner Not Found or Does Not Exist");
    }
}