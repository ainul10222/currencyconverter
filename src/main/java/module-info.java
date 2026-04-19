module com.ainul.currencyconverter {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.ainul.currencyconverter to javafx.fxml;
    opens com.ainul.currencyconverter.controllers to javafx.fxml;
    opens com.ainul.currencyconverter.models to javafx.fxml;
    opens com.ainul.currencyconverter.services to javafx.fxml;

    exports com.ainul.currencyconverter;
    exports com.ainul.currencyconverter.controllers;
    exports com.ainul.currencyconverter.models;
    exports com.ainul.currencyconverter.services;
}
