import java.util.ArrayList;

public class Tache {
    private String Titre;
    private String Description;
    private String Statut; // 4 phases: En attente, En cours, Test, Terminé
    private String Priorite; // Prioritaire, Urgent, Secondaire, Non Urgent
    private ArrayList<Employe> ListeEmploye;
    public Tache(String titre, String description, String Statut, String Priorite) {
        Titre = titre;
        Description = description;
        this.Statut = Statut;
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
    public void setStatut(String statut) {
        Statut = statut;
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
        this.Statut = newStatut;
        this.Priorite = newPriorite;
    }
    public void supprimerTache() {}
}
