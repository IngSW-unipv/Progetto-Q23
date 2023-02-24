package com.example.testingproject.model.DAO;

import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Terreno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TerreniDAO {
    static DatabaseConnection connection = new DatabaseConnection();


    public static ArrayList<Terreno> getTerreni() throws SQLException {
        ArrayList<Terreno> terreni = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{
            //change tipo to type, change database table layout
            String query = "SELECT * FROM AirportManager.hangar;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer tempId,tempNposti,tempPostiLiberi;

            while(resultSet.next()){
                tempId = resultSet.getInt(1);
                tempNposti = resultSet.getInt(2);
                tempPostiLiberi = resultSet.getInt(3);
                Terreno tempterreno = new Terreno(tempId,tempNposti,tempPostiLiberi);
                terreni.add(tempterreno);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return terreni;
    }


}
