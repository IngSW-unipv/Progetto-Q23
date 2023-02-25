package com.example.testingproject.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ModificaAccountSceltaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Scelta della modifica");
    }
}