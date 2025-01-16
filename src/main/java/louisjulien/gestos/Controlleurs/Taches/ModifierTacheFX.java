package louisjulien.gestos.Controlleurs.Taches;

import louisjulien.gestos.POO.Tache;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifierTacheFX {
    @FXML
    private TextField Titre;
    @FXML
    private TextField Description;
    @FXML
    private TextField Status;
    @FXML
    private TextField Priorite;

    private Tache tacheSelectionne;

    public void setTache(Tache tache) {
        tacheSelectionne = tache;
    }

    @FXML
    private void Valider(ActionEvent event) {
        // Récupérer les données saisies
        String titre = Titre.getText();
        String description = Description.getText();
        String status = Status.getText();
        String priorite = Priorite.getText();

        tacheSelectionne.modifierTache(titre, description, status, priorite);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupère la fenêtre courante
        stage.close();
    }

    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupère la fenêtre courante
        stage.close();
    }
}
