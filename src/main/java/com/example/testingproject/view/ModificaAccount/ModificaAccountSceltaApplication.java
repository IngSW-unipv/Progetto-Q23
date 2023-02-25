package com.example.testingproject.view.ModificaAccount;


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;


        import java.io.IOException;

public class ModificaAccountSceltaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.testingproject.view.ModificaAccount.ModificaAccountSceltaApplication.class.getResource("ModificaAccount.fxml"));
        System.out.print(com.example.testingproject.view.ModificaAccount.ModificaAccountSceltaApplication.class.getResource("ModificaAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Scelta della modifica");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}