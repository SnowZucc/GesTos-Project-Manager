package louisjulien.gestos.Controlleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dashboard {

    @FXML
    private void ouvrirGestionEmployes(ActionEvent event) {
        changerScene(event, "/louisjulien/gestos/Employes/employes.fxml");
    }

    @FXML
    private void ouvrirGestionProjets(ActionEvent event) {
        changerScene(event, "/louisjulien/gestos/Projets/projets.fxml");
    }

    @FXML
    private void ouvrirGestionTaches(ActionEvent event) {
        changerScene(event, "/g8/louisjulien/projetfinaljava/Taches/gestionTaches.fxml");
    }

    public void changerScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
