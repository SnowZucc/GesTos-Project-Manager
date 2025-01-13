package g8.louisjulien.projetfinaljava;

import java.util.ArrayList;

public class Tache {
    private String Titre;
    private String Description;
    private String Statut; // 4 phases: En attente, En cours, Test, Terminé
    private boolean Etat = false; // Etat (terminé ou non) d'une tâche
    private String Priorite; // Prioritaire, Urgent, Secondaire, Non Urgent
    public Projet projet;
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
         Pour chaque changement de statut,
         l'état de la tâche ainsi que la complétion du projet équivalent sont réévalués.

         @param statut est l'entier i en paramètre qui détermine le statut de la tâche.
         @return void.
         */
        switch (statut) {
            case 1:
                Statut = "En attente";
                if (this.Etat) {
                    this.projet.completion--;
                    this.Etat = false;
                    // Si l'état du projet était true (terminé),
                    // il est maintenant false (non terminé) car la tâche n'est elle-même plus terminée
                    if (this.projet.Etat) {
                        this.projet.Etat = false;
                    }
                }
                break;
            case 2:
                Statut = "En cours";
                if (this.Etat) {
                    this.projet.completion--;
                    this.Etat = false;
                    // Idem cas 1
                    if (this.projet.Etat) {
                        this.projet.Etat = false;
                    }
                }
                break;
            case 3:
                Statut = "Test";
                if (this.Etat) {
                    this.projet.completion--;
                    this.Etat = false;
                    // Idem cas 1
                    if (this.projet.Etat) {
                        this.projet.Etat = false;
                    }
                }
                break;
            case 4:
                Statut = "Terminé";
                if (!this.Etat) {
                    this.projet.completion++;
                    this.Etat = true;
                    // Si cette tâche était la dernière à terminer (la complétion est donc maximale)
                    // Alors l'état du projet est maintenant true (terminé)
                    if (this.projet.completion == this.projet.getTaches().size() - 1) {
                        this.projet.Etat = true;
                    }
                }
                break;
        }
    }
    public boolean getEtat() {
        return Etat;
    }

    public String getPriorite() {
        return Priorite;
    }
    public void setPriorite(String priorite) {
        Priorite = priorite;
    }

    public Projet getProjet() {
        return projet;
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

    @Override
    public String toString() {
        return this.Titre;          // Renvoie le titre de la tache au lieu de g8.louisjulien.projetfinaljava.machin
    }
}
