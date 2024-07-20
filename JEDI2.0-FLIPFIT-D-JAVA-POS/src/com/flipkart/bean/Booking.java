package com.flipkart.bean;

public class Booking {
    private String bookingID;
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

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }


}
