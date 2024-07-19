package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.dao.CustomerDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerService {
    static ArrayList<Customer> registeredCustomers=new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    List<GymCenter> gyms = new ArrayList<>();
    CustomerDAO userDao = new CustomerDAO();
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
        for(Customer it:registeredCustomers){
            if(Objects.equals(it.getEmail(), email) && Objects.equals(it.getPassword(), password)){
                return true;
            }
        }
        return false;
    }

    public void viewProfile(){
        return;
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

    public boolean logout(){
//        System.out.println("Slot has been booked successfully");
        return true;
    }

}
