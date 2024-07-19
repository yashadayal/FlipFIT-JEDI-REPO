package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.jdbc.DBUtils;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CustomerDAO {

   static Integer customerId=0;
   public void getCustomerById(Integer id){

    }
    public static boolean registerCustomer(Customer customer) {
     Connection connection = null;
     boolean registerSuccess = false;
     String query = "INSERT INTO flipfit_customer VALUES (?,?,?,?,?)";
     try {
      customerId++;
      connection = DBUtils.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1,customerId);

      preparedStatement.setString(2, customer.getCustomerName());
      preparedStatement.setInt(3,1);
      preparedStatement.setString(4, customer.getEmail());
      preparedStatement.setString(5, customer.getPassword());

      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected != 0)
       registerSuccess = true;

     } catch (SQLException e) {
      printSQLException(e);
     }

     return registerSuccess;
    }

 public static Customer viewProfile(String email) {
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
   printSQLException(e);
  } finally {
   try {
    if (connection != null) {
     connection.close();
    }
   } catch (SQLException e) {
    printSQLException(e);
   }
  }

  return customer;
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
   printSQLException(e);
  }

  return loginSuccess;
 }
}

