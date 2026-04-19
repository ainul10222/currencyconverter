package com.ainul.currencyconverter;

import com.ainul.currencyconverter.services.AuthenticationService;
import com.ainul.currencyconverter.services.CurrencyConversionService;
import com.ainul.currencyconverter.services.HistoryService;
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

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize services
        authenticationService = new AuthenticationService();
        currencyConversionService = new CurrencyConversionService();
        historyService = new HistoryService();

        // Create scene with welcome page - normal window size
        Parent root = loadFXML("welcome");
        scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Currency Converter Application");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public static CurrencyConversionService getCurrencyConversionService() {
        return currencyConversionService;
    }

    public static HistoryService getHistoryService() {
        return historyService;
    }

    public static void main(String[] args) {
        launch();
    }

}
