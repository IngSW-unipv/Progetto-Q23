package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.Luggage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LuggageArriveController {
    public Spinner<Integer> WightSpinner;
    public Button addButton;
    @FXML
    private TextField textField;
    public MenuBar myMenuBar;
    @FXML
    private javafx.scene.control.ListView<String> listView;
    private Luggage tempLuggage;
    private BagagliDAO luggageDAO = new BagagliDAO();
    public void addLuggage(ActionEvent actionEvent) {
        String firstAirport = textField.getText().substring(0,3);
        String secondAirport = textField.getText().substring(4,7);
        int  idVolo = Integer.parseInt(textField.getText().substring(8,9));
        String Stato = "IN VOLO";

        int wight = WightSpinner.getValue();

        boolean verifica  = luggageDAO.verifyLuggaggeArrive(idVolo, firstAirport, secondAirport);
       if (verifica == false) {
           listView.getItems().add("NON ESISTE ALCUN VOLO ESISTENTE");
       } else {
        luggageDAO.addLuggage(wight,Stato,idVolo);
           listView.getItems().add("BAGAGLIO AGGIUNTO CON SUCCESSO");
       }
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}
