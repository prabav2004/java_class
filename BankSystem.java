import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    ArrayList<Customer> customers = new ArrayList<>();

    public  void createAccount(int accountNumber,String name, double balance,String accountType,String email){
        Customer customer = new Customer(accountNumber, name, balance, accountType, email);
        customers.add(customer);
        System.out.println("Account created successfully....");
    }

    public Customer searchCustomer(int accountNumber){
        for(Customer c : customers){
            if(c.getAccountNumber() == accountNumber){
                return c;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount){
        Customer c = searchCustomer(accountNumber);
        if(c!=null){
            c.setBalance(c.getBalance()+amount);
            System.out.println("Amount deposited..");
        }
        else{
            System.out.println("Account not found...");
        }
    }

    public void withdraw(int accountNumber, double amount){
        Customer c = searchCustomer(accountNumber);
        if(c!=null){
            if(c.getBalance()>=amount){
                c.setBalance(c.getBalance()-amount);
                System.out.println("Amount withdrawn...");
            }
            else{
                System.out.println("Low balance...");
            }
        }
        else{
            System.out.println("Account not found...");
        }
    }
    public void checkBalance(int accountNumber){
        Customer c = searchCustomer(accountNumber);
        if(c!=null){
            System.out.println(c.getBalance());
        }
        else{
            System.out.println("Account not found...");
        }
    }
    public void transfer(int fromAccount, int toAccount, double amount){
        Customer sender = searchCustomer(fromAccount);
        Customer receiver = searchCustomer(toAccount);
        if(sender!=null && receiver!=null){
            if(sender.getBalance()>=amount){
                sender.setBalance(sender.getBalance()-amount);
                receiver.setBalance(receiver.getBalance()+amount);
                System.out.println("Amount transferred...");
            }
            else{
                System.out.println("Low balance...");
            }
        }
        else{
            System.out.println("Account not found...");
        }
    }
    public void displayCustomers(){
        for(Customer c : customers){
            
            c.display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();
        while(true){
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Display Customers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("Enter account type: ");
                    String accountType = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    
                    bankSystem.createAccount(accountNumber, name, balance, accountType, email);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int accNumDeposit = sc.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double amountDeposit = sc.nextDouble();
                    bankSystem.deposit(accNumDeposit, amountDeposit);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int accNumWithdraw = sc.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double amountWithdraw = sc.nextDouble();
                    bankSystem.withdraw(accNumWithdraw, amountWithdraw);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int accNumBalance = sc.nextInt();
                    bankSystem.checkBalance(accNumBalance);
                    break;
                case 5:
                    System.out.print("Enter sender's account number: ");
                    int fromAccount = sc.nextInt();
                    System.out.print("Enter receiver's account number: ");
                    int toAccount = sc.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double amountTransfer = sc.nextDouble();
                    bankSystem.transfer(fromAccount, toAccount, amountTransfer);
                    break;
                case 6:
                    bankSystem.displayCustomers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
           
        }
         
    }

}
