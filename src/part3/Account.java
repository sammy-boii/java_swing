package part3;

public class Account extends Customer {
    private int balance;
    private int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal) {
    	setFirstName(FName);
    	setLastName(LName);
        this.balance = accBal;
        this.accountNumber = accNum;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getAccountNum() {
        return this.accountNumber;
    }

    public void deposit(int amount) {
    	if (amount < 0) {
    		System.out.println("Invalid amount! Please try again.");
    	}
        this.balance += amount;
    }

    public void withdraw(int amount) {
		
	    if (this.getBalance() < amount) {
	    	System.out.println("Transaction failed: Insufficient balance.");
	    	return;
	    } 
	    
	    if (amount < 0) {
	    	System.out.println("Invalid amount! Please try again.");
	    	return;
	    }
	    
        this.balance -= amount;
    }
}
