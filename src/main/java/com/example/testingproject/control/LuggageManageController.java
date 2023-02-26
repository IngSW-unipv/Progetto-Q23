package com.example.testingproject.control;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Objects;

public class LuggageManageController {
    @FXML
    public Label WrongID;

    public MenuBar myMenuBar;

    public javafx.scene.control.ListView<String> ListView;
    public TextField textField;
    public Button modifyButton;
    public Button modifyButtonInVolo;

    private String StringSmarrito = "SMARRITO";
    private String StringInVolo = "IN VOLO";
    @FXML
    private Button searchButton;
    @FXML
    private Luggage tempLuggage;
    @FXML
    private BagagliDAO luggageDAO = new BagagliDAO();
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void search(ActionEvent event) {
        // addettamento stringa dinamica per ricerca
        String codice = textField.getText();
        int lencodice = codice.length();
        int lcod,line = 0;
        char j ;
        codice= codice.substring(8);
        lcod = codice.length();
        for(int i = 0; i < lcod; i++) {
            j = codice.charAt(i);
            if (j == '-'){
                 line = i;
                 break;
            }
        }
        System.out.println(line);
        // prelevamento informazioni dall'etichetta
        int idVolo = 0;
        int idBagaglio = 0;
        boolean verifica = false;
        String firstAirport = textField.getText().substring(0, 3);
        String secondAirport = textField.getText().substring(4, 7);
        String volo =codice.substring(0,line);
        String bagaglio = codice.substring(line+1,lcod);

        System.out.println("id baglio: "+ bagaglio);

        modifyButton.setVisible(false);
        modifyButtonInVolo.setVisible(false);
        try {
            idVolo = Integer.parseInt(volo);
            idBagaglio = Integer.parseInt(bagaglio);
            System.out.println("id volo: " +idVolo);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // verifica di presenza del volo specificato
        verifica = luggageDAO.verifyLuggagge(idVolo, firstAirport, secondAirport);
        if (!verifica) {
            ListView.getItems().add("IL VOLO RICERCATO NON ESISTE");
        } else {
            tempLuggage = luggageDAO.getLuggaggeById(idBagaglio);
            assert tempLuggage != null;
            // verifica esistenza bagaglio specificato
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
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }

    public void deleteText(MouseEvent mouseEvent) {
    }

    public void modify(ActionEvent actionEvent){
        luggageDAO.modifyStato(tempLuggage.getId(), StringSmarrito);
        ListView.getItems().add("STATO BAGAGAGLIO CAMBIATO CORRETTAMENTE");
    }

    public void modifyINVOLO(ActionEvent actionEvent) {
        luggageDAO.modifyStato(tempLuggage.getId(), StringInVolo);
        ListView.getItems().add("STATO BAGAGAGLIO CAMBIATO CORRETTAMENTE");
    }

   /* public void goToHome(ActionEvent actionEvent) throws IOException {
            root = FXMLLoader.load(Objects.requireNonNull(HomePage.class.getResource("homePage_view.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 1024, 512);
            stage.setScene(scene);
            stage.show();
       }*/
}