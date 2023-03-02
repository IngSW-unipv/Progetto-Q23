package com.example.testingproject.control;

import com.example.testingproject.model.ConnectionHolder;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.PistaSingleton;
import com.example.testingproject.view.login.LoginPageApplication;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoadingPageController implements Initializable {

    private final Stage stage = this.stage;

    @FXML
    private ProgressBar myProgressBar;

    @FXML
    private Pane mainLayout;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {



        myProgressBar.setStyle("-fx-accent: #00FF00;");
        Task<Void> task1 = new Task<Void>() {

            @Override
            public Void call() throws InterruptedException{
                try {

                    for(int i=0;i<=4000;i++){
                        TimeUnit.MILLISECONDS.sleep(1);
                        myProgressBar.setProgress(i*0.00025);




                    }
                    TimeUnit.MILLISECONDS.sleep(250);


                } catch (Exception e) {

                    System.exit(1);
                }

                return null;
            }
        };

        task1.setOnSucceeded(e -> {
            goToHome();


        });


        Task<Void> task2 = new Task<Void>() {

            @Override
            public Void call() throws InterruptedException{
                try {
                    DatabaseConnection connection = ConnectionHolder.getInstance();
                    System.out.println(connection+ " Connessione");
                    PistaSingleton.getInstance().getPiste();



                } catch (SQLException e) {

                    System.exit(1);
                }

                return null;
            }
        };

        task2.setOnSucceeded(e -> {



        });
        task2.setOnFailed(e ->{
            System.exit(1);
        });




        new Thread(task1).start();
        new Thread(task2).start();

    }
    public void goToHome(){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPageApplication.class.getResource("login_view.fxml"));
        Scene scene = null;
        try {

            scene = new Scene(fxmlLoader.load(), 1024, 512);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.setScene(scene);

        stage.show();
        ((Stage) mainLayout.getScene().getWindow()).close();


    }


    }







