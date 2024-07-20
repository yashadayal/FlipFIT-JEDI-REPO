package com.flipkart.exceptions;
public class GymOwnerNotFoundException extends Exception {
    public GymOwnerNotFoundException() {
        super("Gym Owner Not Found or Does Not Exist");
    }
}