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

    public void setPassword(String pass){
        password = pass;
//      update pass in database
    }
    public ArrayList<Admin> getAdminData(){
        return null;
    }
    public ArrayList<GymOwner> getListOfGymOwners(){
        return null;
    }
    public ArrayList<GymCenter> getListOfGymCenters(){
        return null;
    }
    public ArrayList<GymOwner> getListOfPendingGymOwners(){
        return null;
    }
    public ArrayList<GymCenter> getListOfPendingGymCenters(){
        return null;
    }
}