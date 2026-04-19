module com.ainul.currencyconverter {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.ainul.currencyconverter to javafx.fxml;

    exports com.ainul.currencyconverter;
}
