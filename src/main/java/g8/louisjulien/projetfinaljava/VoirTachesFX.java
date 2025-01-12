package g8.louisjulien.projetfinaljava;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    public void setProjet(Projet projet) {
        colTitreTache.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        colDescriptionTache.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colStatutTache.setCellValueFactory(new PropertyValueFactory<>("Statut"));
        colPrioriteTache.setCellValueFactory(new PropertyValueFactory<>("Priorite"));

        tableTaches.setItems(FXCollections.observableArrayList(projet.getTaches()));
    }
}