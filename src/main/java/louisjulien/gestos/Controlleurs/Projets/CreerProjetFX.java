package louisjulien.gestos.Controlleurs.Projets;

import louisjulien.gestos.POO.Projet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CreerProjetFX {
    @FXML
    private TextField Titre;
    @FXML
    private DatePicker Deadline;

    @FXML
    private void Valider(ActionEvent event) {
        // Récupérer les données saisies
        String titre = Titre.getText();
        LocalDate deadline = Deadline.getValue();

        // Créer le projet
        Projet nouveauProjet = new Projet(titre, deadline);
        System.out.println("Projet  créé : " + nouveauProjet.getTitre() + " de deadline " + nouveauProjet.getDeadline());
        changerScene(event, "/louisjulien/gestos/Projets/projets.fxml");
    }

    @FXML
    private void Annuler(ActionEvent event) {
        changerScene(event, "/louisjulien/gestos/Projets/projets.fxml");
    }

    private void changerScene(ActionEvent event, String fxmlFile) {
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
