package com.flipkart.dao;

import com.flipkart.constants.Constants;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;
import com.flipkart.jdbc.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymOwnerDAO {

    Connection connection = DBUtils.getConnection();

    public void registerGymOwner(String name, String email, String password ) throws SQLException, RegistrationFailedException {

        String query1 = Constants.FETCH_OWNER_WITH_EMAIL;
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Email already exists.");
            return;
        }
        String query2 = Constants.INSERT_OWNER;
        PreparedStatement stmt1 = connection.prepareStatement(query2);
        stmt1.setString(1, name);
        stmt1.setString(2, email);
        stmt1.setString(3, password);
        stmt1.executeUpdate();
        System.out.println("Gym owner successfully registered.");
    }

    public boolean gymOwnerLogin(String email, String password) throws SQLException, LoginFailedException, WrongCredentialException, GymOwnerNotFoundException {

        String query = Constants.FETCH_OWNER_PASSWORD;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("Email does not exist.");
            return false;
        }
        String actualPassword = resultSet.getString("ownerPassword");
        if (actualPassword.equals(password)) {
            System.out.println("Gym Owner successfully logged in.");
            return true;
        }
        System.out.println("Incorrect password. Please try again.");
        return false;
    }

    public boolean changeGymOwnerPassword(String email, String currPassword, String newPassword) throws SQLException, WrongCredentialException {

        String query = Constants.FETCH_OWNER_PASSWORD;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("Email does not exist.");
            return false;
        }
        String actualPassword = resultSet.getString("ownerPassword");
        if (actualPassword.equals(currPassword)) {
            String updateQuery = Constants.UPDATE_OWNER_PASSWORD;
            PreparedStatement preparedStatement1 = connection.prepareStatement(updateQuery);
            preparedStatement1.setString(1, newPassword);
            preparedStatement1.setString(2, email);
            preparedStatement1.executeUpdate();
            System.out.println("Password updated successfully.");
            return true;
        }
        System.out.println("Incorrect current password. Please try again.");
        return false;
    }

    public boolean checkOwnerStatusByEmail(String email) throws SQLException,GymOwnerNotFoundException {
        String query = Constants.APPROVED_OWNERS;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next() && resultSet.getBoolean("isApproved")) {
            return true;
        }
        else{
            return false;
        }
    }

    public void viewAllGymOwners() throws SQLException, GymOwnerNotFoundException{
        String query = Constants.FETCH_GYM_OWNERS;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        int i=1;
        while (rs.next()) {
            System.out.println("Gym Owner " + i++);
            System.out.println("Gym Owner Name: " + rs.getString("ownerName"));
            System.out.println("Gym Owner Email: " + rs.getString("ownerEmail"));
            System.out.println("Gym Owner Phone: " + rs.getString("ownerPhone"));
            System.out.println("Gym Owner PAN Card: " + rs.getString("pancard"));
            System.out.println("Gym Owner Aadhar Card: " + rs.getString("aadharCard"));
        }

    }
    public void sendOwnerApprovalRequest(String gymOwnerId){

    }
    public void setPendingGymOwnerList(){

    }
    public void viewPendingGymOwnerList() throws GymOwnerNotFoundException, SQLException {
        String query = Constants.UNAPPROVED_OWNERS;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        int i=1;
        while (rs.next()) {
            System.out.println("Gym Owner " + i++);
            System.out.println("Gym Owner Name: " + rs.getString("ownerName"));
            System.out.println("Gym Owner Email: " + rs.getString("ownerEmail"));
            System.out.println("Gym Owner Phone: " + rs.getString("ownerPhone"));
            System.out.println("Gym Owner PAN Card: " + rs.getString("pancard"));
            System.out.println("Gym Owner Aadhar Card: " + rs.getString("aadharCard"));
        }
    }

    public void approveAllGymOwners() throws SQLException {
        String updateQuery = "UPDATE flipfit_gymowner SET isApproved = 1 WHERE isApproved = 0";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(updateQuery);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " gym owners approved successfully.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    public void approveGymOwnerByEmail(String gymOwnerEmail) throws SQLException {
        String updateQuery = "UPDATE flipfit_gymowner SET isApproved = 1 WHERE ownerEmail = ?";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(updateQuery);
            stmt.setString(1, gymOwnerEmail);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Gym owner with email " + gymOwnerEmail + " approved successfully.");
            } else {
                System.out.println("No gym owner found with email " + gymOwnerEmail);
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
