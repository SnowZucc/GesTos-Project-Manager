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
import java.time.LocalDateTime;
import java.util.List;

public class ProjetsFX {
    @FXML
    private TableView<Projet> tableProjets;

    @FXML
    private TableColumn<Projet, String> colTitre;

    @FXML
    private TableColumn<Projet, Boolean> colEtat;

    @FXML
    private TableColumn<Projet, LocalDate> colDeadline;

    private ObservableList<Projet> listeProjets;

    @FXML
    public void initialize() {
        // Lier les colonnes aux propriétés des projets
        colTitre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        colEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
        colDeadline.setCellValueFactory(new PropertyValueFactory<>("Deadline"));

        // Charger les projets dans l'ObservableList
        List<Projet> projets = Projet.getListeProjets();
        listeProjets = FXCollections.observableArrayList(projets);

        // Définir les données dans le tableau
        tableProjets.setItems(listeProjets);
    }

    @FXML
    private void creerProjet(ActionEvent event) {
        changerScene(event, "creerProjet.fxml");
    }

    @FXML
    private void modifierProjet(ActionEvent event) {
        // Faire passer le projet comme dans VoirTachesFX
        Projet projetSelectionne = tableProjets.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierProjet.fxml"));
            Scene scene = new Scene(loader.load());

            ModifierProjetFX controller = loader.getController(); // Récupérer le contrôleur
            controller.setProjet(projetSelectionne); // Passer le projet sélectionné au contrôleur

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnHiding(e -> {
                listeProjets.clear();                                   // Rafraichir les données du tableau mais qui marche pour cette méthode
                listeProjets.addAll(Projet.getListeProjets());
                tableProjets.refresh();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void supprimerProjet(ActionEvent event) {
        Projet projetSelectionne = tableProjets.getSelectionModel().getSelectedItem();
            listeProjets.remove(projetSelectionne);
//          Projet.getListeProjets().remove(projetSelectionne);
            Projet.supprimerProjet(projetSelectionne);
            listeProjets.clear();                                   // Rafraichir les données du tableau mais qui marche pour cette méthode
            listeProjets.addAll(Projet.getListeProjets());
            tableProjets.refresh();
    }

    @FXML
    private void voirTaches(ActionEvent event) {
        Projet projetSelectionne = tableProjets.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("voirTaches.fxml"));
                Scene scene = new Scene(loader.load());

                VoirTachesFX controller = loader.getController();   // Récupère le contrôleur de la fenêtre des tâches
                controller.setProjet(projetSelectionne); // Passe le projet sélectionné au contrôleur

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        // Change scène
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    @FXML
    private void Retour(ActionEvent event) {
        changerScene(event, "dashboard.fxml");
    }
}
