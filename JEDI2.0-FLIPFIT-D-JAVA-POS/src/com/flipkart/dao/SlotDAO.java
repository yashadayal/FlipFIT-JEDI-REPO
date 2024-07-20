package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slots;
import com.flipkart.exceptions.SQLExceptionHandler;
import com.flipkart.jdbc.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SlotDAO {
    private final GymCenterDAO gymCenterDao = new GymCenterDAO();
    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();

    public ArrayList<Slots> getSlotByCenterId(int gymCenterId) {
        Connection connection = null;
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

    public void removeSlot(int gymCenterId, int slotId) {
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

            String incrementQuery = "UPDATE flipfit_gymcenter SET gymCenterCapacity = gymCenterCapacity + 1 WHERE gymcenterId = ?";
            centerStatement = connection.prepareStatement(incrementQuery);
            centerStatement.setInt(1, fetchedGymCenterId);
            centerStatement.executeUpdate();

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
}
