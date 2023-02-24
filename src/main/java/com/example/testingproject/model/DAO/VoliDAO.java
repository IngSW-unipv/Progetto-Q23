package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Voli;

import java.sql.*;
import java.util.ArrayList;

public class VoliDAO {
    static DatabaseConnection connection = new DatabaseConnection();

    public static ArrayList<Voli> getVoli() throws SQLException {
        ArrayList<Voli> voli = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{
            //change tipo to type, change database table layout
            String query = "SELECT A.*,NOMEAEREO FROM volo as A JOIN(SELECT id,modello AS NOMEAEREO FROM aereo )AS B ON B.id=A.id;";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            String tempGate,tempNomeAereo;
            int tempId,tempDurata,tempRitardo,tempAereo;

            while(resultSet.next()){
                tempGate = resultSet.getString(5);
                tempNomeAereo = resultSet.getString(6);
                tempId = resultSet.getInt(1);
                tempDurata = resultSet.getInt(2);
                tempRitardo = resultSet.getInt(3);
                tempAereo = resultSet.getInt(4);
                Voli tempVoli = new Voli(tempGate,tempNomeAereo,tempId,tempDurata,tempRitardo,tempAereo);
                voli.add(tempVoli);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        connection.closeConnection(conn);
        return voli;
    }

    /*public boolean createAccount(Account account){
        Connection conn = connection.getConnection();
        try{
            String query = "INSERT INTO Utente (" + account.getUsername() + "," + account.getPassword() + "," + account.getUserType() + ")";
            PreparedStatement preparedStatement =conn.prepareStatement(query);
            preparedStatement.executeQuery();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }*/




}
