package com.flipkart.bean;

/**
 * @author JEDI-04
 * Booking Class
 */

public class Booking {

    private int bookingID; // Unique identifier for the booking
    private String email;  // Email of the customer making the booking
    private String customerID; // ID of the customer making the booking
    private final String startTime; // Start time of the booking
    private final String endTime; // End time of the booking

    /**
     * Constructs a Booking object with the provided booking ID, start time, and end time.
     *
     * @param bookingID The unique identifier for the booking
     * @param startTime The start time of the booking
     * @param endTime   The end time of the booking
     */
    public Booking( int bookingID,String startTime,String endTime) {
        this.bookingID = bookingID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Retrieves the email of the customer who made the booking.
     *
     * @return The email of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer who made the booking.
     *
     * @param email The email of the customer to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the customer ID of the customer who made the booking.
     *
     * @return The customer ID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID of the customer who made the booking.
     *
     * @param customerID The customer ID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * Retrieves the booking ID.
     *
     * @return The booking ID
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * Sets the booking ID.
     *
     * @param bookingID The booking ID to set
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Retrieves the start time of the booking.
     *
     * @return The start time of the booking
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Retrieves the end time of the booking.
     *
     * @return The end time of the booking
     */
    public String getEndTime() {
        return endTime;
    }
}
