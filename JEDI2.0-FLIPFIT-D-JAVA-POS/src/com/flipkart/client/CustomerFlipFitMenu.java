package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerService;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerService();
    Customer customer = new Customer();
    void login(String email, String password){

        CustomerService userBusiness = new CustomerService();
        userBusiness.loginCustomer(email, password);
        System.out.println("Customer logged-in successfully!");
        customerMenu();
    }

    void register(String name, String email, String password){
        CustomerService userBusiness = new CustomerService();
        userBusiness.registerCustomer(name, email, password);
        System.out.println("Customer registered successfully!");
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


