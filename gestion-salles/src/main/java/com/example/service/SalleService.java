package com.example.service;

import com.example.model.Salle;

public class SalleService extends AbstractCrudService<Salle, Long> {

    public SalleService() {
        super(Salle.class);
    }
}