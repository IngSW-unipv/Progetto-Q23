package com.example.testingproject.view.piste;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PisteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PisteApplication.class.getResource("piste-view.fxml"));
        URL url = PisteApplication.class.getResource("piste-view.fxml");
        System.out.print(url);
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Piste");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


