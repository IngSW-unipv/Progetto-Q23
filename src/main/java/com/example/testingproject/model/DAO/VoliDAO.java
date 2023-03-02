package com.example.testingproject.model.DAO;
import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.Voli;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class VoliDAO implements IVoliDAO {
    static DatabaseConnection connection = ConnectionHolder.getInstance();

    public  ArrayList<Voli> getVoliPartenza() throws SQLException {
        ArrayList<Voli> voli = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{

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
    public  ArrayList<Voli> getVoliArrivo() throws SQLException {
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



    public boolean inserisciVoli( int idVolo, int durataapp, int ritardoapp,int aereo,String gate) throws SQLException {
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
            errorAlert.showAndWait();
            connection.closeConnection(conn);
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }
    public boolean inserisciPartenza(  int idVolo,int pista,String dataora,String aeroportop) throws SQLException {
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
            errorAlert.showAndWait();
            connection.closeConnection(conn);
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }
    public boolean inserisciArrivo( int idVolo, int pista,String dataora,String aeroportop) throws SQLException {
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


    public ArrayList<Integer> getVoliIdwithPistaId(Integer pistaId) throws SQLException {
        ArrayList<Integer> voli = new ArrayList<Integer>();
        Connection conn = connection.getConnection();

        try{

            String query = "SELECT volo FROM AirportManager.arrivo WHERE volo ="+pistaId.toString()+";";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer tempID;

            while(resultSet.next()){
                tempID= Integer.parseInt(resultSet.getString(1));


                voli.add(tempID);
            }

             query = "SELECT volo FROM AirportManager.partenza WHERE volo ="+pistaId.toString()+";";
             preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();



            while(resultSet.next()){
                tempID= Integer.parseInt(resultSet.getString(1));


                voli.add(tempID);
            }



        }

        catch (SQLException e) {
            connection.closeConnection(conn);
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return voli;
    }


    public Voli findVoloByID(Integer ID){
        Connection conn = connection.getConnection();
        String tempGate;
        int tempDuration,tempId, tempAereo,tempDelay;
        String query = "SELECT * FROM AirportManager.volo where id ="+ID.toString()+";";


        try {
            PreparedStatement  preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                return null;
            }else {
                resultSet.next();
                tempId = Integer.parseInt(resultSet.getString(1));
                tempDuration= Integer.parseInt(resultSet.getString(2));
                tempDelay = Integer.parseInt(resultSet.getString(3));
                tempAereo = Integer.parseInt(resultSet.getString(4));
                tempGate = resultSet.getString(5);
                Voli tempVoli = new Voli(tempGate,null, null, tempId,tempDuration,tempDelay,tempAereo,1);
                connection.closeConnection(conn);
                return tempVoli;
            }

        } catch (SQLException e) {
            connection.closeConnection(conn);
            return null;
        }


    }

    }



