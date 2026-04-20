package com.ainul.currencyconverter;

import com.ainul.currencyconverter.services.AuthenticationService;
import com.ainul.currencyconverter.services.CurrencyConversionService;
import com.ainul.currencyconverter.services.HistoryService;
import com.ainul.currencyconverter.services.ResourceLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App - Main Application Entry Point
 */
public class App extends Application {

    private static Scene scene;
    private static AuthenticationService authenticationService;
    private static CurrencyConversionService currencyConversionService;
    private static HistoryService historyService;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize services
        authenticationService = new AuthenticationService();
        currencyConversionService = new CurrencyConversionService();
        historyService = new HistoryService();

        // Create scene with welcome page - normal window size
        scene = new Scene(loadFXML("welcome"), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Currency Converter Application");
        stage.show();
    }

    /**
     * Loads an FXML file and returns the root node.
     *
     * @param fxml the name of the FXML file
     * @return the root node of the loaded FXML
     * @throws IOException if the FXML file cannot be loaded
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getFxml(fxml));
        return fxmlLoader.load();
    }

    /**
     * Sets the root of the current scene to a new FXML layout.
     *
     * @param fxml the FXML layout to load
     * @throws IOException if the FXML file cannot be loaded
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Returns the current scene.
     *
     * @return the current scene
     */
    public static AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public static CurrencyConversionService getCurrencyConversionService() {
        return currencyConversionService;
    }

    public static HistoryService getHistoryService() {
        return historyService;
    }
}
