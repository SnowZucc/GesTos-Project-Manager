import java.time.LocalDateTime;
import java.util.ArrayList;

public class Projet {
    private String Titre;
    private boolean Etat;
    private ArrayList<Tache> ListeTache;
    private ArrayList<Employe> ListeEmploye;
    private LocalDateTime Deadline;
    public Projet(String Titre, LocalDateTime Deadline) {
        this.Titre = Titre;
        // Modification de l'état en temps réel: lorsque toutes les taches sont terminées, le projet est terminé
        // Si on ajoute une tache, le projet est inachevé jusqu'à ce que cette dernière soit terminée
//        for (Tache tache : ListeTache) {
//            if (tache.getStatut().equals("Terminé")) {
//                continue;
//            }
//        }
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
    public LocalDateTime getDeadline() {
        return Deadline;
    }
    public void setDeadline(LocalDateTime Deadline) {
        this.Deadline = Deadline;
    }


    public void modifierProjet(String Titre, LocalDateTime newDeadline) {
        this.Titre = Titre;
        this.Deadline = newDeadline;
    }
    public void supprimerProjet() {}


    public void attribuerRole(Employe employe, Tache tache) {
        tache.getEmployes().add(employe);
    }
}
