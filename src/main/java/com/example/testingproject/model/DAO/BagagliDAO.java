package com.example.testingproject.model.DAO;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Luggage;;
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

    public Luggage getLuggaggeById(int id) {
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

                Luggage tempLuggages = new Luggage(tempId, tempPeso, tempStato, tempVolo);
                return tempLuggages;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyStato(int id, String Stato) {
        Connection conn = connection.getConnection();
        try {
            String query = "UPDATE `AirportManager`.`bagaglio` SET `stato` = '" + Stato + "' WHERE (`id` = '" + id + "');";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    // metodo per l'inserimento di bagagli all'interno di database
    public boolean verifyLuggaggeArrive(int idVolo,String firstAirport, String secondAirport) {
        Connection conn = connection.getConnection();
        boolean continua = true;
        try {
            int tempVolo;
            String tempArrivo, tempPartenza;
            String query = "SELECT partenza.volo,arrivo.aeroportop,partenza.aeroportoa FROM arrivo, partenza WHERE arrivo.volo = partenza.volo ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {

            } else {
                while(resultSet.next() && (continua == true)) {
                    tempVolo = resultSet.getInt(1);
                    tempPartenza = resultSet.getString(2);
                    tempArrivo = resultSet.getString(3);

                    if ((tempPartenza.equals(firstAirport)) && (tempArrivo.equals(secondAirport)) && (tempVolo == idVolo)) {
                        continua = false;
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addLuggage( int peso, String stato, int volo) {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO bagaglio(peso,stato,volo) values('"+peso+"', '"+stato+"', '"+volo+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

}
