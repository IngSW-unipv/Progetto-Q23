package com.example.testingproject.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection DatabaseLink;

    public Connection getConnection(){
        String databaseName ="java";
        String databaseUser = "root";
        String databasePassword = "riccardo12caiulo";
        String url = "34.68.181.102" +databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return DatabaseLink;
    }

}
