package Test;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;

import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.Voli;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.*;

public class MethodsTests {




    @Test
    void checkConversionDirection(){
        String direction = "Sud";
        Pista pista =new Pista(1,1234,"E");
        assertEquals(pista.convertDirection(direction),"S");

    }

    @Test
    void checkPasswordTest(){
        Account account = new Account("Tusername","Tpassword","Bagagli","Tname","Tsurname");
        String inputPassword = "Tpassword";
        assertTrue(account.checkPassword(inputPassword));

    }














}
