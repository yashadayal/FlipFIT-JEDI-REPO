package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerDAO {
     static ArrayList<Customer> registeredCustomers=new ArrayList<>();

   public void getCustomerById(Integer id){

    }
    public static boolean registerCustomer(String name, String email, String password) {

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

    public static boolean loginCustomer(String email, String password){

        for(Customer it:registeredCustomers){
            if(Objects.equals(it.getEmail(), email) && Objects.equals(it.getPassword(), password)){
                return true;
            }
        }
        return false;
    }
}
