module aimscreen {
    requires javafx.controls;
    requires javafx.fxml;

    opens aimscreen to javafx.fxml;
    exports aimscreen;
}
