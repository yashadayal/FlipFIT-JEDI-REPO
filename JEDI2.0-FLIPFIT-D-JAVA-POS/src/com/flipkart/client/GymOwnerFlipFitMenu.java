package com.flipkart.client;

import com.flipkart.business.GymCenterService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;

import java.sql.SQLException;
import java.util.Scanner;

public class GymOwnerFlipFitMenu {


    private Scanner scanner = new Scanner(System.in);
    private GymOwnerService gymOwnerService = new GymOwnerService();
    private GymCenterService gymCenterService = new GymCenterService();


    void gymOwnerMenu(String email) throws GymOwnerNotFoundException, SQLException {
        System.out.println("\n\n--------------------WELCOME TO GYM OWNER MENU---------------------\n");
        System.out.println("1. View Status of Gym Owner Approval Request\n");
        System.out.println("2. Register Gym Center\n");
        System.out.println("3. View All Gym Centers\n");
        //System.out.println("3. Add Slots in your Gym Centers\n");
        System.out.println("4. View Status of your Gym Centers\n");
        System.out.println("5. Log out\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        boolean ownerApproved = gymCenterService.gymOwnerApprovalStatus(email);
        switch (choice){
            case 1:
                if(ownerApproved){
                    System.out.println("You have been approved by the Admin");
                }
                else{
                    System.out.println("Your gym owner application is still pending for approval");
                }
                gymOwnerMenu(email);
                break;

            case 2:
                if(ownerApproved){
                    gymCenterService.registerGymCenter(email);
                }
                else{
                    System.out.println("Your can not add Gym Center before you're approved by the Admin");
                }
                gymOwnerMenu(email);
                break;
            case 3:
                gymCenterService.veiwAllGymCenters();
                gymOwnerMenu(email);
                break;
            case 4:
                gymCenterService.viewGymCenterByEmail(email);
                gymOwnerMenu(email);
                break;
            case 5:
                return;
        }

    }
    void login(String email, String password) throws GymOwnerNotFoundException, SQLException, LoginFailedException, WrongCredentialException {
        if(gymOwnerService.loginGymOwner(email, password)) {
            gymOwnerMenu(email);
        }
    }

    void registerGymOwner() throws GymOwnerNotFoundException, SQLException, RegistrationFailedException {
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        gymOwnerService.registerGymOwner(name, email, password);
    }

    void changePassword(String email, String currPassword, String newPassword) throws GymOwnerNotFoundException, SQLException, WrongCredentialException {
        gymOwnerService.changePassword(email, currPassword, newPassword);
    }


    private boolean checkOwnerStatus(String email){

        return true;
//        if(gymCenterService.approvalStatus(email)){
//            return true;
//        }
//        else{
//            System.out.println("You are not approved yet, please contact admin");
//            return false;
//        }
    }


    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){}

    void addSlot(){}
}
