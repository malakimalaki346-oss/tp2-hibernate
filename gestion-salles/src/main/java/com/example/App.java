package com.example;

import com.example.model.Utilisateur;
import com.example.model.Salle;
import com.example.service.UtilisateurService;
import com.example.service.SalleService;

import java.util.List;

public class App {

    public static void main(String[] args) {

        UtilisateurService utilisateurService = new UtilisateurService();
        SalleService salleService = new SalleService();

        // =========================
        // CREATE
        // =========================
        Utilisateur u1 = new Utilisateur("Ali", "ali@email.com");
        utilisateurService.create(u1);

        Salle s1 = new Salle("Salle A", 30);
        salleService.create(s1);

        System.out.println("=== Après insertion ===");

        // =========================
        // READ ALL
        // =========================
        List<Utilisateur> utilisateurs = utilisateurService.findAll();
        utilisateurs.forEach(System.out::println);

        List<Salle> salles = salleService.findAll();
        salles.forEach(System.out::println);

        // =========================
        // UPDATE
        // =========================
        if (!utilisateurs.isEmpty()) {
            Utilisateur utilisateur = utilisateurs.get(0);
            utilisateur.setNom("Ali Modifié");
            utilisateurService.update(utilisateur);
        }

        System.out.println("=== Après modification ===");
        utilisateurService.findAll().forEach(System.out::println);

        // =========================
        // DELETE
        // =========================
        if (!salles.isEmpty()) {
            Salle salle = salles.get(0);
            salleService.delete(salle.getId());
        }

        System.out.println("=== Après suppression salle ===");
        salleService.findAll().forEach(System.out::println);

        System.out.println("=== Fin du programme ===");
    }
}