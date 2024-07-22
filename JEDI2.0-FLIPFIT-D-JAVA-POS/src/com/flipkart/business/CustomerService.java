package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.client.FlipFitApplicationClient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JEDI-04
 * Java class for Customer Service Operations
 */

public class CustomerService {
    private FlipFitApplicationClient flipfitAppClient = new FlipFitApplicationClient();
    List<Booking> bookings = new ArrayList<>();
    List<GymCenter> gyms = new ArrayList<>();
    CustomerDAO userDao = new CustomerDAO();

    /**
     * Method for registering customer
     * @param name
     * @param email
     * @param password
     */
    public boolean registerCustomer(String name, String email, String password)
    {
        Customer customer=new Customer();
        customer.setCustomerName(name);
        customer.setPassword(password);
        customer.setEmail(email);
        boolean registerSuccess = false;
        registerSuccess = userDao.registerCustomer(customer);
        return registerSuccess;
    }

    /**
     * Method for login customer
     * @param email
     * @param password
     */
    public boolean loginCustomer(String email, String password){

        System.out.println("Customer running");
        boolean loginSuccess = userDao.loginCustomer(email, password);
        return loginSuccess;
    }

    /**
     * Method for changing password
     * @param email
     * @param oldPassword
     * @param newPassword
     */
    public void changePassword(String email, String oldPassword, String newPassword){
        userDao.changePassword(email, oldPassword, newPassword);
    }

    /**
     * Method for viewing profile
     * @param email
     */
    public void viewProfile(String email){
        Customer customerDetails= userDao.viewProfile(email);
        if (customerDetails != null) {
            System.out.println("Customer ID: " + customerDetails.getCustomerId());
            System.out.println("Name: " + customerDetails.getCustomerName());
            System.out.println("Phone: " + customerDetails.getCustomerPhone());
            System.out.println("Address: " + customerDetails.getCustomerAddress());
            System.out.println("Email: " + customerDetails.getEmail());
        }
    }


    /**
     * Method for booking slot
     * @param email
     * @param slotId
     */

    public boolean bookSlot(String email, int slotId){
//        fetch customer id using email and pass the values to book slot
//        bookingService.bookSlot();
        System.out.println("Slot has been booked successfully");
        return true;
    }

    /**
     * Method for checking booking
     * @param email
     * @throws SQLException
     */
    public boolean viewBooking(String email) throws SQLException {
        List<Booking> customerBookings = userDao.viewBooking(email);
        for (Booking booking : customerBookings) {
            System.out.println("Booking ID: " + booking.getBookingID()+"\tstartTime:"+booking.getStartTime()+"\tendTime:"+booking.getEndTime());
        }
        return true;
    }

    /**
     * Method for delete booking
     * @param email
     */
    public boolean deleteBookings(String email){
        boolean bookingSuccess=false;
        for (Booking booking : bookings) {
            if (booking.getEmail().equals(email)) {
                bookingSuccess=true;
                bookings.remove(booking);
            }
        }
        if(bookingSuccess) {
            System.out.println("Successfully cancelled your bookings");
            return true;
        }
        return false;
    }

    /**
     * Method for logout
     */
    public void logout(){
        System.out.println("Successfully logged out");
    }

}
