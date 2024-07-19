package com.flipkart.client;

import com.flipkart.business.AdminService;
import java.util.Scanner;

public class AdminFlipFitMenu {

    static AdminService adminService = new AdminService();
    Scanner scanner = new Scanner(System.in);
    void login(String username, String password) {
        adminService.adminLogin(username, password);
        adminMenu();
    }
    void changeAdminPassword(String email, String currentPassword, String newPassword){
        adminService.changePassword(email, currentPassword, newPassword);
    }

    void adminMenu(){
        System.out.println("\n\n--------------------WELCOME TO ADMIN MENU---------------------\n");
        System.out.println("1. View All Gym Owners\n");
        System.out.println("2. View All Gym Centers\n");
        System.out.println("3. View Pending Gym Owner Requests\n");
        System.out.println("4. View Pending Gym Center Requests\n");
        System.out.println("5. Previous Menu\n");
        System.out.println("--------------------------------------------------------------\n");

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminService.viewListOfGymOwners();
                    prevMenuForAdmin();
                    break;
                case 2:
                    adminService.viewListOfGymCenters();
                    prevMenuForAdmin();
                    break;
                case 3:
                    adminService.viewPendingListOfGymOwners();
                    prevMenuForAdmin();
                    break;
                case 4:
                    adminService.viewPendingListOfGymCenters();
                    prevMenuForAdmin();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
            if (choice == 5) {
                break;
            }
        }
    }
    void prevMenuForAdmin(){
        System.out.println("\n\n1. Previous Menu");
        int choice = scanner.nextInt();
        if (choice==1){
            adminMenu();
        }
        else{
            System.out.println("Invalid Choice. Please press 1.");
        }
    }
}