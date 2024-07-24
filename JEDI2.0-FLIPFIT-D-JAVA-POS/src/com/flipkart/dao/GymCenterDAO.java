package com.flipkart.dao;

import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.constants.Constants;
import com.flipkart.jdbc.DBUtils;

import java.sql.*;
import java.util.Date;

/**
 * @author JEDI-04
 * Java class for Gym Center Dao Operations
 */

public class GymCenterDAO {
    private Connection connection = DBUtils.getConnection();

    /**
     * Retrieves the owner ID associated with the given email.
     *
     * @param email The email of the gym center owner
     * @return The owner ID
     * @throws GymCentreNotFoundException If the owner ID is not found
     * @throws SQLException              If a database access error occurs
     */
    private int getOwnerIdByEmail(String email) throws GymCentreNotFoundException, SQLException {
        String query = Constants.FETCH_OWNER;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, email);
        ResultSet rs1 = stmt1.executeQuery();
        rs1.next();
        int ownerId = rs1.getInt("ownerId");
        return ownerId;
    }

    /**
     * Registers a new gym center.
     *
     * @param email            The email of the gym center owner
     * @param gymCenterName    The name of the gym center
     * @param gymCenterGSTin   The GSTIN of the gym center
     * @param gymCenterCapacity The capacity of the gym center
     * @param gymCenterPrice   The price of the gym center
     * @throws GymCentreNotFoundException If the owner ID is not found
     * @throws SQLException              If a database access error occurs
     * @throws RegistrationFailedException If gym center registration fails
     */
    public void registerGymCenter(String email, String gymCenterName, String gymCenterGSTin, int gymCenterCapacity, int gymCenterPrice) throws GymCentreNotFoundException, SQLException, RegistrationFailedException {

        int ownerId = getOwnerIdByEmail(email);
        String query = Constants.INSERT_GYM_DATA;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, gymCenterName);
        stmt1.setString(2, gymCenterGSTin);
        stmt1.setInt(3, gymCenterCapacity);
        stmt1.setInt(4, gymCenterPrice);
        stmt1.setInt(5, ownerId);
        stmt1.executeUpdate();
        System.out.println("Gym center registered successfully. Pending for approval");
    }

    /**
     * View gym centers associated with a specific owner email.
     *
     * @param email The email of the gym center owner
     * @throws GymCentreNotFoundException If the owner ID is not found
     * @throws SQLException              If a database access error occurs
     */
    public void viewGymCenterByEmail(String email) throws GymCentreNotFoundException, SQLException {
        int ownerId = getOwnerIdByEmail(email);
        String query = Constants.FETCH_GYMCENTER_WITH_OWNER;
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, ownerId);
        ResultSet rs= stmt.executeQuery();
        printGymCentersInfo(rs);
    }


    /**
     * View all registered gym centers.
     *
     * @throws GymCentreNotFoundException If no gym centers are found
     * @throws SQLException              If a database access error occurs
     */
    public void viewAllGymCenters() throws GymCentreNotFoundException, SQLException {

        String query = Constants.FETCH_GYMCENTER;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        printGymCentersInfo(rs);
    }

    /**
     * View approval status of a gym center by its ID.
     *
     * @param gymCenterId The ID of the gym center
     * @return true if the gym center is approved, false otherwise
     * @throws GymCentreNotFoundException If the gym center ID is incorrect
     * @throws SQLException              If a database access error occurs
     */
    public boolean viewGymCenterApprovalStatusByGymCenterId(String gymCenterId) throws GymCentreNotFoundException, SQLException {
        String query = Constants.FETCH_GYMCENTER_WITH_ID;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        stmt1.setString(1, gymCenterId);
        ResultSet rs = stmt1.executeQuery();
        if (!rs.next()) {
            System.out.println("Incorrect GYM Center Id");
        }
        return rs.getBoolean("isGymCenterApproved");
    }

    /**
     * View pending gym centers awaiting approval.
     *
     * @throws GymCentreNotFoundException If no pending gym centers are found
     * @throws SQLException              If a database access error occurs
     */
    public void viewPendingGymCentersList() throws GymCentreNotFoundException, SQLException {
        String query = Constants.FETCH_NOT_APPROVED_GYM;
        PreparedStatement stmt1 = connection.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        printGymCentersInfo(rs);
    }

    /**
     * Increment capacity of a gym center by its ID.
     *
     * @param gymCenterId The ID of the gym center
     * @throws GymCentreNotFoundException If the gym center ID is incorrect
     * @throws SQLException              If a database access error occurs
     */
    public void incrementCapacity(int gymCenterId)  throws GymCentreNotFoundException, SQLException {
        PreparedStatement preparedStatement = null;
        String query = Constants.INCREMENT_CAPACITY;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, gymCenterId);
        preparedStatement.executeUpdate();
    }

    /**
     * Decrement capacity of a gym center by its ID.
     *
     * @param gymCenterId The ID of the gym center
     * @throws GymCentreNotFoundException If the gym center ID is incorrect
     * @throws SQLException              If a database access error occurs
     */
    public void decrementCapacity(int gymCenterId)  throws GymCentreNotFoundException, SQLException {
        PreparedStatement preparedStatement = null;
        String query = Constants.DECREMENT_CAPACITY;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, gymCenterId);
        preparedStatement.executeUpdate();
    }

    /**
     * Approve all pending gym centers.
     *
     * @throws SQLException If a database access error occurs
     */
    public void approveAllPendingGymCenters() throws SQLException {
        String updateQuery = "UPDATE flipfit_gymcenter SET isGymCenterApproved = 1 WHERE isGymCenterApproved = 0";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(updateQuery);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " gym centers approved successfully.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /**
     * Approve a gym center by its ID.
     *
     * @param gymCenterId The ID of the gym center to approve
     * @throws SQLException              If a database access error occurs
     * @throws GymCentreNotFoundException If the gym center ID is incorrect
     */
    public void approveGymCenterById(int gymCenterId) throws SQLException, GymCentreNotFoundException {
        String updateQuery = "UPDATE flipfit_gymcenter SET isGymCenterApproved = 1 WHERE gymcenterId = ?";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(updateQuery);
            stmt.setInt(1, gymCenterId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gym center with ID " + gymCenterId + " approved successfully.");
            } else {
                System.out.println("No gym center found with ID " + gymCenterId);
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /**
     * View approved gym centers associated with a specific owner email.
     *
     * @param email The email of the gym center owner
     * @throws GymCentreNotFoundException If the owner ID is not found
     * @throws SQLException              If a database access error occurs
     */
    public void viewApprovedGymCenterByEmail(String email) throws GymCentreNotFoundException, SQLException {

        int ownerID = getOwnerIdByEmail(email);
        PreparedStatement stmt1 = connection.prepareStatement(Constants.FETCH_APPROVED_GYMCENTER_BY_EMAIL);
        stmt1.setInt(1, ownerID);
        ResultSet rs = stmt1.executeQuery();
        printGymCentersInfo(rs);
    }

    /**
     * Adds a slot for a gym center.
     *
     * @param gymCenterId   The ID of the gym center
     * @param startDateTime The start date and time of the slot
     * @param endDateTime   The end date and time of the slot
     * @param capacity      The capacity of the slot
     * @throws GymCentreNotFoundException If the gym center ID is incorrect
     * @throws SQLException              If a database access error occurs
     */
    public void addSlot(int gymCenterId, Date startDateTime, Date endDateTime, int capacity) throws GymCentreNotFoundException, SQLException {
        String query = "INSERT INTO flipfit_slots (gymCenterId, startTime, endTime, capacity, date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, gymCenterId);
        stmt.setTimestamp(2, new Timestamp(startDateTime.getTime()));
        stmt.setTimestamp(3, new Timestamp(endDateTime.getTime()));
        stmt.setInt(4, capacity);
        stmt.setDate(5, new java.sql.Date(startDateTime.getDate()));
        stmt.executeUpdate();
        System.out.println("Slot successfully added.");

    }

    /**
     * Prints the gym center information from the given result set.
     *
     * @param rs The result set containing gym center information
     * @throws SQLException If a database access error occurs
     */
    public void printGymCentersInfo(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            System.out.println("There are no data available.\n");
            return;
        }

        System.out.printf("| %-20s | %-10s | %-30s | %-7s | %-17s | %-12s | %-25s |\n",
                "gymCenterName", "gymCenterId", "gymCenterLocation", "ownerId", "gymCenterCapacity", "gymCenterPrice", "isGymCenterApproved");
        System.out.println("|----------------------|-------------|--------------------------------|---------|-------------------|----------------|---------------------------|");

        do {
            System.out.printf("| %-20s | %-11d | %-30s | %-7d | %-17d | %-14d | %-25s |\n",
                    rs.getString("gymCenterName"),
                    rs.getInt("gymCenterId"),
                    rs.getString("gymCenterLocation"),
                    rs.getInt("ownerId"),
                    rs.getInt("gymCenterCapacity"),
                    rs.getInt("gymCenterPrice"),
                    rs.getInt("isGymCenterApproved")
            );
        } while (rs.next());

    }
}


