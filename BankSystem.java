import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    ArrayList<Customer> customers = new ArrayList<>();

    // Create Account
    public void createAccount(String name, double balance, String accountType, String email) {
        Customer customer = new Customer(name, balance, accountType, email);
        customers.add(customer);

        System.out.println("Account created successfully!");
        System.out.println("Your Account Number is: " + customer.getAccountNumber());
    }

    // Search Customer
    public Customer searchCustomer(int accountNumber) {
        for (Customer c : customers) {
            if (c.getAccountNumber() == accountNumber) {
                return c;
            }
        }
        return null;
    }

    // Deposit
    public void deposit(int accountNumber, double amount) {
        Customer c = searchCustomer(accountNumber);
        if (c != null) {
            c.setBalance(c.getBalance() + amount);
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw
    public void withdraw(int accountNumber, double amount) {
        Customer c = searchCustomer(accountNumber);
        if (c != null) {
            if (c.getBalance() >= amount) {
                c.setBalance(c.getBalance() - amount);
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    // Balance Enquiry
    public void checkBalance(int accountNumber) {
        Customer c = searchCustomer(accountNumber);
        if (c != null) {
            System.out.println("Current Balance: " + c.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    // Transfer
    public void transfer(int fromAcc, int toAcc, double amount) {
        Customer sender = searchCustomer(fromAcc);
        Customer receiver = searchCustomer(toAcc);

        if (sender != null && receiver != null) {
            if (sender.getBalance() >= amount) {
                sender.setBalance(sender.getBalance() - amount);
                receiver.setBalance(receiver.getBalance() + amount);
                System.out.println("Transfer successful!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Invalid account!");
        }
    }

    // Display All
    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }

        for (Customer c : customers) {
            c.display();
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankSystem bankSystem = new BankSystem(); // ✅ created once

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Display Customers");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter account type: ");
                    String accountType = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    bankSystem.createAccount(name, balance, accountType, email);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accDeposit = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double depAmount = sc.nextDouble();

                    bankSystem.deposit(accDeposit, depAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accWithdraw = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double withAmount = sc.nextDouble();

                    bankSystem.withdraw(accWithdraw, withAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int accBalance = sc.nextInt();

                    bankSystem.checkBalance(accBalance);
                    break;

                case 5:
                    System.out.print("Enter sender account number: ");
                    int from = sc.nextInt();

                    System.out.print("Enter receiver account number: ");
                    int to = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                    bankSystem.transfer(from, to, amt);
                    break;

                case 6:
                    bankSystem.displayCustomers();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}