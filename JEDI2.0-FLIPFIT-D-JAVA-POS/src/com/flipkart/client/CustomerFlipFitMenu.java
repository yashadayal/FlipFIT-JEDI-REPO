package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.business.BookingService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.GymCenterService;
import com.flipkart.business.SlotService;
import com.flipkart.dao.SlotDAO;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author JEDI-04
 *  The class displays the menu for customer client
 */

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerService();
    Customer customer = new Customer();
    GymCenterService gymCenterService=new GymCenterService();
    SlotDAO slotDAO=new SlotDAO();
    BookingService bookingService=new BookingService();
    String customerEmail;
    void login(String email, String password) throws LoginFailedException, SQLException, WrongCredentialException {

        try{
            CustomerService userBusiness = new CustomerService();
            boolean loginSuccess = userBusiness.loginCustomer(email, password);
            if (loginSuccess) {
                customerEmail = email;
                customerMenu();
            } else {
                System.out.println("You have entered wrong email id and password");
            }
        }
        catch(LoginFailedException exp){
            throw new LoginFailedException("Login Failed!");
        }
        catch(SQLException exp){
            throw new SQLException("Error Occurred!");
        }
    }

    void register(String name, String email, String password) throws SQLException, RegistrationFailedException {
        try{
            CustomerService userBusiness = new CustomerService();
            userBusiness.registerCustomer(name, email, password);
            customerEmail = email;
            System.out.println("Customer registered successfully!");
            customerMenu();
        }
        catch(RegistrationFailedException exp){
            throw new RegistrationFailedException("Registration failed");
        }
    }

    void customerMenu() throws SQLException {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--------------------WELCOME TO CUSTOMER MENU---------------------\n");
        System.out.println("1. View Profile\n");
        System.out.println("2. Book Slot\n");
        System.out.println("3. View Booking\n");
        System.out.println("4. Logout");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Enter your choice: ");
        Integer customerOptions = scanner.nextInt();
        switch (customerOptions){
            case 1:
                customerService.viewProfile(customerEmail);
                customerMenu();
                break;
            case 2:
                System.out.println("List of gym centers. Please select your gym center id");
                gymCenterService.veiwAllGymCenters();
                int gymCenterId=scanner.nextInt();
                System.out.println("List of gym center slots. Please select your gym slot id");
                slotDAO.getSlotByCenterId(gymCenterId);
                int slotId=scanner.nextInt();
                bookingService.bookSlot(customerEmail,slotId);
                customerMenu();
                break;
            case 3:
                customerService.viewBooking(customerEmail);
                System.out.println("\n\n1. Cancel Booking");
                System.out.println("2. Previous Menu");

                int pick = scanner.nextInt();
                switch (pick){
                    case 1:
                        System.out.println("Enter the booking id to cancel: ");
                        int bookingId = scanner.nextInt();
                        bookingService.cancelBooking(customerEmail, bookingId);
                        break;
                    case 2:
                        customerMenu();
                        break;
                    default:
                        System.out.println("INVALID CHOICE.");
                }
                break;
            case 4:
                customerService.logout();
                break;
            default:
                System.out.println("INVALID CHOICE");
                customerMenu();
                break;
        }
        }
        catch(SQLException exp){
            throw new SQLException("Error Occurred!");
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


