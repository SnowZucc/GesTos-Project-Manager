module g8.louisjulien.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens g8.louisjulien.demo to javafx.fxml;
    exports g8.louisjulien.demo;
}