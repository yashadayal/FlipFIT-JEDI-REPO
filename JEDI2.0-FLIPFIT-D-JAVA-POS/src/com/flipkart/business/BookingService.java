package com.flipkart.business;

import com.flipkart.dao.BookingDAO;

import java.sql.SQLException;

public class BookingService {
    private static final BookingDAO bookingDAO = new BookingDAO();
    private static SlotService slotService = new SlotService();

    public void bookSlot(int customerId, int slotId) throws SQLException {
        boolean isAvailableSlot = slotService.isAvailableSlot(slotId);
        if(!isAvailableSlot){
            System.out.println("No seats available for the booking");
            return;
        }
        bookingDAO.bookSlot(customerId, slotId);
    }

    public void cancelBooking(){

    }
}
