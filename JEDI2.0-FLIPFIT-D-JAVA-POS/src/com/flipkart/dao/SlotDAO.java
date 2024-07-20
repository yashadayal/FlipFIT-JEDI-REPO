package com.flipkart.dao;

import com.flipkart.bean.Slots;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class SlotDAO {
    private final GymCenterDAO gymCenterDao = new GymCenterDAO();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();
    Connection connection = DBUtils.getConnection();

    public ArrayList<Slots> getSlotByCenterId(int gymCenterId) {
        ArrayList<Slots> slots = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM flipfit_slots WHERE gymCenterId = ?";

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, gymCenterId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Slots slot = new Slots();
                slot.setSlotID(resultSet.getInt("slotId"));
                slot.setGymCentreID(resultSet.getInt("gymCenterId"));
                slot.setCapacity(resultSet.getInt("capacity"));
                slot.setDate(resultSet.getString("date"));
                slot.setStartTime(String.valueOf(resultSet.getTimestamp("startTime")));
                slot.setEndTime(String.valueOf(resultSet.getTimestamp("endTime")));

                slots.add(slot);
            }
            resultSet.close();
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                sqlExceptionHandler.printSQLException(e);
            }
        }
        return slots;
    }

    public void removeSlot(int gymCenterId, int slotId){
        Connection connection = null;
        PreparedStatement slotStatement = null;
        PreparedStatement centerStatement = null;
        ResultSet resultSet = null;

        try {
            String fetchQuery = "SELECT gymCenterId FROM flipfit_slots WHERE slotId = ?";
            connection = DBUtils.getConnection();
            slotStatement = connection.prepareStatement(fetchQuery);
            slotStatement.setInt(1, slotId);

            resultSet = slotStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Incorrect data: No slot found with slot id " + slotId + " and gym center id " + gymCenterId);
                return;
            }

            int fetchedGymCenterId = resultSet.getInt("gymCenterId");

            String removeQuery = "DELETE FROM flipfit_slots WHERE slotId = ?";
            slotStatement = connection.prepareStatement(removeQuery);
            slotStatement.setInt(1, slotId);
            slotStatement.executeUpdate();

            gymCenterDao.decrementCapacity(gymCenterId);

        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                sqlExceptionHandler.printSQLException(e);
            }
        }
    }

    public void addSlot(int gymCenterId, int capacity, String date, LocalDateTime startTime, LocalDateTime endTime) throws SQLException{
        PreparedStatement slotStatement = null;
        String insertQuery = "INSERT INTO flipfit_slots (gymCenterId, capacity, date, startTime, endTime) VALUES (?, ?, ?, ?, ?)";
        slotStatement = connection.prepareStatement(insertQuery);
        slotStatement.setInt(1, gymCenterId);
        slotStatement.setInt(2, capacity);
        slotStatement.setString(3, date);
        slotStatement.setTimestamp(4, Timestamp.valueOf(startTime));
        slotStatement.setTimestamp(5, Timestamp.valueOf(endTime));

        int rowsAffected = slotStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Slot added successfully.");
        } else {
            System.out.println("Failed to add slot.");
        }
        gymCenterDao.incrementCapacity(gymCenterId);
    }

    public boolean isAvailableSlot(int slotId) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "SELECT capacity FROM flipfit_slots WHERE slotId = ?";
        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, slotId);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int capacity = resultSet.getInt("capacity");
            return capacity > 0;
        }

        return false;
    }

    public void decrementCapacity(int slotId)  throws SQLException {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE flipfit_slots SET capacity = capacity - 1 WHERE slotId = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, slotId);
        preparedStatement.executeUpdate();
    }

    public int getGymCenterIdBySlotId(int slotId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int gymCenterId = -1;
        String query = "SELECT gymCenterId FROM flipfit_slots WHERE slotId = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, slotId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            gymCenterId = resultSet.getInt("gymCenterId");
        } else {
            System.out.println("No gym center found for slotId: " + slotId);
        }

        return gymCenterId;
    }

}
