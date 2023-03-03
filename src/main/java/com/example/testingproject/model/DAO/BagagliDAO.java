package com.example.testingproject.model.DAO;
import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Luggage;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BagagliDAO implements IBagagliDAO{
     DatabaseConnection connection = ConnectionHolder.getInstance();

    public  ArrayList<Luggage> getLuggage() throws SQLException {
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

    public Luggage getLuggaggeById(int id) throws SQLException {
        Connection conn = connection.getConnection();

        try {
            String tempStato;
            int tempId, tempPeso, tempVolo;
            String query = "SELECT * FROM AirportManager.bagaglio WHERE id = '" + id + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Il bagaglio non esiste");
                errorAlert.showAndWait();
                connection.closeConnection(conn);
                return null;
            } else {
                resultSet.next();
                tempId = resultSet.getInt(1);
                tempPeso = resultSet.getInt(2);
                tempVolo = resultSet.getInt(4);
                tempStato = resultSet.getString(3);
                connection.closeConnection(conn);
                return new Luggage(tempId, tempPeso, tempStato, tempVolo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.closeConnection(conn);
            return null;
        }
    }

    public void modifyStato(int id, String Stato) throws SQLException{
        Connection conn = connection.getConnection();
        try {
            String query = "UPDATE `AirportManager`.`bagaglio` SET `stato` = '" + Stato + "' WHERE (`id` = '" + id + "');";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            connection.closeConnection(conn);
        }
    }

    @Override
    public boolean verify(int idBagaglio) throws SQLException {
        Connection conn = connection.getConnection();
        try {
            int tempbagaglio;
            String query = "SELECT * FROM AirportManager.bagaglio ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                connection.closeConnection(conn);
                return false;
            } else while (resultSet.next()) {
                tempbagaglio = resultSet.getInt(1);
                if ((tempbagaglio == idBagaglio)) {
                    connection.closeConnection(conn);
                    return true;
                }
            }
        } catch (SQLException e) {
            connection.closeConnection(conn);
            e.printStackTrace();
        }
        return false;
    }


    public boolean verifyFlyArrivo(int idVolo, String Airport) throws SQLException{
        Connection conn = connection.getConnection();
        try {
            int tempVolo;
            String tempPartenza;
            String query = "SELECT * FROM AirportManager.arrivo; ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                connection.closeConnection(conn);
                return false;
            } else while (resultSet.next()) {
                tempVolo = resultSet.getInt(1);
                tempPartenza = resultSet.getString(3);
                if ((tempPartenza.equals(Airport)) && (tempVolo == idVolo)) {
                    connection.closeConnection(conn);
                    return true;
                }
            }
        } catch (SQLException e) {
            connection.closeConnection(conn);
            e.printStackTrace();
        }
        return false;
    }

    public boolean verifyFlyPartenza(int idVolo, String Airport) throws SQLException{
        Connection conn = connection.getConnection();
        try {
            int tempVolo;
            String tempArrivo;
            String query = "SELECT * FROM AirportManager.partenza; ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                connection.closeConnection(conn);
                return false;
            } else while (resultSet.next()) {
                tempVolo = resultSet.getInt(1);
                tempArrivo= resultSet.getString(3);
                if ((tempArrivo.equals(Airport)) && (tempVolo == idVolo)) {
                    connection.closeConnection(conn);
                    return true;
                }
            }
        } catch (SQLException e) {
            connection.closeConnection(conn);
            e.printStackTrace();
        }
        return false;
    }
    public void addLuggage(int peso, String stato, int volo) throws SQLException{
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO bagaglio(peso,stato,volo) values('" + peso + "', '" + stato + "', '" + volo + "')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            connection.closeConnection(conn);
        }
    }

    // verifica se volo è pertinente e se è possibile inserire un'altro bagaglio
    public boolean verifyPlaceonBord(int idVolo, int wight)  throws SQLException {
        Connection conn = connection.getConnection();
        try {
            int tempVolo;
            int tempCaricoMax;
            String tempArrivo, tempPartenza;
            String query = "SELECT volo.id, caricomax FROM volo join aereo on volo.aereo = aereo.id where volo.id = '"+ idVolo+ "'";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                connection.closeConnection(conn);
                return false;
            } else while (resultSet.next()) {
                tempVolo = resultSet.getInt(1);
                tempCaricoMax = resultSet.getInt(2);
                if ((tempVolo == idVolo)) {
                    if ((tempCaricoMax >= wight)) {
                        connection.closeConnection(conn);
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            connection.closeConnection(conn);
            e.printStackTrace();
        }
        connection.closeConnection(conn);
        return false;
    }

    public int sumWigth(int idVolo) throws SQLException {
        Connection conn = connection.getConnection();
        try {
            int tempPeso;
            String query = " SELECT sum(PESO), volo FROM (select volo,peso from bagaglio) as a join(select id from volo) as b on b.id=volo where volo ='" + idVolo + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Il bagaglio non esiste");
                errorAlert.showAndWait();
            } else {
                resultSet.next();
                tempPeso = resultSet.getInt(1);
                connection.closeConnection(conn);
                return tempPeso;
            }
        } catch (SQLException e) {
            connection.closeConnection(conn);
            e.printStackTrace();
        }
        connection.closeConnection(conn);
        return 0;
    }
}