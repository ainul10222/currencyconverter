package com.ainul.currencyconverter.controllers;

import com.ainul.currencyconverter.App;
import com.ainul.currencyconverter.services.HistoryService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Controller for the saved conversion history page
 */
public class HistoryController {
    private HistoryService historyService;

    @FXML
    private StackPane rootStackPane;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Label headerLabel;
    @FXML
    private TextArea historyTextArea;
    @FXML
    private Button clearHistoryButton;

    @FXML
    public void initialize() {
        historyService = App.getHistoryService();

        // Bind the background image dimensions to the StackPane's size
        // so the image scales with window resizing
        if (backgroundImage != null && rootStackPane != null) {
            backgroundImage.fitWidthProperty().bind(rootStackPane.widthProperty());
            backgroundImage.fitHeightProperty().bind(rootStackPane.heightProperty());
        }

        refreshHistory();
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
    private void handleClearHistory() {
        historyService.clearHistory();
        refreshHistory();
        showAlert("Success", "Saved history cleared.");
    }

    private void refreshHistory() {
        String historyText = historyService.getHistoryText();
        if (historyText.isEmpty()) {
            historyTextArea.setText("No saved conversion history yet.");
            clearHistoryButton.setDisable(true);
        } else {
            historyTextArea.setText(historyText);
            clearHistoryButton.setDisable(false);
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
