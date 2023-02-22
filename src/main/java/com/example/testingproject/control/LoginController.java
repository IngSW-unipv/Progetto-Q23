package com.example.testingproject.control;

import com.example.testingproject.view.login.LoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.example.testingproject.view.homePage.HomePage;

import java.io.IOException;

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



    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException {


        if(InputUsername.getText().isEmpty() && InputPassword.getText().isEmpty()){
            WrongLogIn.setText("");
            emptyInput.setText("Please Input Log In Data");
        }

     else if(InputUsername.getText().equals("admin1") && InputPassword.getText().equals("password")){
            emptyInput.setText("");
            WrongLogIn.setText("");
            System.out.print(HomePage.class.getResource("homePage_view.fxml"));
            root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root,1024, 512);
            stage.setScene(scene);
            stage.show();
     }

     else{
         emptyInput.setText("");
         WrongLogIn.setText("Wrong Username or Password");
     }
    }

    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}