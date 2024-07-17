package com.flipkart.business;

import java.util.List;

public class GymOwnerService {
    public void registerGymOwner(){
        System.out.println("You have been registered successfully");
    }
    public void loginGymOwner(){
        System.out.println("You have been logged in successfully");
    }
    public List<String> viewGymCenter(){
//        List<String> gymCenter;
//        System.out.println("List of available centers are: " + gymCenter.toString());
//        return gymCenter;
        return null;
    }
    public boolean addSlot(){
        System.out.println("Slot has been booked successfully");
        return true;
    }

    public boolean requestForApproval(){
        System.out.println("Slot has been canceled successfully");
        return true;
    }
}
