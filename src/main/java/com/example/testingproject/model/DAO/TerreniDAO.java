package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Aereo;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Sosta;
import com.example.testingproject.model.Hangar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TerreniDAO {
    static DatabaseConnection connection = new DatabaseConnection();


    public static ArrayList<Hangar> getTerreni() throws SQLException {
        ArrayList<Hangar> terreni = new ArrayList<>();
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
                Hangar tempterreno = new Hangar(tempId,tempNposti,tempPostiLiberi);
                terreni.add(tempterreno);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return terreni;
    }
    public static ArrayList<Sosta> getSoste(int id) throws SQLException {
        ArrayList<Sosta> soste = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{
            //change tipo to type, change database table layout
            String query = "SELECT * FROM AirportManager.sosta where hangar= '"+id+"';";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer tempHangar,tempAereo;
            String  tempInizio,tempFine;


            while(resultSet.next()){
                tempHangar = resultSet.getInt(1);
                tempAereo = resultSet.getInt(2);
                tempInizio = resultSet.getString(3);
                tempFine = resultSet.getString(4);
                Sosta tempSosta = new Sosta(tempHangar,tempAereo,tempInizio,tempFine);
                soste.add(tempSosta);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return soste;
    }
    public static ArrayList<Aereo> getAerei() throws SQLException {
        ArrayList<Aereo> aerei = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            //change tipo to type, change database table layout
            String query = "SELECT * FROM AirportManager.aereo;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int tempId, tempCaricoMax;
            String tempModello;

            while (resultSet.next()) {
                tempId = resultSet.getInt(1);
                tempCaricoMax = resultSet.getInt(3);
                tempModello = resultSet.getString(2);
                Aereo tempAereo = new Aereo(tempId, tempCaricoMax, tempModello);
                aerei.add(tempAereo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return aerei;
    }

}
