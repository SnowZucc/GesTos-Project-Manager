package g8.louisjulien.projetfinaljava;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML du dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            // Configurer la fenêtre principale
            primaryStage.setTitle("Application de gestion collaborative");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employe e1 = new Employe("Jean Marc", LocalDateTime.now());
        Employe e2 = new Employe("John Doe", LocalDateTime.now());
        Employe e3 = new Employe("John Doe", LocalDateTime.now());
        Employe e4 = new Employe("John Doe", LocalDateTime.now());


        Projet p1 = new Projet("Projet1", LocalDate.of(2025, 1, 10));
        Tache t1_1 = new Tache("P1Tâche1", "Faire les classes java.", "Urgent");
        Tache t1_2 = new Tache("P1Tâche2", "Faire les interfaces.", "Secondaire");
        Tache t1_3 = new Tache("P1Tâche3", "Faire le diagramme UML.", "Prioritaire");
        p1.ajouterTacheProjet(t1_1);
        p1.ajouterTacheProjet(t1_2);
        p1.ajouterTacheProjet(t1_3);

        Projet p2 = new Projet("Projet2", LocalDate.of(2025, 1, 17));
        Tache t2_1 = new Tache("P1Tâche1", "Faire le rapport.", "Prioritaire");
        Tache t2_2 = new Tache("P1Tâche2", "Faire le texte", "Urgent");
        Tache t2_3 = new Tache("P1Tâche3", "Faire le powerpoint.", "Secondaire");
        p2.ajouterTacheProjet(t2_1);
        p2.ajouterTacheProjet(t2_2);
        p2.ajouterTacheProjet(t2_3);

        System.out.println("Etat du projet1 AVANT update : " + p1.getEtat());
        System.out.println("Etat de la tâche 1 AVANT update : " + t1_1.getEtat());
        t1_1.setStatut(4);
        System.out.println("Etat de la tâche 1 APRES update : " + t1_1.getEtat());

        t1_2.setStatut(4);
        t1_3.setStatut(4);
        System.out.println("Etat du projet1 APRES update : " + p1.getEtat());

//        // La doc : https://github.com/xerial/sqlite-jdbc et https://sqlite.fr/languages/java/
//        DatabaseManager.initializeDatabase(); // Initialiser la base de données
//
//        // Récupérer et afficher les projets
//        List<Projet> projets = DatabaseManager.getAllProjets();
//        for (Projet projet : projets) {
//            System.out.println("Projet : " + projet.getTitre() + ", Deadline : " + projet.getDeadline());
//        }
//
//        // Récupérer et afficher les tâches du projet 1
//        List<Tache> taches = DatabaseManager.getTachesByProjetId(1);
//        for (Tache tache : taches) {
//            System.out.println("Tâche : " + tache.getTitre() + ", Description : " + tache.getDescription());
//
//
        launch(args); // Lance l'application JavaFX
//        }
    }
}