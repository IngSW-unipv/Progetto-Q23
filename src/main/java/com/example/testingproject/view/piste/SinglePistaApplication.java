package com.example.testingproject.view.piste;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SinglePistaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PisteApplication.class.getResource("singlePista-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Pista");
        stage.setScene(scene);
        stage.show();
    }

    protected static void main(String[] args) {
        launch();
    }
}


