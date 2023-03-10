package com.example.testingproject.control;

import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.Luggage;
import com.example.testingproject.view.homePage.HomePageApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class LuggageManageController {
    @FXML
    public MenuBar myMenuBar;
    @FXML
    public javafx.scene.control.ListView<String> ListView;
    public TextField textField;
    @FXML
    public Button modifyButton;
    @FXML
    public Button modifyButtonInVolo;
    @FXML
    public javafx.scene.control.ListView<String> ListView1;
    @FXML
    public Button clearButton;
    private Luggage tempLuggage;
    private final BagagliDAO luggageDAO = new BagagliDAO();
    public void initialize() throws SQLException {
        ArrayList<Luggage> bagaglio;
        bagaglio = luggageDAO.getLuggage();
        ListView1.getItems().add("BAGAGLIO"+"  "+ "STATO");
        for (Luggage luggage : bagaglio) {
            ListView1.getItems().add(luggage.getId() + "        " + luggage.getStato());
        }

    }
    public void search() throws SQLException {
        // addettamento stringa dinamica per ricerca
        String codice = textField.getText();
        int idBagaglio = 0;

        modifyButton.setVisible(false);
        modifyButtonInVolo.setVisible(false);
        try {
            idBagaglio = Integer.parseInt(codice);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        boolean verifica = luggageDAO.verify(idBagaglio);

            if (!verifica) {
                ListView.getItems().add("IL BAGAGLIO NON ESISTE");
            } else {
                tempLuggage = luggageDAO.getLuggaggeById(idBagaglio);
                if (tempLuggage.getId() == idBagaglio) {
                    ListView.getItems().add("CODICE VOLO: " + tempLuggage.getVolo());
                    ListView.getItems().add("STATO: " + tempLuggage.getStato());
                    ListView.getItems().add("PESO: " + tempLuggage.getPeso());

                    if (Objects.equals(tempLuggage.getStato(), "SMARRITO")) {
                        modifyButtonInVolo.setVisible(true);
                    } else if ((Objects.equals(tempLuggage.getStato(), "IN VOLO"))) {
                        modifyButton.setVisible(true);
                    }
                } else {
                    ListView.getItems().add("BAGAGLIO NON ESISTENTE");
                }
            }
        }
    public void modify() throws SQLException {
        String Smarrito = "SMARRITO";
        luggageDAO.modifyStato(tempLuggage.getId(), Smarrito);
        ListView.getItems().add("STATO BAGAGAGLIO CAMBIATO CORRETTAMENTE");
    }

    public void modifyINVOLO() throws SQLException {
        String StringInVolo = "IN VOLO";
        luggageDAO.modifyStato(tempLuggage.getId(), StringInVolo);
        ListView.getItems().add("STATO BAGAGAGLIO CAMBIATO CORRETTAMENTE");
    }

    public void goToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HomePageApplication.class.getResource("homePage_view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void clear() {
        int selectedId = ListView.getSelectionModel().getSelectedIndex();
        ListView.getItems().remove(selectedId);
    }

}
