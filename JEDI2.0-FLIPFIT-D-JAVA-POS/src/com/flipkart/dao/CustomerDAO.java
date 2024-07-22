package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    private static final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();

    public void getCustomerById(Integer id) {

    }

    public static boolean registerCustomer(Customer customer) {
        Connection connection = null;
        boolean registerSuccess = false;
        String query = "INSERT INTO flipfit_customer (customerName, customerEmail, password) VALUES (?, ?, ?)";
        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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

    public static Customer viewProfile(String email) {
        Connection connection = null;
        Customer customer = null;
        String query = "SELECT customerId, customerName, customerPhone, customerAddress, customerEmail, password FROM flipfit_customer WHERE customerEmail = ?";

        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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

    public static void changePassword(String email, String oldPassword, String newPassword) {
        Connection connection = null;
        String selectQuery = "SELECT password FROM flipfit_customer WHERE customerEmail = ?";
        String updateQuery = "UPDATE flipfit_customer SET password = ? WHERE customerEmail = ?";

        try {
            connection = DBUtils.getConnection();

            // Step 1: Check if the user exists
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, email);
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (storedPassword.equals(oldPassword)) {
                    // Step 2: If user exists and old password matches, update the password
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
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


    public static boolean loginCustomer(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean loginSuccess = false;

        String query = "SELECT * FROM flipfit_customer WHERE customerEmail = ? AND password = ?";
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(query);
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


