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

import java.time.LocalDate;

public class EmployeFX {
    @FXML
    private TableView<Employe> tableEmployes;

    @FXML
    private TableColumn<Employe, String> colNom;

    @FXML
    private TableColumn<Employe, LocalDate> colDateEmbauche;

    private ObservableList<Employe> listeEmployes = FXCollections.observableArrayList();    // Permet de voir la selection de la table

    @FXML
    public void initialize() {
        // Lier les colonnes aux propriétés des employés
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colDateEmbauche.setCellValueFactory(new PropertyValueFactory<>("DateEmbauche"));

        tableEmployes.setItems(listeEmployes);
    }

    @FXML
    private void creerEmploye(ActionEvent event) {
        changerScene(event, "creerEmploye.fxml");
    }

    @FXML
    private void modifierEmploye(ActionEvent event) {

    }

    @FXML
    private void supprimerEmploye(ActionEvent event) {

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
