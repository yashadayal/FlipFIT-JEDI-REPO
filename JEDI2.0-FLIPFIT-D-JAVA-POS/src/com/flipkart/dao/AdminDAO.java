package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

public class AdminDAO {
    private static String password = "";

    public void setAdminData(){
//      take admin data from service layer and save in db
    }

    public void setPassword(String pass){
        password = pass;
//      update pass in database
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