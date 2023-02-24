package com.example.testingproject.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Spinner;

public class LuggageArriveController {
    public Spinner<Integer> WightSpinner;
    public Button addButton;
    @FXML
    private TextField textField;
    @FXML
    private ListView listView;

    public void addLuggage(ActionEvent actionEvent) {
        String firstAirport = textField.getText().substring(0,3);
        String secondAirport = textField.getText().substring(4,7);
        int wight = WightSpinner.getValue();

        System.out.println(firstAirport);
        System.out.println(secondAirport);
        System.out.println(wight);
    }
}
