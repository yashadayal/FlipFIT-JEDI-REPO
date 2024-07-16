package com.flipkart.bean;

import java.util.List;

public class GymCenter{
    private int gymCenterId;

    public String getGymCenterLocation() {
        return gymCenterLocation;
    }

    public void setGymCenterLocation(String gymCenterLocation) {
        this.gymCenterLocation = gymCenterLocation;
    }

    public int getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(int gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    public List<Slots> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slots> slotList) {
        this.slotList = slotList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    private String gymCenterLocation;
    private List<Slots> slotList;
    private List<Customer> customerList;

}