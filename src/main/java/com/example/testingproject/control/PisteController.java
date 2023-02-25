package com.example.testingproject.control;

import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.service.PistaService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class PisteController {
    public PisteController() throws SQLException {
    }

    private PistaService pisteService = new PistaService();
    private ArrayList<Pista> piste = pisteService.getPiste();




}