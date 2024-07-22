package com.flipkart.business;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.sql.SQLException;
import java.util.*;
import java.io.FileInputStream;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAO;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.exceptions.WrongCredentialException;

import java.util.Properties;

/**
 * @author JEDI-04
 * Java class for Admin Service Operations
 */

public class AdminService {
    public static AdminDAO adminDao = new AdminDAO();
    private static int adminId = 0;
    String adminEmail="";
    String adminPassword="";
//    public AdminService() {
//        try {
//
//            Properties prop = new Properties();
//            FileInputStream fileInputStream = new FileInputStream("src/config.properties");
//            prop.load(fileInputStream);
//             adminEmail = prop.getProperty("adminEmail");
//             adminPassword = prop.getProperty("adminPassword");
//            adminDao.setAdminData(adminEmail,adminPassword);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    /**
     * Method for admin login
     * @param email
     * @param password
     * @throws LoginFailedException
     * @throws WrongCredentialException
     */
    public boolean adminLogin(String email, String password) throws LoginFailedException, WrongCredentialException {

        try{
            if (Objects.equals(email, adminEmail) && Objects.equals(password, adminPassword)) {
                System.out.println("Admin with username " + email + " logged in successfully.");
                return true;
            }
        }
        catch(LoginFailedException exp) {
            System.out.println("Incorrect email or password.");
        }
        return false;
    }

    /**
     * Method for change password
     * @param email
     * @param oldPassword
     * @param newPassword
     * @throws SQLException
     * @throws WrongCredentialException
     */
    public void changePassword(String email, String oldPassword, String newPassword) throws SQLException, WrongCredentialException {
        try{
            if (!Objects.equals(email, adminEmail)) {
                System.out.println("Incorrect email.");
                return;
            }
            if (!Objects.equals(oldPassword, adminPassword)) {
                System.out.println("Incorrect password.");
                return;
            }
            adminDao.setPassword(newPassword);
            System.out.println("Your password has been changed successfully" + newPassword);
        }
        catch(WrongCredentialException exp){
            throw new WrongCredentialException("Wrong Credentials");
        }
        catch(SQLException exp){
            System.out.println("Error Occurred!");
        }
    }

    /**
     * Method to view list of gym owners
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     */
    public ArrayList<GymOwner> viewListOfGymOwners() throws SQLException, GymOwnerNotFoundException {
        return adminDao.getListOfGymOwners();
    }

    /**
     * Method to view list of gym centers
     * @throws SQLException
     * @throws GymCentreNotFoundException
     */
    public ArrayList<GymCenter> viewListOfGymCenters() throws SQLException, GymCentreNotFoundException {
        return adminDao.getListOfGymCenters();
    }

    /**
     * Method to view pending list of gym owners
     * @throws SQLException
     * @throws GymOwnerNotFoundException
     */
    public ArrayList<GymOwner> viewPendingListOfGymOwners() throws SQLException, GymOwnerNotFoundException {
        return adminDao.getListOfPendingGymOwners();
    }

    /**
     * Method to view pending list of gym centers
     * @throws SQLException
     * @throws GymCenterNotFoundException
     */
    public ArrayList<GymCenter> viewPendingListOfGymCenters() throws SQLException, GymCentreNotFoundException {
        return adminDao.getListOfPendingGymCenters();
    }

    /**
     * Method to approve all gym centers
     * @throws SQLException
     */
    public void approveAllGymCenter() throws SQLException {
        adminDao.approveAllGymCenter();
    }

    /**
     * Method to approve gym center by gym center id
     * @throws SQLException
     */
    public void approveGymCenterById(int gymCenterId) throws SQLException{
        adminDao.approveGymCenterById(gymCenterId);
    }

    /**
     * Method to approve all gym owners
     * @throws SQLException
     */
    public void approveAllGymOwners() throws SQLException {
        adminDao.approveAllGymOwners();
    }

    /**
     * Method to approve gym owner by gym owner email
     * @throws SQLException
     */
    public void approveGymOwnerByEmail(String gymOwnerEmail) throws SQLException{
        adminDao.approveGymOwnerByEmail(gymOwnerEmail);
    }

}
