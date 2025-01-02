import java.time.LocalDateTime;
import java.util.ArrayList;

public class Projet {
    private String Titre;
    private ArrayList<Tache> ListeTache;
    private ArrayList<Employe> ListeEmploye;
    private LocalDateTime Deadline;
    public Projet(String Titre, LocalDateTime Deadline) {
        this.Titre = Titre;
        this.Deadline = Deadline;
    }


    public String getTitre() {
        return Titre;
    }
    public void setTitre(String Titre) {
        this.Titre = Titre;
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
}
