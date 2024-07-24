package com.flipkart.bean;

/**
 * @author JEDI-04
 * User Class
 */

public class User {

    private String userID;
    private String userName;
    private String email;
    private String password;
    private Role role;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Parameterized constructor to initialize a User object.
     * @param id The ID of the user.
     * @param userName The user's username.
     * @param email The user's email address.
     * @param password The user's password.
     * @param role The role of the user (Admin, Gym Owner, Gym Customer).
     */
    public User(String id, String userName, String email, String password, Role role) {
        this.userID = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Retrieves the role of the user.
     * @return The role of the user.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * @param role The role to set for the user.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Retrieves the user ID.
     * @return The user ID.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user ID.
     * @param userID The user ID to set.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the username of the user.
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the email address of the user.
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the password of the user.
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the User object.
     * @return A string representation containing user details.
     */
    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

