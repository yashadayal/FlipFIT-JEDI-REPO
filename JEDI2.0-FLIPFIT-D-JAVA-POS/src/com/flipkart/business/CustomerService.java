package com.flipkart.business;

import java.util.List;

public class CustomerService {
    public void registerCustomer(){
        System.out.println("You have been registered successfully");
    }
    public void loginCustomer(){
        System.out.println("You have been logged in successfully");
    }
    public List<String> viewGymCenter(){
//        List<String> gymCenter;
//        System.out.println("List of available centers are: "+ gymCenter);
//        return gymCenter;
        return null;
    }
    public boolean bookSlot(){
        System.out.println("Slot has been booked successfully");
        return true;
    }

    public boolean modifySlot(){
        System.out.println("Slot has been canceled successfully");
        return true;
    }

}
