package com.example.testingproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection connection;
   private String databaseUser = "root";
   private String databasePassword = "riccardo12caiulo";
   private String url = "jdbc:mysql://34.68.181.102:3306/%s";


    public Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return connection;
    }


    public void closeConnection(Connection connection) throws SQLException {

       if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }




}
