package g8.louisjulien.projetfinaljava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Projet {
    private String Titre;
    public boolean Etat;
    public int completion = 0;
    private ArrayList<Tache> ListeTache = new ArrayList<>();
    private ArrayList<Employe> ListeEmploye = new ArrayList<>();
    private LocalDate Deadline;
    public Projet(String Titre, LocalDate Deadline) {
        this.Titre = Titre;
        this.Etat = false;
        this.Deadline = Deadline;
    }


    public String getTitre() {
        return Titre;
    }
    public void setTitre(String Titre) {
        this.Titre = Titre;
    }
    public boolean getEtat() {
        return Etat;
    }
    public ArrayList<Tache> getTaches() {
        return ListeTache;
    }
    public ArrayList<Employe> getEmployes() {
        return ListeEmploye;
    }
    public LocalDate getDeadline() {
        return Deadline;
    }
    public void setDeadline(LocalDate Deadline) {
        this.Deadline = Deadline;
    }


    public void modifierProjet(String Titre, LocalDate newDeadline) {
        this.Titre = Titre;
        this.Deadline = newDeadline;
    }
    public void supprimerProjet() {}


    public void attribuerRole(Employe employe, Tache tache) {
        tache.getEmployes().add(employe);
    }

    public void ajouterTacheProjet(Tache tache) {
        tache.projet = this;
        this.ListeTache.add(tache);
    }
}
