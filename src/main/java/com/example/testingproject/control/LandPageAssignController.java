package com.example.testingproject.control;

import com.example.testingproject.model.Aereo;
import com.example.testingproject.model.DAO.TerreniDAO;
import com.example.testingproject.model.Hangar;
import com.example.testingproject.model.Sosta;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LandPageAssignController {
    @FXML
    MenuBar myMenuBar;
    @FXML
    ListView hangarList;
    @FXML
    ListView aereiList;
    @FXML
    DatePicker datePickerI;
    @FXML
    DatePicker datePickerF;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public ArrayList<Hangar> hg;
    public ArrayList<Aereo> aerei;
    public int selectedHangar;
    public  int selectedAereo;
    public  String selectedDateI,selectedDateF;
    public void initialize() throws SQLException {
      hg = TerreniDAO.getTerreni();
      for (int i =0; i< hg.size(); i++){
          hangarList.getItems().add(hg.get(i).id);
      }
    aerei = TerreniDAO.getAerei();

      for (int j = 0; j<aerei.size();j++){
          aereiList.getItems().add(aerei.get(j).getId());
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

    public void handleHangarList(MouseEvent mouseEvent) {
        selectedHangar = (Integer) hangarList.getSelectionModel().getSelectedItem();
    }

    public void handleAereiList(MouseEvent mouseEvent) {
        selectedAereo = (Integer) aereiList.getSelectionModel().getSelectedItem();
    }

    public void handleAssign(ActionEvent actionEvent) throws SQLException {
        System.out.println(selectedAereo+"  "+selectedHangar);
        Sosta sosta = new Sosta(selectedHangar,selectedAereo,selectedDateI,selectedDateF);
        TerreniDAO.insertSosta(sosta);
    }

    public void setSelectedDateI(ActionEvent actionEvent) {
        selectedDateI = String.valueOf(datePickerI.getValue());
    }

    public void setSelectedDateF(ActionEvent actionEvent) {
        selectedDateF = String.valueOf(datePickerF.getValue());
    }
}
