package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
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

/**
 * @author JEDI-04
 * Java class for Gym Owner Dao Operations
 */

public class GymOwnerDAO {

    Connection connection = DBUtils.getConnection();

    /**
     * Prints gym owner information from the given ResultSet.
     *
     * @param rs The ResultSet containing gym owner information
     * @throws SQLException If a database access error occurs
     */
    private void printGymOwners(ResultSet rs) throws SQLException {

        if(!rs.next()) {
            System.out.println("No data available.\n");
        }

        System.out.printf("| %-20s | %-30s | %-15s | %-20s | %-20s |\n",
                "Gym Owner Name", "Gym Owner Email", "Gym Owner Phone", "Gym Owner PAN Card", "Gym Owner Aadhar Card");
        System.out.println("|----------------------|--------------------------------|-----------------|----------------------|-----------------------|");

        do {
            System.out.printf("| %-20s | %-30s | %-15s | %-20s | %-21s |\n",
                    rs.getString("ownerName"),
                    rs.getString("ownerEmail"),
                    rs.getString("ownerPhone"),
                    rs.getString("pancard"),
                    rs.getString("aadharCard"));
        }while (rs.next());

    }

    /**
     * Registers a new gym owner.
     *
     * @param name     The name of the gym owner
     * @param email    The email of the gym owner
     * @param password The password of the gym owner
     * @throws SQLException              If a database access error occurs
     * @throws RegistrationFailedException If gym owner registration fails
     */
    public void registerGymOwner(String name, String email, String password ) throws SQLException, RegistrationFailedException {

        try{
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
        catch(RegistrationFailedException exp){
            throw new RegistrationFailedException("Registration Failed!");
        }
    }

    /**
     * Authenticates gym owner login.
     *
     * @param email    The email of the gym owner
     * @param password The password of the gym owner
     * @return true if login successful, false otherwise
     * @throws SQLException              If a database access error occurs
     * @throws LoginFailedException      If gym owner login fails
     * @throws WrongCredentialException  If incorrect credentials are provided
     * @throws GymOwnerNotFoundException If the gym owner is not found
     */
    public boolean gymOwnerLogin(String email, String password) throws SQLException, LoginFailedException, WrongCredentialException, GymOwnerNotFoundException {

        try{
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
        }
        catch(LoginFailedException exp){
            throw new LoginFailedException("Login Failed!");
        }
        return false;
    }

    /**
     * Changes gym owner password.
     *
     * @param email        The email of the gym owner
     * @param currPassword The current password of the gym owner
     * @param newPassword  The new password to be set
     * @return true if password changed successfully, false otherwise
     * @throws SQLException             If a database access error occurs
     * @throws WrongCredentialException If incorrect credentials are provided
     */
    public boolean changeGymOwnerPassword(String email, String currPassword, String newPassword) throws SQLException, WrongCredentialException {

        try{
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
        }
        catch(SQLException exp){
            throw new SQLException("Error Occurred!");
        }
        return false;
    }

    /**
     * Checks approval status of gym owner by email.
     *
     * @param email The email of the gym owner
     * @return true if gym owner is approved, false otherwise
     * @throws SQLException              If a database access error occurs
     * @throws GymOwnerNotFoundException If the gym owner is not found
     */
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

    /**
     * Views all gym owners.
     *
     * @throws SQLException              If a database access error occurs
     * @throws GymOwnerNotFoundException If no gym owners are found
     */
    public void viewAllGymOwners() throws SQLException, GymOwnerNotFoundException{
        String query = Constants.FETCH_GYM_OWNERS;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        printGymOwners(rs);
    }

    /**
     * Sends approval request for gym owner.
     *
     * @param gymOwnerId The ID of the gym owner
     */
    public void sendOwnerApprovalRequest(String gymOwnerId){

    }

    /**
     * Sets pending gym owner list.
     */
    public void setPendingGymOwnerList(){

    }

    /**
     * Views pending gym owner list.
     *
     * @throws GymOwnerNotFoundException If no pending gym owners are found
     * @throws SQLException             If a database access error occurs
     */
    public void viewPendingGymOwnerList() throws GymOwnerNotFoundException, SQLException {
        String query = Constants.UNAPPROVED_OWNERS;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        printGymOwners(rs);
    }

    /**
     * Approves all gym owners.
     *
     * @throws SQLException If a database access error occurs
     */
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

    /**
     * Approves gym owner by email.
     *
     * @param gymOwnerEmail The email of the gym owner
     * @throws SQLException If a database access error occurs
     */
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
