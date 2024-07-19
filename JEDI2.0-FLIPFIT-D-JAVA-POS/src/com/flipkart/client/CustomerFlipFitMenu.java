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
        boolean loginSuccess = userBusiness.loginCustomer(email, password);
        if(loginSuccess)
        {
            customerEmail=email;
            System.out.println("Customer logged-in successfully!");
            customerMenu();
        }
        else {
            System.out.println("You have entered wrong email id and password");
        }

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
        System.out.println("1. View Profile\n");
        System.out.println("2. Book Slot\n");
        System.out.println("3. View Booking\n");
        System.out.println("4. Cancel Booking\n");
        System.out.println("5. Logout");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Enter your choice: ");
        Integer customerOptions = scanner.nextInt();
        switch (customerOptions){
            case 1:
                customerService.viewProfile(customerEmail);
                System.out.println("Successfully showed customer profile");
                break;
            case 2:
                customerService.bookSlot();
                System.out.println("Successfully booked slot");
                break;
            case 3:
                customerService.viewBooking(customerEmail);
                System.out.println("Successfully viewed the booking");
                break;
            case 4:
                customerService.deleteBookings(customerEmail);
                System.out.println("Successfully deleted all bookings");
                break;
            case 5:
                customerService.logout();
                System.out.println("Successfully logged out");
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }

    }

    void changePassword(String email, String currPassword, String newPassword){
        customerService.changePassword(email, currPassword, newPassword);
    }
    void viewCenters(){

    }

    void bookSlot(){

    }

    void modifySlot(){

    }

}


