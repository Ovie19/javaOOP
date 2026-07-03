package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account account;
    private final String pin = "2468";

    @BeforeEach
    public void setUp() {
        account = new Account(pin);
    }

    @Test
    public void deposit500_balanceIs500Test() {
        account.deposit(500);
        assertEquals(500, account.getBalance(pin));
    }

    @Test
    public void deposit300_deposit700_balanceIs1000Test() {
        account.deposit(300);
        account.deposit(700);
        assertEquals(1000, account.getBalance(pin));
    }

    @Test
    public void deposit500_withdraw200_balanceIs300Test() {
        account.deposit(500);
        account.withdraw(200, pin);
        assertEquals(300, account.getBalance(pin));
    }

    @Test
    public void depositMinus500_throwException_balanceIs0Test() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-500));
        assertEquals(0,  account.getBalance(pin));
    }

    @Test
    public void deposit300_withdraw200_withdraw50_balanceIs50Test() {
        account.deposit(300);
        account.withdraw(200, pin);
        account.withdraw(50, pin);
        assertEquals(50, account.getBalance(pin));
    }

    @Test
    public void deposit500_withdraw500_withdraw100_throwExceptionTest() {
        account.deposit(500);
        account.withdraw(500, pin);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100, pin));
        assertEquals(0, account.getBalance(pin));
    }

    @Test
    public void withdrawMinus500_throwException_balanceIs0Test() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-500, pin));
        assertEquals(0,  account.getBalance(pin));
    }

    @Test
    public void getBalanceWithWrongPinThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> account.getBalance("4095"));
    }

    @Test
    public void withdraw200From500BalanceWithWrongPin_throwsException_balanceIs500Test() {
        account.deposit(500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200, "4095"));
        assertEquals(500, account.getBalance(pin));
    }
}