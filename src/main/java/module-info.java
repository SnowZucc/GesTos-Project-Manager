module g8.louisjulien.projetfinaljava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens louisjulien.gestos to javafx.fxml;
    exports louisjulien.gestos;
    exports louisjulien.gestos.Controlleurs.Employes;
    opens louisjulien.gestos.Controlleurs.Employes to javafx.fxml;
    exports louisjulien.gestos.Controlleurs.Projets;
    opens louisjulien.gestos.Controlleurs.Projets to javafx.fxml;
    exports louisjulien.gestos.Controlleurs.Taches;
    opens louisjulien.gestos.Controlleurs.Taches to javafx.fxml;
    exports louisjulien.gestos.Controlleurs;
    opens louisjulien.gestos.Controlleurs to javafx.fxml;
    exports louisjulien.gestos.POO;
    opens louisjulien.gestos.POO to javafx.fxml;
}