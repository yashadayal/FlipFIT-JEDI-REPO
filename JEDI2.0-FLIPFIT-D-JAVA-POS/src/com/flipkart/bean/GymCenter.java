package com.flipkart.bean;

import java.util.List;

public class GymCenter{
    private int gymCenterId;
    private int gymOwnerID;
    private String gymCenterName;
    private String gymCenterLocation;
    protected String gymCenterGSTin;
    private int gymCenterCapacity;
    private int gymCenterPrice;
    private boolean isGymCenterApproved;

    public int getGymCenterCapacity() {
        return gymCenterCapacity;
    }

    public void setGymCenterCapacity(int gymCenterCapacity) {
        this.gymCenterCapacity = gymCenterCapacity;
    }

    public int getGymCenterPrice() {
        return gymCenterPrice;
    }

    public void setGymCenterPrice(int gymCenterPrice) {
        this.gymCenterPrice = gymCenterPrice;
    }

    public boolean getIsGymCenterApproved() {
        return isGymCenterApproved;
    }

    public void setIsGymCenterApproved(boolean isGymCenterApproved) {
        this.isGymCenterApproved = isGymCenterApproved;
    }

    public int getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(int gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    public int getGymOwnerID() {
        return gymOwnerID;
    }

    public void setGymOwnerID(int gymOwnerID) {
        this.gymOwnerID = gymOwnerID;
    }

    public String getGymCenterName() {
        return gymCenterName;
    }

    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    public String getGymCenterLocation() {
        return gymCenterLocation;
    }

    public void setGymCenterLocation(String gymCenterLocation) {
        this.gymCenterLocation = gymCenterLocation;
    }

    public String getGstin() {
        return gymCenterGSTin;
    }

    public void setGstin(String gymCenterGstin) {
        this.gymCenterGSTin = gymCenterGstin;
    }
}