package g8.louisjulien.projetfinaljava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeFX {
    @FXML
    private TableView<Employe> tableEmployes;

    @FXML
    private TableColumn<Employe, String> colNom;

    @FXML
    private TableColumn<Employe, LocalDateTime> colDateEmbauche;

    private ObservableList<Employe> listeEmployes;

    @FXML
    public void initialize() {
        // Lier les colonnes aux propriétés des employés
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colDateEmbauche.setCellValueFactory(new PropertyValueFactory<>("DateEmbauche"));

        // Charger les employés dans l'ObservableList
        List<Employe> employes = Employe.getEmployes();
        listeEmployes = FXCollections.observableArrayList(employes);

        // Définir les données dans le tableau
        tableEmployes.setItems(listeEmployes);
    }

    @FXML
    private void creerEmploye(ActionEvent event) {
        changerScene(event, "creerEmploye.fxml");
    }

    @FXML
    private void modifierEmploye(ActionEvent event) {
        ouvrirNouvelleFenetre("modifierEmploye.fxml");
    }

    @FXML
    private void supprimerEmploye(ActionEvent event) {
        Employe employeSelectionne = tableEmployes.getSelectionModel().getSelectedItem();
        if (employeSelectionne != null) {
            listeEmployes.remove(employeSelectionne);
            Employe.getEmployes().remove(employeSelectionne);
        }
    }

    @FXML
    private void afficherHistorique() {
        ouvrirNouvelleFenetre("Historique.fxml");
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

    private void ouvrirNouvelleFenetre(String fxmlFile) {
        try {
            // Charger le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());

            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
