package com.example.testingproject.control;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LuggageDepartureController {
    public Spinner<Integer> WightSpinner;
    public Button addButton;
    public TextField textField;
    public ListView listView;
    public MenuBar myMenuBar;

    public void addLuggage(ActionEvent actionEvent) {
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}
