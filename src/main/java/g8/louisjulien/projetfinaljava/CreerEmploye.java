package g8.louisjulien.projetfinaljava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

        // Convertir LocalDate en LocalDateTime
        LocalDateTime dateTimeEmbauche = date.atStartOfDay();   // A enlever et changer en LocalDate seul

        // Créer l'employé
        Employe nouvelEmploye = new Employe(nom, dateTimeEmbauche);
        System.out.println("Employé créé : " + nouvelEmploye.getNom() + " " + nouvelEmploye.getDateEmbauche());

        ((Stage) Nom.getScene().getWindow()).close();
    }
}
