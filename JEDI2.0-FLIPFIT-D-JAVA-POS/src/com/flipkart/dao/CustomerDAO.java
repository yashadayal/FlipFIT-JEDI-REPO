package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.jdbc.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

 public static void loginCustomer(String email, String password){


    }
}
