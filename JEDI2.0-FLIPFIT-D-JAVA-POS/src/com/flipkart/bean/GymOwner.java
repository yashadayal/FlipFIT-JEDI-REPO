package com.flipkart.bean;

import java.util.List;

/**
 * @author JEDI-04
 * Gym Owner Class
 */

    public class GymOwner {

        private int ownerID;         // Unique identifier for the gym owner
        private String name;         // Name of the gym owner
        private String email;        // Email address of the gym owner
        private String password;     // Password of the gym owner
        private String phone;        // Phone number of the gym owner
        private String panCard;      // PAN card number of the gym owner
        private String aadharCard;   // Aadhar card number of the gym owner
        private boolean isApproved;  // Approval status of the gym owner

        /**
         * Retrieves the Aadhar card number of the gym owner.
         *
         * @return The Aadhar card number
         */
        public String getAadharCard() {
            return aadharCard;
        }

        /**
         * Sets the Aadhar card number of the gym owner.
         *
         * @param aadharCard The Aadhar card number to set
         */
        public void setAadharCard(String aadharCard) {
            this.aadharCard = aadharCard;
        }

        /**
         * Retrieves the unique identifier of the gym owner.
         *
         * @return The gym owner ID
         */
        public int getOwnerID() {
            return ownerID;
        }

        /**
         * Sets the unique identifier for the gym owner.
         *
         * @param ownerID The gym owner ID to set
         */
        public void setOwnerID(int ownerID) {
            this.ownerID = ownerID;
        }

        /**
         * Retrieves the name of the gym owner.
         *
         * @return The name of the gym owner
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the gym owner.
         *
         * @param name The name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Retrieves the email address of the gym owner.
         *
         * @return The email address
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the email address of the gym owner.
         *
         * @param email The email address to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * Retrieves the password of the gym owner.
         *
         * @return The password
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets the password of the gym owner.
         *
         * @param password The password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * Retrieves the phone number of the gym owner.
         *
         * @return The phone number
         */
        public String getPhone() {
            return phone;
        }

        /**
         * Sets the phone number of the gym owner.
         *
         * @param phone The phone number to set
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * Retrieves the PAN card number of the gym owner.
         *
         * @return The PAN card number
         */
        public String getPanCard() {
            return panCard;
        }

        /**
         * Sets the PAN card number of the gym owner.
         *
         * @param panCard The PAN card number to set
         */
        public void setPanCard(String panCard) {
            this.panCard = panCard;
        }

        /**
         * Checks if the gym owner is approved.
         *
         * @return true if the gym owner is approved, false otherwise
         */
        public boolean isApproved() {
            return isApproved;
        }

        /**
         * Sets the approval status of the gym owner.
         *
         * @param approved The approval status to set
         */
        public void setApproved(boolean approved) {
            isApproved = approved;
        }
    }
