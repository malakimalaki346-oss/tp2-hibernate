package com.example.service;

import com.example.model.Utilisateur;

public class UtilisateurService extends AbstractCrudService<Utilisateur, Long> {

    public UtilisateurService() {
        super(Utilisateur.class);
    }
}