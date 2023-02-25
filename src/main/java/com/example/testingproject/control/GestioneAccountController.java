package com.example.testingproject.control;

        import javafx.fxml.FXML;
        import javafx.scene.control.Label;

public class GestioneAccountController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Gestione Account");
    }
}