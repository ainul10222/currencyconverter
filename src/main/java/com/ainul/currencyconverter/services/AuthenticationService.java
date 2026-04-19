package com.ainul.currencyconverter.services;

import com.ainul.currencyconverter.models.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Service for user authentication
 */
public class AuthenticationService {
    private Map<String, User> registeredUsers;
    private User currentUser;

    public AuthenticationService() {
        registeredUsers = new HashMap<>();
        initializeSampleUsers();
    }

    private void initializeSampleUsers() {
        // Add predefined users for login
        registeredUsers.put("Ainul10222",
                new User("Ainul10222", "ainul10222", "ainul10222@example.com", false));
        registeredUsers.put("rafisarkar0128",
                new User("rafisarkar0128", "rafisarkar0128", "rafisarkar0128@example.com", false));
        registeredUsers.put("123", new User("123", "123456789", "123@gmail.com", false));
    }

    /**
     * Register a new user
     */
    public boolean register(String username, String password, String email) {
        if (registeredUsers.containsKey(username)) {
            return false; // User already exists
        }

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false; // Invalid input
        }

        User newUser = new User(username, password, email, false);
        registeredUsers.put(username, newUser);
        return true;
    }

    /**
     * Login user
     */
    public boolean login(String username, String password) {
        User user = registeredUsers.get(username);

        if (user == null) {
            return false; // User not found
        }

        if (user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }

        return false; // Password incorrect
    }

    /**
     * Login as guest
     */
    public void loginAsGuest() {
        currentUser = new User(true);
    }

    /**
     * Logout current user
     */
    public void logout() {
        currentUser = null;
    }

    /**
     * Get current logged-in user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Check if user is logged in
     */
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    /**
     * Get user by username
     */
    public User getUserByUsername(String username) {
        return registeredUsers.get(username);
    }
}
