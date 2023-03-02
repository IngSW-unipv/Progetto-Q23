package com.example.testingproject.control;

import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.model.Voli;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class SinglePistaController {

    @FXML
    Label pistaID;

     @FXML
    ListView voliViewList;




    public void setPista(Integer Id) throws SQLException {
        VoliDAO voliDAO = new VoliDAO();
        pistaID.setText(Id.toString());
        ArrayList<Integer> voli = voliDAO.getVoliIdwithPistaId(Id);
        Voli volo;

        for (int i = 0; i < voli.size(); i++) {
             volo = voliDAO.findVoloByID(voli.get(i));
            voliViewList.getItems().add(volo.getId() + "                  " +volo.getGate()+"                    "+volo.getDurata()+"                "+volo.getRitardo()+"               "+volo.getAereo());

        }



    }

}






