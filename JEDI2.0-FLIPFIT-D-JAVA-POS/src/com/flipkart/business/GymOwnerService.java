package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.WrongCredentialException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GymOwnerService {



    ArrayList<GymOwner> gymOwners = new ArrayList<>();
    HashSet<String> loggedInGymOwners = new HashSet<>();
    HashMap<String, String> registeredGymOwners = new HashMap<>();

    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();

    public void registerGymOwner(String name, String email, String password ) throws GymOwnerNotFoundException,SQLException, RegistrationFailedException {
        gymOwnerDAO.registerGymOwner(name, email, password);
    }

    public boolean loginGymOwner(String email, String password) throws GymOwnerNotFoundException, SQLException, LoginFailedException, WrongCredentialException {
        return gymOwnerDAO.gymOwnerLogin(email, password);
    }

    public void changePassword(String email, String oldPassword, String newPassword) throws GymOwnerNotFoundException, SQLException, WrongCredentialException {
        gymOwnerDAO.changeGymOwnerPassword(email, oldPassword, newPassword);
    }

    public void checkOwnerStatusByEmail(String email) throws GymOwnerNotFoundException, SQLException {
        gymOwnerDAO.checkOwnerStatusByEmail(email);
    }

    public List<String> viewGymCenter(){
//        List<String> gymCenter;
//        System.out.println("List of available centers are: " + gymCenter.toString());
//        return gymCenter;
        return null;
    }

    public boolean addSlot(){
        System.out.println("Slot has been booked successfully");
        return true;
    }

    public boolean requestForApproval(){
        System.out.println("Slot has been canceled successfully");
        return true;
    }
}
