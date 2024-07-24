package com.flipkart.dao;

import com.flipkart.constants.Constants;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.exceptions.BookingNotFoundException;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * @author JEDI-04
 * Java class for Booking Dao Operations
 */

public class BookingDAO {
    Connection connection = DBUtils.getConnection();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();
    private final SlotDAO slotDao = new SlotDAO();
    private final GymCenterDAO gymCenterDao = new GymCenterDAO();

    /**
     * Method to book a slot for a customer.
     *
     * @param email The email of the customer booking the slot
     * @param slotId The ID of the slot to be booked
     * @throws BookingFailedException If booking the slot fails
     * @throws SQLException If a database access error occurs
     */
    public void bookSlot( String email, int slotId) throws BookingFailedException,SQLException {
        try {
            String insertQuery = Constants.INSERT_BOOKING;
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            insertStatement.setInt(1, customerId);
            insertStatement.setString(1, email);
            insertStatement.setInt(2, slotId);

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Booking added successfully.");
            } else {
                System.out.println("Failed to add booking.");
            }

            slotDao.decrementCapacity(slotId);

            int gymCenterId = slotDao.getGymCenterIdBySlotId(slotId);
            if (gymCenterId != -1){
                gymCenterDao.decrementCapacity(gymCenterId);
            }

        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }
    }

    /**
     * Method to cancel a booking for a customer.
     *
     * @param customerEmail The email of the customer cancelling the booking
     * @param bookingId The ID of the booking to be cancelled
     * @throws BookingNotFoundException If the booking to be cancelled is not found
     * @throws SQLException If a database access error occurs
     */
    public void cancelBooking(String customerEmail, int bookingId) throws BookingNotFoundException, SQLException {
        String deleteQuery = "DELETE FROM flipfit_booking WHERE bookingId = ? AND customerId = (SELECT customerId FROM flipfit_customer WHERE email = ?)";
        PreparedStatement stmt = null;
//            stmt = connection.prepareStatement(deleteQuery);
//            stmt.setInt(1, bookingId);
//            stmt.setString(2, customerEmail);
//            System.out.println("query run");
//            int rowsAffected = stmt.executeUpdate();

        if (bookingId > 0) {
            int slotId = getSlotIdByBookingId(bookingId);
            if (slotId == -1) {
                throw new BookingNotFoundException("Slot ID for booking ID " + bookingId + " not found.");
            }
            slotDao.incrementCapacity(slotId);
            int gymCenterId = slotDao.getGymCenterIdBySlotId(slotId);
            if (gymCenterId == -1) {
                throw new BookingNotFoundException("Gym Center ID for slot ID " + slotId + " with booking ID " + bookingId + " not found.");
            }
            gymCenterDao.incrementCapacity(gymCenterId);
            System.out.println("Booking with ID " + bookingId + " for customer with email " + customerEmail + " cancelled successfully.");
        } else {
            throw new BookingNotFoundException("Cancellation failed. No booking found with ID " + bookingId + " for customer with email " + customerEmail);
        }
    }

    /**
     * Method to retrieve slot ID from booking ID.
     *
     * @param bookingId The ID of the booking for which slot ID is to be retrieved
     * @return The slot ID associated with the given booking ID, or -1 if not found
     * @throws SQLException If a database access error occurs
     */
    public int getSlotIdByBookingId(int bookingId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int slotId = -1;
        String query = Constants.FETCH_SLOT_WITH_BOOKING;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookingId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            slotId = resultSet.getInt("slotId");
        } else {
            System.out.println("No slot found for bookingId: " + bookingId);
        }

        return slotId;
    }

}


