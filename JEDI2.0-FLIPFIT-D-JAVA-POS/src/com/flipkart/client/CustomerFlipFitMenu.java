package com.flipkart.client;

import com.flipkart.business.CustomerService;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerService();

    void login(String username, String password){
        customerService.loginCustomer(username, password);
        customerMenu();
    }

    void register(String name, String email, String password){
        customerService.registerCustomer(name, email, password);
        customerMenu();
    }

    void customerMenu(){
        System.out.println("\n\n--------------------WELCOME TO CUSTOMER MENU---------------------\n");
        System.out.println("1. View all Gym Centers\n");
        System.out.println("2. View My Bookings\n");
        System.out.println("3. Cancel My Bookings\n");
        System.out.println("4. Book Slots\n");
        System.out.println("-----------------------------------------------------------------\n");
    }

    void viewCenters(){

    }

    void bookSlot(){

    }

    void modifySlot(){

    }

}


