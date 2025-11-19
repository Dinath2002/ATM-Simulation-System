// Note: This class is simplified and handles the exceptions from BankAccount
// by catching them and printing the error message using println.

public class ATM {
private BankAccount currentAccount;

public ATM(BankAccount account) {
this.currentAccount = account;
System.out.println("Welcome to the ATM Simulation for Account: " + currentAccount.getAccountNumber() + "\n");
}

public void checkBalance() {
System.out.println("\n💰 Current Balance: " + currentAccount.getBalance());
}

public void deposit(double amount) {
try {
currentAccount.deposit(amount);
} catch (IllegalArgumentException e) {
// Printing the exception message using System.out.println
System.out.println(e.getMessage());
}
}

public void withdraw(double amount) {
try {
currentAccount.withdraw(amount);
} catch (IllegalArgumentException e) {
// Printing the exception message using System.out.println
System.out.println(e.getMessage());
} catch (InsufficientFundsException e) {
// Printing the exception message using System.out.println
System.out.println(e.getMessage());
}
}
}