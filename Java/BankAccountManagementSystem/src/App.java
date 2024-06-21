import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int accountNumCreate = 0;

        System.out.println("Please create an account to continue!");
        System.out.println("Please enter a name: ");
        String name = scanner.nextLine();
        //scanner.nextLine(); // clean buffer
        
        String newAccountNumber = "191201" + String.valueOf(accountNumCreate);
        Account.accounts.add(new Account(newAccountNumber, name, 0));
        Bank.trackTransaction(Account.accounts.get(count).getOwner() + " - " + "opened a new account");
        Account.accounts.get(count).viewBalance();

        while(true) {

            System.out.println("Please enter a transaction type you want to make: ");
            
            String transactionTye = scanner.nextLine();
            Bank.trackTransaction(transactionTye);
            //scanner.nextLine(); // clean buffer

            switch (transactionTye) {
                case "deposit":
                    System.out.println("Please enter the amount: ");
                    double deposit_amount = scanner.nextDouble();
                    scanner.nextLine(); // clean buffer
                    Account.accounts.get(count).deposit(deposit_amount);
                    Bank.trackTransaction(Account.accounts.get(count).getOwner() + " - " + transactionTye + " - " + deposit_amount);
                    break;
                case "withdraw":
                    System.out.println("Please enter the amount: ");
                    double withdraw_amount = scanner.nextDouble();
                    scanner.nextLine(); // clean buffer
                    Account.accounts.get(count).withdraw(withdraw_amount);
                    Bank.trackTransaction(Account.accounts.get(count).getOwner() + " - " + transactionTye + " - " + withdraw_amount);
                    break;
                case "view balance":
                    Account.accounts.get(count).viewBalance();
                    Bank.trackTransaction(Account.accounts.get(count).getOwner() + " - " + transactionTye);
                    break;
                case "display bank info":
                    Bank.displayBankInfo();
                    Bank.trackTransaction(Account.accounts.get(count).getOwner() + " - " + transactionTye);
                    break;
                case "track transaction":
                    for(String transaction : Bank.transactionHistory) {
                        System.out.println(transaction);
                    }
                    Bank.trackTransaction(transactionTye);
                    break;
                default:
                    System.out.println("Please enter a valid transaction!");
                    
            }
            
            System.out.println("Do you want to continue? (yes or no)");
            String q = scanner.nextLine();
            if(q.equals("no")){break;}
        } 

        scanner.close();

    }  
}
