package Test;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.service.AccountService;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MethodsTests {
    AccountService accountService = new AccountService();
    AccountDAO accountDAO = new AccountDAO();



    @Test
    void findAccountbyUsernameDAOTest() throws SQLException {
        String username = "daniele";
        Account tempaccount = accountDAO.getAccountbyUsername(username);
        assertEquals(tempaccount.getUsername(),username);


    }

    @Test
    void findAccountbyUsernameServiceTest() throws SQLException {
        String username = "daniele";
        Account tempaccount = accountService.findAccountByUsername(username);
        assertEquals(tempaccount.getUsername(),username);


    }

    @Test
    void addAccountDAOTest() throws SQLException {
        Account account = new Account("check","check","Voli","chek","check");
        if(accountService.findAccountByUsername(account.getUsername())==null){ //per vedere se account con quel username esiste già
            accountDAO.createAccount(account);
            assertEquals(accountService.findAccountByUsername(account.getUsername()).getUsername(),account.getUsername());
        }
    }





}
