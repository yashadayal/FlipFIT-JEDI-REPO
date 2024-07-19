package com.flipkart.exceptions;
public class GymOwnerNotFound extends Exception {
    public GymOwnerNotFound() {
        super("Gym Owner Not Found or Does Not Exist");
    }
}