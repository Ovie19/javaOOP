package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account account;
    private final String pin = "2468";

    @BeforeEach
    public void setUp() {
        account = new Account("AccountNumber","firstName","lastName", pin);
    }

    @Test
    public void deposit500_balanceIs500Test() {
        account.deposit(new BigDecimal("500"));
        assertEquals(new BigDecimal("500"), account.getBalance(pin));
    }

    @Test
    public void deposit300_deposit700_balanceIs1000Test() {
        account.deposit(new BigDecimal("300"));
        account.deposit(new BigDecimal("700"));
        assertEquals(new BigDecimal("1000"), account.getBalance(pin));
    }

    @Test
    public void deposit500_withdraw200_balanceIs300Test() {
        account.deposit(new BigDecimal("500"));
        account.withdraw(new BigDecimal("200"), pin);
        assertEquals(new BigDecimal("300"), account.getBalance(pin));
    }

    @Test
    public void depositMinus500_throwException_balanceIs0Test() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(new BigDecimal("-500")));
        assertEquals(BigDecimal.ZERO,  account.getBalance(pin));
    }

    @Test
    public void deposit300_withdraw200_withdraw50_balanceIs50Test() {
        account.deposit(new BigDecimal("300"));
        account.withdraw(new BigDecimal("200"), pin);
        account.withdraw(new BigDecimal("50"), pin);
        assertEquals(new BigDecimal("50"), account.getBalance(pin));
    }

    @Test
    public void deposit500_withdraw500_withdraw100_throwExceptionTest() {
        account.deposit(new BigDecimal("500"));
        account.withdraw(new BigDecimal("500"), pin);
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("100"), pin)
        );
        assertEquals(BigDecimal.ZERO, account.getBalance(pin));
    }

    @Test
    public void withdrawMinus500_throwException_balanceIs0Test() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("-500"), pin)
        );
        assertEquals(BigDecimal.ZERO,  account.getBalance(pin));
    }

    @Test
    public void getBalanceWithWrongPinThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> account.getBalance("4095"));
    }

    @Test
    public void withdraw200From500BalanceWithWrongPin_throwsException_balanceIs500Test() {
        account.deposit(new BigDecimal("500"));
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("500"), "4095")
        );
        assertEquals(new BigDecimal("500"), account.getBalance(pin));
    }
}