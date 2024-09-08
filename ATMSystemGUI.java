package MyProject;//package MyProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSystemGUI extends JFrame implements ActionListener {
    private JTextField amountField, balanceField, pinField;   // here we are make a text field of the project
    private JButton depositButton, withdrawButton, balanceButton, changePINButton; //what are the button you needed i write it here

    private double balance = 100000; // Initial balance   // After that we are fixed the balance as 100000...
    private String correctPIN = "1430"; // Correct PIN  --making the pin as private which is accessed by me only and who i give the data

    public ATMSystemGUI() {    // Making a ATMSystemGUI as a class name
        setTitle(" ⚡ ATM AUTOMATED TELLER MACHINE ---- By Aman Ranjan..💰💰💰💰");    // this is my tile of the project  as top bar
        setSize(4000, 800);           /// by this you can make the size of the atm platform
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // if not the exit

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Amount: "));
        amountField = new JTextField();
        panel.add(amountField);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        panel.add(new JLabel("Balance: "));
        balanceField = new JTextField(String.valueOf(balance));
        balanceField.setEditable(false);
        panel.add(balanceField);

        balanceButton = new JButton("Check Balance $");
        balanceButton.addActionListener(this);
        panel.add(balanceButton);

        panel.add(new JLabel("Enter PIN: "));//JLabel is like a signpost in your GUI - you use it to show text or images to the user.
        pinField = new JTextField();
        panel.add(pinField);

        changePINButton = new JButton("Change PIN");  // writing the for the change pin button to take an action on that
        changePINButton.addActionListener(this);
        panel.add(changePINButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {   // through this we are going to perform the action in this like make realistic
        if (e.getSource() == depositButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                balance += amount;
                updateBalanceField();
                JOptionPane.showMessageDialog(this, "Deposit successful.\nThank you!form SBI💰");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount.\nEnter Valid amount💰");
            }
        } else if (e.getSource() == withdrawButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= balance) {
                    balance -= amount;
                    updateBalanceField();
                    JOptionPane.showMessageDialog(this, "Withdrawal successful.\nYour transition going to be proceed !\nPlease collect Your Receipt");
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient balance.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount.\nEnter the Amount according to the you Balance!.");
            }
        } else if (e.getSource() == balanceButton) {
            JOptionPane.showMessageDialog(this, "Current Balance: $" + balance+"\nThankyou 🏧");
        } else if (e.getSource() == changePINButton) {
            String pin = pinField.getText();
            if (pin.equals(correctPIN)) {
                JOptionPane.showMessageDialog(this, "PIN changed successfully.\nThank you 😊");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect PIN.\nPlease Enter the Valid Pin.");
            }

        }
    }

    private void updateBalanceField() {
        balanceField.setText(String.valueOf(balance));
    }   // through this method we are going to are going to update the value in this ]

    public static void main(String[] args) {

        new ATMSystemGUI();  // through the new keyWord we are calling the ATM class
    }
}

