package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.VistaVoloBagaglio;
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
    public ListView<String> ListView1;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private javafx.scene.control.ListView<String> listView;
    private Luggage tempLuggage;
    private final BagagliDAO luggageDAO = new BagagliDAO();

    public void initialize() throws SQLException {
        ArrayList<VistaVoloBagaglio> voli = new ArrayList<>();
        ListView1.getItems().add("VOLO"+"  "+ "PARTENZA"+"  "+ "ARRIVO");
        voli = luggageDAO.getVistaArrivo();
        for (VistaVoloBagaglio vistaVoloBagaglio : voli) {
            ListView1.getItems().add(vistaVoloBagaglio.getIdVolo() + "             " + vistaVoloBagaglio.getAeroportoP() + "             " + vistaVoloBagaglio.getAeroportoA());
        }
    }
    public void addLuggage(ActionEvent actionEvent) throws SQLException {
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

        // ricava per il volo il peso attuale di tutti bagagli
        int wigth = luggageDAO.sumWigth(idVolo);
        int wigthLuggage = WightSpinner.getValue();

        // verifica esistenza volo e posto sul aereo
        boolean verifica = luggageDAO.verifyPlaceonBord(idVolo, wigth+wigthLuggage,firstAirport,secondAirport);
        System.out.println(verifica);

        if (wigthLuggage == 0) {
            listView.getItems().add("PESO ERRATO: INSERISCI UN PESO CHE SIA ALMENO MAGGIORE DI 0");
        } else if (!verifica) {
            listView.getItems().add("NON E' STATO POSSIBILE INSERIRE IL BAGAGLIO");
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
