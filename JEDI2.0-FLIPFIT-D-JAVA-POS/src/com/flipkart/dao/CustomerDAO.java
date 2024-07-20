package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.exceptions.WrongCredentialException;
import com.flipkart.jdbc.DBUtils;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    static Integer customerId = 0;
    private static final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();

    public void getCustomerById(Integer id) {

    }

    public static boolean registerCustomer(Customer customer) throws SQLException, RegistrationFailedException {
        Connection connection = null;
        boolean registerSuccess = false;
        String query = "INSERT INTO flipfit_customer VALUES (?,?,?,?,?)";
        try {
            customerId++;
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);

            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setInt(3, 1);
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 0)
                registerSuccess = true;

        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }

        return registerSuccess;
    }

    public static Customer viewProfile(String email) throws SQLException{
        Connection connection = null;
        Customer customer = null;
        String query = "SELECT customerId, customerName, customerPhone, customerAddress, email, password FROM Customer WHERE email = ?";

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
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
            }

            rs.close();
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                sqlExceptionHandler.printSQLException(e);
            }
        }

        return customer;
    }

    public static boolean loginCustomer(String email, String password) throws LoginFailedException, SQLException, WrongCredentialException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean loginSuccess = false;

        String query = "SELECT * FROM flipfit_customer WHERE email = ? AND password = ?";
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


