package com.example.testingproject.control;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.view.luggage.LuggageMainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LuggageManageController {
    public TableColumn <Luggage, Integer> idColumn;
    public TableColumn <Luggage, String>stateColumn;
    public TableColumn <Luggage, Integer> weightColumn;
    public TextField textField;
    @FXML
    private Button searchButton;


    @FXML

    private void search(){

    }

    public void deleteText(MouseEvent mouseEvent) {
    }
}

