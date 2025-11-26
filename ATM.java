// Note: This class is simplified and handles the exceptions from BankAccount
// by catching them and printing the error message using println.

import java.text.DecimalFormat;

public class ATM {

    private BankAccount currentAccount;
    private final DecimalFormat currencyFormat = new DecimalFormat("Rs. #,##0.00");

    public ATM(BankAccount account) {
        this.currentAccount = account;
        System.out.println("Welcome to the ATM Simulation for Account: " + currentAccount.getAccountNumber() + "\n");
    }

    public void checkBalance() {
        System.out.println("\n💰 Current Balance: " + format(currentAccount.getBalance()));
    }

    public void deposit(double amount) {
        try {
            double newBalance = currentAccount.deposit(amount);
            System.out.println("✅ Deposit successful! Amount: " + format(amount) + " | New balance: " + format(newBalance));
        } catch (IllegalArgumentException e) {
            // Printing the exception message using System.out.println
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            double newBalance = currentAccount.withdraw(amount);
            System.out.println("✅ Withdrawal successful! Amount: " + format(amount) + " | New balance: " + format(newBalance));
        } catch (IllegalArgumentException e) {
            // Printing the exception message using System.out.println
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            // Printing the exception message using System.out.println
            System.out.println(e.getMessage());
        }
    }

    private String format(double amount) {
        return currencyFormat.format(amount);
    }
}
