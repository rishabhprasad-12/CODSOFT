import java.util.*;

class Account {
    // Private variables to store PIN, balance, and transaction history
    private int pin;
    private float balance;
    private List<Transaction> transactionHistory;

    // Constructor to initialize account with PIN, initial balance, and empty transaction history
    public Account(int pin) {
        this.pin = pin;
        this.balance = 10000.0f;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to check if the user-provided PIN matches the account PIN
    public boolean checkPin(int userPin) {
        return this.pin == userPin;
    }

    // Method to get the current account balance
    public float getBalance() {
        return this.balance;
    }

    // Method to withdraw a specified amount from the account
    public void withdraw(float wdAmount) {
        if (wdAmount > 0 && wdAmount <= balance) {
            // Update balance and record transaction
            balance -= wdAmount;
            recordTransaction(wdAmount, true);
            System.out.println("\nWithdrawal successful. \nCurrent balance: " + balance);
        } else {
            System.out.println("\nInsufficient funds or invalid amount.");
        }
    }

    // Method to deposit a specified amount into the account
    public void deposite(float dAmount) {
        if (dAmount > 0) {
            // Update balance and record transaction
            balance += dAmount;
            recordTransaction(dAmount, false);
            System.out.println("\nDeposit successful. \nCurrent balance: " + balance);
        } else {
            System.out.println("\nInvalid amount for deposit.");
        }
    }

    // Private method to record a transaction in the transaction history
    private void recordTransaction(float amount, boolean isWithdrawal) {
        transactionHistory.add(new Transaction(amount, isWithdrawal));
    }

    // Method to display the transaction history    
    public void displayHistory() {
        if (!transactionHistory.isEmpty()) {
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("No transaction history.");
        }
    }
}

class Transaction {
    // Private variables to store transaction amount and type (withdrawal or deposit)
    private float amount;
    private boolean isWithdrawal;

    // Constructor to initialize transaction with amount and type
    public Transaction(float amount, boolean isWithdrawal) {
        this.amount = amount;
        this.isWithdrawal = isWithdrawal;
    }

    // Override toString method to provide a string representation of the transaction
    @Override
    public String toString() {
        if(isWithdrawal) {
            return "Withdrawal: -$" + amount;
        } else {
            return "Deposit: $" + amount;
        }
    }
}

class ATM {
    // Private variable to store the associated account
    private Account account;

    // Constructor to initialize ATM with an account
    public ATM(Account account) {
        this.account = account;
    }

    // Method to display the ATM interface
    public void display() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter PIN: ");
        int userPIN = sc.nextInt();

        if (account.checkPin(userPIN)) {
            System.out.println("\t\t\t\tATM Interface");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showOptions(sc);
        } else {
            System.out.println("Invalid PIN");
        }
    }

    // Private method to show the ATM options to the user
    private void showOptions(Scanner sc) {
        while (true) {
            System.out.println("\n  \t \t \t \t  Choices");
            System.out.println("\nWithdrawal: Press '1' \t\tDeposit: '2' \t\tCheck Balance: '3'");
            System.out.println("Transaction History: Press '4' \tExit: Press '0'");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("\nYour Choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter Amount: ");
                    float withdrawal = sc.nextFloat();
                    account.withdraw(withdrawal);
                    break;
                case 2:
                    System.out.println("Deposit Amount: ");
                    float depositAmount = sc.nextFloat();
                    account.deposite(depositAmount);
                    break;
                case 3:
                    System.out.println("Your Current Balance is "+ account.getBalance());
                    break;
                case 4:
                    System.out.println("Transaction History\n");
                    account.displayHistory();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Please Enter Again.");
            }
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPIN should be of 4-digit.");
        System.out.println("Generate ATM Pin");
        int pin = sc.nextInt();

        // Declare and Initialize the object of Account Class
        Account acc = new Account(pin);
        // Declare and Initialize the object of ATM Class with passing the object of Account Class as a parameter
        ATM atm = new ATM(acc);
        // call method from ATM class to perform operations on Account Object
        atm.display();
        sc.close();
    }
}

