import java.util.*;

public class atm{
    private bank_account account;

    public atm(bank_account account){
        this.account = account;
    }

    public void displayMenu(){
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performAction(int choice){
        Scanner sc=new Scanner(System.in);
        switch(choice){
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter the amount to be  deposit: ");
                int Damount = sc.nextInt();
                deposit(Damount);
                break;
            case 3:
                System.out.print("Enter the amount to be withdraw: ");
                int Wamount=sc.nextInt();
                withdraw(Wamount);
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
    }

    public void checkBalance(){
        System.out.println("\nCurrent balance :" + account.getBalance());
    }

    public void deposit(int Damount){
        account.deposit(Damount);
    }

    public void withdraw(int Wamount){
        account.withdraw(Wamount);
    }
}
