package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.Constants;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.exceptions.WrongCredentialException;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author JEDI-04
 * Java class for Admin Dao Operations
 */

public class AdminDAO {
    private static String password = "";
    private final GymCenterDAO gymCenterdao=new GymCenterDAO();
    private final GymOwnerDAO gymOwnerDAO=new GymOwnerDAO();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();

    /**
     * Method to set initial admin data if not already present.
     * @param adminEmail The email of the admin to check if data exists
     * @param adminPassword The password to be set for the admin
     * @throws SQLException If a database access error occurs
     */
    public void setAdminData(String adminEmail,String adminPassword) throws SQLException{
        try {
            Connection connection = DBUtils.getConnection();

            PreparedStatement stmt1 = connection.prepareStatement(Constants.COUNT_ADMIN);
            stmt1.setString(1, adminEmail);
            ResultSet rs = stmt1.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("Admin data already exists. Skipping insertion.");
                return;
            }

            PreparedStatement stmt2 = connection.prepareStatement(Constants.INSERT_ADMIN_CRED);
            stmt2.setInt(1,1);
            stmt2.setString(2,"Admin");
            stmt2.setString(3, adminEmail);
            stmt2.setString(4, adminPassword);
            stmt2.executeUpdate();
            System.out.println("Admin data saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to set password for Admin.
     * @param pass The new password to be set for Admin
     * @throws SQLException If a database access error occurs
     * @throws WrongCredentialException If provided credentials are incorrect
     */
    public void setPassword(String pass) throws SQLException, WrongCredentialException {
        this.password = pass;

        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.UPDATE_ADMIN_CRED);
            stmt.setString(1, pass);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("Failed to update password. No rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to retrieve Admin data.
     *
     * @return ArrayList of Admin objects
     */
    public ArrayList<Admin> getAdminData(){
        return null;
    }

    /**
     * Method to get list of all Gym Owners.
     *
     * @return ArrayList of GymOwner objects
     * @throws SQLException If a database access error occurs
     * @throws GymOwnerNotFoundException If no Gym Owners are found
     */
    public ArrayList<GymOwner> getListOfGymOwners() throws SQLException, GymOwnerNotFoundException {
        gymOwnerDAO.viewAllGymOwners();
        return null;
    }

    /**
     * Method to get list of all Gym Centers.
     *
     * @return ArrayList of GymCenter objects
     * @throws GymCentreNotFoundException If no Gym Centers are found
     * @throws SQLException If a database access error occurs
     */
    public ArrayList<GymCenter> getListOfGymCenters() throws GymCentreNotFoundException, SQLException {
        gymCenterdao.viewAllGymCenters();
        return null;
    }

    /**
     * Method to get list of pending Gym Owners.
     *
     * @return ArrayList of GymOwner objects
     * @throws SQLException If a database access error occurs
     * @throws GymOwnerNotFoundException If no pending Gym Owners are found
     */
    public ArrayList<GymOwner> getListOfPendingGymOwners() throws SQLException, GymOwnerNotFoundException {
        gymOwnerDAO.viewPendingGymOwnerList();
        return null;
    }

    /**
     * Method to get list of pending Gym Centers.
     *
     * @return ArrayList of GymCenter objects
     * @throws GymCentreNotFoundException If no pending Gym Centers are found
     * @throws SQLException If a database access error occurs
     */
    public ArrayList<GymCenter> getListOfPendingGymCenters() throws GymCentreNotFoundException, SQLException {
        gymCenterdao.viewPendingGymCentersList();
        return null;
    }

    /**
     * Method to approve all pending Gym Centers.
     *
     * @throws SQLException If a database access error occurs
     */
    public void approveAllGymCenter() throws SQLException {
        gymCenterdao.approveAllPendingGymCenters();
    }

    /**
     * Method to approve a specific Gym Center by ID.
     *
     * @param gymCenterId The ID of the Gym Center to approve
     * @throws SQLException If a database access error occurs
     */
    public void approveGymCenterById(int gymCenterId) throws SQLException {
        gymCenterdao.approveGymCenterById(gymCenterId);
    }

    /**
     * Method to approve all pending Gym Owners.
     *
     * @throws SQLException If a database access error occurs
     */
    public void approveAllGymOwners() throws SQLException {
        gymOwnerDAO.approveAllGymOwners();
    }

    /**
     * Method to approve a specific Gym Owner by email.
     *
     * @param gymOwnerEmail The email of the Gym Owner to approve
     * @throws SQLException If a database access error occurs
     */
    public void approveGymOwnerByEmail(String gymOwnerEmail) throws SQLException{
        gymOwnerDAO.approveGymOwnerByEmail(gymOwnerEmail);
    }

}