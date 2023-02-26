package com.example.testingproject.control;
import com.example.testingproject.model.Account;
import com.example.testingproject.model.Voli;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.model.DAO.VoliDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.stage.Stage;
import com.example.testingproject.view.Voli.VoliArrivo.VoliArrivoApplication;
import com.example.testingproject.view.Voli.VoliPartenze.VoliPartenzeApplication;
import com.example.testingproject.view.Voli.AggiuntaVoli.AggiuntaVoliApplication;

public class VoliController{
    ArrayList<Voli> voli_ = new ArrayList<>();

    @FXML
    private Button buttonVoliDepartures;
    @FXML
    private Button buttonVoliArrivals;
    @FXML
    private Button buttonAddVoli;

    @FXML
    private Label Label;

    private Stage stage;
    private Scene scene;
    private Voli tempVoli;


    private Parent root;

    private VoliDAO VoliDAO = new VoliDAO();
    private AccountService accountService = new AccountService();

    @FXML
    protected void openArrivalsVoliView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(VoliArrivoApplication.class.getResource("VoliArrivo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openVoliDeparturesView(ActionEvent event) throws IOException, SQLException {
        root = FXMLLoader.load(VoliPartenzeApplication.class.getResource("VoliPartenze.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
        //tempVoli = VoliDAO.getAccountbyUsername(InputUsername.getText());


    }
    @FXML
    protected void openAddVoli(ActionEvent event) throws IOException, SQLException {
        root = FXMLLoader.load(AggiuntaVoliApplication.class.getResource("AggiuntaVoli.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
        //tempVoli = VoliDAO.getAccountbyUsername(InputUsername.getText());


    }

}
