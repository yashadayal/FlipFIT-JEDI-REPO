package com.flipkart.bean;

public class Booking {

    public Booking(String customerID, int bookingID) {
        this.customerID = customerID;
        this.bookingID = bookingID;
    }

    private int bookingID;
    private String email;
    private String customerID;

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


}
