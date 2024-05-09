package part3;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.util.LinkedList;

public class GUI extends JFrame {
    private Transaction transferObject;
    private StringBuilder sbAllData;
    private LinkedList<Account> globalAccounts;

    private JLabel showAllData;
    private JButton showAllButton, depositButton, withdrawButton, transferButton;
    private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer, depositInput, withdrawInput, transferAmount;

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        setLayout(null);
        
        transferObject = new Transaction();
        
        sbAllData = new StringBuilder();
        globalAccounts = accounts;
        
        sbAllData.append("<html><style>td, th {padding: 5px 40px;} table {padding: 4px;} body {text-align: left; font-size: 11px;}</style><table>");
        
        sbAllData.append("<tr><th>First Name</th><th>Last Name</th><th>Account Number</th><th>Balance</th></tr>");

        for (Account account : globalAccounts) {
            sbAllData.append("<tr>");
            sbAllData.append("<td>").append(account.getFirstName()).append("</td>");
            sbAllData.append("<td>").append(account.getLastName()).append("</td>");
            sbAllData.append("<td>").append(account.getAccountNum()).append("</td>");
            sbAllData.append("<td>").append(account.getBalance()).append("</td>");
            sbAllData.append("</tr>");
        }

        sbAllData.append("</table></html>");

        showAllData = new JLabel(sbAllData.toString());

        
        showAllButton = new JButton("Show All");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");

        accDeposit = new JTextField();
        accWithdraw = new JTextField();
        acc1Transfer = new JTextField();
        acc2Transfer = new JTextField();
        depositInput = new JTextField();
        withdrawInput = new JTextField();
        transferAmount = new JTextField();

        accDeposit.setBounds(70, 20, 140, 35); 
        depositInput.setBounds(217, 20, 140, 35); 
        depositButton.setBounds(585, 20, 140, 35); 

        accWithdraw.setBounds(70, 75, 140, 35); 
        withdrawInput.setBounds(217, 75, 140, 35); 
        withdrawButton.setBounds(585, 75, 140, 35);

        acc1Transfer.setBounds(70, 130, 140, 35); 
        acc2Transfer.setBounds(217, 130, 140, 35); 
        transferAmount.setBounds(365, 130, 140, 35); 
        transferButton.setBounds(585, 130, 140, 35); 

        showAllButton.setBounds(585, 185, 140, 35); 

        showAllData.setBounds(20, 180, 1000, 500);


        add(showAllData);
        
        add(showAllButton);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        
        add(accDeposit);
        add(accWithdraw);
        add(acc1Transfer);
        add(acc2Transfer);
        add(depositInput);
        add(withdrawInput);
        add(transferAmount);

        accDeposit.setHorizontalAlignment(JLabel.CENTER);
        accDeposit.setText("Enter deposit account");


        accWithdraw.setHorizontalAlignment(JLabel.CENTER);
        accWithdraw.setText("Enter withdraw account");

        acc1Transfer.setHorizontalAlignment(JLabel.CENTER);
        acc1Transfer.setText("Enter source account");

        acc2Transfer.setHorizontalAlignment(JLabel.CENTER);
        acc2Transfer.setText("Enter target account");

        depositInput.setHorizontalAlignment(JLabel.CENTER);
        depositInput.setText("Enter deposit amount");

        withdrawInput.setHorizontalAlignment(JLabel.CENTER);
        withdrawInput.setText("Enter withdraw amount");

        transferAmount.setHorizontalAlignment(JLabel.CENTER);
        transferAmount.setText("Enter transfer amount");

