package org.example.devoir2022.dao.impl;

import org.example.devoir2022.dao.MembreDao;
import org.example.devoir2022.models.Incident;
import org.example.devoir2022.models.Membre;
import org.example.devoir2022.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class MembreDaoImpl implements MembreDao {
    @Override
    public boolean inserer(Membre membre){
        try(Connection connection = DataBaseConnection.getConnection()){
            String query = "insert into members values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, membre.getIdentifiant());
            preparedStatement.setString(2, membre.getNom());
            preparedStatement.setString(3, membre.getPrenom());
            preparedStatement.setString(4, membre.getEmail());
            preparedStatement.setString(5, membre.getPhone());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public Set<Incident> chargerListIncident(Membre membre){
        Set<Incident> incidents = null;
        try(Connection connection = DataBaseConnection.getConnection()){
            String query = "SELECT * FROM incident WHERE incident.memberId = ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, membre.getIdentifiant());
            ResultSet resultSet = preparedStatement.executeQuery();
            incidents = new HashSet<Incident>();
            while(resultSet.next()){
                Incident incident = new Incident();
                incident.setMemberId(membre.getIdentifiant());
                incident.setReference(resultSet.getString("reference"));
                incident.setDate(resultSet.getString("date"));
                incident.setStatus(resultSet.getString("status"));
                incidents.add(incident);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return incidents;
    }
}
