package com.flipkart.client;

import com.flipkart.business.AdminService;
import java.util.Scanner;

public class AdminFlipFitMenu {

    static AdminService adminService = new AdminService();

    void login(String username, String password) {
        adminService.adminLogin(username, password);
        adminMenu();
    }
    void changeAdminPassword(String email, String currentPassword, String newPassword){
        adminService.changePassword(email, currentPassword, newPassword);
    }

    void adminMenu(){
        System.out.println("\n\n--------------------WELCOME TO ADMIN MENU---------------------\n");
        System.out.println("1. View Pending Gym Owner Requests\n");
        System.out.println("2. Approve Gym Owner Registration Requests\n");
        System.out.println("3. View Pending Gym Center Requests\n");
        System.out.println("4. Approve Gym Center Registration Requests\n");
        System.out.println("5. Previous Menu\n");

        // List of all gym owners
        // list of all gym centers
        System.out.println("--------------------------------------------------------------\n");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminService.viewPendingListOfGymOwners();
                    break;
                case 2:
//                    adminService.;
//                    break;
                case 3:
                    adminService.viewPendingListOfGymCenters();
                    break;
                case 4:
//                    changePassword();
//                    break;
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
}