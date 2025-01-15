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

public class ModifierEmployeFX {
    @FXML
    private TextField EmployeEcrit;
    @FXML
    private TextField Nom;
    @FXML
    private DatePicker dateEmbauche;

    @FXML
    private void Valider(ActionEvent event) {
        // Récupérer les données saisies
        String employeEcrit = EmployeEcrit.getText().trim();
        String nom = Nom.getText();
        System.out.println("Nom initial : " + nom);
        Employe employe = trouverEmployeParNom(nom);   // Trouver l'objet Employé via le nom tapé
        LocalDate date = dateEmbauche.getValue();

        // Convertir LocalDate en LocalDateTime

        // Modifier l'employé
        Employe.modifierEmploye(employe, employeEcrit, date);
        System.out.println("Employé modifié : " + employe.getNom() + " " + employe.getDateEmbauche());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Récupère la fenêtre courante
        stage.close();
    }

    private Employe trouverEmployeParNom(String nom) {
        System.out.println("Liste complète des employés :");
        for (Employe employe : Employe.getEmployes()) {
            System.out.println(employe.getNom());
            if (employe.getNom().equalsIgnoreCase(nom.trim())) {
                return employe;
            }
        }
        System.out.println("Employé non trouvé pour le nom : " + nom);
        return null;
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
