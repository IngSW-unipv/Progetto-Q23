package com.example.testingproject.control;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreazioneAccountController implements Initializable{

   @FXML
    TextField nomeField;
   @FXML
   TextField cognomeField;
   @FXML
   TextField usernameField;
   @FXML
   TextField passwordField;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] ruolo = {"Terreni","Bagagli","Piste","Admin"};
    public String selectedRole;

    AccountService accountService = new AccountService();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        myChoiceBox.getItems().addAll(ruolo);
        myChoiceBox.setOnAction(this::getRuolo);

    }

    public void getRuolo(ActionEvent event) {

        String myRuolo = myChoiceBox.getValue();
        selectedRole = myRuolo;
    }

    public void creazioneAccount(ActionEvent actionEvent) throws SQLException {
        Account tempAccount = new Account(usernameField.getText(),passwordField.getText(),selectedRole,nomeField.getText(),cognomeField.getText());
        try {
            accountService.AddAccount(tempAccount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void goToHome(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
}
