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

public class ModifierProjetFX {
    @FXML
    private TextField Titre;
    @FXML
    private DatePicker Deadline;

    private Projet projetSelectionne;

    public void setProjet(Projet projet) {
        projetSelectionne = projet;
    }

    @FXML
    private void Valider(ActionEvent event) {
        // Récupérer les données saisies
        String titre = Titre.getText();
        LocalDate deadline = Deadline.getValue();

        Projet.modifierProjet(projetSelectionne, titre, deadline);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupère la fenêtre courante
        stage.close();
    }

    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupère la fenêtre courante
        stage.close();
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
