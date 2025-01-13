package g8.louisjulien.projetfinaljava;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VoirTachesFX {
    @FXML
    private TableView<Tache> tableTaches;
    @FXML
    private TableColumn<Tache, String> colTitreTache;
    @FXML
    private TableColumn<Tache, Boolean> colDescriptionTache;
    @FXML
    private TableColumn<Tache, Boolean> colStatutTache;
    @FXML
    private TableColumn<Tache, Boolean> colPrioriteTache;

    private Projet projetSelectionne;
    private Tache tacheSelectionnee;

    public void setProjet(Projet projet) {
        projetSelectionne = projet;
        colTitreTache.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        colDescriptionTache.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colStatutTache.setCellValueFactory(new PropertyValueFactory<>("Statut"));
        colPrioriteTache.setCellValueFactory(new PropertyValueFactory<>("Priorite"));

        tableTaches.setItems(FXCollections.observableArrayList(projet.getTaches()));
    }

    @FXML
    private void creerTache(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("creerTache.fxml"));
            Scene scene = new Scene(loader.load());

            // Récupérer le contrôleur de la fenêtre créerTache
            CreerTacheFX controller = loader.getController();
            controller.setProjet(projetSelectionne); // Passer le projet sélectionné

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnHiding(e -> tableTaches.setItems(FXCollections.observableArrayList(projetSelectionne.getTaches())));     // Execute un rafraichissement du tableau quand
            stage.show();                                                                                                       // la fenêtre création est fermée
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifierTache(ActionEvent event) {
        //changerScene(event, "modifierTache.fxml");
        Tache tacheSelectionnee = tableTaches.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierTache.fxml"));
            Scene scene = new Scene(loader.load());

            ModifierTacheFX controller = loader.getController();   // Récupère le contrôleur de la fenêtre des tâches
            controller.setTache(tacheSelectionnee); // Passe le projet sélectionné au contrôleur

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnHiding(e -> tableTaches.refresh());     // Rafraichit mais avec .refresh (ça marche pas avec setItems jsp pk)
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void supprimerTache(ActionEvent event) {
        Tache tacheSelectionne = tableTaches.getSelectionModel().getSelectedItem();
        System.out.println(tacheSelectionne);
        projetSelectionne.supprimerTacheProjet(tacheSelectionne);
        System.out.println(projetSelectionne.getTaches());
        tableTaches.setItems(FXCollections.observableArrayList(projetSelectionne.getTaches()));
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