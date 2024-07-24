package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.constants.Constants;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JEDI-04
 * Java class for Customer Dao Operations
 */

public class CustomerDAO {

    private static final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();

    /**
     * Method to retrieve customer information by ID.
     *
     * @param id The ID of the customer to retrieve
     */
    public void getCustomerById(Integer id) {

    }

    /**
     * Method to register a new customer.
     *
     * @param customer The customer object containing registration details
     * @return true if registration is successful, false otherwise
     */
    public static boolean registerCustomer(Customer customer) {
        Connection connection = null;
        boolean registerSuccess = false;

        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.REGISTER_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 0)
                registerSuccess = true;

        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }

        return registerSuccess;
    }

    /**
     * Method to view customer profile details.
     *
     * @param email The email of the customer whose profile to view
     * @return A Customer object containing profile details, or null if not found
     */
    public static Customer viewProfile(String email) {
        Connection connection = null;
        Customer customer = null;

        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.FETCH_CUSTOMER_DATA);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerId(rs.getInt("customerId"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerPhone(rs.getInt("customerPhone"));
                customer.setCustomerAddress(rs.getString("customerAddress"));
                customer.setEmail(rs.getString("customerEmail"));
                customer.setPassword(rs.getString("password"));
            }
            rs.close();
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }

        return customer;
    }

    /**
     * Method to change customer password.
     *
     * @param email The email of the customer whose password to change
     * @param oldPassword The current password of the customer
     * @param newPassword The new password to set
     */
    public static void changePassword(String email, String oldPassword, String newPassword) {
        Connection connection = null;

        try {
            connection = DBUtils.getConnection();

            // Step 1: Check if the user exists
            PreparedStatement selectStatement = connection.prepareStatement(Constants.FETCH_CUSTOMER_PASSWORD);
            selectStatement.setString(1, email);
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (storedPassword.equals(oldPassword)) {
                    // Step 2: If user exists and old password matches, update the password
                    PreparedStatement updateStatement = connection.prepareStatement(Constants.UPDATE_CUSTOMER_PASSWORD);
                    updateStatement.setString(1, newPassword);
                    updateStatement.setString(2, email);

                    int rowsAffected = updateStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Customer with email " + email + " changed password successfully\n");
                    } else {
                        System.out.println("Password update failed for customer with email " + email + "\n");
                    }

                    updateStatement.close();
                } else {
                    System.out.println("Incorrect old password, please try again.\n");
                }
            } else {
                System.out.println("Customer with email " + email + " does not exist\n");
            }

            rs.close();
            selectStatement.close();
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
       }
    }

    /**
     * Method to view bookings made by a customer.
     *
     * @param email The email of the customer whose bookings to retrieve
     * @return A list of Booking objects representing the customer's bookings
     * @throws SQLException If a database access error occurs
     */
    public List<Booking> viewBooking(String email) throws SQLException {
        List<Booking> customerBookings = new ArrayList<>();
        Connection connection = null;
        String customerIdQuery = "SELECT customerId FROM flipfit_customer WHERE customerEmail = ?";
        String bookingQuery = "SELECT b.bookingId, s.startTime, s.endTime " +
                "FROM flipfit_booking b " +
                "JOIN flipfit_slots s ON b.slotId = s.slotId " +
                "WHERE b.customerId = ?";
        try {
            connection = DBUtils.getConnection();
            PreparedStatement customerIdStatement = connection.prepareStatement(customerIdQuery);
            customerIdStatement.setString(1, email);
            ResultSet customerIdResult = customerIdStatement.executeQuery();

            int customerId = -1;
            if (customerIdResult.next()) {
                customerId = customerIdResult.getInt("customerId");
            } else {
                System.out.println("No customer found with email: " + email);
                return customerBookings;
            }
            PreparedStatement bookingStatement = connection.prepareStatement(bookingQuery);
            bookingStatement.setInt(1, customerId);
            ResultSet bookingResult = bookingStatement.executeQuery();

            while (bookingResult.next()) {
                int bookingId = bookingResult.getInt("bookingId");
                String startTime = bookingResult.getString("startTime");
                String endTime = bookingResult.getString("endTime");

                Booking booking = new Booking(bookingId,startTime,endTime);

                customerBookings.add(booking);
            }
            bookingResult.close();
            bookingStatement.close();
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }
        return customerBookings;
    }

    /**
     * Method to authenticate a customer login.
     *
     * @param email The email of the customer attempting to login
     * @param password The password provided by the customer
     * @return true if login is successful, false otherwise
     */
    public static boolean loginCustomer(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean loginSuccess = false;

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(Constants.VERIFY_CUSTOMER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Customer found, login successful
                loginSuccess = true;
                System.out.println("Login successful for email: " + email);
            } else {
                // Customer not found or credentials do not match
                System.out.println("Login failed for email: " + email);
            }
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }

        return loginSuccess;
    }
}


