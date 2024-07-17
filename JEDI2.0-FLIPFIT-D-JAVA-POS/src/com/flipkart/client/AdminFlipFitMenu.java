package com.flipkart.client;

import com.flipkart.business.AdminService;

public class AdminFlipFitMenu {

    static AdminService adminService = new AdminService();

    void login(String username, String password) {
        adminService.login(username, password);
        System.out.println("WELCOME TO ADMIN MENU---------------------\n");
    }
}