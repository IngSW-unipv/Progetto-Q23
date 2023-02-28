package com.example.testingproject.control;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.view.GestioneAccount.GestioneAccountApplication;
import com.example.testingproject.view.ModificaAccount.ModificaAccountSceltaApplication;
import com.example.testingproject.view.creazioneAccount.CreazioneApplication;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DeletionAccountController {

    @FXML
    private TextField usernameInput;

    @FXML
    private Label accountNotFound;


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void DeleteAccount(ActionEvent event) throws SQLException, IOException {
        String username = usernameInput.getText();
        AccountService accountService = new AccountService();

            Account tempAccount = accountService.findAccountByUsername(username);
            if (tempAccount == null) {
                accountNotFound.setText("Account non esiste!");


            } else {
                accountService.deleteAccount(tempAccount);
                goToHome(event);


            }


        }


    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

    }

