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