package g8.louisjulien.projetfinaljava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreerEmploye {
    @FXML
    private TextField Nom;
    @FXML
    private DatePicker dateEmbauche;

    @FXML
    private void Valider(ActionEvent event) {
        // Récupérer les données saisies
        String nom = Nom.getText();
        LocalDate date = dateEmbauche.getValue();


        // Créer l'employé
        Employe nouvelEmploye = new Employe(nom, date);
        System.out.println("Employé créé : " + nouvelEmploye.getNom() + " " + nouvelEmploye.getDateEmbauche());
        changerScene(event, "employes.fxml");
    }

    @FXML
    private void Annuler(ActionEvent event) {
        changerScene(event, "employes.fxml");
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
