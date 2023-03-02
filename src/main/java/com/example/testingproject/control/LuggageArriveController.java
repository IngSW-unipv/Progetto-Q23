package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
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
import java.util.Objects;

public class LuggageArriveController {
    public Button addButton;
    public Button clearButton;
    public Spinner<Integer> WightSpinner;
    @FXML
    private TextField textField;
    public MenuBar myMenuBar;
    @FXML
    private javafx.scene.control.ListView<String> listView;
    private final BagagliDAO luggageDAO = new BagagliDAO();

    public void addLuggage() throws SQLException {
        // addettamento stringa dinamica per ricerca
        String codice = textField.getText();
        int idVolo = 0;
        int idBagaglio = 0;

        int wigthLuggage = WightSpinner.getValue();
        String Airport = textField.getText().substring(0, 3);
        String volo = textField.getText().substring(4,codice.length());
        String string = "IN VOLO";
        try {
            idVolo = Integer.parseInt(volo);

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // verifica esistenza del volo
        boolean verifica = luggageDAO.verifyFlyArrivo(idVolo,Airport);
        if (!verifica) {
            listView.getItems().add("IL VOLO RICERCATO NON ESISTE");
        }else if (wigthLuggage == 0) {
                listView.getItems().add("PESO ERRATO: INSERISCI UN PESO CHE SIA ALMENO MAGGIORE DI 0");
        } else {
            listView.getItems().add("IL BAGAGLIO E' STATO AGGIUNTO CORRETTAMENTE");
            luggageDAO.addLuggage(wigthLuggage,string, idVolo);
        }
    }

    public void closeWindow() {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
    public void goToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HomePageApplication.class.getResource("homePage_view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void clear(MouseEvent mouseEvent) {
        int selectedId = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedId);
    }
}
