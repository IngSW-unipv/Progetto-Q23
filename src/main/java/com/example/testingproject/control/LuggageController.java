package com.example.testingproject.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LuggageController{

    @FXML
    private Button buttonLuggageDepartures;
    @FXML
    private Button buttonLuggageArrivals;
    @FXML
    private Button buttonLuggageManage;
    @FXML
    private Button buttonLuggageFly;
    @FXML
    private Label welcomeText;

    @FXML
    protected void openLuggageDeparturesView() {welcomeText.setText("Departure");}
    @FXML
    protected void openArrivalsLuggageView() {welcomeText.setText("Arrivals");}

    @FXML
    protected void openLuggageManageView() {welcomeText.setText("Manage");}

    @FXML
    protected void openLuggageFlyView() {welcomeText.setText("Fly");}

}
