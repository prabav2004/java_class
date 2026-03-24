public class Customer {

    private static int counter = 1000; // static auto-increment

    private int accountNumber;
    private String name;
    private double balance;
    private String accountType;
    private String email;

    // Constructor
    public Customer(String name, double balance, String accountType, String email) {
        this.accountNumber = ++counter; // auto-generate
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
    }

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public void setEmail(String email) { this.email = email; }

    // Display
    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Email: " + email);
        System.out.println("---------------------------");
    }
}