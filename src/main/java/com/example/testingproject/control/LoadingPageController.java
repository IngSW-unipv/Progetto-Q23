package com.example.testingproject.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
//import javafx.scene.control.Slider;

public class LoadingPageController implements Initializable{

    @FXML
    private ProgressBar myProgressBar;

    @FXML
    private Button myButton;

    @FXML
    private Label myLabel;

    //The BigDecimal class gives its user complete control over rounding behavior
  //  BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0));
    double progress;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        myProgressBar.setStyle("-fx-accent: #00FF00;");
    }

    public void increaseProgress() {

        if(progress< 0.9999999999999999) {          //per farlo fermare a 100 lo faccio fermare a 0.9999999999999999
            progress += 0.1;
            System.out.println(progress);
            myProgressBar.setProgress(progress);
            myLabel.setText("            " + Integer.toString((int)Math.round(progress * 100)) + "%");  //gli spazi tra apici sono per permettere che la percentuale stia al centro
        }
    }
}



