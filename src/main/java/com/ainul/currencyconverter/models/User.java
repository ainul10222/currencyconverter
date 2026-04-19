package com.ainul.currencyconverter.models;

/**
 * User model for authentication
 */
public class User {
    private String username;
    private String password;
    private String email;
    private boolean isGuest;

    public User(String username, String password, String email, boolean isGuest) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isGuest = isGuest;
    }

    public User(boolean isGuest) {
        this.username = "Guest";
        this.isGuest = isGuest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGuest() {
        return isGuest;
    }

    public void setGuest(boolean guest) {
        isGuest = guest;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", email='" + email + '\'' + ", isGuest="
                + isGuest + '}';
    }
}
