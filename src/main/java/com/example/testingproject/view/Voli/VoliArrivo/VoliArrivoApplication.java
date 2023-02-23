package com.example.testingproject.view.Voli.VoliArrivo;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VoliArrivoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VoliArrivoApplication.class.getResource("VoliArrivo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Voli");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
