package com.example.testingproject.control;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.DAO.BagagliDAO;
import com.example.testingproject.model.UserHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class LuggageManageController {
    @FXML
    MenuBar myMenuBar;
    public TableColumn <Luggage, Integer> idColumn;
    public TableColumn <Luggage, String>stateColumn;
    public TableColumn <Luggage, Integer> weightColumn;
    public TextField textField;
    @FXML
    private Button searchButton;
    private Luggage tempLuggage;
    private BagagliDAO luggageDAO = new BagagliDAO();


    @FXML

    public void Search(ActionEvent event) {
        tempLuggage = BagagliDAO.getLuggaggeById(textField.getText());

        if (tempLuggage.getStato().equals(textField.getText())) {
            UserHolder holder = UserHolder.getInstance();
        }
    }
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}