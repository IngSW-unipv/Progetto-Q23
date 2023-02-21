package com.example.testingproject.view.luggage.fly;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LuggageFlyMainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LuggageFlyMainApplication.class.getResource("luggageManageView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Luggage Fly");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}