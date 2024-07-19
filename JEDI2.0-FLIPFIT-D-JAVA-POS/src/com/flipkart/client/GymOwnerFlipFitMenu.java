package com.flipkart.client;

import com.flipkart.business.GymOwnerService;

import java.util.Scanner;

public class GymOwnerFlipFitMenu {


    private Scanner scanner = new Scanner(System.in);
    private GymOwnerService gymOwnerService = new GymOwnerService();

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
        System.out.println("1. Register Gym Centers\n");
        System.out.println("2. View All Gym Centers And Slots\n");
        System.out.println("3. Add Slots in your Gym Centers\n");
        System.out.println("4. View Status of your Gym Center Application\n");
        System.out.println("5. Log out\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
            case 2:
            case 3:
        }



        System.out.println("----------TO BE IMPLEMENTED---------");
    }
    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){}

    void addSlot(){}
}
