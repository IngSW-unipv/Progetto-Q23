package com.example.testingproject.control;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.DAO.BagagliDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;


public class LuggageManageController {
    @FXML
    public Label WrongID;

    public MenuBar myMenuBar;
    public TableColumn <Luggage, Integer> idColumn;
    public TableColumn <Luggage, String>stateColumn;
    public TableColumn <Luggage, Integer> weightColumn;
    public TextField textField;
    @FXML
    private Button searchButton;
    private Luggage tempLuggage;
    private BagagliDAO luggageDAO = new BagagliDAO();


    @FXML

    public void search(ActionEvent event) {
        int id = 0;
        String a = textField.getText().substring(7);
        try{
            id = Integer.parseInt(a);
            System.out.println(id) ;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        tempLuggage = BagagliDAO.getLuggaggeById(id);

        if (tempLuggage.getId() == id) {
            System.out.println(tempLuggage.getId());
            System.out.println(tempLuggage.getStato());
            System.out.println(tempLuggage.getVolo());
            System.out.println(tempLuggage.getPeso());
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
}