package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.exceptions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author JEDI-04
 * Java class for Gym Owner Service Operations
 */

public class GymOwnerService {

    ArrayList<GymOwner> gymOwners = new ArrayList<>();
    HashSet<String> loggedInGymOwners = new HashSet<>();
    HashMap<String, String> registeredGymOwners = new HashMap<>();

    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();

    /**
     * Method for registering gym owner
     * @param name
     * @param email
     * @param password
     * @throws GymOwnerNotFoundException
     * @throws SQLException
     * @throws RegistrationFailedException
     */
    public void registerGymOwner(String name, String email, String password ) throws GymOwnerNotFoundException,SQLException, RegistrationFailedException {
        gymOwnerDAO.registerGymOwner(name, email, password);
    }

    /**
     * Method for login gym owner
     * @param email
     * @param password
     * @throws GymOwnerNotFoundException
     * @throws SQLException
     * @throws LoginFailedException
     * @throws WrongCredentialException
     */
    public boolean loginGymOwner(String email, String password) throws GymOwnerNotFoundException, SQLException, LoginFailedException, WrongCredentialException {
        return gymOwnerDAO.gymOwnerLogin(email, password);
    }

    /**
     * Method for changing password
     * @param email
     * @param oldPassword
     * @param newPassword
     * @throws GymOwnerNotFoundException
     * @throws SQLException
     * @throws WrongCredentialException
     */
    public void changePassword(String email, String oldPassword, String newPassword) throws GymOwnerNotFoundException, SQLException, WrongCredentialException {
        gymOwnerDAO.changeGymOwnerPassword(email, oldPassword, newPassword);
    }

    /**
     * Method for checking gym owner status provided gym owner email
     * @param email
     * @throws GymOwnerNotFoundException
     * @throws SQLException
     */
    public void checkOwnerStatusByEmail(String email) throws GymOwnerNotFoundException, SQLException {
        gymOwnerDAO.checkOwnerStatusByEmail(email);
    }

    /**
     * Method for view gym center list
     */
    public List<String> viewGymCenter(){
//        List<String> gymCenter;
//        System.out.println("List of available centers are: " + gymCenter.toString());
//        return gymCenter;
        return null;
    }

    /**
     * Method for adding slot
     */
    public boolean addSlot(){
        System.out.println("Slot has been booked successfully");
        return true;
    }

    /**
     * Method for request for gym center approval
     */
    public boolean requestForApproval(){
        System.out.println("Slot has been canceled successfully");
        return true;
    }
}
