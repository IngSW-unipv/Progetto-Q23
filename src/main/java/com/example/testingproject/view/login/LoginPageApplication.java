package com.example.testingproject.view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageApplication extends Application {
    private static Stage stage;
    @Override
    public void start(Stage PrimaryStage) throws IOException {
        stage = PrimaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPageApplication.class.getResource("login_view.fxml"));
       PrimaryStage.setResizable(false);
      Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        PrimaryStage.setTitle("Login Page");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
       
    }


    public static void main(String[] args) {
        launch();
    }
}