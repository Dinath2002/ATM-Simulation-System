// Custom exception class for when a user tries to withdraw more than they have

class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {
// Encapsulated data (private)

    private double balance;
    private String accountNumber;

// Constructor
    public BankAccount(String id, double initialBalance) {
        this.accountNumber = id;
        this.balance = initialBalance >= 0 ? initialBalance : 0.0;
    }

// Getter for Balance
    public double getBalance() {
        return balance;
    }

// Deposit Logic (simplified error handling)
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
// Using println for error message as requested
            throw new IllegalArgumentException("❌ Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("✅ Deposit successful! Amount: " + amount);
    }

// Withdraw Logic (simplified error handling)
    public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException {
        if (amount <= 0) {
// Using println for error message as requested
            throw new IllegalArgumentException("❌ Withdrawal amount must be positive.");
        }
        if (amount > balance) {
// Using println for error message as requested
            throw new InsufficientFundsException("❌ Insufficient funds! Current balance: " + balance);
        }

        balance -= amount;
        System.out.println("✅ Withdrawal successful! Amount: " + amount);
    }

// Getter for Account Number
    public String getAccountNumber() {
        return accountNumber;

    }
}
