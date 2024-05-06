package part3;

import javax.swing.*;
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
        globalAccounts = accounts;
        
        sbAllData = new StringBuilder();
        globalAccounts = accounts;
        
        for (Account account : globalAccounts) {
            sbAllData.append("First Name: ").append(account.getFirstName()).append("\n");
            sbAllData.append("Last Name: ").append(account.getLastName()).append("\n");
            sbAllData.append("Account Number: ").append(account.getAccountNum()).append("\n");
            sbAllData.append("Balance: ").append(account.getBalance()).append("\n\n");
        }
        
        showAllData = new JLabel(sbAllData.toString());
        
        showAllButton = new JButton("Show All");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");
        
        showAllData.setBounds(20, 20, 1000, 500);
        showAllButton.setBounds(20, 230, 100, 30);
        depositButton.setBounds(20, 270, 100, 30);
        withdrawButton.setBounds(20, 310, 100, 30);
        transferButton.setBounds(20, 350, 100, 30);

        accDeposit = new JTextField();
        accWithdraw = new JTextField();
        acc1Transfer = new JTextField();
        acc2Transfer = new JTextField();
        depositInput = new JTextField();
        withdrawInput = new JTextField();
        transferAmount = new JTextField();

        accDeposit.setBounds(130, 270, 100, 30);
        accWithdraw.setBounds(130, 310, 100, 30);
        acc1Transfer.setBounds(130, 350, 100, 30);
        acc2Transfer.setBounds(240, 350, 100, 30);
        depositInput.setBounds(240, 270, 100, 30);
        withdrawInput.setBounds(240, 310, 100, 30);
        transferAmount.setBounds(350, 350, 100, 30);

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

        HandlerClass handler = new HandlerClass();
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
    }

    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button clicks
            if (e.getSource() == showAllButton) {
               
            }
            // Add more conditions for other buttons
        }
    }

}