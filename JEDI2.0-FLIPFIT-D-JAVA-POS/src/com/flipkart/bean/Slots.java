package com.flipkart.bean;

public class Slots {

    private int slotID;
    private int gymCentreID;
    private int capacity;
    private String date;
    private String startTime;
    private String endTime;

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public int getGymCentreID() {
        return gymCentreID;
    }

    public void setGymCentreID(int gymCentreID) {
        this.gymCentreID = gymCentreID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
