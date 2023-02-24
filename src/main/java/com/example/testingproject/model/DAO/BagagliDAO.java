package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Luggage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BagagliDAO {
    static DatabaseConnection connection = new DatabaseConnection();

    public static ArrayList<Luggage> getLuggage() throws SQLException {
        ArrayList<Luggage> luggages = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            String query = "SELECT * FROM bagaglio";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            String tempStato;
            int tempId, tempPeso, tempVolo;

            while (resultSet.next()) {
                tempId = resultSet.getInt(1);
                tempPeso = resultSet.getInt(2);
                tempVolo = resultSet.getInt(4);
                tempStato = resultSet.getString(3);
                Luggage tempLugagges = new Luggage(tempId, tempPeso, tempStato, tempVolo);
                luggages.add(tempLugagges);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return luggages;
    }

    public static Luggage getLuggaggeById(int id) {
        Connection conn = connection.getConnection();

        try {
            String tempStato;
            int tempId, tempPeso, tempVolo;
            String query = "SELECT * FROM AirportManager.bagaglio WHERE id = '" + id + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return null;
            } else {
                resultSet.next();
                tempId = resultSet.getInt(1);
                tempPeso = resultSet.getInt(2);
                tempVolo = resultSet.getInt(4);
                tempStato = resultSet.getString(3);

                Luggage tempLuggages = new Luggage(tempId,  tempPeso,tempStato, tempVolo);
                return tempLuggages;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}