package com.example.testingproject.control;

import com.example.testingproject.view.homePage.HomePage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.stage.Stage;

import com.example.testingproject.view.homePage.HomePage;
public class VoliController{

    @FXML
    private Button buttonVoliDepartures;
    @FXML
    private Button buttonVoliArrivals;
    @FXML
    private Label Label;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void openVoliDeparturesView() {Label.setText("Departure");}
    @FXML
    protected void openArrivalsVoliView() {Label.setText("Arrivals");}

    @FXML
    protected void openLuggageManageView() {Label.setText("Manage");
      /* System.out.print(manage.class.getResource("manageView.fxml"));
        root = FXMLLoader.load(manageMain.class.getResource("manageView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024, 512);
        stage.setScene(scene);
        stage.show();
*/
    }

    @FXML
    protected void openLuggageFlyView() {Label.setText("Fly");}

}
