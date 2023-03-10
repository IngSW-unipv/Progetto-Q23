package com.example.testingproject.control;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.view.homePage.HomePageApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ModificaAccountSceltaController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField inputUsername;

    @FXML
    private Label alarmText;

    @FXML
   private TextField newUsername;

    @FXML
     private TextField newType;

    @FXML
     private PasswordField newPassword;

    @FXML
    private Label sucessText;
    AccountDAO accountDAO = new AccountDAO();




    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePageApplication.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

    public void findAccount(ActionEvent event) throws SQLException {
        Account tempaccount = accountDAO.getAccountbyUsername(inputUsername.getText());
        sucessText.setText("");
        if(tempaccount==null){
            alarmText.setText("Account non esiste!");
        }else{
            alarmText.setText("");
            newUsername.setText(tempaccount.getUsername());
            newPassword.setText(tempaccount.getPassword());
            newType.setText(tempaccount.getUserType());

        }


    }

    public void updateAccount(ActionEvent event) throws InterruptedException, SQLException {
        Account tempaccount = accountDAO.getAccountbyUsername(inputUsername.getText());

        try {

            accountDAO.updateUsername(tempaccount.getUsername(), newUsername.getText());
            accountDAO.updatePassword(tempaccount.getPassword(), newPassword.getText());
            accountDAO.updateType(tempaccount.getUserType(), newType.getText());
            sucessText.setText("Account aggiornato!");
        }
        catch (SQLException e){
            e.printStackTrace();

        }


    }

}