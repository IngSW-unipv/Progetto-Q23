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

    AccountDAO accountDAO = new AccountDAO();



    @Test
    void findAccountbyUsernameDAOTest() throws SQLException {
        String username = "daniele";
        Account tempaccount = accountDAO.getAccountbyUsername(username);
        assertEquals(tempaccount.getUsername(),username);


    }

    @Test
    void addAccountDAOTest() throws SQLException {
        Account account = new Account("check","check","Voli","chek","check");
        if(accountDAO.getAccountbyUsername(account.getUsername())==null){ //per vedere se account con quel username esiste già
            accountDAO.createAccount(account);
            assertEquals(accountDAO.getAccountbyUsername(account.getUsername()).getUsername(),account.getUsername());
        }
    }

    @Test
    void findPistaByIDTest() throws SQLException {
        PistaDAO pistaDAO = new PistaDAO();
        Integer Id = 1;
        Pista pista =pistaDAO.findPistaByID(Id);
        assertNotNull(pista);
        assertEquals(pista.getId(),Id);


    }


    @Test
    void findVolobyIDTest(){
        VoliDAO voliDAO = new VoliDAO();
        Integer Id = 1;
        Voli volo = voliDAO.findVoloByID(Id);
        assertNotNull(volo);
        assertEquals(volo.getId(),Id);


    }











}
