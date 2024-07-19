package com.flipkart.dao;

import com.flipkart.bean.GymCenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GymCenterDAO {


    public void registerGymCenter(String gymCenterName, String gymCenterGSTin, int gymCenterCapacity, int gymCenterPrice) {
        // add to the table from here
    }

    public List<GymCenter> viewAllGymCenters() {
        // take from table and return;
        return null;
    }

    public boolean approvalStatus(String email){
        // take status from table
        return false;
    }

    public List<GymCenter> viewGymCenterStatus(String email){
        // take the gyms under this email id and return them as a list
        return null;
    }

    public List<GymCenter> viewPendingGymCenter(){
        //
        return null;
    }

}
