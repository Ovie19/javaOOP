package bankApp;

public class Account {

    private int balance;

    private final String pin;

    public Account(String pin) {
        this.pin = pin;
    }

    public int getBalance(String pin) {
        if (!isValidPin(pin)) throw new IllegalArgumentException("Invalid pin");
        return balance;
    }

    public void deposit(int amount) {
        boolean isInvalidAmount = amount <= 0;
        if (isInvalidAmount) throw new IllegalArgumentException("Invalid amount");

        balance = balance + amount;
    }

    public void withdraw(int amount, String pin) {
        if  (!isValidPin(pin)) throw new IllegalArgumentException("Invalid pin");

        boolean isInvalidAmount = balance < amount || amount <= 0;
        if (isInvalidAmount) throw new IllegalArgumentException("Invalid amount");

        balance = balance - amount;
    }

    private boolean isValidPin(String pin) {
        return this.pin.equals(pin);
    }
}