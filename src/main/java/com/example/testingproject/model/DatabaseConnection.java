package com.example.testingproject.model;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection connection;
   private final String databaseUser = "root";
   private final String databasePassword = "riccardo12caiulo";
   private final String url = "jdbc:mysql://34.68.181.102:3306/AirportManager";


    public Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception exception){
            exception.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Connessione");
            errorAlert.setHeaderText("Connessione non riuscita");
            errorAlert.setContentText("Connessione non riuscita. Controlla la connessione alla rete");
            errorAlert.showAndWait();
        }
        return connection;
    }


    public void closeConnection(Connection connection) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Errore di Chiusura Connessione");
                errorAlert.setHeaderText("Chiusura connessione non riuscita");
                errorAlert.setContentText("Chiusura connessione non riuscita. Controlla la connessione alla rete");
                errorAlert.showAndWait();
            }
        }




}
