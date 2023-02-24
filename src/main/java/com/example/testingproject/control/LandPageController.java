package com.example.testingproject.control;


import com.example.testingproject.model.DAO.TerreniDAO;
import com.example.testingproject.model.Terreno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class LandPageController {
    @FXML
    MenuBar myMenuBar;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    ListView terreniList;
    public ArrayList<Terreno> tr;
    public void initialize() throws SQLException {
    tr = TerreniDAO.getTerreni();
    for(int i = 0 ; i < tr.size(); i++){
        terreniList.getItems().add(tr.get(i).id);
       }
    }
    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}