package com.flipkart.constants;

/**
 * @author JEDI-04
 * Constants Class
 */

public class Constants {

    // queries for Admin DAO

    /**
     * SQL query: SELECT COUNT(*) FROM flipfit_admin WHERE adminEmail = ?
     * Purpose: Count the number of admin records with a specific email.
     */
    public static final String COUNT_ADMIN = "SELECT COUNT(*) FROM flipfit_admin WHERE adminEmail = ?";

    /**
     * SQL query: INSERT INTO flipfit_admin (adminId, adminName, adminEmail, adminPassword) VALUES (?, ?, ?, ?)
     * Purpose: Insert new admin credentials into the database.
     */
    public static final String INSERT_ADMIN_CRED = "INSERT INTO flipfit_admin (adminId, adminName, adminEmail, adminPassword) VALUES (?, ?, ?, ?)";

    /**
     * SQL query: UPDATE flipfit_admin SET adminPassword = ? LIMIT 1
     * Purpose: Update the password of the admin user.
     */
    public static final String UPDATE_ADMIN_CRED = "UPDATE flipfit_admin SET adminPassword = ? LIMIT 1";


    // Booking DAO

    /**
     * SQL query: INSERT INTO flipfit_booking (email, scheduleId) VALUES (?, ?)
     * Purpose: Insert a new booking record into the booking table.
     */
    public static final String INSERT_BOOKING = "INSERT INTO flipfit_booking (email, scheduleId) VALUES (?, ?)";

    /**
     * SQL query: SELECT slotId FROM flipfit_booking WHERE bookingId = ?
     * Purpose: Fetch the slot ID associated with a specific booking ID.
     */
    public static final String FETCH_SLOT_WITH_BOOKING = "SELECT slotId FROM flipfit_booking WHERE bookingId = ?";


    // Customer DAO

    /**
     * SQL query: INSERT INTO flipfit_customer (customerName, customerEmail, password) VALUES (?, ?, ?)
     * Purpose: Register a new customer with provided details.
     */
    public static final String REGISTER_CUSTOMER = "INSERT INTO flipfit_customer (customerName, customerEmail, password) VALUES (?, ?, ?)";

    /**
     * SQL query: SELECT customerId, customerName, customerPhone, customerAddress, customerEmail, password
     *            FROM flipfit_customer WHERE customerEmail = ?
     * Purpose: Fetch customer data based on the email address.
     */
    public static final String FETCH_CUSTOMER_DATA = "SELECT customerId, customerName, customerPhone, customerAddress, customerEmail, password FROM flipfit_customer WHERE customerEmail = ?";

    /**
     * SQL query: SELECT password FROM flipfit_customer WHERE customerEmail = ?
     * Purpose: Fetch the password of a customer based on the email address.
     */
    public static final String FETCH_CUSTOMER_PASSWORD = "SELECT password FROM flipfit_customer WHERE customerEmail = ?";

    /**
     * SQL query: UPDATE flipfit_customer SET password = ? WHERE customerEmail = ?
     * Purpose: Update the password of a customer based on the email address.
     */
    public static final String UPDATE_CUSTOMER_PASSWORD = "UPDATE flipfit_customer SET password = ? WHERE customerEmail = ?";

    /**
     * SQL query: SELECT * FROM flipfit_customer WHERE customerEmail = ? AND password = ?
     * Purpose: Verify customer credentials based on email and password.
     */
    public static final String VERIFY_CUSTOMER = "SELECT * FROM flipfit_customer WHERE customerEmail = ? AND password = ?";


    // Gym Center DAO

    /**
     * SQL query: SELECT ownerId FROM flipfit_gymowner WHERE ownerEmail = ?
     * Purpose: Fetch the owner ID associated with a specific owner email.
     */
    public static final String FETCH_OWNER = "SELECT ownerId FROM flipfit_gymowner WHERE ownerEmail = ?";

    /**
     * SQL query: INSERT INTO flipfit_gymcenter (gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice, ownerId) VALUES (?, ?, ?, ?, ?)
     * Purpose: Insert new gym center details into the database.
     */
    public static final String INSERT_GYM_DATA = "INSERT INTO flipfit_gymcenter (gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice, ownerId) VALUES (?, ?, ?, ?, ?)";

    /**
     * SQL query: SELECT * FROM flipfit_gymcenter WHERE ownerId = ?
     * Purpose: Fetch gym centers associated with a specific owner ID.
     */
    public static final String FETCH_GYMCENTER_WITH_OWNER = "SELECT * FROM flipfit_gymcenter WHERE ownerId = ?";

    /**
     * SQL query: SELECT * FROM flipfit_gymcenter
     * Purpose: Fetch all gym centers.
     */
    public static final String FETCH_GYMCENTER = "SELECT * FROM flipfit_gymcenter";

    /**
     * SQL query: SELECT * FROM flipfit_gymcenter WHERE gymCenterId = ?
     * Purpose: Fetch a gym center based on its ID.
     */
    public static final String FETCH_GYMCENTER_WITH_ID = "SELECT * FROM flipfit_gymcenter WHERE gymCenterId = ?";

    /**
     * SQL query: SELECT * FROM flipfit_gymcenter WHERE isGymCenterApproved = 0
     * Purpose: Fetch gym centers that are not yet approved.
     */
    public static final String FETCH_NOT_APPROVED_GYM = "SELECT * FROM flipfit_gymcenter WHERE isGymCenterApproved = 0";

