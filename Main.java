
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

// Setup Account: Initial balance $500.00 
            BankAccount userAccount = new BankAccount("123456", 100000.00);

// Initialize the ATM
            ATM atm = new ATM(userAccount);
            while (true) {
                printMenu();
                int choice = readMenuChoice(scanner);
                double amount;

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        amount = readAmount(scanner, "Enter deposit amount: Rs. ");
                        atm.deposit(amount);
                        break;
                    case 3:
                        amount = readAmount(scanner, "Enter withdrawal amount: Rs. ");
                        atm.withdraw(amount);
                        break;
                    case 4:
                        System.out.println("\n👋 Thank you. Goodbye!");
                        return;
                    default:
                        // Should never hit due to validation in readMenuChoice
                        System.out.println("⚠️ Invalid choice. Please enter 1, 2, 3, or 4.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Select an option: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear trailing newline
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                System.out.println("⚠️ Invalid choice. Please enter 1, 2, 3, or 4.");
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static double readAmount(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Clear trailing newline
                if (amount > 0) {
                    return amount;
                }
                System.out.println("⚠️ Amount must be greater than zero.");
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid amount. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
