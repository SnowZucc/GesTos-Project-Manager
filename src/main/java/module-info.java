module g8.louisjulien.projetfinaljava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens g8.louisjulien.projetfinaljava to javafx.fxml;
    exports g8.louisjulien.projetfinaljava;
}