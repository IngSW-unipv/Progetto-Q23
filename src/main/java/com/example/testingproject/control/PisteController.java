package com.example.testingproject.control;


import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.PistaSingleton;
import com.example.testingproject.view.homePage.HomePageApplication;
import com.example.testingproject.view.piste.SinglePistaApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import com.example.testingproject.model.Wind;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.testingproject.view.piste.PisteApplication;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PisteController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private VBox itemHolder = null;

    @FXML
    private ScrollPane scroller;

   @FXML
   Label removeAlert;

   @FXML
   Label addAlert;

   @FXML
    TextField removeID;


    @FXML
    TextField lengthValue;

    @FXML
    TextField directionValue;





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {

            scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            itemHolder.setSpacing(10);
            scroller.setFitToWidth(true);

            ArrayList<Pista> piste= PistaSingleton.getInstance().getPiste();
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
                    } catch (SQLException e) {
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



    public void addPista(ActionEvent event) throws SQLException {
        addAlert.setText("");
        PistaDAO pistaDAO = new PistaDAO();
        Integer inputID = 1;

        if(!(directionValue.getText().isEmpty() && lengthValue.getText().isEmpty())) {
            Integer inputLength = Integer.parseInt(lengthValue.getText());
            String inputDirection = Pista.convertDirection(directionValue.getText());
            Pista tempPista = new Pista(inputID, inputLength, inputDirection);
            boolean output = false;
            try {
                output = pistaDAO.newPista(tempPista);
            } catch (Exception e) {
                addAlert.setText("Errore!");
            }
            if (!output) {
                addAlert.setText("Errore!");
            } else {
                addAlert.setText("");
            }
        }
        else{
            addAlert.setText("Errore!");
        }

        PistaSingleton.getInstance().update();

    }

    public void removePista(ActionEvent event) throws SQLException {
        removeAlert.setText("");
        if(!(removeID.getText().isEmpty())) {
            Integer inputID = Integer.parseInt(removeID.getText());
            PistaDAO pistaDAO = new PistaDAO();
            Pista pista = pistaDAO.findPistaByID(inputID);
            if (pista != null) {
                pistaDAO.removePista(pista);

            } else {
                removeAlert.setText("Pista non esiste!");
            }
        }
        else{
            removeAlert.setText("Pista non esiste!");
        }


    PistaSingleton.getInstance().update();

    }
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePageApplication.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

}


