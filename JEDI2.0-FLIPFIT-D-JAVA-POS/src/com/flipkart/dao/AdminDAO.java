package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.jdbc.DBUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import java.util.Properties;

public class AdminDAO {
    private static String password = "";

    public void setAdminData(String adminEmail,String adminPassword){
//      take admin data from service layer and save in db
        try {
            // Database connection and save operation
            // Replace with your actual database handling cod

            Connection connection = DBUtils.getConnection();

            PreparedStatement stmt1 = connection.prepareStatement("SELECT COUNT(*) FROM admins WHERE email = ?");
            stmt1.setString(1, adminEmail);
            ResultSet rs = stmt1.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("Admin data already exists. Skipping insertion.");
                return;
            }

            PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO admins (email, password) VALUES (?, ?)");
            stmt2.setString(1, adminEmail);
            stmt2.setString(2, adminPassword);
            stmt2.executeUpdate();
            System.out.println("Admin data saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPassword(String pass) {
        this.password = pass;

        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE admins SET password = ? limit 1");
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
    public ArrayList<GymOwner> getListOfGymOwners(){
        System.out.println("list of gym owners");
        return null;
    }
    public ArrayList<GymCenter> getListOfGymCenters(){
        System.out.println("list of gym centers");
        return null;
    }
    public ArrayList<GymOwner> getListOfPendingGymOwners(){
        System.out.println("Pending list of gym owners");
        return null;
    }
    public ArrayList<GymCenter> getListOfPendingGymCenters(){
        System.out.println("Pending list of gym centers");
        return null;
    }
}