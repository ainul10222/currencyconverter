package com.ainul.currencyconverter.controllers;

import com.ainul.currencyconverter.App;
import com.ainul.currencyconverter.models.Currency;
import com.ainul.currencyconverter.models.User;
import com.ainul.currencyconverter.services.AuthenticationService;
import com.ainul.currencyconverter.services.CurrencyConversionService;
import com.ainul.currencyconverter.services.HistoryService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Controller for the home/currency conversion page
 */
public class HomeController {
    private AuthenticationService authService;
    private CurrencyConversionService conversionService;
    private HistoryService historyService;
    private DecimalFormat decimalFormat;

    @FXML
    private Label welcomeLabel;
    @FXML
    private TextField amountField;
    @FXML
    private ComboBox<Currency> fromCurrencyCombo;
    @FXML
    private ComboBox<Currency> toCurrencyCombo;
    @FXML
    private Label resultLabel;
    @FXML
    private Label exchangeRateLabel;
    @FXML
    private TextArea historyTextArea;

    @FXML
    public void initialize() {
        authService = App.getAuthenticationService();
        conversionService = App.getCurrencyConversionService();
        historyService = App.getHistoryService();
        decimalFormat = new DecimalFormat("#.##");

        // Set welcome label
        User currentUser = authService.getCurrentUser();
        if (currentUser != null) {
            welcomeLabel.setText("Welcome, " + currentUser.getUsername() + "!");
        }

        // Populate currency combo boxes
        fromCurrencyCombo.getItems().addAll(conversionService.getAllCurrencies());
        toCurrencyCombo.getItems().addAll(conversionService.getAllCurrencies());

        // Set default selections
        if (!fromCurrencyCombo.getItems().isEmpty()) {
            fromCurrencyCombo.getSelectionModel().selectFirst();
        }
        if (toCurrencyCombo.getItems().size() > 1) {
            toCurrencyCombo.getSelectionModel().select(1);
        }

        // Add listeners for real-time conversion
        amountField.textProperty().addListener((obs, oldVal, newVal) -> performConversion());
        fromCurrencyCombo.setOnAction(e -> performConversion());
        toCurrencyCombo.setOnAction(e -> performConversion());

        historyTextArea.setEditable(false);
        historyTextArea.setWrapText(true);
        historyTextArea.setText(historyService.getHistoryText());
    }

    @FXML
    private void performConversion() {
        try {
            String amountText = amountField.getText().trim();
            if (amountText.isEmpty()) {
                resultLabel.setText("Result: 0.00");
                exchangeRateLabel.setText("");
                return;
            }

            double amount = Double.parseDouble(amountText);

            if (amount < 0) {
                resultLabel.setText("Amount cannot be negative");
                resultLabel.setStyle("-fx-text-fill: #ff0000;");
                return;
            }

            Currency fromCurrency = fromCurrencyCombo.getSelectionModel().getSelectedItem();
            Currency toCurrency = toCurrencyCombo.getSelectionModel().getSelectedItem();

            if (fromCurrency == null || toCurrency == null) {
                resultLabel.setText("Please select both currencies");
                return;
            }

            double result =
                    conversionService.convert(amount, fromCurrency.getCode(), toCurrency.getCode());
            double exchangeRate =
                    conversionService.getExchangeRate(fromCurrency.getCode(), toCurrency.getCode());

            resultLabel.setText(
                    "Result: " + decimalFormat.format(result) + " " + toCurrency.getCode());
            resultLabel.setStyle("-fx-text-fill: #000000;");
            exchangeRateLabel.setText("Exchange Rate: 1 " + fromCurrency.getCode() + " = "
                    + decimalFormat.format(exchangeRate) + " " + toCurrency.getCode());
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid amount entered");
            resultLabel.setStyle("-fx-text-fill: #ff0000;");
        }
    }

    @FXML
    private void handleAddToHistory() {
        try {
            String amountText = amountField.getText().trim();
            if (amountText.isEmpty()) {
                showAlert("Error", "Please enter an amount");
                return;
            }

            double amount = Double.parseDouble(amountText);
            Currency fromCurrency = fromCurrencyCombo.getSelectionModel().getSelectedItem();
            Currency toCurrency = toCurrencyCombo.getSelectionModel().getSelectedItem();

            if (fromCurrency == null || toCurrency == null) {
                showAlert("Error", "Please select both currencies");
                return;
            }

            double result =
                    conversionService.convert(amount, fromCurrency.getCode(), toCurrency.getCode());
            String historyEntry = decimalFormat.format(amount) + " " + fromCurrency.getCode()
                    + " = " + decimalFormat.format(result) + " " + toCurrency.getCode();

            historyService.addEntry(historyEntry);
            historyTextArea.setText(historyService.getHistoryText());

            showAlert("Success", "Conversion added to history");
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid amount entered");
        }
    }

    @FXML
    private void handleClearHistory() {
        historyService.clearHistory();
        historyTextArea.clear();
        showAlert("Success", "History cleared");
    }

    @FXML
    private void handleSwapCurrencies() {
        Currency temp = fromCurrencyCombo.getSelectionModel().getSelectedItem();
        fromCurrencyCombo.getSelectionModel()
                .select(toCurrencyCombo.getSelectionModel().getSelectedItem());
        toCurrencyCombo.getSelectionModel().select(temp);
        performConversion();
    }

    @FXML
    private void handleClearAmount() {
        amountField.clear();
        resultLabel.setText("Result: 0.00");
        exchangeRateLabel.setText("");
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
    private void handleBackToWelcome() {
        try {
            App.setRoot("welcome");
        } catch (IOException e) {
            showAlert("Error", "Failed to navigate back: " + e.getMessage());
        }
    }

    @FXML
    private void handleGoHome() {
        try {
            App.setRoot("home");
        } catch (IOException e) {
            showAlert("Error", "Failed to navigate home: " + e.getMessage());
        }
    }

    @FXML
    private void handleOpenSettings() {
        try {
            App.setRoot("settings");
        } catch (IOException e) {
            showAlert("Error", "Failed to open settings: " + e.getMessage());
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
