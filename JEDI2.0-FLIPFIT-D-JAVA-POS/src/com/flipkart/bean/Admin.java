package com.flipkart.bean;

/**
 * @author JEDI-04
 * Admin Class
 */

public class Admin extends User{
    private int adminId; // Unique identifier for the admin
    private String adminName; // Name of the admin

    /**
     * Retrieves the admin ID.
     *
     * @return The admin ID
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Sets the admin ID.
     *
     * @param adminId The admin ID to set
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Retrieves the admin name.
     *
     * @return The admin name
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * Sets the admin name.
     *
     * @param adminName The admin name to set
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}