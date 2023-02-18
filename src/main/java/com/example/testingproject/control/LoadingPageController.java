package com.example.testingproject.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoadingPageController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void increaseProgress() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}