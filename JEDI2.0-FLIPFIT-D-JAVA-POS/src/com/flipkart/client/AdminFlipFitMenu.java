package com.flipkart.client;

<<<<<<< HEAD
public class AdminFlipFitMenu {

    void login(String username, String password) {
        System.out.println("Admin Logged In Successfully");
=======
import com.flipkart.business.AdminService;

public class AdminFlipFitMenu {

    static AdminService adminService = new AdminService();

    void login(String username, String password) {
        adminService.adminLogin(username, password);
        adminMenu();
    }
    void adminMenu(){
        System.out.println("\n\n--------------------WELCOME TO ADMIN MENU---------------------\n");
        System.out.println("1. View Pending Gym Owner Requests\n");
        System.out.println("2. Approve Gym Owner Registration Requests\n");
        System.out.println("3. View Pending Gym Center Requests\n");
        System.out.println("4. Approve Gym Center Registration Requests\n");
        System.out.println("--------------------------------------------------------------\n");
>>>>>>> d1230ecb2e3a5f30040bb7765ba23bde44c23aa2
    }
}