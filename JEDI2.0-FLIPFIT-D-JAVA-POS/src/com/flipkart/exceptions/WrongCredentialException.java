package com.flipkart.exceptions;
public class WrongCredentialException extends Exception {
    public WrongCredentialException(String message) {
        super(message);
        System.out.println("Wrong Credential");
    }
}