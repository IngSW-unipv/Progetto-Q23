package com.example.testingproject.control;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.DAO.BagagliDAO;
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

public class LuggageManageController {

    public MenuBar myMenuBar;

    public javafx.scene.control.ListView<String> ListView;
    public TextField textField;
    public Button modifyButton;
    public Button modifyButtonInVolo;
    public javafx.scene.control.ListView<String> ListView1;
    @FXML
    public Button clearButton;
    @FXML
    private Button searchButton;
    @FXML
    private Luggage tempLuggage;
    @FXML
    private final BagagliDAO luggageDAO = new BagagliDAO();
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void initialize() throws SQLException {
        ArrayList<VistaVoloBagaglio> voli = new ArrayList<>();
        ListView1.getItems().add("VOLO"+"  "+ "PARTENZA"+"  "+ "ARRIVO");
        voli = luggageDAO.getVistaArrivo();
        for (VistaVoloBagaglio vistaVoloBagaglio : voli) {
            ListView1.getItems().add(vistaVoloBagaglio.getIdVolo() + "             " + vistaVoloBagaglio.getAeroportoP() + "             " + vistaVoloBagaglio.getAeroportoA());
        }
    }


    public void search(ActionEvent event) throws SQLException {
        // addettamento stringa dinamica per ricerca
        String codice = textField.getText();
        int lencodice = codice.length();
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
        boolean verifica1 = false;
        boolean verifica2 = false;
        String firstAirport = textField.getText().substring(0, 3);
        String secondAirport = textField.getText().substring(4, 7);
        String volo = codice.substring(0, line);
        String bagaglio = codice.substring(line + 1, lcod);

        System.out.println("id baglio: " + bagaglio);

        modifyButton.setVisible(false);
        modifyButtonInVolo.setVisible(false);
        try {
            idVolo = Integer.parseInt(volo);
            idBagaglio = Integer.parseInt(bagaglio);
            System.out.println("id volo: " + idVolo);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // verifica di presenza del volo specificato
        verifica1 = luggageDAO.verifyFly(idVolo, firstAirport, secondAirport);
        // verifica presenza di bagaglio su quel determinato volo
        verifica2 = luggageDAO.verifyLuggegeinFly(idBagaglio, idVolo);
        if (!verifica1) {
            ListView.getItems().add("IL VOLO RICERCATO NON ESISTE");
        } else {
            if (!verifica2) {
                ListView.getItems().add("IL BAGAGLIO SELEZIONATO NON E' PRESENTE SU QUESTO VOLO");
            } else {
                tempLuggage = luggageDAO.getLuggaggeById(idBagaglio);
                assert tempLuggage != null;
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
    }
    public void modify(ActionEvent actionEvent) throws SQLException {
        String Smarrito = "SMARRITO";
        luggageDAO.modifyStato(tempLuggage.getId(), Smarrito);
        ListView.getItems().add("STATO BAGAGAGLIO CAMBIATO CORRETTAMENTE");
    }

    public void modifyINVOLO(ActionEvent actionEvent) throws SQLException {
        String StringInVolo = "IN VOLO";
        luggageDAO.modifyStato(tempLuggage.getId(), StringInVolo);
        ListView.getItems().add("STATO BAGAGAGLIO CAMBIATO CORRETTAMENTE");
    }

    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(HomePageApplication.class.getResource("homePage_view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    public void clear(MouseEvent mouseEvent) {
        int selectedId = ListView.getSelectionModel().getSelectedIndex();
        ListView.getItems().remove(selectedId);
    }

}