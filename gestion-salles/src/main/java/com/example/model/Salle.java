package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le nom de la salle est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    @Column(nullable = false)
    private String nom;

    @Min(value = 1, message = "La capacité doit être supérieure à 0")
    @Column(nullable = false)
    private int capacite;

    // Constructeur vide obligatoire
    public Salle() {
    }

    // Constructeur avec paramètres
    public Salle(String nom, int capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", capacite=" + capacite +
                '}';
    }
}