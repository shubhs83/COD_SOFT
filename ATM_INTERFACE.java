import java.util.Scanner;

class UserBankAccount
{
    private double balance;

    public UserBankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount)
    {
        if (amount > 0) {
            balance += amount;
        }
    }
}

class ATM
{
    private UserBankAccount userAccount;

    public ATM(UserBankAccount userAccount)
    {
        this.userAccount = userAccount;
    }

    public boolean withdraw(double amount)
    {
        if (userAccount.withdraw(amount))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public void deposit(double amount)
    {
        userAccount.deposit(amount);
    }

    public double checkBalance()
    {
        return userAccount.getBalance();
    }
}

public class ATM_INTERFACE
{
    public static void main(String[] args)
    {
        UserBankAccount userAccount = new UserBankAccount(100000.0); // Initial balance of 100000.0
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Options:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (atm.withdraw(withdrawAmount))
                    {
                        System.out.println("Withdrawal successful. New balance: " + atm.checkBalance());
                    }

                    else
                    {
                        System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + atm.checkBalance());
                    break;

                case 3:
                    System.out.println("Your balance is: " + atm.checkBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}