package louisjulien.gestos.POO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projet {
    private String Titre;
    public boolean Etat;
    public int completion = 0;
    private static List<Projet> ListeProjets = new ArrayList<>();
    private ArrayList<Tache> ListeTache = new ArrayList<>();
    private ArrayList<Employe> ListeEmploye = new ArrayList<>();
    private LocalDate Deadline;
    public Projet(String Titre, LocalDate Deadline) {
        this.Titre = Titre;
        this.Etat = false;
        this.Deadline = Deadline;

        ListeProjets.add(this);
    }

    public static List<Projet> getListeProjets() {
        return ListeProjets;
    }
    public String getTitre() {
        return Titre;
    }
    public void setTitre(String Titre) {
        this.Titre = Titre;
    }
    public String getEtat() {
        if (Etat) {
            return "Complété";
        }
        return "Incomplet";
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


    public static void modifierProjet(Projet projet, String Titre, LocalDate newDeadline) {     // Je l'ai changé en static sinon on peux pas l'utiliser dehors
        projet.Titre = Titre;
        projet.Deadline = newDeadline;
    }
    public static void supprimerProjet(Projet projet) {
        ListeProjets.remove(projet);
    }


    public void attribuerRole(Employe employe, Tache tache) {
        if (!employe.getListeRoles().containsKey(this)) {
            employe.getListeRoles().put(this, new ArrayList<>());
        }
        employe.getTaches(this).add(tache);
        tache.getEmployes().add(employe);
    }

    public void ajouterTacheProjet(Tache tache) {
        tache.projet = this;
        this.ListeTache.add(tache);
    }

    public void supprimerTacheProjet(Tache tache) {     // Supprimer une tache de la liste privée de taches du projet
        ListeTache.remove(tache);
    }
}
