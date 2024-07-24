package com.flipkart.bean;

import java.util.List;

/**
 * @author JEDI-04
 * Gym Center Class
 */

public class GymCenter {

    private int gymCenterId;             // Unique identifier for the gym center
    private int gymOwnerID;              // ID of the gym owner associated with the gym center
    private String gymCenterName;        // Name of the gym center
    private String gymCenterLocation;    // Location of the gym center
    protected String gymCenterGSTin;     // GSTIN of the gym center
    private int gymCenterCapacity;       // Capacity of the gym center
    private int gymCenterPrice;          // Price of services at the gym center
    private boolean isGymCenterApproved; // Approval status of the gym center

    /**
     * Retrieves the capacity of the gym center.
     *
     * @return The capacity of the gym center
     */
    public int getGymCenterCapacity() {
        return gymCenterCapacity;
    }

    /**
     * Sets the capacity of the gym center.
     *
     * @param gymCenterCapacity The capacity to set
     */
    public void setGymCenterCapacity(int gymCenterCapacity) {
        this.gymCenterCapacity = gymCenterCapacity;
    }

    /**
     * Retrieves the price of services at the gym center.
     *
     * @return The price of services at the gym center
     */
    public int getGymCenterPrice() {
        return gymCenterPrice;
    }

    /**
     * Sets the price of services at the gym center.
     *
     * @param gymCenterPrice The price to set
     */
    public void setGymCenterPrice(int gymCenterPrice) {
        this.gymCenterPrice = gymCenterPrice;
    }

    /**
     * Retrieves the approval status of the gym center.
     *
     * @return The approval status of the gym center
     */
    public boolean getIsGymCenterApproved() {
        return isGymCenterApproved;
    }

    /**
     * Sets the approval status of the gym center.
     *
     * @param isGymCenterApproved The approval status to set
     */
    public void setIsGymCenterApproved(boolean isGymCenterApproved) {
        this.isGymCenterApproved = isGymCenterApproved;
    }

    /**
     * Retrieves the unique identifier of the gym center.
     *
     * @return The gym center ID
     */
    public int getGymCenterId() {
        return gymCenterId;
    }

    /**
     * Sets the unique identifier for the gym center.
     *
     * @param gymCenterId The gym center ID to set
     */
    public void setGymCenterId(int gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    /**
     * Retrieves the ID of the gym owner associated with the gym center.
     *
     * @return The gym owner ID
     */
    public int getGymOwnerID() {
        return gymOwnerID;
    }

    /**
     * Sets the ID of the gym owner associated with the gym center.
     *
     * @param gymOwnerID The gym owner ID to set
     */
    public void setGymOwnerID(int gymOwnerID) {
        this.gymOwnerID = gymOwnerID;
    }

    /**
     * Retrieves the name of the gym center.
     *
     * @return The name of the gym center
     */
    public String getGymCenterName() {
        return gymCenterName;
    }

    /**
     * Sets the name of the gym center.
     *
     * @param gymCenterName The name to set
     */
    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    /**
     * Retrieves the location of the gym center.
     *
     * @return The location of the gym center
     */
    public String getGymCenterLocation() {
        return gymCenterLocation;
    }

    /**
     * Sets the location of the gym center.
     *
     * @param gymCenterLocation The location to set
     */
    public void setGymCenterLocation(String gymCenterLocation) {
        this.gymCenterLocation = gymCenterLocation;
    }

    /**
     * Retrieves the GSTIN (Goods and Services Tax Identification Number) of the gym center.
     *
     * @return The GSTIN of the gym center
     */
    public String getGstin() {
        return gymCenterGSTin;
    }

    /**
     * Sets the GSTIN (Goods and Services Tax Identification Number) for the gym center.
     *
     * @param gymCenterGstin The GSTIN to set
     */
    public void setGstin(String gymCenterGstin) {
        this.gymCenterGSTin = gymCenterGstin;
    }
}
