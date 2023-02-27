package com.example.testingproject.model.DAO;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.VistaVoloBagaglio;
import javafx.scene.control.Alert;

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
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Il bagaglio non esiste");
                errorAlert.showAndWait();
                return null;
            } else {
                resultSet.next();
                tempId = resultSet.getInt(1);
                tempPeso = resultSet.getInt(2);
                tempVolo = resultSet.getInt(4);
                tempStato = resultSet.getString(3);

                return new Luggage(tempId, tempPeso, tempStato, tempVolo);
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


    public boolean verifyFly(int idVolo, String firstAirport, String secondAirport) {
        Connection conn = connection.getConnection();
        try {
            int tempVolo;
            String tempArrivo, tempPartenza;
            String query = "SELECT partenza.volo,arrivo.aeroportop,partenza.aeroportoa FROM arrivo, partenza WHERE arrivo.volo = partenza.volo ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return false;
            } else while (resultSet.next()) {
                tempVolo = resultSet.getInt(1);
                tempPartenza = resultSet.getString(2);
                tempArrivo = resultSet.getString(3);
                if ((tempPartenza.equals(firstAirport)) && (tempArrivo.equals(secondAirport)) && (tempVolo == idVolo)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addLuggage(int peso, String stato, int volo) {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO bagaglio(peso,stato,volo) values('" + peso + "', '" + stato + "', '" + volo + "')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    // verifica se volo è pertinente e se è possibile inserire un'altro bagaglio
    public boolean verifyPlaceonBord(int idVolo, int wight, String firstAirport, String secondAirport) {
        Connection conn = connection.getConnection();
        try {
            int tempVolo;
            int tempCaricoMax;
            String tempArrivo, tempPartenza;
            String query = "select aereo, aeroportoa, aeroportop, volo, caricomax FROM(select aereo, aeroportoa, aeroportop, volo FROM (SELECT partenza.volo,arrivo.aeroportop,partenza.aeroportoa FROM arrivo, partenza WHERE arrivo.volo = partenza.volo) T join volo on T.volo = volo.id) T2 join aereo on (T2.aereo = aereo.id);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return false;
            } else while (resultSet.next()) {
                tempArrivo = resultSet.getString(2);
                tempPartenza = resultSet.getString(3);
                tempVolo = resultSet.getInt(4);
                tempCaricoMax = resultSet.getInt(5);
                if ((tempPartenza.equals(firstAirport)) && (tempArrivo.equals(secondAirport)) && (tempVolo == idVolo)) {
                    if ((tempCaricoMax >= wight)) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int sumWigth(int idVolo) {
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
                return tempPeso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean verifyLuggegeinFly(int idBagaglio, int idVolo) {
        Connection conn = connection.getConnection();
        try {
            String query = "SELECT * FROM AirportManager.bagaglio where volo = '" + idVolo + "' and id = '" + idBagaglio + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return false;
            } else {
                resultSet.next();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<VistaVoloBagaglio> getVistaArrivo() {
        ArrayList<VistaVoloBagaglio> vista = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            String query = "SELECT partenza.volo,arrivo.aeroportop,partenza.aeroportoa FROM arrivo, partenza WHERE arrivo.volo = partenza.volo";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int tempId;
            String tempAeroportoP, tempAeroportoA;

            while (resultSet.next()) {
                tempId = resultSet.getInt(1);
                tempAeroportoP = resultSet.getString(2);
                tempAeroportoA = resultSet.getString(3);
                VistaVoloBagaglio tempVolo = new VistaVoloBagaglio(tempId, tempAeroportoP, tempAeroportoA);
                vista.add(tempVolo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vista;
    }
}