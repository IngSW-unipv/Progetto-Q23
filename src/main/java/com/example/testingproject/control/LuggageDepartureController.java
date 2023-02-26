package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.Luggage;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LuggageDepartureController {
    public Spinner<Integer> WightSpinner;
    public Button addButton;
    public TextField textField;
    public MenuBar myMenuBar;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private javafx.scene.control.ListView<String> listView;
    private Luggage tempLuggage;
    private BagagliDAO luggageDAO = new BagagliDAO();
    public void addLuggage(ActionEvent actionEvent) {
        int lengthcod = 0;
        int idVolo = 0;
        String codices = textField.getText();
        String Stato = "IN VOLO";
        String firstAirport = textField.getText().substring(0, 3);
        String secondAirport = textField.getText().substring(4, 7);
        lengthcod = codices.length();
        System.out.println("lunghezza codice: " + lengthcod);
        String volo = textField.getText().substring(8, lengthcod);
        try {
            idVolo = Integer.parseInt(volo);
            System.out.println("id volo: " + idVolo);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // verifica esistenza del volo
        boolean verifica = luggageDAO.verifyLuggagge(idVolo, firstAirport, secondAirport);
        int wight = WightSpinner.getValue();
        if (wight == 0) {
            listView.getItems().add("PESO ERRATO: INSERISCI UN PESO CHE SIA ALMENO MAGGIORE DI 0");
        } else if (!verifica) {
            listView.getItems().add("NESSUN VOLO ESISTENTE");
        } else {
            luggageDAO.addLuggage(wight, Stato, idVolo);
            listView.getItems().add("BAGAGLIO AGGIUNTO CON SUCCESSO");
        }
    }
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
}
