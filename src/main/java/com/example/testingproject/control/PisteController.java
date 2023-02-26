package com.example.testingproject.control;

import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.service.PistaService;
import com.example.testingproject.view.piste.SinglePistaApplication;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import com.example.testingproject.model.Wind;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.testingproject.view.piste.PisteApplication;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PisteController implements Initializable {

    @FXML
    private VBox itemHolder = null;

    @FXML
    private ScrollPane scroller;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PistaService pisteService = new PistaService();

        try {

            scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            itemHolder.setSpacing(10);
            scroller.setFitToWidth(true);

            ArrayList<Pista> piste= pisteService.getPiste();
        Node[] nodes = new Node[piste.size()];

        String Wind,Direction;
        Integer Id, Length;
        Wind wind = new Wind();



        for(int i =0;i<nodes.length;i++){
           Id = piste.get(i).getId();
           Length = piste.get(i).getLength();
           Direction = piste.get(i).getDirection();
            Wind = wind.getDirection();
           FXMLLoader loader = new FXMLLoader(PisteApplication.class.getResource("listItem.fxml"));
            nodes[i] = loader.load();
            PisteItemController p = loader.getController();
            p.itemLoader(Id,Length,Wind,Direction);


            int finalI = i;
            nodes[i].setOnMouseEntered(new EventHandler<MouseEvent>(){

               @Override
               public void handle(MouseEvent event) {

                  nodes[finalI].setStyle("-fx-background-color: rgba(144, 238, 144, 0.70); -fx-background-insets:2;");




               }
           });

            nodes[i].setOnMouseExited(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {

                    nodes[finalI].setStyle("-fx-background-color: rgba(128, 128, 128, 0.70); -fx-background-insets:2;");
                }
            });

            nodes[i].setOnMouseClicked(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                    try {
                    nodes[finalI].setStyle("-fx-background-color: rgba(128, 128, 128, 0.70); -fx-background-insets:2;");
                    FXMLLoader loader = new FXMLLoader(SinglePistaApplication.class.getResource("singlePista-view.fxml"));
                        Parent root = loader.load();
                        SinglePistaController p = loader.getController();
                        p.setPista(piste.get(finalI).getId());
                        Scene scene = new Scene(root);
                        Stage primaryStage = new Stage();
                        primaryStage.setTitle("Pista");
                        primaryStage.setScene(scene);
                        primaryStage.initModality(Modality.APPLICATION_MODAL);
                        primaryStage.show();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            });


            itemHolder.getChildren().add(nodes[i]);

        }




        }  catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}