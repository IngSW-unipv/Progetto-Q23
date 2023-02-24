package com.example.testingproject.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import com.example.testingproject.view.luggage.manage.LuggageManageMainApplication;
import com.example.testingproject.view.luggage.departure.LuggageDepartureMainApplication;
import com.example.testingproject.view.luggage.arrive.LuggageArriveMainApplication;


import java.io.IOException;
import java.util.Objects;

public class LuggageController {

    @FXML
    private Button buttonLuggageDepartures;
    @FXML
    private Button buttonLuggageArrivals;
    @FXML
    private Button buttonLuggageManage;
    @FXML
    private Label Label;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public MenuBar myMenuBar;

    @FXML
    protected void openLuggageDeparturesView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(LuggageDepartureMainApplication.class.getResource("luggageDepartureView.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void openArrivalsLuggageView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(LuggageArriveMainApplication.class.getResource("luggageArriveView.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void openLuggageManageView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(LuggageManageMainApplication.class.getResource("luggageManageView.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }

}