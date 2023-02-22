package com.example.testingproject.control;

import com.example.testingproject.view.luggage.LuggageMainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LuggageManageController {
    @FXML
    private Button searchButton;
    @FXML
    private TextField textField;
    @FXML
    private ListView listView;

    @FXML
    private Button backButton;

    @FXML
    private Spinner selectionTypeSpinner;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private void turnBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(LuggageMainApplication.class.getResource("luggageMainView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void search(){
    }
}

