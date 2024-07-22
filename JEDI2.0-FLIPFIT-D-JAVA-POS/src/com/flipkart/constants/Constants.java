package com.flipkart.constants;

public class Constants {

    // queries for Admin DAO
    public static final String COUNT_ADMIN = "SELECT COUNT(*) FROM flipfit_admin WHERE adminEmail = ?";
    public static final String INSERT_ADMIN_CRED = "INSERT INTO flipfit_admin (adminId,adminName,adminEmail, adminPassword) VALUES (?,?,?, ?)";
    public static final String UPDATE_ADMIN_CRED = "UPDATE flipfit_admin SET adminPassword = ? limit 1";

    // Booking DAO
    public static final String INSERT_BOOKING = "INSERT INTO flipfit_booking (customerId, email, slotId) VALUES (?, ?, ?)";

    // Customer DAO
    public static final String REGISTER_CUSTOMER = "INSERT INTO flipfit_customer (customerName, customerEmail, password) VALUES (?, ?, ?)";
    public static final String FETCH_CUSTOMER_DATA =  "SELECT customerId, customerName, customerPhone, customerAddress, customerEmail, password FROM flipfit_customer WHERE customerEmail = ?";
    public static final String FETCH_CUSTOMER_PASSWORD = "SELECT password FROM flipfit_customer WHERE customerEmail = ?";
    public static final String UPDATE_CUSTOMER_PASSWORD = "UPDATE flipfit_customer SET password = ? WHERE customerEmail = ?";
    public static final String VERIFY_CUSTOMER = "SELECT * FROM flipfit_customer WHERE customerEmail = ? AND password = ?";

    //Gym Center DAO
    public static final String FETCH_OWNER  = "SELECT ownerId FROM flipfit_gymowner WHERE ownerEmail = ?";
    public static final String INSERT_GYM_DATA  = "INSERT INTO flipfit_gymcenter (gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice, ownerId) VALUES (?, ?, ?, ?, ?)";
    public static final String FETCH_GYMCENTER_WITH_OWNER = "SELECT * FROM flipfit_gymcenter WHERE ownerId = ?";
    public static final String FETCH_GYMCENTER = "SELECT * FROM flipfit_gymcenter";
    public static final String FETCH_GYMCENTER_WITH_ID = "SELECT * FROM flipfit_gymcenter WHERE gymCenterId = ?";
    public static final String FETCH_VALID_GYM = "SELECT * FROM flipfit_gymcenter where isApproved=0";
    public static final String INCREMENT_CAPACITY = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity + 1 WHERE gymcenterId = ?";
    public static final String DECREMENT_CAPACITY = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity - 1 WHERE gymcenterId = ?";

    //Gym Owner DAO
    public static final String FETCH_OWNER_WITH_EMAIL = "SELECT ownerEmail FROM flipfit_gymowner WHERE ownerEmail = ?";
    public static final String INSERT_OWNER = "INSERT INTO flipfit_gymowner (ownerName, ownerEmail, ownerPassword) VALUES (?, ?, ?)";
    public static final String FETCH_OWNER_PASSWORD = "SELECT ownerPassword FROM flipfit_gymowner WHERE ownerEmail = ?";
    public static final String UPDATE_OWNER_PASSWORD =  "UPDATE flipfit_gymowner SET ownerPassword = ? WHERE ownerEmail = ?";
    public static final String APPROVED_OWNERS =  "SELECT isApproved FROM flipfit_gymowner WHERE ownerEmail = ?";
    public static final String FETCH_GYM_OWNERS = "SELECT * FROM flipfit_gymowner";
    public static final String UNAPPROVED_OWNERS = "SELECT * FROM flipfit_gymowner where isApproved=0";

    //Slot DAO
    public static final String FETCH_SLOTS_WITH_ID = "SELECT * FROM flipfit_slots WHERE gymCenterId = ?";
    public static final String FETCH_GYM_WITH_SLOT = "SELECT gymCenterId FROM flipfit_slots WHERE slotId = ?";
    public static final String DELETE_SLOT = "DELETE FROM flipfit_slots WHERE slotId = ?";
    public static final String INSERT_SLOT = "INSERT INTO flipfit_slots (gymCenterId, capacity, date, startTime, endTime) VALUES (?, ?, ?, ?, ?)";
    public static final String FETCH_CAPACITY = "SELECT capacity FROM flipfit_slots WHERE slotId = ?";
    public static final String DECREMENT_SLOT_CAPACITY = "UPDATE flipfit_slots SET capacity = capacity - 1 WHERE slotId = ?";
}
