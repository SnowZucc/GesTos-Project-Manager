package g8.louisjulien.projetfinaljava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CreerTacheFX {
    @FXML
    private TextField Titre;
    @FXML
    private TextField Description;
    @FXML
    private TextField Priorite;

    private Projet projetSelectionne;

    public void setProjet(Projet projet) {
        projetSelectionne = projet;
    }

    @FXML
    private void Valider(ActionEvent event) {
        // Récupérer les données saisies
        String titre = Titre.getText();
        String description = Description.getText();
        String priorite = Priorite.getText();

        // Créer le projet
        Tache tache = new Tache(titre, description, priorite);
        projetSelectionne.ajouterTacheProjet(tache);
        System.out.println("Tache ajoutée: " + tache.getTitre());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupère la fenêtre courante
        stage.close();
    }

    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupérer la fenêtre courante
        stage.close();
    }
}
