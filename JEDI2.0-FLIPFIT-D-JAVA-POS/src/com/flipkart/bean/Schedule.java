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

    /**
     * Retrieves the schedule ID.
     * @return The schedule ID.
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * Sets the schedule ID.
     * @param scheduleID The schedule ID to set.
     */
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    /**
     * Retrieves the slot ID associated with the schedule.
     * @return The slot ID.
     */
    public String getSlotID() {
        return slotID;
    }

    /**
     * Sets the slot ID associated with the schedule.
     * @param slotID The slot ID to set.
     */
    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    /**
     * Retrieves the date of the schedule.
     * @return The date of the schedule.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the schedule.
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retrieves the availability status of the schedule.
     * @return The availability status (number of available slots).
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Sets the availability status of the schedule.
     * @param availability The availability to set (number of available slots).
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
