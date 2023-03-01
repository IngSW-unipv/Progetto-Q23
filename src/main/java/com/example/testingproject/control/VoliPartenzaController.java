package com.example.testingproject.control;

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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



public class VoliPartenzaController {

    @FXML
    public ListView voliListView;
    private Stage stage;
    private Scene scene;



    private Parent root;


    private VoliDAO VoliDAO = new VoliDAO();

    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() throws SQLException {

        ArrayList<Voli> voli_ = new ArrayList<>();
        voli_ = VoliDAO.getVoliPartenza();
        for (int i = 0; i < voli_.size(); i++) {
            voliListView.getItems().add( voli_.get(i).getGate() + "  "+ voli_.get(i).getAeroportop()+" "+ voli_.get(i).getDataora() +

                    " "+ voli_.get(i).getId() + " " + voli_.get(i).getDurata() + " " + + voli_.get(i).getRitardo() +
                    " " +  voli_.get(i).getAereo() + " " +
                    voli_.get(i).getPista());

        }

    }
}