import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

// Setup Account: Initial balance $500.00 
   BankAccount userAccount = new BankAccount("123456", 100000.00);

// Initialize the ATM
ATM atm = new ATM(userAccount);
while (true) {
System.out.println("\n===== ATM Menu =====");
System.out.println("1. Check Balance");
System.out.println("2. Deposit");
System.out.println("3. Withdraw");
System.out.println("4. Exit");
System.out.print("Select an option: ");

try {
int choice = scanner.nextInt();
double amount;

switch (choice) {
case 1:
atm.checkBalance();
break;
case 2:
System.out.print("Enter deposit amount: Rs. ");
amount = scanner.nextDouble();
atm.deposit(amount);
break;
case 3:
System.out.print("Enter withdrawal amount: Rs. ");
amount = scanner.nextDouble();
atm.withdraw(amount);
break;
case 4:
System.out.println("\n👋 Thank you. Goodbye!");
scanner.close();
return;
default:
System.out.println("⚠️ Invalid choice. Please enter 1, 2, 3, or 4.");
}
} catch (InputMismatchException e) {
// Catch non-numeric input for the choice
System.out.println("❌ Invalid input. Please enter a number.");
scanner.next(); // Clear the invalid input
}
}
}
}