package g8.louisjulien.projetfinaljava;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Employe {
    private String Nom;
    private LocalDateTime DateEmbauche;
    private HashMap<Projet, List<Tache>> listeRoles;

    public Employe(String nom, LocalDateTime dateEmbauche) {
        Nom = nom;
        DateEmbauche = dateEmbauche;
    }

    public String getNom() {
        return Nom;
    }
    public LocalDateTime getDateEmbauche() {
        return DateEmbauche;
    }
    public Set<Projet> getProjets() {
        return listeRoles.keySet();
    }
    public List<Tache> getTaches(Projet projet) {
        if (listeRoles.containsKey(projet)) {
            return listeRoles.get(projet);
        }
        System.out.println("L'employé " + this.getNom() + " ne participe pas au projet " + projet.getTitre());
        return null;
    }

    public void obtenirInfos() {
        System.out.println(this.getNom() + this.getDateEmbauche());
    }



    public void historique() {
        System.out.println("Historique des tâches de " + this.getNom() + " :\n");
        for (Projet projet : this.getProjets()) {
            if (projet.getEtat()) {
                System.out.println("PROJET " + projet.getTitre());
                for (Tache tache : this.getTaches(projet)) {
                    System.out.println("\t" + tache.toString());
                }
            }
        }
        System.out.println("\n\n");
    }

    public void modifierEmploye(String newNom, LocalDateTime newDateEmbauche) {
        this.Nom = newNom;
        this.DateEmbauche = newDateEmbauche;
    }
}

