import java.util.ArrayList;
import java.util.List;


public class Account {
    public static List<Account> accounts = new ArrayList<>();
    //public static Account[] accounts = new Account[100];

    private static String accountNumber;
    private static String owner;
    private static double balance;

    public Account(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance = amount + this.balance;
        System.out.println("Your deposit of $" + amount + " has been completed.");
        System.out.println("Your current balance is $" + this.balance + " .");
    }
    public void withdraw(double amount) {
        if(this.balance >= amount) {
            this.balance = this.balance - amount;
            System.out.println("Your withdraw of $" + amount + " has been completed.");
            System.out.println("Your current balance is $" + this.balance + " .");
        } else {
            System.out.println("Your balance is insufficient for this transaction.");
        }
    }

    public void viewBalance() {
        System.out.println("Account Owner: " + this.owner);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Balance: " + this.balance);
    }

    public String getOwner() {
        return owner;
    }

}