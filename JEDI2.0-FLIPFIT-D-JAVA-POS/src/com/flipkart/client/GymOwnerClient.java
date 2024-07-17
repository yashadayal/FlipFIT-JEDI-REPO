package com.flipkart.client;

public class GymOwnerClient {

    void login(String username, String password){
        System.out.println("GymOwner " + username  + " logged in Successfully\n");
        System.out.println("WELCOME TO GYM OWNER SERVICE\n\n\n\n");
    }

    void register(String name, String email, String password){
        System.out.println("GymOwner " + name +" registered Successfully\n");
    }

    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){}

    void addSlot(){}
}
