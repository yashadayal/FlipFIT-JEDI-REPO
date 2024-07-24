package com.flipkart.bean;

/**
 * @author JEDI-04
 * Customer Class
 */

public class Customer{

    private int customerId;          // Unique identifier for the customer
    private String customerName;     // Name of the customer
    private String email;            // Email address of the customer
    private String password;         // Password of the customer
    private String customerAddress;  // Address of the customer
    private int customerPhone;       // Phone number of the customer

    /**
     * Retrieves the password of the customer.
     *
     * @return The password of the customer
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the customer.
     *
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the unique identifier of the customer.
     *
     * @return The customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the unique identifier for the customer.
     *
     * @param customerId The customer ID to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Retrieves the email address of the customer.
     *
     * @return The email address of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the customer.
     *
     * @param email The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The name of the customer
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the name of the customer.
     *
     * @param customerName The name to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Retrieves the address of the customer.
     *
     * @return The address of the customer
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the address for the customer.
     *
     * @param customerAddress The address to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Retrieves the phone number of the customer.
     *
     * @return The phone number of the customer
     */
    public int getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Sets the phone number for the customer.
     *
     * @param customerPhone The phone number to set
     */
    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }
}