package com.example.testingproject.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection DatabaseLink;

    public Connection getConnection(){
        String databaseName ="";
        String databaseUser = "";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" +databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return DatabaseLink;
    }

}
