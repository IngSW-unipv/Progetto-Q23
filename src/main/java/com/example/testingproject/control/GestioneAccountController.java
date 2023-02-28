package com.example.testingproject.control;

        import com.example.testingproject.view.GestioneAccount.DeletionAccountApplication;
        import com.example.testingproject.view.ModificaAccount.ModificaAccountSceltaApplication;
        import com.example.testingproject.view.homePage.HomePage;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;
        import com.example.testingproject.view.creazioneAccount.CreazioneApplication;

        import java.io.IOException;

public class GestioneAccountController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void ModificaAccountOnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(ModificaAccountSceltaApplication.class.getResource("ModificaAccount.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.setTitle("Modifica Account");
        stage.show();

    }
   public void CreaAccountOnClick(ActionEvent event) throws IOException {
       root = FXMLLoader.load(CreazioneApplication.class.getResource("AdminCreazioneAccount.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root, 1024, 512);
       stage.setScene(scene);
       stage.setTitle("Aggiungi Account");
       stage.show();

    }

    public void EliminaAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(DeletionAccountApplication.class.getResource("DeletionAccount.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.setTitle("Elimina Account");
        stage.show();

    }


    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

}