package com.ainul.currencyconverter.controllers;

import com.ainul.currencyconverter.App;
import com.ainul.currencyconverter.models.User;
import com.ainul.currencyconverter.services.AuthenticationService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Controller for the settings page
 */
public class SettingsController {
    private AuthenticationService authService;

    @FXML
    private Label settingsWelcomeLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label accountTypeLabel;

    @FXML
    public void initialize() {
        authService = App.getAuthenticationService();
        User currentUser = authService.getCurrentUser();

        if (currentUser != null) {
            usernameLabel.setText(currentUser.getUsername());
            emailLabel.setText(currentUser.getEmail() == null ? "N/A" : currentUser.getEmail());
            accountTypeLabel
                    .setText(currentUser.isGuest() ? "Guest Account" : "Registered Account");
            settingsWelcomeLabel.setText("Account Settings");
        } else {
            usernameLabel.setText("Guest");
            emailLabel.setText("N/A");
            accountTypeLabel.setText("No active user");
            settingsWelcomeLabel.setText("Account Settings");
        }
    }

    @FXML
    private void handleBack() {
        try {
            App.setRoot("home");
        } catch (IOException e) {
            showAlert("Error", "Failed to return to home: " + e.getMessage());
        }
    }

    @FXML
    private void handleHome() {
        try {
            App.setRoot("home");
        } catch (IOException e) {
            showAlert("Error", "Failed to navigate home: " + e.getMessage());
        }
    }

    @FXML
    private void handleLogout() {
        authService.logout();
        try {
            App.setRoot("welcome");
        } catch (IOException e) {
            showAlert("Error", "Failed to logout: " + e.getMessage());
        }
    }

    @FXML
    private void handleViewHistory() {
        try {
            App.setRoot("history");
        } catch (IOException e) {
            showAlert("Error", "Failed to open history: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
