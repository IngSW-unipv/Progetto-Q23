package com.example.testingproject.control;


import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DAO.TerreniDAO;
import com.example.testingproject.model.Sosta;
import com.example.testingproject.model.Hangar;
import com.example.testingproject.view.homePage.HomePageApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LandPageController {
    @FXML
    MenuBar myMenuBar;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    ListView terreniList;
    @FXML
    ListView sosteList;
    @FXML
    Label nposti;
    @FXML
    Label npostiliberi;
    public ArrayList<Hangar> tr;
    public int selected;
    TerreniDAO terreniDAO = new TerreniDAO();
    public void initialize()  {
    tr = terreniDAO.getTerreni();
    for(int i = 0 ; i < tr.size(); i++){
        terreniList.getItems().add(tr.get(i).getId());
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
    @FXML public void handleMouseClick(MouseEvent arg0) throws ParseException {
        Integer id =(Integer) terreniList.getSelectionModel().getSelectedItem();
        if (id == selected) {

        }else {
            selected = id;
            sosteList.getItems().clear();
            for (int i = 0; i < tr.size(); i++) {
                if (tr.get(i).getId() == id) {
                    nposti.setText(Integer.toString(tr.get(i).getNposti()));
                    npostiliberi.setText(Integer.toString(tr.get(i).getNpostiLiberi()));
                }
            }
            ArrayList<Sosta> soste = terreniDAO.getSoste(id);
            for (int j = 0; j < soste.size(); j++) {

                sosteList.getItems().add("ID Aereo: " + soste.get(j).getAereo() + "     Inizio: " + soste.get(j).getInizio() + "    Fine: " + soste.get(j).getFine());

                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setTitle("Avviso");
                String text = "Il contratto per l'Hangar n. "+ soste.get(j).getHangar() + ",occupato dall'aereo n. "+ soste.get(j).getAereo() + " è scaduto";
                errorAlert.setHeaderText("Avviso di scadenza");
                errorAlert.setContentText(text);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = sdf.parse(soste.get(j).getFine());
                Date date2 = new Date(System.currentTimeMillis());
                int result= date1.compareTo(date2);
                if (result < 0)
                errorAlert.showAndWait();
            }
        }
    }
}