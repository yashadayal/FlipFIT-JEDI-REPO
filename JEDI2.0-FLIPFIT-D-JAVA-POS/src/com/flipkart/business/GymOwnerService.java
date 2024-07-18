package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GymOwnerService {

    ArrayList<GymOwner> gymOwners = new ArrayList<>();
    HashSet<String> loggedInGymOwners = new HashSet<>();
    HashMap<String, String> registeredGymOwners = new HashMap<>();

    public void registerGymOwner(String name, String email, String password ){

        if(registeredGymOwners.containsKey(email)){
            System.out.println("Email already registered, Please login!\n\n");
            return;
        }

        GymOwner gymOwner = new GymOwner();
        gymOwner.setName(name);
        gymOwner.setEmail(email);
        gymOwner.setPassword(password);
        gymOwners.add(gymOwner);
        registeredGymOwners.put(email, password);
        System.out.println("Gym owner with email " + email + " registered successfully\n\n");
        // System.out.println(gymOwners.size());
        return;
    }

    public boolean loginGymOwner(String email, String password){

        if(loggedInGymOwners.contains(email)){
            System.out.println("Gym owner with email " + email + " already logged in\n");
            return false;
        }

        if(!registeredGymOwners.containsKey(email)){
            System.out.println("Gym owner with email " + email + " does not exist\n");
            return false;
        }

        if(!registeredGymOwners.get(email).equals(password)){
            System.out.println("Incorrect password, please try again\n");
            return false;
        }

        System.out.println("GymOwner " + email + " logged in Successfully\n");
        return true;
    }

    public void changePassword(String email, String oldPassword, String newPassword){
        if(!registeredGymOwners.containsKey(email)){
            System.out.println("Gym owner with email " + email + " does not exist\n");
            return;
        }
        if(!registeredGymOwners.get(email).equals(oldPassword)){
            System.out.println("Incorrect old password, please try again\n");
        }
        registeredGymOwners.put(email, newPassword);
        for(GymOwner gymOwner : gymOwners){
            if(gymOwner.getEmail().equals(email)){
                gymOwner.setPassword(newPassword);
                break;
            }
        }
        System.out.println("Gym owner with email " + email + " changed successfully\n");
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
