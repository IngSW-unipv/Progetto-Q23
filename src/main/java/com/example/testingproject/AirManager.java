package com.example.testingproject;

import com.example.testingproject.view.LoadingPage.LoadingApplication;
import javafx.application.Application;
import javafx.stage.Stage;


public class AirManager extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        new LoadingApplication().start(stage);
    }

}
