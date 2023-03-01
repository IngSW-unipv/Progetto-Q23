package com.example.testingproject.control;
import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.view.homePage.HomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import com.example.testingproject.view.Voli.VoliArrivo.VoliArrivoApplication;
import com.example.testingproject.view.Voli.VoliPartenze.VoliPartenzeApplication;
import com.example.testingproject.view.Voli.AggiuntaVoli.AggiuntaVoliApplication;

public class VoliController{




    @FXML
    private Label Label;

    private Stage stage;
    private Scene scene;



    private Parent root;

    private VoliDAO VoliDAO = new VoliDAO();

    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePage.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void openArrivalsVoliView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(VoliArrivoApplication.class.getResource("VoliArrivo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openVoliDeparturesView(ActionEvent event) throws IOException, SQLException {
        root = FXMLLoader.load(VoliPartenzeApplication.class.getResource("VoliPartenze.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    protected void openAddVoli(ActionEvent event) throws IOException, SQLException {
        root = FXMLLoader.load(AggiuntaVoliApplication.class.getResource("AggiuntaVoli.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
        


    }

}
