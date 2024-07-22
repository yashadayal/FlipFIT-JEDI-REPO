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
    public void cancelBooking(String customerEmail, int bookingId) throws BookingNotFoundException, SQLException {
        String deleteQuery = "DELETE FROM flipfit_booking WHERE bookingId = ? AND customerEmail = ?)";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(deleteQuery);
            stmt.setInt(1, bookingId);
            stmt.setString(2, customerEmail);

            int rowsAffected = stmt.executeUpdate();
            int slotId = getSlotIdByBookingId(bookingId);

            if (slotId==-1) throw new BookingNotFoundException("slot id for booking id " + bookingId + " not found.");
            slotDao.incrementCapacity(slotId);

            int gymCenterId = slotDao.getGymCenterIdBySlotId(slotId);
            if (gymCenterId==-1) throw new BookingNotFoundException("Gym Center id for slot id " + slotId + " with booking id " + bookingId + " not found.");
            gymCenterDao.incrementCapacity(gymCenterId);

            if (rowsAffected > 0) {
                System.out.println("Booking with ID " + bookingId + " for customer with email " + customerEmail + " cancelled successfully.");
            } else {
                throw new BookingFailedException("Cancellation failed. No booking found with ID " + bookingId + " for customer with email " + customerEmail);
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public int getSlotIdByBookingId(int bookingId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int slotId = -1;
        String query = Constants.FETCH_GYM_WITH_SLOT;

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


