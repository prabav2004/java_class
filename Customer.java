public class Customer {
    private static int accountNumber;
    private String name;
    private double balance;
    private String accountType;
    private String email;
    public Customer(String name, double balance, String accountType, String email) {
      
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void display(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Email: " + email);
    }
}