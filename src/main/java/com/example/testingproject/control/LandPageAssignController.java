package com.example.testingproject.control;

import com.example.testingproject.model.Aereo;
import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DAO.TerreniDAO;
import com.example.testingproject.model.Hangar;
import com.example.testingproject.model.Sosta;
import com.example.testingproject.view.homePage.HomePageApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    @FXML
    Button assignButton;
    @FXML
    Button removeButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public ArrayList<Hangar> hg;
    public ArrayList<Aereo> aerei;
    public int selectedHangar;
    public  int selectedAereo;
    public  String selectedDateI,selectedDateF;
    TerreniDAO terreniDAO = new TerreniDAO();
    public void initialize() throws SQLException {
      hg = terreniDAO.getTerreni();
      for (int i =0; i< hg.size(); i++){
          hangarList.getItems().add(hg.get(i).getId());
      }
    aerei = terreniDAO.getAerei();

      for (int j = 0; j<aerei.size();j++){
          aereiList.getItems().add(aerei.get(j).getId());
      }


    }
    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePageApplication.class.getResource("homePage_view.fxml"));
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
    public void handleRemove(ActionEvent actionEvent) throws  SQLException{
        Sosta sosta = new Sosta(selectedHangar,selectedAereo,selectedDateI,selectedDateF);
        Hangar hgt = terreniDAO.getTerrenoByID(sosta.getHangar());
        boolean inserimento=false;
        if (hgt.getNpostiLiberi()<hgt.getNposti()){
            inserimento = terreniDAO.removeSosta(sosta);
            System.out.println(inserimento);
        }
        if(inserimento){
            terreniDAO.increaseHangar(sosta.getHangar());
        }
        else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Inserimento");
            errorAlert.setHeaderText("La sosta selezionata non puo essere cancellata");
            errorAlert.setContentText("La sosta selezionata non esiste");
            errorAlert.showAndWait();
        }

    }
    public void handleAssign(ActionEvent actionEvent) throws SQLException {
        System.out.println(selectedAereo+"  "+selectedHangar);
        Sosta sosta = new Sosta(selectedHangar,selectedAereo,selectedDateI,selectedDateF);
        Hangar hgt = terreniDAO.getTerrenoByID(sosta.getHangar());
        boolean inserimento=false;
        if (hgt.getNpostiLiberi()>0){
            inserimento = terreniDAO.insertSosta(sosta);
        }
        if(inserimento){
            boolean update = terreniDAO.decreaseHangar(sosta.getHangar());
        }
        else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Inserimento");
            errorAlert.setHeaderText("L'hangar ?? al completo");
            errorAlert.setContentText("L'hangar selezionato ?? al completo. Seleziona un altro Hangar");
            errorAlert.showAndWait();
        }



    }

    public void setSelectedDateI(ActionEvent actionEvent) {
        selectedDateI = String.valueOf(datePickerI.getValue());
    }

    public void setSelectedDateF(ActionEvent actionEvent) {
        selectedDateF = String.valueOf(datePickerF.getValue());
    }
}
