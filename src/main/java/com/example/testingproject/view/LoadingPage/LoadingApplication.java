package com.example.testingproject.view.LoadingPage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoadingApplication.class.getResource("Loading_Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 580, 400);
        stage.setTitle("Loading Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}