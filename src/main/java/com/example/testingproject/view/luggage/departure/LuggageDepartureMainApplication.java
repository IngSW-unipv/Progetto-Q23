package com.example.testingproject.view.luggage.departure;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LuggageDepartureMainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LuggageDepartureMainApplication.class.getResource("luggageManageView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Luggage Departure");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}