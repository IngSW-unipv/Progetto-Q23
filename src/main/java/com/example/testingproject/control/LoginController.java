package com.example.testingproject.control;

import com.example.testingproject.view.login.LoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.example.testingproject.view.homePage.HomePage;

import javax.security.auth.callback.ChoiceCallback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private TextField InputUsername;
    @FXML
    private PasswordField InputPassword;

    @FXML
    private Label WrongLogIn;

    @FXML
    private Label emptyInput;

    @FXML
    private ChoiceBox<String> userTypeChoices;

    private String[] userTypes ={"Administrator","Gestore Bagagli", "Gestore Terreni","Gestore Voli"};

    private Stage stage;
    private Scene scene;
    private Parent root;

    public LoginController() {
    }


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

    public void initialize(URL arg0, ResourceBundle arg1){
        userTypeChoices.getItems().addAll(userTypes);


}
}