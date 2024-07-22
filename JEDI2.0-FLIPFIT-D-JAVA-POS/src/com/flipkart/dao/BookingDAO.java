package com.flipkart.dao;

import com.flipkart.constants.Constants;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BookingDAO {
    Connection connection = DBUtils.getConnection();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();
    private final SlotDAO slotDao = new SlotDAO();
    private final GymCenterDAO gymCenterDao = new GymCenterDAO();

    public void bookSlot(int customerId, int slotId) throws BookingFailedException,SQLException {
        try {
            String insertQuery = Constants.INSERT_BOOKING;
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, customerId);
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
    public void cancelBooking() throws BookingFailedException, SQLException{

    }
}


