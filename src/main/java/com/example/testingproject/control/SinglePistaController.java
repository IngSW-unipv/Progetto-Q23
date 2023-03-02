package com.example.testingproject.control;

import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.model.Pista;
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
import java.util.ResourceBundle;

public class SinglePistaController {

    @FXML
    Label pistaID;


    public void setPista(Integer Id) {
        pistaID.setText(Id.toString());
    }

}






