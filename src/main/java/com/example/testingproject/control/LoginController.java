package com.example.testingproject.control;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.view.login.LoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.testingproject.model.Account;
import com.example.testingproject.view.homePage.HomePage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    MenuBar myMenuBar;
    @FXML
private TextField InputUsername;
    @FXML
    private PasswordField InputPassword;

    @FXML
    private Label WrongLogIn;

    @FXML
    private Label emptyInput;


    private Stage stage;
    private Scene scene;
    private Parent root;

    private Account tempAccount;

    private AccountDAO accountDAO = new AccountDAO();
    private AccountService accountService = new AccountService();




    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException, SQLException {


        if(InputUsername.getText().isEmpty() && InputPassword.getText().isEmpty()){
            WrongLogIn.setText("");
            emptyInput.setText("Please Input Log In Data");
        }


     else{


           tempAccount = accountDAO.getAccountbyUsername(InputUsername.getText());
            if (tempAccount.checkPassword(InputPassword.getText())==true) {

                root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root, 1024, 512);
                stage.setScene(scene);
                stage.show();
            }

            else{
                WrongLogIn.setText("Wrong Username or Password");
                emptyInput.setText("");
            }
     }

    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}