package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LuggageArriveController {
    public Spinner<Integer> WightSpinner;
    public Button addButton;
    @FXML
    private TextField textField;
    public MenuBar myMenuBar;
    @FXML
    private javafx.scene.control.ListView<String> listView;
    private final BagagliDAO luggageDAO = new BagagliDAO();

    public LuggageArriveController() {
    }

    public void addLuggage() {
        int lengthcod;
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
        boolean verifica = luggageDAO.verifyFly(idVolo, firstAirport, secondAirport);
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

    public void closeWindow() {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
    public void goToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HomePage.class.getResource("homePage_view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
}