        HandlerClass handler = new HandlerClass();
        
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
    }

    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	try {
        		if (e.getSource() == showAllButton) {
        		    if (showAllData.isVisible()) {
        		        showAllData.setVisible(false); 
        		    } else {

        		        sbAllData.setLength(0); 
        		        sbAllData.append("<html><style>td, th {padding: 5px 40px;} body {text-align: left; font-size: 11px;}</style><table>");
        		        
        		        sbAllData.append("<tr><th>First Name</th><th>Last Name</th><th>Account Number</th><th>Balance</th></tr>");

        		        for (Account account : globalAccounts) {
        		            sbAllData.append("<tr>");
        		            sbAllData.append("<td>").append(account.getFirstName()).append("</td>");
        		            sbAllData.append("<td>").append(account.getLastName()).append("</td>");
        		            sbAllData.append("<td>").append(account.getAccountNum()).append("</td>");
        		            sbAllData.append("<td>").append(account.getBalance()).append("</td>");
        		            sbAllData.append("</tr>");
        		        }

        		        sbAllData.append("</table></html>");
        		        showAllData.setText(sbAllData.toString());
        		        showAllData.setVisible(true); 
        		       
        		        repaint();
        		    }
        		}


        	  else if (e.getSource() == depositButton) {
        		  
        		  Account foundAccount = null;
        		  
        		  for (Account account : globalAccounts) {
        			    if (account.getAccountNum() == Integer.parseInt(accDeposit.getText())) {
        			        foundAccount = account;
        			        break; 
        			    }
        		  }
        			    
        			    if (foundAccount != null) { 	
        			    	int amount = Integer.parseInt(depositInput.getText());
        			    	
        			    	if (amount < 0) {
        			    		JOptionPane.showMessageDialog(null, "Invalid amount.");
        			    		return;
        			    	}

        			    	
        			    	foundAccount.deposit(amount);
        			    	showAllButton.doClick();
        			    	showAllButton.doClick();
        			    	
        			    	JOptionPane.showMessageDialog(null, "Successfully deposited");
        			    }
        			    else {
        			    	JOptionPane.showMessageDialog(null, "No account found");
        			}

        	  }
        	  else if (e.getSource() == withdrawButton) {
        		  Account foundAccount = null;
        		  
        		  for (Account account : globalAccounts) {
        			    if (account.getAccountNum() == Integer.parseInt(accWithdraw.getText())) {
        			        foundAccount = account;
        			        break; 
        			    }
        		  }
        			    
        			    if (foundAccount != null) { 	
        			    	int amount = Integer.parseInt(withdrawInput.getText());
        			    	
        			    	if (amount < 0) {
        			    		JOptionPane.showMessageDialog(null, "Invalid amount.");
        			    		return;
        			    	}
        			    	
        			    	if (foundAccount.getBalance() < amount) {
        			    		JOptionPane.showMessageDialog(null, "Insufficient amount.");
        			    		return;
        			    	}

        			    	
        			    	foundAccount.withdraw(amount);
        			    	showAllButton.doClick();
        			    	showAllButton.doClick();
        			    	
        			    	JOptionPane.showMessageDialog(null, "Successfully withdrawn");
        			    }
        			    else {
        			    	JOptionPane.showMessageDialog(null, "No account found");
        			}
        	  }
        	  
        	  else if (e.getSource() == transferButton) {
        		    Account sourceAccount = null;
        		    Account targetAccount = null;

        		    for (Account account : globalAccounts) {
        		        if (account.getAccountNum() == Integer.parseInt(acc1Transfer.getText())) {
        		            sourceAccount = account;
        		            break;
        		        }
        		    }

        		    for (Account account : globalAccounts) {
        		        if (account.getAccountNum() == Integer.parseInt(acc2Transfer.getText())) {
        		            targetAccount = account;
        		            break;
        		        }
        		    }

        		    if (sourceAccount != null && targetAccount != null) {
        		        int amount = Integer.parseInt(transferAmount.getText());

        		        if (amount < 0) {
        		            JOptionPane.showMessageDialog(null, "Invalid amount.");
        		            return;
        		        }

        		        if (sourceAccount.getBalance() < amount) {
        		            JOptionPane.showMessageDialog(null, "Insufficient balance in source account.");
        		            return;
        		        }

        		        transferObject.transfer(sourceAccount, targetAccount, amount);
        		        showAllButton.doClick();
    			    	showAllButton.doClick();

        		        JOptionPane.showMessageDialog(null, "Successfully transferred.");
        		    } else {
        		        JOptionPane.showMessageDialog(null, "Account not found.");
        		    }
        		    repaint();
        		    revalidate();
        		}

        	}
        	catch (NumberFormatException err) {
        		JOptionPane.showMessageDialog(null, "Invalid input! Please try again.");
        	}
        }
    }
}