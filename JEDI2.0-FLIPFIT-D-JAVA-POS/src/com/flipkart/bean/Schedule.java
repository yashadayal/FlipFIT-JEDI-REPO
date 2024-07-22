package com.flipkart.bean;

import java.util.Date;

/**
 * @author JEDI-04
 * Schedule Class
 */

public class Schedule {
    private String scheduleID;
    private Date date;
    private String slotID;
    private int availability;

    public String getScheduleID() {
        return scheduleID;
    }
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
