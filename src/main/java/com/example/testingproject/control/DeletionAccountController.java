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

    @FXML
    private Label accountDeleted;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void DeleteAccount(ActionEvent event) throws SQLException {
        String username = usernameInput.getText();
        AccountService accountService = new AccountService();
        try {
            Account tempAccount = accountService.findAccountByUsername(username);
            if(tempAccount==null){
                accountNotFound.setText("Account non esiste!");
                accountDeleted.setText("");

            }else{
                accountService.deleteAccount(tempAccount);
                accountDeleted.setText("Account Rimosso!");
                accountNotFound.setText("");
                TimeUnit.SECONDS.sleep(2);



                root = FXMLLoader.load(GestioneAccountApplication.class.getResource("GestioneAccount.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root, 1024, 512);
                stage.setTitle("Gestione Account");
                stage.setScene(scene);
                stage.show();


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}