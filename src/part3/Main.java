package part3;

import java.util.LinkedList;

import javax.swing.JFrame;

public class Main {
	
	public LinkedList<Account> accounts;
	public LinkedList<String> firstNames;
	public LinkedList<String> lastNames;
	public LinkedList<Integer> accountList;
	public LinkedList<Integer> balanceList;
	
	public String file;
	
	public ReadAccounts readAccounts;
	
	public GUI gui;
	
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
        
        GUI gui = new GUI(accounts);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(820, 600);
        
    }
}
