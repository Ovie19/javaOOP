package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank myBank;
    private final String pin = "1234";

    @BeforeEach
    public void setUp() {
        myBank = new Bank("Semicolon Bank");
    }

    @Test
    public void registerAccount_totalAccountsIs1Test() {
        myBank.registerAccount("firstName", "lastName", pin);
        assertEquals(1, myBank.getTotalAccountsCount());
    }

    @Test
    public void registerAccountTwice_totalAccountsIs2Test() {
        myBank.registerAccount("firstName", "lastName", pin);
        myBank.registerAccount("firstName2", "lastName2", "2345");
        assertEquals(2, myBank.getTotalAccountsCount());
    }

    @Test
    public void registerAccount_bankSavesAccountTest() {
        String accountNumber = myBank.registerAccount("firstName", "lastName", pin);
        assertTrue(myBank.isValidAccountNumber(accountNumber));
    }

    @Test
    public void registerAccount_removeAccount_totalAccountIs0Test() {
        String accountNumber = myBank.registerAccount("firstName", "lastName", pin);
        myBank.removeAccount(accountNumber, pin);
        assertEquals(0, myBank.getTotalAccountsCount());
    }

    @Test
    public void registerAccountTwice_removeAccountA_totalAccountIs1Test() {
        String accountNumber1 = myBank.registerAccount("firstName", "lastName", pin);
        String accountNumber2 = myBank.registerAccount("firstName2", "lastName2", "2345");
        myBank.removeAccount(accountNumber2, "2345");
        assertEquals(1, myBank.getTotalAccountsCount());
    }

    @Test
    public void registerAccount_deposit5k_balanceIs5kTest() {
        String accountNumber = myBank.registerAccount("firstName", "lastName", pin);
        myBank.deposit(accountNumber, new BigDecimal("5000"));
        assertEquals(new BigDecimal("5000"), myBank.checkBalance(accountNumber, pin));
    }

    @Test
    public void registerAccount_deposit5k_deposit2k_balanceIs7kTest() {
        String accountNumber = myBank.registerAccount("firstName", "lastName", pin);
        myBank.deposit(accountNumber, new BigDecimal("5000"));
        myBank.deposit(accountNumber, new BigDecimal("2000"));
        assertEquals(new BigDecimal("7000"), myBank.checkBalance(accountNumber, pin));
    }

    @Test
    public void deposit5kToInvalidAccountNumber_throwsExceptionTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> myBank.deposit("912", new BigDecimal("5000"))
        );
    }

    @Test
    public void registerAccount_deposit5k_withdraw2k_balanceIs3kTest() {
        String accountNumber = myBank.registerAccount("firstName", "lastName", pin);
        myBank.deposit(accountNumber, new BigDecimal("5000"));
        myBank.withdraw(accountNumber, new BigDecimal("2000"), pin);
        assertEquals(new BigDecimal("3000"), myBank.checkBalance(accountNumber, pin));
    }

    @Test
    public void withdraw5kToInvalidAccountNumber_throwsExceptionTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> myBank.withdraw("912", new BigDecimal("5000"), pin)
        );
    }

    @Test
    public void registerTwoAccount_deposit5kToAccountA_transfer3kToAccountB_accountABalanceIs2k_accountBBalanceIs3kTest() {
        String accountNumber1 = myBank.registerAccount("firstName", "lastName", pin);
        String accountNumber2 = myBank.registerAccount("firstName2", "lastName2", "2345");
        myBank.deposit(accountNumber1, new BigDecimal("5000"));
        myBank.transfer(accountNumber1, accountNumber2, new BigDecimal("3000"), pin);
        assertEquals(new BigDecimal("2000"), myBank.checkBalance(accountNumber1, pin));
        assertEquals(new BigDecimal("3000"), myBank.checkBalance(accountNumber2, "2345"));
    }

    @Test
    public void transferToInvalidAccount_throwsExceptionTest() {
        String accountNumber1 = myBank.registerAccount("firstName", "lastName", pin);
        myBank.deposit(accountNumber1, new BigDecimal("5000"));
        assertThrows(
            IllegalArgumentException.class,
            () ->  myBank.transfer(accountNumber1, "91", new BigDecimal("3000"), pin)
        );
    }
}