import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountNumber, String accountHolderName, double initialbalane) {
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance= initialbalane;
        this.transactions= new ArrayList<>();
        transactions.add("Account created with balance:" + initialbalane);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
    public void deposite(double amount){
        if (amount > 0) {
            balance += amount;
            transactions.add("deposite: "+ amount);
        } else {
            System.out.println("invalid deposite amount.");
        }
    }
    public void withdraw(double amount) throws InsufficientResourcesException, InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("withdraw: " + amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawl.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number:" + accountNumber);
        System.out.println("Account Holder:" + accountHolderName);
        System.out.println("Balance: " + balance);
    }
    public void displayTransactionHistory(){
        System.out.println("Transaction History for Account:" + accountNumber);
        for (String transaction: transactions){
            System.out.println(transaction);
        }
    }
}
