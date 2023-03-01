package com.example.testingproject.model.DAO;
import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Voli;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class VoliDAO {
    static DatabaseConnection connection = ConnectionHolder.getInstance();

    public static ArrayList<Voli> getVoliPartenza() throws SQLException {
        ArrayList<Voli> voli = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{
            //change tipo to type, change database table layout
            String query = "SELECT A.*,B.pista,B.aeroportoa,B.dataora FROM volo AS A JOIN(SELECT * FROM partenza )AS B ON A.id=B.volo;";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            String tempGate,tempAeroportoP,tempDataora;
            int tempId,tempDurata,tempRitardo,tempAereo,tempPista;

            while(resultSet.next()){

                tempId = resultSet.getInt(1);
                tempDurata = resultSet.getInt(2);
                tempRitardo = resultSet.getInt(3);
                tempAereo = resultSet.getInt(4);
                tempGate = resultSet.getString(5);
                tempPista = resultSet.getInt(6);
                tempAeroportoP = resultSet.getString(7);
                tempDataora = resultSet.getString(8);


                Voli tempVoli = new Voli(tempGate,tempAeroportoP,tempDataora,tempId,tempDurata,tempRitardo,tempAereo,tempPista);
                voli.add(tempVoli);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        connection.closeConnection(conn);
        return voli;
    }
    public static ArrayList<Voli> getVoliArrivo() throws SQLException {
        ArrayList<Voli> voli = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{
            //change tipo to type, change database table layout
            String query = "SELECT A.*,B.pista,B.aeroportop,B.dataora FROM volo AS A JOIN(SELECT * FROM arrivo )AS B ON A.id=B.volo;";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            String tempGate,tempAeroportoP,tempDataora;
            int tempId,tempDurata,tempRitardo,tempAereo,tempPista;

            while(resultSet.next()){
                tempId = resultSet.getInt(1);
                tempDurata = resultSet.getInt(2);
                tempRitardo = resultSet.getInt(3);
                tempAereo = resultSet.getInt(4);
                tempGate = resultSet.getString(5);
                tempPista = resultSet.getInt(6);
                tempAeroportoP = resultSet.getString(7);
                tempDataora = resultSet.getString(8);
                Voli tempVoli = new Voli(tempGate,tempAeroportoP,tempDataora,tempId,tempDurata,tempRitardo,tempAereo,tempPista);
                voli.add(tempVoli);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        connection.closeConnection(conn);
        return voli;
    }



    public static boolean inserisciVoli( int idVolo, int durataapp, int ritardoapp,int aereo,String gate) throws SQLException {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO volo(id,durata,ritardo,aereo,gate) values('"+idVolo+"', '"+durataapp+"', '"+ritardoapp+"', '"+aereo+ "' , '" +gate+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Inserimento");
            errorAlert.setHeaderText("Record già esistente");
            errorAlert.setContentText("La sosta inserita esiste già in tabella");
            errorAlert.showAndWait();
            connection.closeConnection(conn);
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static boolean inserisciPartenza(  int idVolo,int pista,String dataora,String aeroportop) throws SQLException {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO partenza(volo,aeroportoa,dataora,pista) values('"+idVolo+"''"+aeroportop+"', '"+dataora+"', '"+pista+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Inserimento");
            errorAlert.setHeaderText("Record già esistente");
            errorAlert.setContentText("La sosta inserita esiste già in tabella");
            errorAlert.showAndWait();
            connection.closeConnection(conn);
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static boolean inserisciArrivo( int idVolo, int pista,String dataora,String aeroportop) throws SQLException {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO arrivo(volo,aeroportop,dataora,pista) values('"+idVolo+"','"+aeroportop+"', '"+dataora+"', '"+pista+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Inserimento");
            errorAlert.setHeaderText("Record già esistente");
            errorAlert.setContentText("La sosta inserita esiste già in tabella");
            errorAlert.showAndWait();
            connection.closeConnection(conn);
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }

    /*
    public ArrayList<Voli> getVoliwithPista(int pista){


    }
*/




}
