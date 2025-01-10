module g8.louisjulien.projetfinaljava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens g8.louisjulien.projetfinaljava to javafx.fxml;
    exports g8.louisjulien.projetfinaljava;
}