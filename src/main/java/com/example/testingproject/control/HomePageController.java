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

public class HomePageController{
    @FXML
    MenuBar myMenuBar;
    @FXML
    private Button buttonlogin;
    @FXML
    private javafx.scene.control.Label Label;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void openLoginView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(LoginPage.class.getResource("login_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}