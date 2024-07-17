package com.flipkart.business;

import java.util.List;

public class GymOwnerService {
    public void registerGymOwner(String name, String email, String password ){
        System.out.println("Gym owner with email " + email + " registered successfully");
    }

    public void loginGymOwner(String username, String password){
        System.out.println("GymOwner " + username  + " logged in Successfully\n");
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
