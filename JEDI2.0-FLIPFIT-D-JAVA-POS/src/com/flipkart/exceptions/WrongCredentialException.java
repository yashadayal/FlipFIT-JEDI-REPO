package com.flipkart.exceptions;

/**
 * Exception to check if wrong credential entered by user
 * @author JEDI-04
 */

public class WrongCredentialException extends Exception {
    public WrongCredentialException(String message) {
        super(message);
        System.out.println("Wrong Credential");
    }
}