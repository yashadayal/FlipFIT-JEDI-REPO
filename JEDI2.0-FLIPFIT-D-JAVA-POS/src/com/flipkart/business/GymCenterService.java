package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.dao.GymCenterDAO;

import java.util.List;
import java.util.Scanner;

public class GymCenterService {

    private GymCenterDAO gymCenterDAO = new GymCenterDAO();
    private Scanner scanner = new Scanner(System.in);

    public void registerGymCenter() {

        System.out.println("Enter Gym Center Name: ");
        String gymCenterName = scanner.nextLine();
        System.out.println("Enter Gym Center GSTIN: ");
        String gymCenterGSTin =  scanner.nextLine();
        System.out.println("Enter Gym Center Capacity: ");
        int gymCenterCapacity = scanner.nextInt();
        System.out.println("Enter Gym Center Price: ");
        int gymCenterPrice = scanner.nextInt();

        gymCenterDAO.registerGymCenter(gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice);
    }

    public List<GymCenter> veiwAllGymCenters() {
        return gymCenterDAO.viewAllGymCenters();
    }

    public boolean approvalStatus(String email){
        return gymCenterDAO.approvalStatus(email);
    }

    public List<GymCenter> viewGymCenterStatus(String email){
        // take the gyms under this email id and return them as a list
        return gymCenterDAO.viewGymCenterStatus(email);
    }

}
