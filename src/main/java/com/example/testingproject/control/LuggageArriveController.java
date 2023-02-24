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
    private ListView listView;
    private Luggage tempLuggage;
    private BagagliDAO luggageDAO = new BagagliDAO();
    public void addLuggage(ActionEvent actionEvent) {
        String firstAirport = textField.getText().substring(0,3);
        String secondAirport = textField.getText().substring(4,7);
        String arrivo = "ARRIVO";

        int wight = WightSpinner.getValue();

      //  tempLuggage = BagagliDAO.addLuggaggeArrive(firstAirport, secondAirport, arrivo);

        System.out.println(firstAirport);
        System.out.println(secondAirport);
        System.out.println(wight);
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}
