package com.example.testingproject.control;

import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.model.Voli;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AggiuntaVoli {
    public Spinner<Integer> WightSpinner;
    public Button insertButton;
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
    private Voli tempVoli;

    public void inserisciVoli(ActionEvent actionEvent) {
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



        VoliDAO.inserisciVoli(idVolo,durataapp,ritardoapp,aereo,gate);
        System.out.println("ok!");

    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }
}
