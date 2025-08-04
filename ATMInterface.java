import java.util.*;12345

class User {
    String userID;
    String pin;
    double balance;
    List<String> transactionHistory = new ArrayList<>();

    User(String userID, String pin, double balance) {
        this.userID = userID;
        this.pin = pin;
        this.balance = balance;
    }
}

class ATMOperations {
    private final User user;

    ATMOperations(User user) {
        this.user = user;
    }

    void viewTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (user.transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : user.transactionHistory) {
                System.out.println(record);
            }
        }
    }

    void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= user.balance) {
            user.balance -= amount;
            user.transactionHistory.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            user.balance += amount;
            user.transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void transfer(Scanner sc) {
        System.out.print("Enter receiver User ID: ");
        String receiverID = sc.next();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= user.balance) {
            user.balance -= amount;
            user.transactionHistory.add("Transferred $" + amount + " to UserID: " + receiverID);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Hardcoded user
        try (Scanner sc = new Scanner(System.in)) {
            // Hardcoded user
            User user = new User("12345", "0000", 1000.0);
            
            System.out.println("----- Welcome to ATM Interface -----");
            
            // Login
            System.out.print("Enter User ID: ");
            String inputID = sc.nextLine();
            System.out.print("Enter PIN: ");
            String inputPIN = sc.nextLine();
            
            if (user.userID.equals(inputID) && user.pin.equals(inputPIN)) {
                ATMOperations atm = new ATMOperations(user);
                int option;
                do {
                    System.out.println("\n---- ATM Menu ----");
                    System.out.println("1. Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    System.out.print("Choose option: ");
                    option = sc.nextInt();
                    
                    switch (option) {
                        case 1 -> atm.viewTransactionHistory();
                        case 2 -> atm.withdraw(sc);
                        case 3 -> atm.deposit(sc);
                        case 4 -> atm.transfer(sc);
                        case 5 -> System.out.println("Thank you for using ATM!");
                        default -> System.out.println("Invalid option.");
                    }
                } while (option != 5);
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }
}
