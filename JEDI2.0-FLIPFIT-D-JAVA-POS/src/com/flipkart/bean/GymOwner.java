package com.flipkart.bean;

import java.util.List;

public class GymOwner {

    private int ownerID;
    private boolean isApproved;
    private List<String> centerList;

    public List<String> getCenterList() {
        return centerList;
    }

    public void setCenterList(List<String> centerList) {
        this.centerList = centerList;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
