package g8.louisjulien.projetfinaljava;

import java.util.ArrayList;

public class Tache {
    private String Titre;
    private String Description;
    private String Statut; // 4 phases: En attente, En cours, Test, Terminé
    private String Priorite; // Prioritaire, Urgent, Secondaire, Non Urgent
    private ArrayList<Employe> ListeEmploye;
    public Tache(String titre, String description, String Priorite) {
        this.Titre = titre;
        this.Description = description;
        this.Statut = "En attente";
        this.Priorite = Priorite;
    }

    public String getTitre() {
        return Titre;
    }
    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

    public String getStatut() {
        return Statut;
    }
    public void setStatut(int statut) {
        /**
         Cette méthode permet de modifier le statut de la tâche en cours en fonction de l'entier i renseigné:
         i = 1 : La tâche est placée en attente (statut par défaut à sa création).
         i = 2 : ___________________ en cours.
         i = 3 : ___________________ en phase de tests.
         i = 4 : ____________ terminée.
         @param statut est l'entier i en paramètre qui détermine le statut de la tâche.
         @return void.
         */
        switch (statut) {
            case 1:
                Statut = "En attente";
                break;
            case 2:
                Statut = "En cours";
                break;
            case 3:
                Statut = "Test";
                break;
            case 4:
                Statut = "Terminé";
        }
    }

    public String getPriorite() {
        return Priorite;
    }
    public void setPriorite(String priorite) {
        Priorite = priorite;
    }

    public ArrayList<Employe> getEmployes() {
        return this.ListeEmploye;
    }

    public void modifierTache(String newTitre, String newDescription, String newStatut, String newPriorite) {
        this.Titre = newTitre;
        this.Description = newDescription;
        this.Statut = "En attente";
        this.Priorite = newPriorite;
    }
    public void supprimerTache() {}


}
