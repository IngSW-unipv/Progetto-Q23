package com.example.testingproject.control;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.UserHolder;
import com.example.testingproject.view.Land.LandPage;
import com.example.testingproject.view.Voli.VoliMainApplication;
import com.example.testingproject.view.luggage.LuggageMainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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


    public void search(ActionEvent event) {
        int id = 0;
        modifyButton.setVisible(false);
        modifyButtonInVolo.setVisible(false);
        String a = textField.getText().substring(7);
        try{
            id = Integer.parseInt(a);
            System.out.println(id) ;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        tempLuggage = BagagliDAO.getLuggaggeById(id);
        assert tempLuggage != null;
        if (tempLuggage.getId() == id) {
            ListView.getItems().add("CODICE VOLO: "+ tempLuggage.getVolo());
            ListView.getItems().add("STATO: "+ tempLuggage.getStato());
            ListView.getItems().add("PESO: "+ tempLuggage.getPeso());

            if (Objects.equals(tempLuggage.getStato(), "SMARRITO")){
                modifyButtonInVolo.setVisible(true);
            } else if((Objects.equals(tempLuggage.getStato(), "IN VOLO"))){
                modifyButton.setVisible(true);
            }
        } else {
            WrongID.setText("BAGAGLIO NON ESISTENTE");
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
    }

    public void modifyINVOLO(ActionEvent actionEvent) {
        luggageDAO.modifyStato(tempLuggage.getId(), StringInVolo);
    }
}