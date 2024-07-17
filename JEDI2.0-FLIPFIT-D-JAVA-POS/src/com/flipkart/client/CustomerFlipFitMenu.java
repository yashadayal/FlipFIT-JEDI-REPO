package com.flipkart.client;

import com.flipkart.business.CustomerService;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerService();

    void login(String username, String password){
        customerService.loginCustomer(username, password);
        System.out.println("WELCOME TO GYM CUSTOMER SERVICE-------\n");
    }

    void register(String name, String email, String password){
        customerService.registerCustomer(name, email, password);
        System.out.println("Write menu to be shown after registration-----\n");
    }

    void viewCenters(){

    }

    void bookSlot(){

    }

    void modifySlot(){

    }

}


