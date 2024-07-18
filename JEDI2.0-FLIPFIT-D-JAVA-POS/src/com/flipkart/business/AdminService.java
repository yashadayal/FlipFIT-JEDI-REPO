package com.flipkart.business;
import java.util.ArrayList;
import java.util.Random;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.dao.AdminDAO;

public class AdminService {
    public static AdminDAO adminDao = new AdminDAO();

    private int generateRandomID() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
    public void adminLogin(String adminName, String password) {
        addAdminData(adminName);
        System.out.println("Admin with username " + adminName + "Logged In Successfully");
    }
    public void addAdminData(String adminName){
        Admin admin = new Admin();
        admin.setAdminId(generateRandomID());
        admin.setAdminName(adminName);
        admin.setRole(Role.valueOf("ADMIN"));
        admin.setEmail("adminflipfit@flipkart.com");
        admin.setPassword("admin123");
//        dao impl
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
