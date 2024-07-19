package com.flipkart.client;

import com.flipkart.business.GymCenterService;
import com.flipkart.business.GymOwnerService;

import java.util.Scanner;

public class GymOwnerFlipFitMenu {


    private Scanner scanner = new Scanner(System.in);
    private GymOwnerService gymOwnerService = new GymOwnerService();
    private GymCenterService gymCenterService = new GymCenterService();

    void login(String email, String password){
        if(gymOwnerService.loginGymOwner(email, password)) {
            gymOwnerMenu(email);
        }
    }

    void register(String name, String email, String password){
        gymOwnerService.registerGymOwner(name, email, password);
    }

    void changePassword(String email, String currPassword, String newPassword){
        gymOwnerService.changePassword(email, currPassword, newPassword);
    }

    void gymOwnerMenu(String email){
        System.out.println("\n\n--------------------WELCOME TO GYM OWNER MENU---------------------\n");
        System.out.println("1. View Status of Gym Owner Approval Request\n");
        System.out.println("2. Register Gym Center\n");
        System.out.println("3. View All Gym Centers\n");
        //System.out.println("3. Add Slots in your Gym Centers\n");
        System.out.println("4. View Status of Gym Center\n");
        System.out.println("5. Log out\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                if(checkOwnerStatus(email)){
                    System.out.println("Congratulations! You have been approved by the admin!");
                }
            case 2:
                if(checkOwnerStatus(email)){
                    gymCenterService.registerGymCenter();
                }
            case 3:
                if(checkOwnerStatus(email)){
                    gymCenterService.veiwAllGymCenters();
                }
            case 4:
                if(checkOwnerStatus(email)){
                    gymCenterService.viewGymCenterStatus(email);
                }
            case 5:
                return;
        }

    }
    private boolean checkOwnerStatus(String email){
        if(gymCenterService.approvalStatus(email)){
            return true;
        }
        else{
            System.out.println("You are not approved yet, please contact admin");
            return false;
        }
    }


    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){}

    void addSlot(){}
}
