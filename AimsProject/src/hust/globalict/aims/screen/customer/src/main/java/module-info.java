module customer {
    requires javafx.controls;
    requires javafx.fxml;

    opens customer to javafx.fxml;
    exports customer;
}
