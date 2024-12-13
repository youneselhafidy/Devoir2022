package org.example.devoir2022.dao.impl;

import org.example.devoir2022.dao.IncidentDao;
import org.example.devoir2022.models.Incident;
import org.example.devoir2022.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    @Override
    public boolean inserer(Incident incident){
        try(Connection connection = DataBaseConnection.getConnection()){
            String query = "insert into incidents values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,incident.getMemberId());
            preparedStatement.setString(2,incident.getReference());
            preparedStatement.setString(3,incident.getDate());
            preparedStatement.setString(4,incident.getStatus());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean inserer(Set<Incident> incidents){
        try(Connection connection = DataBaseConnection.getConnection()){
            String query = "insert into incidents values(?,?,?,?)";
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            for(Incident incident : incidents){
                preparedStatement.setString(1,incident.getMemberId());
                preparedStatement.setString(2,incident.getReference());
                preparedStatement.setString(3,incident.getDate());
                preparedStatement.setString(4,incident.getStatus());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            connection.commit();

            connection.setAutoCommit(true);
        }catch(SQLException e){
            try(Connection connection = DataBaseConnection.getConnection()){
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
