package g8.louisjulien.projetfinaljava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Employe {
    private String Nom;
    private LocalDate DateEmbauche;
    private HashMap<Projet, List<Tache>> listeRoles;

    private static List<Employe> employes = new ArrayList<>();

    public Employe(String nom, LocalDate dateEmbauche) {
        Nom = nom;
        DateEmbauche = dateEmbauche;
        listeRoles = new HashMap<>();

        employes.add(this);
    }

    public String getNom() {
        return Nom;
    }
    public LocalDate getDateEmbauche() {
        return DateEmbauche;
    }
    public HashMap<Projet, List<Tache>> getListeRoles() {return listeRoles;}
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

    public static List<Employe> getEmployes() {     // Retourne la liste des employés "employes"
        return employes;
    }

    public void obtenirInfos() {
        System.out.println(this.getNom() + this.getDateEmbauche());
    }



    public List<String[]> getHistorique() {     // Modification pour retourner une liste
        List<String[]> historiqueList = new ArrayList<>();
        System.out.println("HISTORIQUE DE " + this.getNom());
        for (Projet projet : this.getProjets()) {
            if (projet.getEtat().equals("Complété")) {
                System.out.println("Projet : " + projet.getTitre());
                for (Tache tache : this.getTaches(projet)) {
                    System.out.println("\tTâche : " + tache.getTitre());
                    historiqueList.add(new String[]{projet.getTitre(), tache.getTitre()});
                }
            }
        }
        return historiqueList;
    }

    public static void modifierEmploye(Employe employe, String newNom, LocalDate newDateEmbauche) {
        employe.Nom = newNom;
        employe.DateEmbauche = newDateEmbauche;
    }
}

