package org.example.devoir2022.dao;

import org.example.devoir2022.models.Incident;
import org.example.devoir2022.models.Membre;

import java.util.List;
import java.util.Set;

public interface MembreDao {
    public boolean inserer(Membre membre);
    public Set<Incident> chargerListIncident(Membre membre);
}
