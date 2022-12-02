// Sam
package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage /* implements Page */{

    private static JTextField userField;
    private static JPasswordField passField;
  
    public static void display(){
      
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Login Page");
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container pane = frame.getContentPane();

            JLabel titleLabel = new JLabel("Please Login");
            titleLabel.setBounds(50, 25, 200, 30);

            JLabel userLabel = new JLabel("Username");
            userLabel.setBounds(50, 50, 200, 30);

            userField = new JTextField();
            userField.setBounds(50, 75, 200, 30);

            JLabel passLabel = new JLabel("Password");
            passLabel.setBounds(50, 125, 200, 30);

            passField = new JPasswordField();
            passField.setBounds(50, 150, 200, 30);

            JButton submitButton = new JButton("SUBMIT");
            submitButton.setBounds(50, 200, 100, 30);

            LoginListener loginListener = new LoginListener();
            
            submitButton.addActionListener(loginListener);

            pane.add(titleLabel);
            pane.add(userLabel);
            pane.add(userField);
            pane.add(passLabel);
            pane.add(passField);
            pane.add(submitButton);
            pane.setLayout(null);
            frame.setVisible(true);
        });

    }
    
    private static boolean validate(String username, String password){

        // Example implementation below.
        /* 
        for(Account acc : DataBaseInterface){
            if(acc.getUsername().equals(username) && acc.getPassword.equals(password)){
                return true;
            }
        }
        */
        
        return false;
    }

    // Nested class for event handling.
    static class LoginListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            
            // Grab the usernmae and password from the fields.
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Print for testing.
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            // Check to see if the info matches a registered user.
            if(validate(username, password)){
                // Change the current user in Manager class.

                // Proceed to home page.

                // Print for testing.
                System.out.println("Valid!");
            }else{
                System.out.println("Please enter a valid Username and Password.");
            }

        }

    }

    
    // Main Method for testing.
    public static void main(String[] args){
        LoginPage.display();
    }
    

}