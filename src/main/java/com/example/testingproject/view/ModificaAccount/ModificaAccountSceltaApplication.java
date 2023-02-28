package com.example.testingproject.view.ModificaAccount;


        import com.example.testingproject.view.GestioneAccount.GestioneAccountApplication;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;


        import java.io.IOException;

public class ModificaAccountSceltaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestioneAccountApplication.class.getResource("GestioneAccount.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        stage.setTitle("Scelta della modifica");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}