    /**
     * SQL query: UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity + 1 WHERE gymCenterId = ?
     * Purpose: Increment the capacity of a gym center.
     */
    public static final String INCREMENT_CAPACITY = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity + 1 WHERE gymCenterId = ?";

    /**
     * SQL query: UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity - 1 WHERE gymCenterId = ?
     * Purpose: Decrement the capacity of a gym center.
     */
    public static final String DECREMENT_CAPACITY = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity - 1 WHERE gymCenterId = ?";

    /**
     * SQL query: SELECT * FROM flipfit_gymcenter WHERE ownerId = ? AND isGymCenterApproved = 1
     * Purpose: Fetch approved gym centers associated with a specific owner ID.
     */
    public static final String FETCH_APPROVED_GYMCENTER_BY_EMAIL = "SELECT * FROM flipfit_gymcenter WHERE ownerId = ? AND isGymCenterApproved = 1";


    // Gym Owner DAO

    /**
     * SQL query: SELECT ownerEmail FROM flipfit_gymowner WHERE ownerEmail = ?
     * Purpose: Fetch the owner email based on the email address.
     */
    public static final String FETCH_OWNER_WITH_EMAIL = "SELECT ownerEmail FROM flipfit_gymowner WHERE ownerEmail = ?";

    /**
     * SQL query: INSERT INTO flipfit_gymowner (ownerName, ownerEmail, ownerPassword) VALUES (?, ?, ?)
     * Purpose: Insert new gym owner details into the database.
     */
    public static final String INSERT_OWNER = "INSERT INTO flipfit_gymowner (ownerName, ownerEmail, ownerPassword) VALUES (?, ?, ?)";

    /**
     * SQL query: SELECT ownerPassword FROM flipfit_gymowner WHERE ownerEmail = ?
     * Purpose: Fetch the password of a gym owner based on the email address.
     */
    public static final String FETCH_OWNER_PASSWORD = "SELECT ownerPassword FROM flipfit_gymowner WHERE ownerEmail = ?";

    /**
     * SQL query: UPDATE flipfit_gymowner SET ownerPassword = ? WHERE ownerEmail = ?
     * Purpose: Update the password of a gym owner based on the email address.
     */
    public static final String UPDATE_OWNER_PASSWORD = "UPDATE flipfit_gymowner SET ownerPassword = ? WHERE ownerEmail = ?";

    /**
     * SQL query: SELECT isApproved FROM flipfit_gymowner WHERE ownerEmail = ?
     * Purpose: Check if a gym owner is approved based on the email address.
     */
    public static final String APPROVED_OWNERS = "SELECT isApproved FROM flipfit_gymowner WHERE ownerEmail = ?";

    /**
     * SQL query: SELECT * FROM flipfit_gymowner
     * Purpose: Fetch all gym owners.
     */
    public static final String FETCH_GYM_OWNERS = "SELECT * FROM flipfit_gymowner";

    /**
     * SQL query: SELECT * FROM flipfit_gymowner WHERE isApproved = 0
     * Purpose: Fetch gym owners who are not yet approved.
     */
    public static final String UNAPPROVED_OWNERS = "SELECT * FROM flipfit_gymowner WHERE isApproved = 0";


    // Slot DAO

    /**
     * SQL query: SELECT * FROM flipfit_slots WHERE gymCenterId = ?
     * Purpose: Fetch all slots associated with a specific gym center ID.
     */
    public static final String FETCH_SLOTS_WITH_ID = "SELECT * FROM flipfit_slots WHERE gymCenterId = ?";

    /**
     * SQL query: SELECT gymCenterId FROM flipfit_slots WHERE slotId = ?
     * Purpose: Fetch the gym center ID associated with a specific slot ID.
     */
    public static final String FETCH_GYM_WITH_SLOT = "SELECT gymCenterId FROM flipfit_slots WHERE slotId = ?";

    /**
     * SQL query: DELETE FROM flipfit_slots WHERE slotId = ?
     * Purpose: Delete a slot from the database based on the slot ID.
     */
    public static final String DELETE_SLOT = "DELETE FROM flipfit_slots WHERE slotId = ?";

    /**
     * SQL query: INSERT INTO flipfit_slots (gymCenterId, capacity, date, startTime, endTime) VALUES (?, ?, ?, ?, ?)
     * Purpose: Insert a new slot into the database for a gym center.
     */
    public static final String INSERT_SLOT = "INSERT INTO flipfit_slots (gymCenterId, capacity, date, startTime, endTime) VALUES (?, ?, ?, ?, ?)";

    /**
     * SQL query: SELECT capacity FROM flipfit_slots WHERE slotId = ?
     * Purpose: Fetch the capacity of a slot based on the slot ID.
     */
    public static final String FETCH_CAPACITY = "SELECT capacity FROM flipfit_slots WHERE slotId = ?";

    /**
     * SQL query: UPDATE flipfit_slots SET capacity = capacity - 1 WHERE slotId = ?
     * Purpose: Decrement the capacity of a slot based on the slot ID.
     */
    public static final String DECREMENT_SLOT_CAPACITY = "UPDATE flipfit_slots SET capacity = capacity - 1 WHERE slotId = ?";

    /**
     * SQL query: UPDATE flipfit_slots SET capacity = capacity + 1 WHERE slotId = ?
     * Purpose: Increment the capacity of a slot based on the slot ID.
     */
    public static final String INCREMENT_SLOT_CAPACITY = "UPDATE flipfit_slots SET capacity = capacity + 1 WHERE slotId = ?";
}


