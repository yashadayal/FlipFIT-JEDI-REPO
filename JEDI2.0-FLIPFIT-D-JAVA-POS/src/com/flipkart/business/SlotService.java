package com.flipkart.business;

import com.flipkart.dao.SlotDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class SlotService {
    private static SlotDAO slotDao = new SlotDAO();

    public void addSlot(int gymCenterId, int capacity, String date, LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        slotDao.addSlot(gymCenterId, capacity, date, startTime, endTime);
    }
    public void removeSlot(int gymCenterId, int slotId){
        slotDao.removeSlot(gymCenterId, slotId);
    }
    public boolean isAvailableSlot(int slotId) throws SQLException {
        return slotDao.isAvailableSlot(slotId);
    }
}
