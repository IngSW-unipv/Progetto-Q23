package com.example.testingproject.control;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.UserHolder;
import com.example.testingproject.model.service.AccountService;
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
import com.example.testingproject.view.homePage.HomePageApplication;

import java.io.IOException;

import java.sql.SQLException;


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

    private final AccountDAO accountDAO = new AccountDAO();




    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException, SQLException {


        if(InputUsername.getText().isEmpty() && InputPassword.getText().isEmpty()){
            WrongLogIn.setText("");
            emptyInput.setText("Please Input Log In Data");
        }


     else{


            try {
                tempAccount = accountDAO.getAccountbyUsername(InputUsername.getText());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (tempAccount!= null && tempAccount.checkPassword(InputPassword.getText())) {
                UserHolder holder = UserHolder.getInstance();
                holder.setUser(tempAccount);
                root = FXMLLoader.load(HomePageApplication.class.getResource("homePage_view.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root, 1024, 512);
                stage.setTitle("Home Page");
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