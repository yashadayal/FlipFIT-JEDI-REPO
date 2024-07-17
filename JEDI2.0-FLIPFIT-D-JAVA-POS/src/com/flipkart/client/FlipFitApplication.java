package com.flipkart.client;

import java.util.Scanner;

public class FlipFitApplication {

    static Scanner scanner = new Scanner(System.in);
    static AdminClient adminClient = new AdminClient();
    static GymOwnerClient gymOwnerClient = new GymOwnerClient();
    static CustomerClient customerClient = new CustomerClient();

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
        String role = scanner.nextLine();
        role = role.toUpperCase();
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
        System.out.println("Enter Role: ");
        String role = scanner.next();
        role = role.toUpperCase();
        switch (role){
            case "ADMIN":
                adminClient.login(username, password);
                break;
            case "GYM_OWNER":
                gymOwnerClient.login(username, password);
                break;
            case "CUSTOMER":
                customerClient.login(username, password);
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
        gymOwnerClient.register(name, email, password);
    }

    private static void registerGymCustomer(){
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        customerClient.register(name, email, password);
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

