package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.client.FlipFitApplicationClient;
import com.flipkart.jdbc.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.dao.SlotDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    static ArrayList<Customer> registeredCustomers=new ArrayList<>();
    private FlipFitApplicationClient flipfitAppClient = new FlipFitApplicationClient();
    List<Booking> bookings = new ArrayList<>();
    List<GymCenter> gyms = new ArrayList<>();
    CustomerDAO userDao = new CustomerDAO();
    BookingService bookingService = new BookingService();

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

    public boolean loginCustomer(String email, String password){

        System.out.println("Customer running");
        boolean loginSuccess = userDao.loginCustomer(email, password);
        return loginSuccess;
    }

    public void changePassword(String email, String oldPassword, String newPassword){
        userDao.changePassword(email, oldPassword, newPassword);
    }

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

    public List<GymCenter> viewGymCenter(){
//        List<GymCenter> newGym = new ArrayList<GymCenter>();
//        for (GymCenter gym : gyms) {
//            newGym.add(gym);
//        }
        return gyms;
    }
    public boolean bookSlot(){
        System.out.println("Slot has been booked successfully");
        return true;
    }

    public boolean deleteSlot(){
        System.out.println("Slot has been canceled successfully");
        return true;
    }
//    public List<Booking> viewBooking(String email) {
//
//        List<Booking> customerBookings = new ArrayList<Booking>();
//
//        for (Booking b : bookings) {
//            if (b.getEmail().equals(email)) {
//                customerBookings.add(b);
//            }
//        }
//        return customerBookings;
//    }


    public List<Booking> viewBooking(String userId) {

        List<Booking> customerBookings = new ArrayList<>();

        Connection connection = null;
        boolean bookingSuccess = false;
        String query = "SELECT * FROM flipfit_booking WHERE customerId = ?";
        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);


            ResultSet resultSet = preparedStatement.executeQuery();



            // Iterate through the result set
            while (resultSet.next()) {
                // Retrieve data from the result set and create a Booking object
                String bookingID = resultSet.getString("bookingId");
                String customerID = resultSet.getString("customerId");
                // Assuming other fields like date, time, etc., adjust as per your database schema

                Booking booking = new Booking(customerID,bookingID); // Adjust constructor as per your Booking class

                // Add Booking object to the list
                customerBookings.add(booking);
            }
        }
        catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions according to your application's needs
        }

        // Return the list of bookings
        return customerBookings;
    }

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

    public void logout(){
        System.out.println("Successfully logged out");
    }

}
