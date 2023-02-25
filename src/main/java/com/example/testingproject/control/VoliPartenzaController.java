package com.example.testingproject.control;
import com.example.testingproject.model.Account;
import com.example.testingproject.model.Voli;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.stage.Stage;
import com.example.testingproject.view.Voli.VoliArrivo.VoliArrivoApplication;
import com.example.testingproject.view.Voli.VoliPartenze.VoliPartenzeApplication;

public class VoliPartenzaController {

    @FXML
    private Button buttonVoliDepartures;
    @FXML
    private Button buttonVoliArrivals;
    @FXML
    private Label Label;
    @FXML
    public ListView voliListView;
    private Stage stage;
    private Scene scene;
    private Voli tempVoli;


    private Parent root;


    private VoliDAO VoliDAO = new VoliDAO();
    private AccountService accountService = new AccountService();
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() throws SQLException {

        ArrayList<Voli> voli_ = new ArrayList<>();
        voli_ = VoliDAO.getVoli();
        for (int i = 0; i < voli_.size(); i++) {
            voliListView.getItems().add(voli_.get(i).getNome_aereo() +"   "+ voli_.get(i).getGate() + "  "+ voli_.get(i).getAereo());

        }

    }
}