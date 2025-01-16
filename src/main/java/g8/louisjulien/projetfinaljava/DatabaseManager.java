package g8.louisjulien.projetfinaljava;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:projets.db";

    // Création de la base de données et des tables
    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                String createProjetTable = "CREATE TABLE IF NOT EXISTS Projet (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Titre TEXT, " +
                        "Deadline TEXT, " +
                        "Etat BOOLEAN)";

                String createTacheTable = "CREATE TABLE IF NOT EXISTS Tache (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Titre TEXT, " +
                        "Description TEXT, " +
                        "Statut TEXT, " +
                        "Priorite TEXT, " +
                        "ProjetId INTEGER, " +
                        "FOREIGN KEY (ProjetId) REFERENCES Projet(id))";

                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createProjetTable);
                    stmt.execute(createTacheTable);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ajouter un projet
    public static void addProjet(String titre, LocalDate deadline, boolean etat) {
        String sql = "INSERT INTO Projet(Titre, Deadline, Etat) VALUES(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titre);
            //pstmt.setDate(2, deadline);
            pstmt.setBoolean(3, etat);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ajouter une tâche
    public static void addTache(String titre, String description, String statut, String priorite, int projetId) {
        String sql = "INSERT INTO Tache(Titre, Description, Statut, Priorite, ProjetId) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titre);
            pstmt.setString(2, description);
            pstmt.setString(3, statut);
            pstmt.setString(4, priorite);
            pstmt.setInt(5, projetId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer tous les projets
    public static List<Projet> getAllProjets() {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT * FROM Projet";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Projet projet = new Projet(
                        rs.getString("Titre"),
                        LocalDate.parse(rs.getString("Deadline"))
                );
                projet.Etat = rs.getBoolean("Etat");
                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }

    // Récupérer les tâches d'un projet
    public static List<Tache> getTachesByProjetId(int projetId) {
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM Tache WHERE ProjetId = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, projetId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Tache tache = new Tache(
                            rs.getString("Titre"),
                            rs.getString("Description"),
                            rs.getString("Priorite")
                    );
                    tache.setStatut(rs.getString("Statut").equals("Terminé") ? 4 : 1); // Exemple de conversion de statut
                    taches.add(tache);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taches;
    }
}
