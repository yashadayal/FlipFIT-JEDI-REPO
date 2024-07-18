package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerService;

import java.util.Scanner;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerService();
    Customer customer = new Customer();
    String customerEmail;
    void login(String email, String password){

        CustomerService userBusiness = new CustomerService();
        userBusiness.loginCustomer(email, password);
        customerEmail=email;
        System.out.println("Customer logged-in successfully!");
        customerMenu();
    }

    void register(String name, String email, String password){
        CustomerService userBusiness = new CustomerService();
        userBusiness.registerCustomer(name, email, password);
        customerEmail=email;
        System.out.println("Customer registered successfully!");
        customerMenu();
    }

    void customerMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--------------------WELCOME TO CUSTOMER MENU---------------------\n");
        System.out.println("1. View all Gym Centers\n");
        System.out.println("2. View My Bookings\n");
        System.out.println("3. Cancel My Bookings\n");
        System.out.println("4. Book Slots\n");
        System.out.println("-----------------------------------------------------------------\n");
        Integer customerOptions = scanner.nextInt();
        switch (customerOptions){
            case 1:
                customerService.viewGymCenter();
                System.out.println("Successfully showed all Centers");
                break;
            case 2:
                customerService.viewBooking(customerEmail);
                System.out.println("Successfully viewed the booking");
                break;
            case 3:
                customerService.deleteBookings(customerEmail);
                System.out.println("Successfully deleted all bookings");
                break;
            case 4:
                customerService.bookSlot();
                System.out.println("Successfully booked the booking");
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }

    }

    void viewCenters(){

    }

    void bookSlot(){

    }

    void modifySlot(){

    }

}


