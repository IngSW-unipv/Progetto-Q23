package com.example.testingproject.control;


import com.example.testingproject.model.UserHolder;
import com.example.testingproject.view.GestioneAccount.GestioneAccountApplication;
import com.example.testingproject.view.Land.LandPageApplication;
import com.example.testingproject.view.Voli.VoliMainApplication;
import com.example.testingproject.view.luggage.LuggageMainApplication;
import com.example.testingproject.view.piste.PisteApplication;
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
    public void initialize() throws IOException {

        UserHolder holder = UserHolder.getInstance();
        switch (holder.getUser().getUserType()) {
            case "Admin":
                buttons = new ArrayList<>();
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 2; col++) {
                        ToggleButton button = new ToggleButton();
                        if (col == 0 && row ==0) {
                            button.setText("Account");
                            button.setStyle("-fx-font-size:20");

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(GestioneAccountApplication.class.getResource("GestioneAccount.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.setTitle("Account");
                                    stage.show();
                                }
                            });
                        }
                        if (col == 1 && row == 0){
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
                                    stage.setTitle("Voli Page");
                                    stage.show();
                                }
                            });
                        }
                        if (col == 0 && row ==1){
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
                                    stage.setTitle("Bagagli Page");
                                    stage.show();
                                }
                            });
                        }

                        if (col == 1 && row ==1){
                            button.setText("Terreno");
                            button.setStyle("-fx-font-size:20");

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(LandPageApplication.class.getResource("landPage_view.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.setTitle("Terreno Page");
                                    stage.show();
                                }
                            });
                        }
                        if (col == 1 && row ==2){
                            button.setText("Piste");
                            button.setStyle("-fx-font-size:20");

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(PisteApplication.class.getResource("piste-view.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.setTitle("Piste Page");
                                    stage.show();
                                }
                            });
                        }
                        if (col == 0 && row ==2){
                            button.setText("Close");
                            button.setStyle("-fx-font-size:20");

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    System.exit(1);
                                }
                            });
                        }

                        // configure button...
                        buttons.add(button);
                        grid.add(button, col, row);
                    }
                }
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
                                    stage.setTitle("Voli Page");
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
                                    stage.setTitle("Bagagli Page");
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
                                    stage.setTitle("Voli Page");
                                    stage.setScene(scene);
                                    stage.show();
                                }
                            });
                        }
                        if (col == 1) {
                            button.setText("Piste");
                            button.setStyle("-fx-font-size:20");
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(PisteApplication.class.getResource("piste-view.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setTitle("Piste Page");
                                    stage.setScene(scene);
                                    stage.show();
                                }
                            });
                        }
                        buttons.add(button);
                        grid.add(button, col, row);
                    }
                }


                break;

            case "Terreno":
                buttons = new ArrayList<>();
                for (int row = 0; row < 1; row++) {
                    for (int col = 0; col < 2; col++) {
                        ToggleButton button = new ToggleButton();
                        if (col == 0) {
                            button.setText("Lista Terreni");
                            button.setStyle("-fx-font-size:20");
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(LandPageApplication.class.getResource("landPage_view.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.setTitle("Terreno Page");
                                    stage.show();
                                }
                            });
                        }
                        if (col == 1){
                            button.setText("Modifica");
                            button.setStyle("-fx-font-size:20");
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        root = FXMLLoader.load(LandPageApplication.class.getResource("assign/landPage_assignview.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root, 1024, 512);
                                    stage.setScene(scene);
                                    stage.setTitle("Modifica");
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

        }
    }
    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}