package com.example.testingproject.control;


import com.example.testingproject.model.DAO.TerreniDAO;
import com.example.testingproject.model.Terreno;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML
    Label nposti;
    @FXML
    Label npostiliberi;
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
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void handleMouseClick(MouseEvent arg0) {
        Integer id =(Integer) terreniList.getSelectionModel().getSelectedItem();
        for (int i=0;i< tr.size();i++){
            if (tr.get(i).id == id){
             nposti.setText(Integer.toString(tr.get(i).getNposti()));
             npostiliberi.setText(Integer.toString(tr.get(i).getNpostiLiberi()));
            }
        }
        //aggiungere sosta
    }
}