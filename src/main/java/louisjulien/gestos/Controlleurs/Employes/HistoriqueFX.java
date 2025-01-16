package louisjulien.gestos.Controlleurs.Employes;

import louisjulien.gestos.POO.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoriqueFX {
    @FXML
    private TextField nomEmploye;

    @FXML
    private TableView<HistoriqueEntrees> tableHistorique;

    @FXML
    private TableColumn<HistoriqueEntrees, String> colProjet;

    @FXML
    private TableColumn<HistoriqueEntrees, String> colTache;

    private ObservableList<HistoriqueEntrees> historiqueData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colProjet.setCellValueFactory(new PropertyValueFactory<>("projet"));
        colTache.setCellValueFactory(new PropertyValueFactory<>("tache"));

        tableHistorique.setItems(historiqueData);
    }

    @FXML
    public void chargerHistorique() {
        String nom = nomEmploye.getText();
        Employe employe = trouverEmployeParNom(nom);

            for (String[] entry : employe.getHistorique()) {        // Affiche les roles dans le tableau
                historiqueData.add(new HistoriqueEntrees(entry[0], entry[1]));
            }
    }

    private Employe trouverEmployeParNom(String nom) {      // Même fonction que dans ModifierEmploye
        for (Employe employe : Employe.getEmployes()) {
            if (employe.getNom().equalsIgnoreCase(nom)) {
                return employe;
            }
        }
        return null;
    }

    public static class HistoriqueEntrees {
        private final String projet;
        private final String tache;

        public HistoriqueEntrees(String projet, String tache) {
            this.projet = projet;
            this.tache = tache;
        }
    }
}
