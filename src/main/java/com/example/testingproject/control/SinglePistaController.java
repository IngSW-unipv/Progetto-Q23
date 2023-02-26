package com.example.testingproject.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SinglePistaController {

 @FXML
 Label pistaID;

 public void setPista(Integer Id){
     pistaID.setText(Id.toString());
 }



}
