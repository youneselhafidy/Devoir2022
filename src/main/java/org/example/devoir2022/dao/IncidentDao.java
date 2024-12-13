package org.example.devoir2022.dao;

import org.example.devoir2022.models.Incident;

import java.util.Set;

public interface IncidentDao {
    public boolean inserer(Incident incident);
    public boolean inserer(Set<Incident> incidents);
}
