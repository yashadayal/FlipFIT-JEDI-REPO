package com.flipkart.client;

import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerService;

public class GymOwnerFitFlipMenu {

    private GymOwnerService gymOwnerService = new GymOwnerService();

    void login(String username, String password){
        gymOwnerService.loginGymOwner(username, password);
        System.out.println("WELCOME TO GYM OWNER SERVICE\n\n\n\n");
    }

    void register(String name, String email, String password){
        gymOwnerService.registerGymOwner(name, email, password);
        System.out.println("write menu");
    }

    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){}

    void addSlot(){}
}
