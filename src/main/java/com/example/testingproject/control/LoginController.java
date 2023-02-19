package com.example.testingproject.control;

import com.example.testingproject.view.login.LoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    public void LogIn(){}
    @FXML
private TextField InputUsername;
    @FXML
    private PasswordField InputPassword;

    @FXML
    private Label WrongLogIn;

    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException {
    LoginPage page = new LoginPage();

        if(InputUsername.getText().isEmpty() && InputPassword.getText().isEmpty()){
            WrongLogIn.setText("Please Input Log In Data");
        }

     else if(InputUsername.toString().equals("admin1") && InputPassword.toString().equals("password")){
       page.ChangeScene("home_view.fxml");
     }

     else{
         WrongLogIn.setText("Wrong Username or Password");
     }
    }



}