package com.flipkart.bean;

/**
 * @author JEDI-04
 * Booking Class
 */

public class Booking {

    public Booking( int bookingID,String startTime,String endTime) {
        this.bookingID = bookingID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private int bookingID;
    private String email;
    private String customerID;
    private final String startTime;
    private final String endTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String userID) {
        this.customerID = customerID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
}
