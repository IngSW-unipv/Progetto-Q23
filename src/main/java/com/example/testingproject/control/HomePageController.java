package com.example.testingproject.control;


import com.example.testingproject.model.Account;
import com.example.testingproject.model.UserHolder;
import com.example.testingproject.model.Voli;
import com.example.testingproject.view.Land.LandPage;
import com.example.testingproject.view.Voli.VoliMainApplication;
import com.example.testingproject.view.homePage.HomePage;
import com.example.testingproject.view.luggage.LuggageMainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageController{
    @FXML
    MenuBar myMenuBar;
    private List<ToggleButton> buttons;

    @FXML private GridPane grid;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void initialize() {

        UserHolder holder = UserHolder.getInstance();
        System.out.println(holder.getUser().getUserType() + "  " + holder.getUser().getUsername());
        switch (holder.getUser().getUserType()) {
            case "Admin":

                break;
            case "Bagagli":
                buttons = new ArrayList<>();
                for (int row = 0; row < 1; row++) {
                    for (int col = 0; col < 2; col++) {
                        ToggleButton button = new ToggleButton();
                        if (col == 0) {
                            button.setText("Voli");
                            button.setStyle("-fx-font-size:20");
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(VoliMainApplication.class.getResource("VoliVis.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.show();
                                }
                            });
                        }
                        if (col == 1) {
                            button.setText("Bagagli");
                            button.setStyle("-fx-font-size:20");
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(LuggageMainApplication.class.getResource("mainLuggageView.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.show();
                                }
                            });
                        }
                        // configure button...
                        buttons.add(button);
                        grid.add(button, col, row);
                    }
                }
                break;
            case "Voli":
                System.out.println("sei un GESTORE Terreni");
                buttons = new ArrayList<>();
                for (int row = 0; row < 2; row++) {
                    for (int col = 0; col < 1; col++) {
                        ToggleButton button = new ToggleButton();
                        // configure button...
                        buttons.add(button);
                        grid.add(button, col, row);
                    }
                }

                break;

            case "Terreno":
                buttons = new ArrayList<>();
                for (int row = 0; row < 1; row++) {
                    for (int col = 0; col < 3; col++) {
                        ToggleButton button = new ToggleButton();
                        if (col == 0) {
                            button.setText("Lista Terreni");
                            button.setStyle("-fx-font-size:20");
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(LandPage.class.getResource("landPage_view.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.show();
                                }
                            });
                        }
                        if (col == 1){
                            button.setText("Modifica");
                            button.setStyle("-fx-font-size:20");}

                        // configure button...
                        buttons.add(button);
                        grid.add(button, col, row);
                    }
                }
                break;

        }
    }
    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}