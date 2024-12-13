package org.example.devoir2022.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Devoir2022";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    public static Connection getConnection() {
        if (connection == null) {
            try{
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
