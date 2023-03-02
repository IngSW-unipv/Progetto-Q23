package com.example.testingproject.model;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHolder {

    private static DatabaseConnection instance;
    private Connection connection;
    private final String databaseUser = "root";
    private final String databasePassword = "riccardo12caiulo";
    private final String url = "jdbc:mysql://34.68.181.102:3306/AirportManager";

    private ConnectionHolder() throws SQLException {
            try {
                Class.forName("org.postgresql.Driver");
                this.connection = DriverManager.getConnection(url, databaseUser, databasePassword);
            } catch (ClassNotFoundException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }
        public Connection getConnection() {
            return connection;
        }
        public static DatabaseConnection getInstance()  {
        try {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
            return instance;
        }catch (SQLException e){
        }
            return null;
        }
    }