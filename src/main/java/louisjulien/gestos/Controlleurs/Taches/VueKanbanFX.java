package louisjulien.gestos.Controlleurs.Taches;

import louisjulien.gestos.POO.Projet;
import louisjulien.gestos.POO.Tache;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class VueKanbanFX {
    @FXML
    private ListView<Tache> colEnAttente, colEnCours, colEnTest, colTermine;

    private Projet projetSelectionne;

    public void setProjet(Projet projet) {
        this.projetSelectionne = projet;
        remplirColonnes();
    }

    private void remplirColonnes() {
        ObservableList<Tache> enAttente = FXCollections.observableArrayList();      // Listes observables vides
        ObservableList<Tache> enCours = FXCollections.observableArrayList();
        ObservableList<Tache> enTest = FXCollections.observableArrayList();
        ObservableList<Tache> termine = FXCollections.observableArrayList();

        for (Tache tache : projetSelectionne.getTaches()) {     // Répartition des tâches en les colonnes correspondantes selon état
            switch (tache.getStatut()) {
                case "En attente" -> enAttente.add(tache);
                case "En cours"   -> enCours.add(tache);
                case "Test"       -> enTest.add(tache);
                case "Terminé"    -> termine.add(tache);
            }
        }

        colEnAttente.setItems(enAttente);       // On assigne les listes aux listview correspondantes
        colEnCours.setItems(enCours);
        colEnTest.setItems(enTest);
        colTermine.setItems(termine);

        configurerDragAndDrop(colEnAttente, 1);
        configurerDragAndDrop(colEnCours, 2);
        configurerDragAndDrop(colEnTest, 3);
        configurerDragAndDrop(colTermine, 4);
    }

    private void configurerDragAndDrop(ListView<Tache> colonne, int nouvelEtat) {
        // Quand on commence à "tirer" une Tache depuis la colonne
        colonne.setOnDragDetected(event -> {
            Tache tache = colonne.getSelectionModel().getSelectedItem();
                Dragboard dragboard = colonne.startDragAndDrop(TransferMode.MOVE);      // Drag and drop
                ClipboardContent content = new ClipboardContent();
                content.putString(tache.getTitre());
                dragboard.setContent(content);
            event.consume();
        });

        colonne.setOnDragOver(event -> {
            if (event.getGestureSource() != colonne && event.getDragboard().hasString()) {      // Quand on survole une autre colonne en tenant la Tache
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        colonne.setOnDragDropped(event -> {Dragboard dragboard = event.getDragboard(); // Quand on lâche la tache dans la colonne
                String titreTache = dragboard.getString();                                       // Obtient la tâche touchée
                Tache tache = trouverTacheParTitre(titreTache);                                   // Recherche de la tache par son titre
                    tache.setStatut(nouvelEtat);                                                  // Définit le nouvel état
                    remplirColonnes();                                                         // Re-remplit les colonnes
            event.setDropCompleted(true);
            event.consume();
        });
    }

    private Tache trouverTacheParTitre(String titre) {
        for (Tache tache : projetSelectionne.getTaches()) {
            if (tache.getTitre().equals(titre)) {
                return tache;
            }
        }
        return null;
    }
}