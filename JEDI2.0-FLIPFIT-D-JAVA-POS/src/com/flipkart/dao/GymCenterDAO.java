package com.flipkart.dao;

import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.constants.Constants;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;

public class GymCenterDAO {
    private Connection connection = DBUtils.getConnection();

    private int getOwnerIdByEmail(String email) throws GymCentreNotFoundException, SQLException {
        String query = Constants.FETCH_OWNER;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, email);
        ResultSet rs1 = stmt1.executeQuery();
        rs1.next();
        int ownerId = rs1.getInt("ownerId");
        return ownerId;
    }

    public void registerGymCenter(String email, String gymCenterName, String gymCenterGSTin, int gymCenterCapacity, int gymCenterPrice) throws GymCentreNotFoundException, SQLException, RegistrationFailedException {

        int ownerId = getOwnerIdByEmail(email);
        String query = Constants.INSERT_GYM_DATA;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, gymCenterName);
        stmt1.setString(2, gymCenterGSTin);
        stmt1.setInt(3, gymCenterCapacity);
        stmt1.setInt(4, gymCenterPrice);
        stmt1.setInt(5, ownerId);
        stmt1.executeUpdate();
        System.out.println("Gym center registered successfully. Pending for approval");
    }

    public void viewGymCenterByEmail(String email) throws GymCentreNotFoundException, SQLException {

        int ownerId = getOwnerIdByEmail(email);
        String query = Constants.FETCH_GYMCENTER_WITH_OWNER;
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, ownerId);
        ResultSet rs= stmt.executeQuery();
        rs.next();
        while (rs.next()) {
            System.out.println("Gym Center Name: " + rs.getString("gymCenterName"));
            System.out.println("Approval Status: " + rs.getString("isGymCenterApproved"));
            System.out.println("Gym Center Location: " + rs.getString("gymCenterLocation"));
            System.out.println("Gym Center Capacity: " + rs.getString("gymCenterCapacity"));
            System.out.println("Gym Center Price: " + rs.getString("gymCenterPrice\n"));
        }
    }


    public void viewAllGymCenters() throws GymCentreNotFoundException, SQLException {

        String query = Constants.FETCH_GYMCENTER;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        int i=1;
        while (rs.next()) {
            System.out.println("Gym Center " + i++);
            System.out.println("Gym Center Name: " + rs.getString("gymCenterName"));
            System.out.println("Approval Status: " + rs.getString("isGymCenterApproved"));
            System.out.println("Gym Center Location: " + rs.getString("gymCenterLocation"));
            System.out.println("Gym Center OwnerId: " + rs.getString("ownerId"));
            System.out.println("Gym Center Capacity: " + rs.getString("gymCenterCapacity"));
            System.out.println("Gym Center Price: " + rs.getString("gymCenterPrice\n"));
        }
    }

    public boolean viewGymCenterApprovalStatusByGymCenterId(String gymCenterId) throws GymCentreNotFoundException, SQLException {
        String query = Constants.FETCH_GYMCENTER_WITH_ID;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, gymCenterId);
        ResultSet rs = stmt1.executeQuery();
        if (!rs.next()) {
            System.out.println("Incorrect GYM Center Id");
        }
        return rs.getBoolean("isGymCenterApproved");
    }

    public void viewPendingGymCentersList() throws GymCentreNotFoundException, SQLException {
        String query = Constants.FETCH_VALID_GYM;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        int i=1;
        while (rs.next()) {
            System.out.println("Gym Center " + i++);
            System.out.println("Gym Center Name: " + rs.getString("gymCenterName"));
            System.out.println("Approval Status: " + rs.getString("isGymCenterApproved"));
            System.out.println("Gym Center Location: " + rs.getString("gymCenterLocation"));
            System.out.println("Gym Center OwnerId: " + rs.getString("ownerId"));
            System.out.println("Gym Center Capacity: " + rs.getString("gymCenterCapacity"));
            System.out.println("Gym Center Price: " + rs.getString("gymCenterPrice\n"));
        }
    }

    public void incrementCapacity(int gymCenterId)  throws GymCentreNotFoundException, SQLException {
        PreparedStatement preparedStatement = null;
        String query = Constants.INCREMENT_CAPACITY;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, gymCenterId);
        preparedStatement.executeUpdate();
    }

    public void decrementCapacity(int gymCenterId)  throws GymCentreNotFoundException, SQLException {
        PreparedStatement preparedStatement = null;
        String query = Constants.DECREMENT_CAPACITY;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, gymCenterId);
        preparedStatement.executeUpdate();
    }

    public void approveAllPendingGymCenters() throws SQLException {
        String updateQuery = "UPDATE flipfit_gymcenter SET isGymCenterApproved = 1 WHERE isGymCenterApproved = 0";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(updateQuery);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " gym centers approved successfully.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    public void approveGymCenterById(int gymCenterId) throws SQLException, GymCentreNotFoundException {
        String updateQuery = "UPDATE flipfit_gymcenter SET isGymCenterApproved = 1 WHERE gymcenterId = ?";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(updateQuery);
            stmt.setInt(1, gymCenterId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gym center with ID " + gymCenterId + " approved successfully.");
            } else {
                System.out.println("No gym center found with ID " + gymCenterId);
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

}
