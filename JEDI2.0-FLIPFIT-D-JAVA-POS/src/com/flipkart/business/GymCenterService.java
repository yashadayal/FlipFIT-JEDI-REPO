package com.flipkart.business;

import com.flipkart.dao.GymCenterDAO;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.RegistrationFailedException;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author JEDI-04
 * Java class for Gym Center Service Operations
 */

public class GymCenterService {

    private GymCenterDAO gymCenterDAO = new GymCenterDAO();
    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method for registering gym center
     * @param ownerEmail
     * @throws GymCentreNotFoundException
     * @throws SQLException
     * @throws RegistrationFailedException
     */
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

    /**
     * Method for viewing gym center provided gym center email
     * @param email
     * @throws GymCentreNotFoundException
     * @throws SQLException
     */
    public void viewGymCenterByEmail(String email) throws GymCentreNotFoundException, SQLException {
        gymCenterDAO.viewGymCenterByEmail(email);
    }


    /**
     * Method for viewing approved gym center provided gym center email
     * @param email
     * @throws GymCentreNotFoundException
     * @throws SQLException
     */
    public void viewApprovedGymCenterByEmail(String email) throws GymCentreNotFoundException, SQLException {
        gymCenterDAO.viewApprovedGymCenterByEmail(email);
    }

    /**
     * Method for view all gym centers
     * @throws GymCentreNotFoundException
     * @throws SQLException
     */
    public void veiwAllGymCenters() throws GymCentreNotFoundException, SQLException {
        gymCenterDAO.viewAllGymCenters();
    }

    /**
     * Method for checking gym owner approval status
     * @param email
     * @throws GymCentreNotFoundException
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     */
    public boolean gymOwnerApprovalStatus(String email) throws GymCentreNotFoundException, SQLException, GymOwnerNotFoundException {
        return gymOwnerDAO.checkOwnerStatusByEmail(email);
    }

    /**
     * Method for view of gym center approval status provided gym center id
     * @param gymCenterId
     * @throws GymCentreNotFoundException
     * @throws SQLException
     */
    public boolean viewGymCenterApprovalStatusByGymCenterId(String gymCenterId) throws GymCentreNotFoundException, SQLException {
        return gymCenterDAO.viewGymCenterApprovalStatusByGymCenterId(gymCenterId);
    }

    /**
     * Method for adding slot
     * @param gymCenterId
     * @param startDateTime
     * @param endDateTime
     * @param capacity
     * @throws GymCentreNotFoundException
     * @throws SQLException
     */
    public void addSlot(int gymCenterId, Date startDateTime, Date endDateTime, int capacity) throws GymCentreNotFoundException, SQLException {
        gymCenterDAO.addSlot(gymCenterId, startDateTime, endDateTime, capacity);
    }
}