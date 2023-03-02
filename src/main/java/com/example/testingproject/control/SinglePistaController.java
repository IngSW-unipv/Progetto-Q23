package com.example.testingproject.control;

import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.Voli;
import com.example.testingproject.model.Wind;
import com.example.testingproject.model.service.PistaService;
import com.example.testingproject.view.piste.PisteApplication;
import com.example.testingproject.view.piste.SinglePistaApplication;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

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






