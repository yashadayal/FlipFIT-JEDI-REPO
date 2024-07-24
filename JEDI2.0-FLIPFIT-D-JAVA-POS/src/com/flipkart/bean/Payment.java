package com.flipkart.bean;

/**
 * @author JEDI-04
 * Payment Class
 */

public class Payment {

    private String paymentId;   // Unique identifier for the payment
    private String amountPaid;  // Amount paid for the booking
    private String bookingId;   // ID of the booking associated with this payment

    /**
     * Retrieves the amount paid for the booking.
     *
     * @return The amount paid
     */
    public String getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the amount paid for the booking.
     *
     * @param amountPaid The amount paid to set
     */
    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Retrieves the booking ID associated with the payment.
     *
     * @return The booking ID
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Sets the booking ID associated with the payment.
     *
     * @param bookingId The booking ID to set
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Retrieves the payment ID.
     *
     * @return The payment ID
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment ID.
     *
     * @param paymentId The payment ID to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}

