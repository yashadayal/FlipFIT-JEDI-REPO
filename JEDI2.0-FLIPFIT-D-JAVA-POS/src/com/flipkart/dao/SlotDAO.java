package com.flipkart.dao;

import com.flipkart.bean.Slots;
import com.flipkart.constants.Constants;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * @author JEDI-04
 * Java class for Slot Dao Operations
 */

public class SlotDAO {
    private final GymCenterDAO gymCenterDao = new GymCenterDAO();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();
    Connection connection = DBUtils.getConnection();

    public ArrayList<Slots> getSlotByCenterId(int gymCenterId) {
        ArrayList<Slots> slots = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = Constants.FETCH_SLOTS_WITH_ID;

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, gymCenterId);

            resultSet = preparedStatement.executeQuery();
            System.out.println("|   Slot Id   |  Gym Center Id  |  Capacity  |    Date    |  Start Time          |  End Time            |");
            System.out.println("|-------------|-----------------|------------|------------|--------------------- |----------------------|");

            while (resultSet.next()) {
                Slots slot = new Slots();
                slot.setSlotID(resultSet.getInt("slotId"));
                slot.setGymCentreID(resultSet.getInt("gymCenterId"));
                slot.setCapacity(resultSet.getInt("capacity"));
                slot.setDate(resultSet.getString("date"));
                slot.setStartTime(String.valueOf(resultSet.getTimestamp("startTime")));
                slot.setEndTime(String.valueOf(resultSet.getTimestamp("endTime")));


                System.out.printf("| %-12s| %-16s| %-11s| %-11s| %-14s  | %-12s  |%n",
                        resultSet.getString("slotId"),
                            resultSet.getString("gymCenterId"),
                            resultSet.getString("capacity"),
                            resultSet.getString("date"),
                            resultSet.getString("startTime"),
                            resultSet.getString("endTime"));

//                System.out.println("---------------------------------------------------------");

                slots.add(slot);
            }
        } catch (SQLException e) {
            sqlExceptionHandler.printSQLException(e);
        }
        return slots;
    }

    public void removeSlot(int gymCenterId, int slotId){
        Connection connection = null;
        PreparedStatement slotStatement = null;
        PreparedStatement centerStatement = null;
        ResultSet resultSet = null;

        try {
            String fetchQuery = Constants.FETCH_GYM_WITH_SLOT;
            connection = DBUtils.getConnection();
            slotStatement = connection.prepareStatement(fetchQuery);
            slotStatement.setInt(1, slotId);

            resultSet = slotStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Incorrect data: No slot found with slot id " + slotId + " and gym center id " + gymCenterId);
                return;
            }

            int fetchedGymCenterId = resultSet.getInt("gymCenterId");

            String removeQuery = Constants.DELETE_SLOT;
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
        String insertQuery = Constants.INSERT_SLOT;
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

        String query = Constants.FETCH_CAPACITY;
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
        String query = Constants.DECREMENT_SLOT_CAPACITY;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, slotId);
        preparedStatement.executeUpdate();
    }

    public void incrementCapacity(int slotId)  throws SQLException {
        PreparedStatement preparedStatement = null;
        String query = Constants.INCREMENT_SLOT_CAPACITY;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, slotId);
        preparedStatement.executeUpdate();
    }

    public int getGymCenterIdBySlotId(int slotId) throws SQLException {
        String query = Constants.FETCH_GYM_WITH_SLOT;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setInt(1, slotId);
        ResultSet rs1 = stmt1.executeQuery();
        rs1.next();
        int gymCenterId = rs1.getInt("gymCenterId");
        return gymCenterId;
    }

}
