package com.flipkart.client;

import java.util.Scanner;

public class FlipFitApplicationClient {

    static Scanner scanner = new Scanner(System.in);
    static AdminFlipFitMenu adminFlipFitMenu = new AdminFlipFitMenu();
    static GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu();
    static CustomerFlipFitMenu customerFlipFitMenu = new CustomerFlipFitMenu();

    private static void displayMainMenu() {
        System.out.println("Welcome to the Flipfit Application:");
        System.out.println("1. Login");
        System.out.println("2. Registration of the GYM Customer");
        System.out.println("3. Registration of the GYM Owner");
        System.out.println("4. Change Password");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void changePassword(){
        System.out.println("Enter your role");
        String role = scanner.next();
        Scanner scan = new Scanner(System.in);
        String pass = "";
        role = role.toUpperCase();
        System.out.println("Please enter new password");
        pass = scan.nextLine();
        switch (role){
            case "ADMIN":
                System.out.println("Your password has been changed successfully");
                break;
            case "GYM_OWNER":
                System.out.println("Your password has been changed successfully");
                break;
            case "CUSTOMER":
                System.out.println("Your password has been changed successfully");
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }

    private static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        System.out.println("Enter Role (Admin, Gym_Owner, Customer): ");
        String role = scanner.next();
        role = role.toUpperCase();
        switch (role){
            case "ADMIN":
                adminFlipFitMenu.login(username, password);
                break;
            case "GYM_OWNER":
                gymOwnerFlipFitMenu.login(username, password);
                break;
            case "CUSTOMER":
                customerFlipFitMenu.login(username, password);
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }


    private static void registerGymOwner(){
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        gymOwnerFlipFitMenu.register(name, email, password);
    }

    private static void registerGymCustomer(){
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        customerFlipFitMenu.register(name, email, password);
    }


    public static void main(String[] args) {


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

