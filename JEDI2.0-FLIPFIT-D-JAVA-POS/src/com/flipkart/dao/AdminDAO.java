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

public class AdminDAO {
    private static String password = "";
    private final GymCenterDAO gymCenterdao=new GymCenterDAO();
    private final GymOwnerDAO gymOwnerDAO=new GymOwnerDAO();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();

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
    public ArrayList<Admin> getAdminData(){
        return null;
    }
    public ArrayList<GymOwner> getListOfGymOwners() throws SQLException, GymOwnerNotFoundException {
        gymOwnerDAO.viewAllGymOwners();
        return null;
    }
    public ArrayList<GymCenter> getListOfGymCenters() throws GymCentreNotFoundException, SQLException {
        gymCenterdao.viewAllGymCenters();
        return null;
    }
    public ArrayList<GymOwner> getListOfPendingGymOwners() throws SQLException, GymOwnerNotFoundException {
        gymOwnerDAO.viewPendingGymOwnerList();
        return null;
    }
    public ArrayList<GymCenter> getListOfPendingGymCenters() throws GymCentreNotFoundException, SQLException {
        gymCenterdao.viewPendingGymCentersList();
        return null;
    }
    public void approveAllGymCenter() throws SQLException {
        gymCenterdao.approveAllPendingGymCenters();
    }
    public void approveGymCenterById(int gymCenterId) throws SQLException {
        gymCenterdao.approveGymCenterById(gymCenterId);
    }
    public void approveAllGymOwners() throws SQLException {
        gymOwnerDAO.approveAllGymOwners();
    }
    public void approveGymOwnerByEmail(String gymOwnerEmail) throws SQLException{
        gymOwnerDAO.approveGymOwnerByEmail(gymOwnerEmail);
    }

}