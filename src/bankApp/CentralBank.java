package bankApp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Banks {

    private static final Map<BankName, Bank> banks = new HashMap<>();
    private static final Map<String, Account> accounts = new HashMap<>();

    static {
        banks.put(BankName.ACCESS_BANK, new Bank(BankName.ACCESS_BANK));
        banks.put(BankName.ZENITH_BANK, new Bank(BankName.ZENITH_BANK));
        banks.put(BankName.FIRST_BANK, new Bank(BankName.FIRST_BANK));
        banks.put(BankName.FIDELITY_BANK, new Bank(BankName.FIDELITY_BANK));
        banks.put(BankName.STANBIC_IBTC, new Bank(BankName.STANBIC_IBTC));
    }

    public Account registerAccount(String bankName, String firstName, String lastName, String pin) {
        BankName myBankName = BankName.valueOf(bankName);
        Bank bank = banks.get(myBankName);
        if (bank != null) {
            Account account = bank.registerAccount(firstName, lastName, pin);
            accounts.put(account.getAccountNumber(), account);
            return account;
        }
        return null;
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        Account account = accounts.get(accountNumber);
        if (account != null)
            account.deposit(amount);

    }

    public void withdraw(String accountNumber, BigDecimal amount, String pin) {
        Account account = accounts.get(accountNumber);
        if (account != null)
            account.withdraw(amount, pin);
    }

    public void transfer(
        String senderAccountNumber,
        String receiverAccountNumber,
        BigDecimal amount,
        String pin
    ) {
        Account senderAccount = accounts.get(senderAccountNumber);
        Account receiverAccount = accounts.get(receiverAccountNumber);

        if (senderAccount != null && receiverAccount != null) {
            senderAccount.withdraw(amount, pin);
            receiverAccount.deposit(amount);
        }
    }

    public BigDecimal checkBalance(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        if (account != null)
            return account.getBalance(pin);

        return BigDecimal.ZERO;
    }

//    public static Account createAccount(String bankName, String firstName, String lastName, String pin) {
//        Bank bank = banks.get(bankName);
//        if (bank == null) {
//            throw new IllegalArgumentException("Bank not found: " + bankName);
//        }
//
//        Account account = bank.registerAccount(firstName, lastName, pin);
//        accounts.put(account.getAccountNumber(), account);
//        return account;
//    }
//
//    public static void transfer(
//            String senderAccountNumber,
//            String receiverAccountNumber,
//            BigDecimal amount,
//            String pin
//    ) {
//        Account sender = accounts.get(senderAccountNumber);
//        Account receiver = accounts.get(receiverAccountNumber);
//
//        validateAccount(sender, "Sender");
//        validateAccount(receiver, "Receiver");
//
//        sender.withdraw(amount, "1234");
//        receiver.deposit(amount);
//
//        System.out.println("✅ Transfer successful!");
//        System.out.println("Sent: " + amount + " from " + senderAccountNumber +
//                " to " + receiverAccountNumber);
//        System.out.println("Sender new balance: " + sender.getBalance("1234"));
//        System.out.println("Receiver new balance: " + receiver.getBalance("1234"));
//    }
//
//    private static void validateAccount(Account account, String type) {
//        if (account == null) {
//            throw new IllegalArgumentException(type + " account not found");
//        }
//    }
//
//    public static Bank getBank(String bankName) {
//        return banks.get(bankName);
//    }
//
//    public static Account getAccount(String accountNumber) {
//        return accounts.get(accountNumber);
//    }
//
//    public static void main(String[] args) {
//        Account account1 = createAccount("Access Bank", "firstName", "lastName", "1234");
//        Account account2 = createAccount("Zenith Bank", "firstName2", "lastName2", "1234");
//
//        account1.deposit(new BigDecimal("20000"));
//
//        System.out.println("Account 1: " + account1.getAccountNumber() + " | Balance: " + account1.getBalance("1234"));
//        System.out.println("Account 2: " + account2.getAccountNumber() + " | Balance: " + account2.getBalance("1234"));
//
//        transfer(account1.getAccountNumber(), account2.getAccountNumber(),
//                new BigDecimal("3000"), "1234");
//    }
}