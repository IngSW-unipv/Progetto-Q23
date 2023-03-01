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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LuggageArriveController {
    public Button addButton;
    public Button clearButton;
    @FXML
    private TextField textField;
    public MenuBar myMenuBar;
    @FXML
    private javafx.scene.control.ListView<String> listView;
    private final BagagliDAO luggageDAO = new BagagliDAO();

    public void addLuggage() throws SQLException {
        // addettamento stringa dinamica per ricerca
        String codice = textField.getText();
        int lcod, line = 0;
        char j;
        codice = codice.substring(8);
        lcod = codice.length();
        for (int i = 0; i < lcod; i++) {
            j = codice.charAt(i);
            if (j == '-') {
                line = i;
                break;
            }
        }
        System.out.println(line);
        // prelevamento informazioni dall'etichetta
        int idVolo = 0;
        int idBagaglio = 0;
        boolean verifica1;
        boolean verifica2;

        String firstAirport = textField.getText().substring(0, 3);
        String secondAirport = textField.getText().substring(4, 7);
        String volo = codice.substring(0, line);
        String bagaglio = codice.substring(line + 1, lcod);

        System.out.println("id baglio: " + bagaglio);

        try {
            idVolo = Integer.parseInt(volo);
            idBagaglio = Integer.parseInt(bagaglio);
            System.out.println("id volo: " + idVolo);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // verifica esistenza del volo
        verifica1 = luggageDAO.verifyFly(idVolo, firstAirport, secondAirport);
        verifica2 = luggageDAO.verifyLuggegeinFly(idBagaglio, idVolo);

        if (!verifica1) {
            listView.getItems().add("IL VOLO RICERCATO NON ESISTE");
        } else if (!verifica2) {
                listView.getItems().add("IL BAGAGLIO SELEZIONATO NON E' PRESENTE SU QUESTO VOLO");
            } else {
                boolean verifica3 = luggageDAO.removeLuggage(idBagaglio);
                if (!verifica3){listView.getItems().add("IL NON E' STATO RIMOSSO");}
                else {listView.getItems().add("IL BAGAGLIO E' ARRIVATO A DESTINAZIONE");}
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
    public void clear(MouseEvent mouseEvent) {
        int selectedId = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedId);
    }
}
