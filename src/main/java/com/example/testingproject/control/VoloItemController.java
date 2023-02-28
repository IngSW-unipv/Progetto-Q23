package com.example.testingproject.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VoloItemController {


    @FXML
    private Label idValue;

    @FXML
    private Label durationValue;

    @FXML
    private Label aereoValue;

    @FXML
    private Label delayValue;

    @FXML
    private Label gateValue;




    public void itemLoaderVoli(Integer Id, Integer duration, Integer aereo, Integer delay, Integer gate){
        idValue.setText(Id.toString());
        durationValue.setText(duration.toString());
        aereoValue.setText(aereo.toString());
        delayValue.setText(delay.toString());
        gateValue.setText(gate.toString());

    }

}



