import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        }
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(5000); // Initial balance
        ATM atm = new ATM(account);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
