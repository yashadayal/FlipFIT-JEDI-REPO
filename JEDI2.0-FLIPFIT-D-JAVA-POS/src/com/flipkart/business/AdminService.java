package com.flipkart.business;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.dao.AdminDAO;

public class AdminService {
    public static AdminDAO adminDao = new AdminDAO();
    private static int adminId = 0;
    private String adminEmail = "admin@flipkart.com";
    private static String adminPassword = "admin123";


    public void adminLogin(String email, String password) {

        if(Objects.equals(email, adminEmail) && Objects.equals(password, adminPassword)){
            System.out.println("Admin with username " + email + " and password" + password + " logged in successfully.");
        }
        else{
            System.out.println("Incorrect email or password.");
        }
    }

    public void changePassword(String newPassword, String email){
        if(!Objects.equals(email, adminEmail)){
            System.out.println("Incorrect email.");
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
