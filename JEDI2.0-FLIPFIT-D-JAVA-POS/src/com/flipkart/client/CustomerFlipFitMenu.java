package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerService;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerService();
    Customer customer = new Customer();
    String customerEmail;
    void login(String email, String password) throws LoginFailedException, SQLException, WrongCredentialException {

        CustomerService userBusiness = new CustomerService();
        boolean loginSuccess = userBusiness.loginCustomer(email, password);
        if(loginSuccess)
        {
            customerEmail=email;
            customerMenu();
        }
        else {
            System.out.println("You have entered wrong email id and password");
        }

    }

    void register(String name, String email, String password) throws SQLException, RegistrationFailedException {
        CustomerService userBusiness = new CustomerService();
        userBusiness.registerCustomer(name, email, password);
        customerEmail=email;
        System.out.println("Customer registered successfully!");
        customerMenu();
    }

    void customerMenu() throws SQLException {
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
                customerMenu();
                break;
            case 2:
//                customerService.bookSlot();
                customerMenu();
                break;
            case 3:
                List<Booking> customerBookings=customerService.viewBooking(customerEmail);
                for (Booking booking : customerBookings) {
                    System.out.println("Booking ID: " + booking.getBookingID());
                }
                customerMenu();
                System.out.println("Successfully viewed the booking");
                break;
            case 4:
                customerService.deleteBookings(customerEmail);
                customerMenu();
                break;
            case 5:
                customerService.logout();
                break;
            default:
                System.out.println("INVALID CHOICE");
                customerMenu();
                break;
        }
    }

    void changePassword(String email, String currPassword, String newPassword) throws WrongCredentialException {
        customerService.changePassword(email, currPassword, newPassword);
    }
    void viewCenters(){

    }

    void bookSlot(){

    }

    void modifySlot(){

    }

}


