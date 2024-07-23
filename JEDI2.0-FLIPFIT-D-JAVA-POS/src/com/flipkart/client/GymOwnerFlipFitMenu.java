package com.flipkart.client;

import com.flipkart.business.GymCenterService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author JEDI-04
 *  The class displays the menu for gym owner client
 */

public class GymOwnerFlipFitMenu {


    private Scanner scanner = new Scanner(System.in);
    private GymOwnerService gymOwnerService = new GymOwnerService();
    private GymCenterService gymCenterService = new GymCenterService();


    /**
     * Method for gym owner menu
     * @param email
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     * @throws ParseException
     */
    void gymOwnerMenu(String email) throws GymOwnerNotFoundException, SQLException, ParseException {
        System.out.println("\n\n--------------------WELCOME TO GYM OWNER MENU---------------------\n");
        System.out.println("1. View Status of Gym Owner Approval Request\n");
        System.out.println("2. Register Gym Center\n");
        System.out.println("3. View All Gym Centers\n");
        System.out.println("4. Add Slots in your Gym Centers\n");
        System.out.println("5. View Status of your Gym Centers\n");
        System.out.println("6. Log out\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        boolean ownerApproved = gymCenterService.gymOwnerApprovalStatus(email);
        switch (choice){
            case 1:
                if(ownerApproved){
                    System.out.println("You have been approved by the Admin");
                }
                else{
                    System.out.println("Your gym owner application is still pending for approval");
                }
                break;

            case 2:
                if(ownerApproved){
                    gymCenterService.registerGymCenter(email);
                }
                else{
                    System.out.println("Your can not add Gym Center before you're approved by the Admin");
                }
                break;
            case 3:
                gymCenterService.veiwAllGymCenters();
                break;
            case 4:
                addSlot(email);
                break;
            case 5:
                gymCenterService.viewGymCenterByEmail(email);
                break;
            case 6:
                return;
        }
        gymOwnerMenu(email);
    }

    /**
     * Method for login
     * @param email
     * @param password
     * @throws SQLException
     * @throws LoginFailedException
     * @throws WrongCredentialException
     * @throws ParseException
     * @throws GymOwnerNotFoundException
     */
    void login(String email, String password) throws GymOwnerNotFoundException, SQLException, LoginFailedException, WrongCredentialException, ParseException {
        try{
            if (gymOwnerService.loginGymOwner(email, password)) {
                gymOwnerMenu(email);
            }
        }
        catch(LoginFailedException exp){
            throw new LoginFailedException("Login Failed!");
        }
    }

    /**
     * Method for register gym owner
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     * @throws RegistrationFailedException
     */
    void registerGymOwner() throws GymOwnerNotFoundException, SQLException, RegistrationFailedException {
        try{
            System.out.println("Enter Name: ");
            String name = scanner.next();
            System.out.println("Enter Email: ");
            String email = scanner.next();
            System.out.println("Enter password: ");
            String password = scanner.next();
            gymOwnerService.registerGymOwner(name, email, password);
        }
        catch(RegistrationFailedException exp){
            throw new RegistrationFailedException("Registration Failed!");
        }
    }

    /**
     * Method for change password
     * @param email
     * @param currPassword
     * @param newPassword
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     * @throws WrongCredentialException
     */
    void changePassword(String email, String currPassword, String newPassword) throws GymOwnerNotFoundException, SQLException, WrongCredentialException {
        gymOwnerService.changePassword(email, currPassword, newPassword);
    }


    /**
     * Method for login
     * @param email
     * @throws RegistrationFailedException
     * @throws SQLException
     * @throws ParseException
     */
    void addSlot(String email) throws GymOwnerNotFoundException, SQLException, RegistrationFailedException, ParseException {
        // show the list of gym centers under this gym owner
        gymCenterService.viewApprovedGymCenterByEmail(email);

        // take input of gym center id
        System.out.println("Enter gym center id: ");
        int gymCenterId = scanner.nextInt();

        // add a slot in that gym
        System.out.println("Enter Date (YYYY-MM-DD): ");
        String dateString = scanner.next();

        System.out.println("Enter slot start time (HH:mm:ss): ");
        String starttimeString = scanner.next();

        String startDateTime = dateString + " " + starttimeString;
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = startDateFormat.parse(startDateTime);

        System.out.println("Enter slot end time (HH:mm:ss): ");
        String endtimeString = scanner.next();

        String endDateTime = dateString + " " + endtimeString;
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date end = endDateFormat.parse(startDateTime);
        System.out.println("Enter capacity: ");
        int capacity = scanner.nextInt();

        gymCenterService.addSlot(gymCenterId, start, end, capacity);

    }


    void getGymCenterList(){}

    void addCenter(){}

    void getSlots(){

    }

}
