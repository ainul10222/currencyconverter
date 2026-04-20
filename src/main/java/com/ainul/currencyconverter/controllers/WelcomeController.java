package com.ainul.currencyconverter.controllers;

import com.ainul.currencyconverter.App;
import com.ainul.currencyconverter.services.AuthenticationService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Controller for the welcome/authentication page
 */
public class WelcomeController {
    private AuthenticationService authService;

    @FXML
    private StackPane rootStackPane;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField loginUsernameField;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private Label loginErrorLabel;

    @FXML
    private TextField signupUsernameField;
    @FXML
    private PasswordField signupPasswordField;
    @FXML
    private TextField signupEmailField;
    @FXML
    private Label signupErrorLabel;
    @FXML
    private Label signupSuccessLabel;

    @FXML
    public void initialize() {
        authService = App.getAuthenticationService();

        // Bind the background image dimensions to the StackPane's size
        // so the image scales with window resizing
        if (backgroundImage != null && rootStackPane != null) {
            backgroundImage.fitWidthProperty().bind(rootStackPane.widthProperty());
            backgroundImage.fitHeightProperty().bind(rootStackPane.heightProperty());
        }

        // Bind the TabPane width to 75% of the root StackPane width
        // so the login box scales to 75% of the window width and stays centered
        if (tabPane != null && rootStackPane != null) {
            tabPane.maxWidthProperty().bind(rootStackPane.widthProperty().multiply(0.75));
        }
    }

    @FXML
    private void handleLogin() {
        String username = loginUsernameField.getText().trim();
        String password = loginPasswordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            loginErrorLabel.setText("Username and password cannot be empty");
            loginErrorLabel.setStyle("-fx-text-fill: #ff0000;");
            return;
        }

        if (authService.login(username, password)) {
            try {
                App.setRoot("home");
            } catch (IOException e) {
                loginErrorLabel.setText("Error loading home page");
                loginErrorLabel.setStyle("-fx-text-fill: #ff0000;");
            }
        } else {
            loginErrorLabel.setText("Invalid username or password");
            loginErrorLabel.setStyle("-fx-text-fill: #ff0000;");
            loginPasswordField.clear();
        }
    }

    @FXML
    private void handleSignup() {
        String username = signupUsernameField.getText().trim();
        String password = signupPasswordField.getText();
        String email = signupEmailField.getText().trim();

        signupSuccessLabel.setText("");
        signupErrorLabel.setText("");

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            signupErrorLabel.setText("All fields are required");
            signupErrorLabel.setStyle("-fx-text-fill: #ff0000;");
            return;
        }

        if (!email.contains("@")) {
            signupErrorLabel.setText("Please enter a valid email address");
            signupErrorLabel.setStyle("-fx-text-fill: #ff0000;");
            return;
        }

        if (password.length() < 6) {
            signupErrorLabel.setText("Password must be at least 6 characters long");
            signupErrorLabel.setStyle("-fx-text-fill: #ff0000;");
            return;
        }

        if (authService.register(username, password, email)) {
            signupSuccessLabel.setText("Account created successfully! You can now login.");
            signupSuccessLabel.setStyle("-fx-text-fill: #00aa00;");
            signupUsernameField.clear();
            signupPasswordField.clear();
            signupEmailField.clear();

            // Switch to login tab after successful signup
            tabPane.getSelectionModel().selectFirst();
        } else {
            signupErrorLabel.setText("Username already exists. Please choose another.");
            signupErrorLabel.setStyle("-fx-text-fill: #ff0000;");
        }
    }

    @FXML
    private void handleGuestLogin() {
        authService.loginAsGuest();
        try {
            App.setRoot("home");
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to load home page");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
