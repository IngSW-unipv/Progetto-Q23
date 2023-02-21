package com.example.testingproject.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class CreazioneAccountController implements Initializable{

    @FXML
    private Label myLabel;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] ruolo = {"Terreni","Bagagli","Piste"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        myChoiceBox.getItems().addAll(ruolo);
        myChoiceBox.setOnAction(this::getRuolo);

    }

    public void getRuolo(ActionEvent event) {

        String myRuolo = myChoiceBox.getValue();
        myLabel.setText(myRuolo);
    }

}
