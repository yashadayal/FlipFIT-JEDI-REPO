package com.flipkart.exceptions;

/**
 * Exception to check if login failed
 * @author JEDI-04
 */

public class LoginFailedException extends RuntimeException{
    public LoginFailedException(String message) {
        super(message);
        System.out.println("Login Failed"+message);
    }
}