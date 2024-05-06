package part2;

import java.util.LinkedList;

public class Main {
	
	public LinkedList<Account> accounts;
	public LinkedList<String> firstNames;
	public LinkedList<String> lastNames;
	public LinkedList<Integer> accountList;
	public LinkedList<Integer> balanceList;
	
	public String file;
	
	public ReadAccounts readAccounts;
	
	public Transaction t;
	
    public static void main(String[] args) {
        String file = "src/accounts.csv"; 

        LinkedList<Account> accounts = new LinkedList<>();

        ReadAccounts readAccounts = new ReadAccounts(file);

        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();
        
        for (int i = 0; i < firstNames.size(); i++) {
        	accounts.add(new Account(firstNames.get(i), lastNames.get(i), balanceList.get(i), accountList.get(i)));
        }
        
      for (Account account: accounts) {
    	  System.out.println("First Name: " + account.getFirstName());
          System.out.println("Last Name: " + account.getLastName());
          System.out.println("Account Number: " + account.getAccountNum());
          System.out.println("Balance: " + account.getBalance());
          System.out.println();
      }
      
      Transaction t = new Transaction();
      
      Account account1 = accounts.get(0);
      Account account2 = accounts.get(1);
      Account account3 = accounts.get(2);
      Account account4 = accounts.get(3);
      
      System.out.println();
      
      t.transfer(account2, account1, 10);
      t.transfer(account3, account4, -50);
      t.transfer(account2, account3, 100);
      
      
      account1.deposit(-400);
      account1.deposit(99999);
      
      account4.withdraw(-50);
      account4.withdraw(50505);
      
      System.out.println();
      
      System.out.println("Account 1: " + account1.getBalance());
      System.out.println("Account 2: " + account2.getBalance());
      System.out.println("Account 3: " + account3.getBalance());
      System.out.println("Account 4 :" + account4.getBalance());
}
}
