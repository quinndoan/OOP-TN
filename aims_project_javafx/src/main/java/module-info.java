module globalict {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens globalict to javafx.fxml;
    exports globalict;
}
