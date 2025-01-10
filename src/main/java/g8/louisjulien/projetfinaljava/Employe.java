package g8.louisjulien.projetfinaljava;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Employe {
    private String Nom;
    private LocalDateTime DateEmbauche;
    private HashMap<Projet, List<Tache>> listeRoles;

    private static List<Employe> employes = new ArrayList<>();

    public Employe(String nom, LocalDateTime dateEmbauche) {
        Nom = nom;
        DateEmbauche = dateEmbauche;
        listeRoles = new HashMap<>();

        employes.add(this);
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

    public static List<Employe> getEmployes() {     // Retourne la liste des employés "employes"
        return employes;
    }

    public void obtenirInfos() {
        System.out.println(this.getNom() + this.getDateEmbauche());
    }



    public List<String[]> getHistorique() {     // Modification pour retourner une liste
        List<String[]> historiqueList = new ArrayList<>();

        for (Projet projet : this.getProjets()) {
            if (projet.getEtat()) {
                for (Tache tache : this.getTaches(projet)) {
                    historiqueList.add(new String[]{projet.getTitre(), tache.toString()});
                }
            }
        }
        System.out.println(historiqueList);
        return historiqueList;
    }

    public static void modifierEmploye(Employe employe, String newNom, LocalDateTime newDateEmbauche) {
        employe.Nom = newNom;
        employe.DateEmbauche = newDateEmbauche;
    }
}

