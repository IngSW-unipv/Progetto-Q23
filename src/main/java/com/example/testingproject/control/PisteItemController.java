package com.example.testingproject.control;

import com.example.testingproject.view.piste.PisteApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PisteItemController {


    @FXML
    private Label IdValue;

    @FXML
    private Label lengthValue;

    @FXML
    private Label windValue;

    @FXML
    private Label directionValue;

    private String setDirection(String direction){
        if(direction.equals("E")){
            return "Est";
        }
        else if(direction.equals("W")){
            return "Ovest";
        }
        else if(direction.equals("N")){
            return "Nord";
        }else{
            return "Sud";
        }
    }


    public void itemLoader(Integer Id, Integer Length, String Wind, String Direction){
        IdValue.setText(Id.toString());
        lengthValue.setText(Length.toString());
        windValue.setText(Wind);
        directionValue.setText(setDirection(Direction));

    }

}



