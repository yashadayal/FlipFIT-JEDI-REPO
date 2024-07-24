package com.flipkart.bean;

/**
 * @author JEDI-04
 * Slots Class
 */

public class Slots {

    private int slotID;
    private int gymCentreID;
    private int capacity;
    private String date;
    private String startTime;
    private String endTime;

    /**
     * Retrieves the slot ID.
     * @return The slot ID.
     */
    public int getSlotID() {
        return slotID;
    }

    /**
     * Sets the slot ID.
     * @param slotID The slot ID to set.
     */
    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    /**
     * Retrieves the gym center ID associated with the slot.
     * @return The gym center ID.
     */
    public int getGymCentreID() {
        return gymCentreID;
    }

    /**
     * Sets the gym center ID associated with the slot.
     * @param gymCentreID The gym center ID to set.
     */
    public void setGymCentreID(int gymCentreID) {
        this.gymCentreID = gymCentreID;
    }

    /**
     * Retrieves the capacity of the slot.
     * @return The capacity of the slot.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the slot.
     * @param capacity The capacity to set.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Retrieves the date of the slot.
     * @return The date of the slot.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the slot.
     * @param date The date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Retrieves the start time of the slot.
     * @return The start time of the slot.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the slot.
     * @param startTime The start time to set.
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Retrieves the end time of the slot.
     * @return The end time of the slot.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the slot.
     * @param endTime The end time to set.
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
