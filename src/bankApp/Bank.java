package bankApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static final String BANK_CODE = "312";
    private int serialNumber = 1457;
    private String name;
    private final List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        Account foundAccount = findAccountByAccountNumber(accountNumber);
        validateAccount(foundAccount);
        foundAccount.deposit(amount);
    }

    public void withdraw(String accountNumber, BigDecimal amount, String pin) {
        Account foundAccount = findAccountByAccountNumber(accountNumber);
        validateAccount(foundAccount);
        foundAccount.withdraw(amount, pin);
    }

    public void transfer(
        String senderAccountNumber,
        String receiverAccountNumber,
        BigDecimal amount,
        String pin
    ) {
        Account senderAccount = findAccountByAccountNumber(senderAccountNumber);
        Account receiverAccount = findAccountByAccountNumber(receiverAccountNumber);

        validateAccount(senderAccount);
        validateAccount(receiverAccount);

        senderAccount.withdraw(amount, pin);
        receiverAccount.deposit(amount);
    }

    public BigDecimal checkBalance(String accountNumber, String pin) {
        Account foundAccount = findAccountByAccountNumber(accountNumber);
        validateAccount(foundAccount);
        return foundAccount.getBalance(pin);
    }

    public String registerAccount(String firstName, String lastName, String pin) {
        String accountNumber = generateAccountNumber();
        Account account = new Account(accountNumber, firstName, lastName, pin);
        accounts.add(account);
        return accountNumber;
    }

    public void removeAccount(String accountNumber, String pin) {
        Account foundAccount = findAccountByAccountNumber(accountNumber);
        validateAccount(foundAccount);
        foundAccount.getBalance(pin);
        accounts.remove(foundAccount);
    }

    public boolean isValidAccountNumber(String accountNumber) {
        Account foundAccount = findAccountByAccountNumber(accountNumber);
        return foundAccount != null;
    }

    public int getTotalAccountsCount() {
        return accounts.size();
    }

    private Account findAccountByAccountNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private String generateAccountNumber() {
        String nubanSerialNumber = padToNineDigits(serialNumber);
        String baseAccountNumber = BANK_CODE + nubanSerialNumber;
        int[] multipliers = {3, 7, 3, 3, 7, 3, 3, 7, 3, 3, 7, 3};

        int total = 0;
        for (int index = 0; index < baseAccountNumber.length(); index++) {
            total += Character.getNumericValue(baseAccountNumber.charAt(index))
                    *  multipliers[index];
        }

        int mod = total % 10;
        int checkDigit = (10 - mod) % 10;

        String accountNumber = nubanSerialNumber + checkDigit;
        System.out.println(accountNumber);
        serialNumber++;
        return accountNumber;
    }

    private String padToNineDigits(int serialNumber) {
        return String.format("%09d", serialNumber);
    }

    private void validateAccount(Account account) {
        boolean isNotFound = account == null;
        if (isNotFound) throw new IllegalArgumentException("Account not found");
    }
}
