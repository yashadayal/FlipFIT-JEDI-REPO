package com.flipkart.client;

import com.flipkart.business.GymOwnerService;

public class GymOwnerFlipFitMenu {

    private GymOwnerService gymOwnerService = new GymOwnerService();

    void login(String username, String password){
        gymOwnerService.loginGymOwner(username, password);
        gymOwnerMenu();
    }

    void register(String name, String email, String password){
        gymOwnerService.registerGymOwner(name, email, password);
        gymOwnerMenu();
    }
    void gymOwnerMenu(){
        System.out.println("\n\n--------------------WELCOME TO GYM OWNER MENU---------------------\n");
        System.out.println("1. Register Gym Centers\n");
        System.out.println("2. View All Gym Centers And Slots\n");
        System.out.println("3. Add Slots in your Gym Centers\n");
        System.out.println("4. View Status of your Gym Center Application\n");
        System.out.println("-----------------------------------------------------------------\n");
    }
    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){}

    void addSlot(){}
}
