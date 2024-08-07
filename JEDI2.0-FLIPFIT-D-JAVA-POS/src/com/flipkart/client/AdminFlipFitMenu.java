package com.flipkart.client;

import com.flipkart.business.AdminService;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.WrongCredentialException;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author JEDI-04
 * Class that display Admin Menu
 */

public class AdminFlipFitMenu {

    static AdminService adminService = new AdminService();
    Scanner scanner = new Scanner(System.in);

    /**
     * Method for login
     * @param username
     * @param password
     * @throws SQLException
     * @throws LoginFailedException
     * @throws GymOwnerNotFoundException
     * @throws WrongCredentialException
     */
    void login(String username, String password) throws SQLException, LoginFailedException, GymOwnerNotFoundException, WrongCredentialException {
        try{
            boolean adminLogin = adminService.adminLogin(username, password);
            if (adminLogin)
                adminMenu();
        }
        catch(LoginFailedException exp){
            throw new LoginFailedException("Login Failed!");
        }
    }

    /**
     * Method for change password for admin
     * @param email
     * @param currentPassword
     * @param newPassword
     * @throws SQLException
     * @throws WrongCredentialException
     */
    void changeAdminPassword(String email, String currentPassword, String newPassword) throws SQLException, WrongCredentialException {
        adminService.changePassword(email, currentPassword, newPassword);
    }

    /**
     * Method for admin menu
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     */
    void adminMenu() throws SQLException, GymOwnerNotFoundException {
        try{
            System.out.println("\n\n--------------------WELCOME TO ADMIN MENU---------------------\n");
            System.out.println("1. View All Gym Owners\n");
            System.out.println("2. View All Gym Centers\n");
            System.out.println("3. View Pending Gym Owner Requests\n");
            System.out.println("4. View Pending Gym Center Requests\n");
            System.out.println("5. Previous Menu\n");
            System.out.println("--------------------------------------------------------------\n");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminService.viewListOfGymOwners();
                    prevMenuForAdmin();
                    break;
                case 2:
                    adminService.viewListOfGymCenters();
                    prevMenuForAdmin();
                    break;
                case 3:
                    adminService.viewPendingListOfGymOwners();
                    System.out.println("1. Approve all Gym Owners");
                    System.out.println("2. Approve Gym Owners by Email");
                    System.out.println("3. Previous Menu");
                    int pick = scanner.nextInt();
                    switch (pick) {
                        case 1:
                            adminService.approveAllGymOwners();
                            break;
                        case 2:
                            System.out.println("Enter Email:");
                            String email = scanner.next();
                            adminService.approveGymOwnerByEmail(email);
                            break;
                        case 3:
                            adminMenu();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                    break;
                case 4:
                    adminService.viewPendingListOfGymCenters();
                    System.out.println("1. Approve all Gym Centers");
                    System.out.println("2. Approve Gym Centers by Id");
                    System.out.println("3. Previous Menu");
                    int pick1 = scanner.nextInt();
                    switch (pick1) {
                        case 1:
                            adminService.approveAllGymCenter();
                            break;
                        case 2:
                            System.out.println("Enter gym Center Id:");
                            int id = scanner.nextInt();
                            adminService.approveGymCenterById(id);
                            break;
                        case 3:
                            adminMenu();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        catch(SQLException exp){
            throw new SQLException("Gym owner not found");
        }
    }

    /**
     * Method for going back to previous menu for admin
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     */
    void prevMenuForAdmin() throws SQLException, GymOwnerNotFoundException {
        try{
            System.out.println("\n\n1. Previous Menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                adminMenu();
            } else {
                System.out.println("Invalid Choice. Please press 1.");
            }
        }
        catch(SQLException exp){
            throw new SQLException("Gym owner not found");
        }
    }
}