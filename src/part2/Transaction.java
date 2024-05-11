package part2;


public class Transaction {
	public void transfer(Account acc1, Account acc2, int amount) {
		if (acc1.getBalance() < amount) {
			System.out.println("Transaction failed: Insufficient balance.");
			return;
		}
	    	 acc1.withdraw(amount);
	    	 acc2.deposit(amount);
	}
}
