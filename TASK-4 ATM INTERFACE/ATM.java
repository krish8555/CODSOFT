import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && account.getBalance() >= amount) {
            account.withdraw(amount);
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // initial balance
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
