package com.example.testingproject.control;

import com.example.testingproject.model.DAO.TerreniDAO;
import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.view.homePage.HomePageApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;


public class AggiuntaVoliController {
    @FXML
    public Button insertButtonPart;
    @FXML
    public Button insertButtonArrivo;
    @FXML
    private TextField gateh;
    @FXML
    private TextField aeroportoph;
    @FXML
    private TextField dataorah;
    @FXML
    private TextField idvoloh;
    @FXML
    private TextField duratah;
    @FXML
    private TextField ritardoh;
    @FXML
    private TextField pistah;
    @FXML
    private TextField idaereoh;






    public MenuBar myMenuBar;
    @FXML
    private javafx.scene.control.ListView<String> listView;
    private Stage stage;
    private Scene scene;



    private Parent root;

    VoliDAO voliDAO = new VoliDAO();
    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HomePageApplication.class.getResource("homePage_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 512);
        stage.setScene(scene);
        stage.show();
    }

    public void inserisciVoliPart(ActionEvent actionEvent) throws SQLException {
        try{
        String gate = gateh.getText();
        String aeroportop = aeroportoph.getText();
        String dataora = dataorah.getText();
        String idvolo = idvoloh.getText();
        String durata = duratah.getText();
        String ritardo = ritardoh.getText();
        String pista = pistah.getText();
        String idaereo = idaereoh.getText();
        int  idVolo = Integer.parseInt(idvolo);
        int  durataapp = Integer.parseInt(durata);
        int  ritardoapp = Integer.parseInt(ritardo);
        int  aereo = Integer.parseInt(idaereo);
        int  pistaapp = Integer.parseInt(pista);
            boolean inserisci = voliDAO.inserisciVoli(idVolo, durataapp, ritardoapp, aereo, gate);
            System.out.println(inserisci);
            if(inserisci) {
                voliDAO.inserisciPartenza(idVolo, pistaapp, dataora, aeroportop);
                System.out.println("ok!");
            }
        }
        catch(NumberFormatException e){
            System.out.println("Errore");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore di Inserimento");
            errorAlert.setHeaderText("Inserisci i dati nel formato corretto");
            errorAlert.showAndWait();

        }

    }





    public void inserisciVoliArrivo(ActionEvent insertButtonArrivo) throws SQLException {
       try {
           String gate = gateh.getText();
           String aeroportop = aeroportoph.getText();
           String dataora = dataorah.getText();
           String idvolo = idvoloh.getText();
           String durata = duratah.getText();
           String ritardo = ritardoh.getText();
           String pista = pistah.getText();
           String idaereo = idaereoh.getText();
           int idVolo = Integer.parseInt(idvolo);
           int durataapp = Integer.parseInt(durata);
           int ritardoapp = Integer.parseInt(ritardo);
           int aereo = Integer.parseInt(idaereo);
           int pistaapp = Integer.parseInt(pista);


           boolean inserisci = voliDAO.inserisciVoli(idVolo, durataapp, ritardoapp, aereo, gate);
           System.out.println(inserisci);
           if (inserisci) {
               voliDAO.inserisciArrivo(idVolo, pistaapp, dataora, aeroportop);
               System.out.println("ok!");
           }
       }catch(NumberFormatException e){
           System.out.println("Errore");
           Alert errorAlert = new Alert(Alert.AlertType.ERROR);
           errorAlert.setTitle("Errore di Inserimento");
           errorAlert.setHeaderText("Inserisci i dati nel formato corretto");
           errorAlert.showAndWait();

        }

    }


}
