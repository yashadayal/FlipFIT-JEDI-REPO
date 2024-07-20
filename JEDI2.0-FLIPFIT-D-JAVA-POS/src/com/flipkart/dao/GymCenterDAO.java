package com.flipkart.dao;

import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;

public class GymCenterDAO {
    private Connection connection = DBUtils.getConnection();

    private int getOwnerIdByEmail(String email) throws GymCentreNotFoundException, SQLException {
        String query = "SELECT ownerId FROM flipfit_gymowner WHERE ownerEmail = ?";
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, email);
        ResultSet rs1 = stmt1.executeQuery();
        rs1.next();
        int ownerId = rs1.getInt("ownerId");
        return ownerId;
    }

    public void registerGymCenter(String email, String gymCenterName, String gymCenterGSTin, int gymCenterCapacity, int gymCenterPrice) throws GymCentreNotFoundException, SQLException, RegistrationFailedException {

        int ownerId = getOwnerIdByEmail(email);
        String query = "INSERT INTO flipfit_gymcenter (gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice, ownerId) VALUES (?, ?, ?, ?, ?)";
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
        String query = "SELECT * FROM flipfit_gymcenter WHERE ownerId = ?";
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

        String query = "SELECT * FROM flipfit_gymcenter";
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
        String query = "SELECT * FROM flipfit_gymcenter WHERE gymCenterId = ?";
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, gymCenterId);
        ResultSet rs = stmt1.executeQuery();
        if (!rs.next()) {
            System.out.println("Incorrect GYM Center Id");
        }
        return rs.getBoolean("isGymCenterApproved");
    }

    public void viewPendingGymCentersList() throws GymCentreNotFoundException, SQLException {
        String query = "SELECT * FROM flipfit_gymcenter where isApproved=0";
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
        String query = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity + 1 WHERE gymcenterId = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, gymCenterId);
        preparedStatement.executeUpdate();
    }

    public void decrementCapacity(int gymCenterId)  throws GymCentreNotFoundException, SQLException {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity - 1 WHERE gymcenterId = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, gymCenterId);
        preparedStatement.executeUpdate();
    }



}
