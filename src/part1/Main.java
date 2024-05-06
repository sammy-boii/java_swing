package part1;

public class Main {
	public Account account1;
	public Account account2;
	public Transaction t;
	
    public static void main(String[] args) {
    	
        Account account1 = new Account("Jeffrey", "Ting", 1, 2000);
        Account account2 = new Account("Hiran", "Patel", 2, 1000);
        
        System.out.println("Balance of account1: " + account1.getBalance());
        
        System.out.println("Balance of account2: " + account2.getBalance());
        
        account1.deposit(250);
        
        System.out.println("Balance of account1 after deposit: " + account1.getBalance());

        account2.withdraw(500);

        System.out.println("Balance of account2 after withdrawal: " + account2.getBalance());

        Transaction t = new Transaction();

        t.transfer(account1, account2, 250);

        System.out.println("Balance of account1 after transfer: " + account1.getBalance());

        System.out.println("Balance of account2 after transfer: " + account2.getBalance());
    }
}
