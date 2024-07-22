package com.flipkart.bean;

/**
 * @author JEDI-04
 * Admin Class
 */

public class Admin extends User{
    private int adminId;
    private String adminName;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}