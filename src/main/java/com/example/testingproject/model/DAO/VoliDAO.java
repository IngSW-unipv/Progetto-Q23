package com.example.testingproject.model.DAO;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.Voli;
import java.sql.*;
import java.util.ArrayList;

public class VoliDAO {
    static DatabaseConnection connection = new DatabaseConnection();

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



    public static void inserisciVoli( int idVolo, int durataapp, int ritardoapp,int aereo,String gate) {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO volo(id,durata,ritardo,aereo,gate) values('"+idVolo+"', '"+durataapp+"', '"+ritardoapp+"', '"+aereo+ "' , '" +gate+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public static void inserisciPartenza(  int pista,String dataora,String aeroportop) {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO partenza(aeroportoa,dataora,pista) values('"+aeroportop+"', '"+dataora+"', '"+pista+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public static void inserisciArrivo(  int pista,String dataora,String aeroportop) {
        Connection conn = connection.getConnection();
        try {
            String query = "INSERT INTO arrivo(aeroportop,dataora,pista) values('"+aeroportop+"', '"+dataora+"', '"+pista+"')";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static void getVoliwithGate(Integer gateID) throws SQLException {
        ArrayList<Voli> voli = new ArrayList<Voli>();
        Connection conn = connection.getConnection();

try {
    String query = "SELECT id,direzione,lunghezza FROM AirportManager.pista;";
    PreparedStatement preparedStatement = conn.prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();



}
catch (SQLException e){
    e.printStackTrace();
}



    }





}
