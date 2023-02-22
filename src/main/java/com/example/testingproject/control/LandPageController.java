package com.example.testingproject.control;


import com.example.testingproject.view.Voli.VoliArrivo.VoliArrivoApplication;
import com.example.testingproject.view.login.LoginPage;
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

import java.io.IOException;

public class LandPageController{
    @FXML
    MenuBar myMenuBar;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}