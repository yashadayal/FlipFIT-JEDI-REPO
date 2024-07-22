package com.flipkart.business;

import com.flipkart.dao.SlotDAO;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.RegistrationFailedException;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author JEDI-04
 * Java class for Slot Service Operations
 */

public class SlotService {
    private static SlotDAO slotDao = new SlotDAO();

    /**
     * Method for adding slot
     * @param gymCenterId
     * @param capacity
     * @param date
     * @param startTime
     * @param endTime
     * @throws SQLException
     */
    public void addSlot(int gymCenterId, int capacity, String date, LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        slotDao.addSlot(gymCenterId, capacity, date, startTime, endTime);
    }

    /**
     * Method for removing slot
     * @param gymCenterId
     * @param slotId
     */
    public void removeSlot(int gymCenterId, int slotId){
        slotDao.removeSlot(gymCenterId, slotId);
    }

    /**
     * Method for checking if slot available or not
     * @param slotId
     * @throws SQLException
     */
    public boolean isAvailableSlot(int slotId) throws SQLException {
        return slotDao.isAvailableSlot(slotId);
    }
}
