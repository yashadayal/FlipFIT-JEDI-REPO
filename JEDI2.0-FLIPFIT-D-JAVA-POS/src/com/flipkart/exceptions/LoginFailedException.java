package com.flipkart.exceptions;
public class LoginFailedException extends RuntimeException{
    public LoginFailedException(String message) {
        super(message);
        System.out.println("Login Failed"+message);
    }
}