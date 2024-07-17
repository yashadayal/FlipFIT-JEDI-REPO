package com.flipkart.dao;

public interface GymOwnerInterfaceDAO {

    public void sendOwnerApprovalRequest(String gymOwnerId);
    public void setPendingGymOwnerList();

}
