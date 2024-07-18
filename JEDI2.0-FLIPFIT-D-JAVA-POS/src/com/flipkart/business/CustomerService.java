package com.flipkart.business;

import com.flipkart.dao.CustomerDAO;

import java.util.List;

public class CustomerService {

    CustomerDAO userDao = new CustomerDAO();
    public boolean registerCustomer(String name, String email, String password)
    {
        boolean registerSuccess = false;
        registerSuccess = CustomerDAO.registerCustomer(name,email,password);
        return registerSuccess;

    }

    public boolean loginCustomer(String email, String password){
        boolean loginSuccess = false;
        loginSuccess = CustomerDAO.loginCustomer(email,password);
        return loginSuccess;
    }

    public List<String> viewGymCenter(){
//        List<String> gymCenter;
//        System.out.println("List of available centers are: "+ gymCenter);
//        return gymCenter;
        return null;
    }
    public boolean bookSlot(){
        System.out.println("Slot has been booked successfully");
        return true;
    }

    public boolean modifySlot(){
        System.out.println("Slot has been canceled successfully");
        return true;
    }

}
