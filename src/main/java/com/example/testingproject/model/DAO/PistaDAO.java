package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Pista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PistaDAO {
    static DatabaseConnection connection = ConnectionHolder.getInstance();

    public ArrayList<Pista> findPiste() throws SQLException {
        ArrayList<Pista> piste = new ArrayList<Pista>();
        Connection conn = connection.getConnection();



        try{

            String query = "SELECT id,direzione,lunghezza FROM AirportManager.pista;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            String tempDirection;
            Integer tempId,tempLength;

            while(resultSet.next()){
                tempId = Integer.parseInt(resultSet.getString(1));
                tempDirection = resultSet.getString(2);

                tempLength = Integer.parseInt(resultSet.getString(3));

                Pista tempPista = new Pista(tempId,tempLength,tempDirection);
                piste.add(tempPista);
            }

        }

        catch (SQLException e) {
            connection.closeConnection(conn);
            throw new RuntimeException(e);
        }

        connection.closeConnection(conn);
        return piste;
    }




public Pista findPistaByID(Integer Id) throws SQLException {
    Connection conn = connection.getConnection();
    String tempDirection;
    Integer tempId,tempLength;
    String query = "SELECT id,direzione,lunghezza FROM AirportManager.pista WHERE id = "+Id.toString()+";";


    try {
        PreparedStatement  preparedStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.isBeforeFirst()){
            return null;
        }else {
            resultSet.next();
            tempId = Integer.parseInt(resultSet.getString(1));
            tempDirection = resultSet.getString(2);
            tempLength = Integer.parseInt(resultSet.getString(3));
            Pista tempPista = new Pista(tempId, tempLength, tempDirection);
            connection.closeConnection(conn);
            return tempPista;
        }

    } catch (SQLException e) {
        connection.closeConnection(conn);
        return null;
    }



}


public boolean newPista(Pista pista) throws SQLException {

        Connection conn = connection.getConnection();
        try{
            String direction = pista.getDirection();
            String length = pista.getLength().toString();

            String query = "INSERT INTO AirportManager.pista (direzione, lunghezza)  Values ('"+direction+"', '"+length+"');";

            PreparedStatement preparedStatement =conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            connection.closeConnection(conn);
            return false;
        }

    }

    public boolean removePista(Pista pista) {
        Connection conn = connection.getConnection();
        try{
            Integer Id = pista.getId();

            String query = "DELETE FROM AirportManager.pista WHERE id = "+Id.toString() +";";

            PreparedStatement preparedStatement =conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            connection.closeConnection(conn);
            return false;
        }

    }


}






