module globalict {
    requires javafx.controls;
    requires javafx.fxml;

    opens globalict to javafx.fxml;
    exports globalict;
}
