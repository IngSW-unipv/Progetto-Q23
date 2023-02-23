package com.example.testingproject.control;


import com.example.testingproject.model.Account;
import com.example.testingproject.model.UserHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class HomePageController{
    @FXML
    MenuBar myMenuBar;
    public void initialize() {

        UserHolder holder = UserHolder.getInstance();
        System.out.println(holder.getUser().getUsername());
    }
    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}