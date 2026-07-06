package bankApp;

import java.math.BigDecimal;

public class Account {

    private String name;
    private String number;
    private BigDecimal balance;
    private final String pin;

    public Account(String accountNumber, String firstName, String lastName, String pin) {
        this.pin = pin;
        this.balance = BigDecimal.ZERO;
        this.number = accountNumber;
        this.name = firstName + " " + lastName;
    }

    public BigDecimal getBalance(String pin) {
        if (!isValidPin(pin)) throw new IllegalArgumentException("Invalid pin");
        return balance;
    }

    public void deposit(BigDecimal amount) {
        boolean isInvalidAmount = amount.compareTo(BigDecimal.ZERO) < 0;
        if (isInvalidAmount) throw new IllegalArgumentException("Invalid amount");

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount, String pin) {
        if  (!isValidPin(pin)) throw new IllegalArgumentException("Invalid pin");

        boolean isInvalidAmount = balance.compareTo(amount) < 0 || amount.compareTo(BigDecimal.ZERO) <= 0;
        if (isInvalidAmount) throw new IllegalArgumentException("Invalid amount");

        balance = balance.subtract(amount);
    }

    public String getAccountName() {
        return name;
    }

    public String getAccountNumber() {
        return number;
    }

    private boolean isValidPin(String pin) {
        return this.pin.equals(pin);
    }
}