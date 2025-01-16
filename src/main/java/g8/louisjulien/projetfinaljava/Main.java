package g8.louisjulien.projetfinaljava;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main extends Application{
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
        Employe e1 = new Employe("Jean Marc", LocalDate.now());
        Employe e2 = new Employe("John Doe", LocalDate.now());
        Employe e3 = new Employe("Cécile Dupuis", LocalDate.now());
        Employe e4 = new Employe("Philippe Etchebest", LocalDate.now());


        Projet p1 = new Projet("Faire l'application Java", LocalDate.of(2025, 1, 16));
        Tache t1_1 = new Tache("POO", "Faire les classes de la POO", "Urgent");
        Tache t1_2 = new Tache("Dashboard", "Faire le dashboard graphique", "Prioritaire");
        Tache t1_3 = new Tache("CSS", "Rendre joli grâce au CSS", "Secondaire");
        p1.ajouterTacheProjet(t1_1);
        p1.attribuerRole(e1, t1_1);
        p1.attribuerRole(e2, t1_1);
        p1.attribuerRole(e3, t1_1);
        p1.ajouterTacheProjet(t1_2);
        p1.attribuerRole(e2, t1_2);
        p1.attribuerRole(e4, t1_2);
        p1.ajouterTacheProjet(t1_3);
        p1.attribuerRole(e3, t1_3);


        Projet p2 = new Projet("Détruire l'ISEP", LocalDate.of(2025, 3, 23));
        Tache t2_1 = new Tache("Attaque", "Planifier l'attaque", "Urgent");
        Tache t2_2 = new Tache("Reconnaissance", "Chercher les failles", "Prioritaire");
        Tache t2_3 = new Tache("Bombe", "Fabriquer la bombe", "Secondaire");
        p2.ajouterTacheProjet(t2_1);
        p2.attribuerRole(e1, t2_1);
        p2.attribuerRole(e2, t2_1);
        p2.attribuerRole(e3, t2_1);
        p2.attribuerRole(e4, t2_1);
        p2.ajouterTacheProjet(t2_2);
        p2.attribuerRole(e1, t2_2);
        p2.attribuerRole(e3, t2_2);
        p2.attribuerRole(e4, t2_2);
        p2.ajouterTacheProjet(t2_3);
        p2.attribuerRole(e1, t2_3);
        p2.attribuerRole(e2, t2_3);
        p2.attribuerRole(e4, t2_3);

//        TEST getHistorique()
        t1_1.setStatut(4);
        t1_2.setStatut(3);
        t1_3.setStatut(1);
        System.out.println(e1.getHistorique());
        System.out.println(e2.getHistorique());
        System.out.println(e3.getHistorique());
        System.out.println(e4.getHistorique());


//        TEST Etat
        System.out.println("Etat du projet1 AVANT update : " + p1.getEtat());
        System.out.println("Etat de la tâche 1 AVANT update : " + t1_1.getEtat());
        t1_1.setStatut(4);
        System.out.println("Etat de la tâche 1 APRES update : " + t1_1.getEtat());

        t1_2.setStatut(4);
        t1_3.setStatut(2);
        System.out.println("Etat du projet1 APRES update : " + p1.getEtat());

        launch(args); // Lance l'application JavaFX
    }
}