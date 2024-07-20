package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.dao.GymCenterDAO;
import com.flipkart.dao.GymOwnerDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GymCenterService {

    private GymCenterDAO gymCenterDAO = new GymCenterDAO();
    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private Scanner scanner = new Scanner(System.in);

    public void registerGymCenter(String ownerEmail) throws SQLException {

        System.out.println("Enter Gym Center Name: ");
        String gymCenterName = scanner.nextLine();
        System.out.println("Enter Gym Center GSTIN: ");
        String gymCenterGSTin =  scanner.nextLine();
        System.out.println("Enter Gym Center Capacity: ");
        int gymCenterCapacity = scanner.nextInt();
        System.out.println("Enter Gym Center Price: ");
        int gymCenterPrice = scanner.nextInt();

        gymCenterDAO.registerGymCenter(ownerEmail, gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice);
    }

    public void viewGymCenterByEmail(String email) throws SQLException {
        gymCenterDAO.viewGymCenterByEmail(email);
    }

    public void veiwAllGymCenters() throws SQLException {
        gymCenterDAO.viewAllGymCenters();
    }

    public boolean gymOwnerApprovalStatus(String email) throws SQLException {
        return gymOwnerDAO.checkOwnerStatusByEmail(email);
    }

    public boolean viewGymCenterApprovalStatusByGymCenterId(String gymCenterId) throws SQLException {
        return gymCenterDAO.viewGymCenterApprovalStatusByGymCenterId(gymCenterId);
    }

}