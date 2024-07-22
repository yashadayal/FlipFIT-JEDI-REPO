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
        return;
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
    public boolean bookSlot(String email, int slotId){
//        fetch customer id using email and pass the values to book slot
//        bookingService.bookSlot();
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


    public List<Booking> viewBooking(String email) {

        List<Booking> customerBookings = new ArrayList<>();

        Connection connection = null;
//        System.out.println(userId);
        boolean bookingSuccess = false;
        String query = "SELECT * FROM flipfit_booking WHERE customerId = ?";
        String userId_query = "SELECT customerId FROM flipfit_customer WHERE customerEmail = ?";
        try {
            connection = DBUtils.getConnection();

            PreparedStatement preparedStatement_email = connection.prepareStatement(userId_query);
            preparedStatement_email.setString(1, email);

            ResultSet resultSet = preparedStatement_email.executeQuery();

            String customerId = "na"; // Assuming -1 is not a valid customerId

            if (resultSet.next()) {
                customerId = resultSet.getString("customerId");
            } else {
                // Handle case where no customer with the given email is found
                System.out.println("No customer found with email: " + email);
                return customerBookings; // Return empty list
            }


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerId);

            ResultSet resultSet2 = preparedStatement.executeQuery();



            // Iterate through the result set
            while (resultSet2.next()) {
                // Retrieve data from the result set and create a Booking object
                int bookingID = resultSet2.getInt("bookingId");
                String customerID = resultSet2.getString("customerId");
                // Assuming other fields like date, time, etc., adjust as per your database schema

                Booking booking = new Booking(customerID,bookingID); // Adjust constructor as per your Booking class

                // Add Booking object to the list
                customerBookings.add(booking);
                System.out.println(booking);
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
