package com.example.testingproject.view.GestioneAccount;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class GestioneAccountApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.testingproject.view.GestioneAccount.GestioneAccountApplication.class.getResource("GestioneAccount.fxml"));
        System.out.print(com.example.testingproject.view.GestioneAccount.GestioneAccountApplication.class.getResource("GestioneAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Gestione Account");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}