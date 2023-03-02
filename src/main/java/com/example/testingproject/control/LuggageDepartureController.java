package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.Voli;
import com.example.testingproject.view.homePage.HomePageApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

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
    @FXML
    private javafx.scene.control.ListView<String> listView1;
    private Luggage tempLuggage;
    private final BagagliDAO luggageDAO = new BagagliDAO();

    public void addLuggage(ActionEvent actionEvent) throws SQLException {
        int idVolo = 0;
        String codices = textField.getText();
        String Stato = "IN VOLO";
        String Airport = textField.getText().substring(0, 3);
        String bagaglio = textField.getText().substring(4, codices.length());
        try {
            idVolo = Integer.parseInt(bagaglio);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // ricava per il volo il peso attuale di tutti bagagli
        int wigth = luggageDAO.sumWigth(idVolo);
        int wigthLuggage = WightSpinner.getValue();

        // verifica esistenza volo e posto sul aereo
        boolean verifica1 = luggageDAO.verifyPlaceonBord(idVolo, wigth+wigthLuggage);
        boolean verifica2 = luggageDAO.verifyFlyPartenza(idVolo,Airport);


        if (!verifica2){
            listView.getItems().add("IL VOLO SELEZIONATO NON ESISTE");
        } else if (wigthLuggage == 0) {
            listView.getItems().add("PESO ERRATO: INSERISCI UN PESO CHE SIA ALMENO MAGGIORE DI 0");
        } else if (!verifica1) {
            listView.getItems().add("PESO MASSIMO RAGGIUNTO");
        } else {
            luggageDAO.addLuggage(wigthLuggage, Stato, idVolo);
            listView.getItems().add("BAGAGLIO AGGIUNTO CON SUCCESSO");
        }
    }
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(HomePageApplication.class.getResource("homePage_view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void closeWindow() {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }

    public void clear(MouseEvent mouseEvent) {
        int selectedId = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedId);
    }
}
