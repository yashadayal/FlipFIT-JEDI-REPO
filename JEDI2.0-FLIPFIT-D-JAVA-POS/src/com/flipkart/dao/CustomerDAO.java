package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.jdbc.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CustomerDAO {


 public void getCustomerById(Integer id) {

 }

 public static boolean registerCustomer(Customer customer) {
  Connection connection = null;
  boolean registerSuccess = false;
  String query = "INSERT INTO customer VALUES (?,?,?)";
  try {
   connection = DBUtils.getConnection();
   PreparedStatement preparedStatement = connection.prepareStatement(query);
   preparedStatement.setString(1, customer.getEmail());
   preparedStatement.setString(2, customer.getCustomerName());
   preparedStatement.setString(3, customer.getPassword());

   int rowsAffected = preparedStatement.executeUpdate();
   if (rowsAffected != 0)
    registerSuccess = true;

  } catch (SQLException e) {
   printSQLException(e);
  }

  return registerSuccess;
 }

 public static void printSQLException(SQLException ex) {
  for (Throwable e : ex) {
   if (e instanceof SQLException) {
    e.printStackTrace(System.err);
    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
    System.err.println("Message: " + e.getMessage());
    Throwable t = ex.getCause();
    while (t != null) {
     System.out.println("Cause: " + t);
     t = t.getCause();
    }
   }
  }
 }

 public static boolean loginCustomer(String email, String password) {
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  boolean loginSuccess = false;

  String query = "SELECT * FROM customer WHERE email = ? AND password = ?";
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
   printSQLException(e);
  }

  return loginSuccess;
 }
}

