package com.flipkart.business;

import com.flipkart.dao.GymCenterDAO;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.RegistrationFailedException;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author JEDI-04
 * Java class for Gym Center Service Operations
 */

public class GymCenterService {

    private GymCenterDAO gymCenterDAO = new GymCenterDAO();
    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private Scanner scanner = new Scanner(System.in);

    public void registerGymCenter(String ownerEmail) throws GymCentreNotFoundException, SQLException, RegistrationFailedException {

        try{
            System.out.println("Enter Gym Center Name: ");
            String gymCenterName = scanner.nextLine();
            System.out.println("Enter Gym Center GSTIN: ");
            String gymCenterGSTin = scanner.nextLine();
            System.out.println("Enter Gym Center Capacity: ");
            int gymCenterCapacity = scanner.nextInt();
            System.out.println("Enter Gym Center Price: ");
            int gymCenterPrice = scanner.nextInt();
            gymCenterDAO.registerGymCenter(ownerEmail, gymCenterName, gymCenterGSTin, gymCenterCapacity, gymCenterPrice);
        }
        catch(RegistrationFailedException exp){
            throw new RegistrationFailedException("Registration failed!");
        }
        catch(GymCentreNotFoundException exp){
            throw new GymCentreNotFoundException("Gym center not found!");
        }
    }

    public void viewGymCenterByEmail(String email) throws GymCentreNotFoundException, SQLException {
        gymCenterDAO.viewGymCenterByEmail(email);
    }

    public void veiwAllGymCenters() throws GymCentreNotFoundException, SQLException {
        gymCenterDAO.viewAllGymCenters();
    }

    public boolean gymOwnerApprovalStatus(String email) throws GymCentreNotFoundException, SQLException, GymOwnerNotFoundException {
        return gymOwnerDAO.checkOwnerStatusByEmail(email);
    }

    public boolean viewGymCenterApprovalStatusByGymCenterId(String gymCenterId) throws GymCentreNotFoundException, SQLException {
        return gymCenterDAO.viewGymCenterApprovalStatusByGymCenterId(gymCenterId);
    }

}