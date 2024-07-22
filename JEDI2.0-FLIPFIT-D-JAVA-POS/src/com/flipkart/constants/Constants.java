package com.flipkart.constants;

public class Constants {

    // queries for Admin DAO
    public static final String COUNT_ADMIN = "SELECT COUNT(*) FROM flipfit_admin WHERE adminEmail = ?";
    public static final String INSERT_ADMIN_CRED = "INSERT INTO flipfit_admin (adminId,adminName,adminEmail, adminPassword) VALUES (?,?,?, ?)";
    public static final String UPDATE_ADMIN_CRED = "UPDATE flipfit_admin SET adminPassword = ? limit 1";

    // Booking DAO
    public static final String INSERT_BOOKING = "INSERT INTO flipfit_booking (customerId, slotId) VALUES (?, ?)";

    // Customer DAO
    public static final String REGISTER_CUSTOMER = "INSERT INTO flipfit_customer (customerName, customerEmail, password) VALUES (?, ?, ?)";
    public static final String FETCH_CUSTOMER_DATA =  "SELECT customerId, customerName, customerPhone, customerAddress, customerEmail, password FROM flipfit_customer WHERE customerEmail = ?";
    public static final String FETCH_CUSTOMER_PASSWORD = "SELECT password FROM flipfit_customer WHERE customerEmail = ?";
    public static final String UPDATE_CUSTOMER_PASSWORD = "UPDATE flipfit_customer SET password = ? WHERE customerEmail = ?";
    public static final String VERIFY_CUSTOMER = "SELECT * FROM flipfit_customer WHERE customerEmail = ? AND password = ?";

    //
}
