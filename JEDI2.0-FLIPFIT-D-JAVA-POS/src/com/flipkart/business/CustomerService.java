package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.dao.CustomerDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerService {
    static ArrayList<Customer> registeredCustomers=new ArrayList<>();
    public boolean registerCustomer(String name, String email, String password)
    {
        Customer customer=new Customer();
        customer.setCustomerName(name);
        customer.setPassword(password);
        customer.setEmail(email);
        if(registeredCustomers.isEmpty()||!registeredCustomers.contains(customer)) {
            registeredCustomers.add(customer);
            return true;
        }
        return false;
    }

    public boolean loginCustomer(String email, String password){
        for(Customer it:registeredCustomers){
            if(Objects.equals(it.getEmail(), email) && Objects.equals(it.getPassword(), password)){
                return true;
            }
        }
        return false;
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
