package com.flipkart.business;

import com.flipkart.dao.BookingDAO;
import com.flipkart.exceptions.BookingFailedException;

import java.sql.SQLException;

/**
 * @author JEDI-04
 * Java class for Booking Service Operations
 */

public class BookingService {
    private static final BookingDAO bookingDAO = new BookingDAO();
    private static SlotService slotService = new SlotService();

    public void bookSlot(int customerId, String email, int slotId) throws BookingFailedException, SQLException {
        boolean isAvailableSlot = false;
        try {
            isAvailableSlot = slotService.isAvailableSlot(slotId);
        } catch (BookingFailedException | SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!isAvailableSlot){
            System.out.println("No seats available for the booking");
            return;
        }
        bookingDAO.bookSlot(customerId, email, slotId);
    }

    public void cancelBooking() throws BookingFailedException, SQLException{

    }
}
