// Sam
package Boundary;

import Control.*;
import Entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends Page {

    private static JFrame frame;
    private static JTextField fnameField;
    private static JTextField lnameField;
    private static JTextField emailField;
    private static JTextField cardField;
    private static JTextField userField;
    private static JPasswordField passField;
 
    public static void display(){

        EventQueue.invokeLater(() -> {
            // Create the frame.
            frame = new JFrame("Register Page");
            // Set frame dimensions.
            frame.setSize(500, 700);
            // Exit the program when the window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Grab a reference to the content pane.
            Container pane = frame.getContentPane();
            pane.setBackground(Color.yellow);
            // Title
            JLabel titleLabel = new JLabel("Please enter your information.");
            titleLabel.setBounds(50, 25, 200, 30);

            // First Name
            JLabel fnameLabel = new JLabel("First Name");
            fnameLabel.setBounds(50, 50, 200, 30);

            fnameField = new JTextField();
            fnameField.setBounds(50, 75, 200, 30);

            // Last Name
            JLabel lnameLabel = new JLabel("Last Name");
            lnameLabel.setBounds(50, 125, 200, 30);

            lnameField = new JTextField();
            lnameField.setBounds(50, 150, 200, 30);
            
            // Email
            JLabel emailLabel = new JLabel("Email");
            emailLabel.setBounds(50, 200, 200, 30);

            emailField = new JTextField();
            emailField.setBounds(50, 225, 200, 30);

            JLabel cardLabel = new JLabel("Credit Card Number");
            cardLabel.setBounds(50, 275, 200, 30);

            cardField = new JTextField();
            cardField.setBounds(50, 300, 200, 30);

            // Username
            JLabel userLabel = new JLabel("Username");
            userLabel.setBounds(50, 350, 200, 30);

            userField = new JTextField();
            userField.setBounds(50, 375, 200, 30);

            // Password
            JLabel passLabel = new JLabel("Password");
            passLabel.setBounds(50, 425, 200, 30);

            passField = new JPasswordField();
            passField.setBounds(50, 450, 200, 30);

            // Submit button
            JButton submitButton = new JButton("SUBMIT");
            submitButton.setBounds(50, 500, 100, 30);

            RegisterListener registerListener = new RegisterListener();
            
            submitButton.addActionListener(registerListener);

            // Add all elements to the content pane.
            pane.add(titleLabel);
            pane.add(fnameLabel);
            pane.add(fnameField);
            pane.add(lnameLabel);
            pane.add(lnameField);
            pane.add(emailLabel);
            pane.add(emailField);
            pane.add(cardLabel);
            pane.add(cardField);
            pane.add(userLabel);
            pane.add(userField);
            pane.add(passLabel);
            pane.add(passField);
            pane.add(submitButton);
            // Set content pane layout to null.
            pane.setLayout(null);
            // Set the frame to visible.
            frame.setVisible(true);
        });
  
    }
    
    private static boolean validateUsername(String username){
        
        
        for(Account acc : DatabaseInterface.getAccounts()){
            if(acc.getUsername().equals(username)){
                return false;
            }
        }
        
        return true;

    }
    
    private static void register(String firstName, String lastName, String email, 
    String cardNum, String username, String password){

        // New Account object.
        Account newAcc = new Account(firstName, lastName, cardNum, username, password, email);

        // Add the new account to the database.
        DatabaseInterface.getAccounts().add(newAcc);

        // Change the current user in Manager.
        Manager.currentAccount = newAcc;
        

    }

    // Nested class for event handling.
    static class RegisterListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            
            // Grab the information from the fields.
            String firstName = fnameField.getText();
            String lastName = lnameField.getText();
            String email = emailField.getText();
            String cardNum = cardField.getText();
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Print for testing.
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Card Number: " + cardNum);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            // Check to see if the username already exists.
            if(validateUsername(username)){
                // Register the user.
                register(firstName, lastName, email, cardNum, username, password);
                // Change the current user in Manager class.

                // Delete and clean up the current frame.
                frame.dispose();

                // Proceed to home page.
                //Manager.proceed(3);
                PaymentPage.setPaymentStrategy("Account");
                PaymentPage.performStrategy(0,0);
                
                // Print for testing.
                System.out.println("Valid!");
            }else{
                System.out.println("Sorry that username is taken.");
            }

        }

    }

    // Main Method for testing.
    public static void main(String[] args){
        RegisterPage.display();
    }
    
}