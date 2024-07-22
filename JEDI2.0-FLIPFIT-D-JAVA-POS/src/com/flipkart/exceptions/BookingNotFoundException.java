package com.flipkart.exceptions;
/**
 * Exception to check if booking is failed
 * @author JEDI-04
 */

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String message) {
        super(message);
        System.out.println("Booking Failed"+message);
    }
}
