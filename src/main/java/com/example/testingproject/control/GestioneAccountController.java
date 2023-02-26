package com.example.testingproject.control;

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
        stage.show();

    }
   public void CreaAccountOnClick(ActionEvent event) throws IOException {
       root = FXMLLoader.load(CreazioneApplication.class.getResource("AdminCreazioneAccount.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root, 1024, 512);
       stage.setScene(scene);
       stage.show();

    }
}