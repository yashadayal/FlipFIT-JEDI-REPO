package com.flipkart.client;

import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;

import java.sql.SQLException;
import java.util.Scanner;

public class FlipFitApplicationClient {

    static Scanner scanner = new Scanner(System.in);
    static AdminFlipFitMenu adminFlipFitMenu = new AdminFlipFitMenu();
    static GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu();
    static CustomerFlipFitMenu customerFlipFitMenu = new CustomerFlipFitMenu();

    public static void displayMainMenu() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("Welcome to the Flipfit Application:");
        System.out.println("1. Login");
        System.out.println("2. Registration of the GYM Customer");
        System.out.println("3. Registration of the GYM Owner");
        System.out.println("4. Change Password");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void changePassword() throws SQLException, GymOwnerNotFoundException, WrongCredentialException {
        System.out.println("Enter your role");
        String role = scanner.next();
        role = role.toUpperCase();
        System.out.println("Enter your email");
        String email = scanner.next();
        System.out.println("Enter your current password");
        String currPassword = scanner.next();
        System.out.println("Please enter new password");
        String newPassword = scanner.next();

        switch (role){
            case "ADMIN":
                adminFlipFitMenu.changeAdminPassword(email, currPassword, newPassword);
                break;
            case "GYM_OWNER":
                gymOwnerFlipFitMenu.changePassword(email, currPassword, newPassword);
                break;
            case "CUSTOMER":
                customerFlipFitMenu.changePassword(email, currPassword, newPassword);
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }

    private static void login() throws SQLException, GymOwnerNotFoundException, LoginFailedException,WrongCredentialException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        System.out.println("Enter Role (Admin, Gym_Owner, Customer): ");
        String role = scanner.next();
        role = role.toUpperCase();
        switch (role){
            case "ADMIN":
                adminFlipFitMenu.login(email, password);
                break;
            case "GYM_OWNER":
                gymOwnerFlipFitMenu.login(email, password);
                break;
            case "CUSTOMER":
                customerFlipFitMenu.login(email, password);
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }


    private static void registerGymOwner() throws SQLException, GymOwnerNotFoundException, RegistrationFailedException {
        gymOwnerFlipFitMenu.registerGymOwner();
    }

    private static void registerGymCustomer() throws SQLException,RegistrationFailedException {
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        customerFlipFitMenu.register(name, email, password);
    }


    public static void main(String[] args) throws SQLException, GymOwnerNotFoundException, WrongCredentialException {
        while (true) {
            displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    registerGymCustomer();
                    break;
                case 3:
                    registerGymOwner();
                    break;
                case 4:
                    changePassword();
                    break;
                case 5:
                    System.out.println("Exiting Application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

