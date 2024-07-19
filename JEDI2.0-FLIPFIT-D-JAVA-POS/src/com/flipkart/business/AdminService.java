package com.flipkart.business;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.dao.AdminDAO;
import java.util.Properties;



public class AdminService {
    public static AdminDAO adminDao = new AdminDAO();
    private static int adminId = 0;
    String adminEmail="";
    String adminPassword="";
    public AdminService() {
        try {

            Properties prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("/Users/palak.sharma1/Desktop/FlipFIT-JEDI-REPO/JEDI2.0-FLIPFIT-D-JAVA-POS/src/config.properties");
            prop.load(fileInputStream);
             adminEmail = prop.getProperty("adminEmail");
             adminPassword = prop.getProperty("adminPassword");
            adminDao.setAdminData(adminEmail,adminPassword);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adminLogin(String email, String password) {

        if(Objects.equals(email, adminEmail) && Objects.equals(password, adminPassword)){
            System.out.println("Admin with username " + email + " and password" + password + " logged in successfully.");
        }
        else{
            System.out.println("Incorrect email or password.");
        }
    }

    public void changePassword(String email, String oldPassword, String newPassword){
        if(!Objects.equals(email, adminEmail)){
            System.out.println("Incorrect email.");
            return;
        }
        if(!Objects.equals(oldPassword, adminPassword)){
            System.out.println("Incorrect password.");
            return;
        }
        adminPassword = newPassword;

        System.out.println("Your password has been changed successfully" + adminPassword);
    }

    public ArrayList<GymOwner> viewListOfGymOwners(){
        return adminDao.getListOfGymOwners();
    }
    public ArrayList<GymCenter> viewListOfGymCenters(){
        return adminDao.getListOfGymCenters();
    }
    public ArrayList<GymOwner> viewPendingListOfGymOwners(){
        return adminDao.getListOfPendingGymOwners();
    }
    public ArrayList<GymCenter> viewPendingListOfGymCenters(){
        return adminDao.getListOfPendingGymCenters();
    }

}
