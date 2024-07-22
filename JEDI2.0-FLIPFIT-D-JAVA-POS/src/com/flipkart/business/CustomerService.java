package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.client.FlipFitApplicationClient;
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
    public List<Booking> viewBooking(String email) {

        List<Booking> customerBookings = new ArrayList<Booking>();

        for (Booking b : bookings) {
            if (b.getEmail().equals(email)) {
                customerBookings.add(b);
            }
        }
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
