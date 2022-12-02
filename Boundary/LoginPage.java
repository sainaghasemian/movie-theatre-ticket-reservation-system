// Sam
// package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends Page{

    private static JFrame frame;
    private static JTextField userField;
    private static JPasswordField passField;
  
    public static void display(){
      
        EventQueue.invokeLater(() -> {
            // Create the frame.
            frame = new JFrame("Login Page");
            // Set the dimensions.
            frame.setSize(500, 500);
            // Exit the program when the window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Grab reference to the content pane.
            Container pane = frame.getContentPane();

            // Create a text label that reads "Please login", and set its location and dimensions.
            JLabel titleLabel = new JLabel("Please Login");
            titleLabel.setBounds(50, 25, 200, 30);

            // Label for Username field.
            JLabel userLabel = new JLabel("Username");
            userLabel.setBounds(50, 50, 200, 30);

            // Create a new text field object and set its location and dimensions.
            userField = new JTextField();
            userField.setBounds(50, 75, 200, 30);

            // Label for Password field.
            JLabel passLabel = new JLabel("Password");
            passLabel.setBounds(50, 125, 200, 30);

            // Create a new password field object and set its location and dimensions.
            passField = new JPasswordField();
            passField.setBounds(50, 150, 200, 30);

            // Create the submit button and set its location and dimensions.
            JButton submitButton = new JButton("SUBMIT");
            submitButton.setBounds(50, 200, 100, 30);

            // Create the listener object and add it to the submit button.
            LoginListener loginListener = new LoginListener();
            submitButton.addActionListener(loginListener);

            // Add each element to the content pane.
            pane.add(titleLabel);
            pane.add(userLabel);
            pane.add(userField);
            pane.add(passLabel);
            pane.add(passField);
            pane.add(submitButton);
            // Set the layout of the pane to null.
            pane.setLayout(null);
            // Set the frame to visible.
            frame.setVisible(true);
        });

    }
    
    private static boolean validate(String username, String password){

        // Example implementation below.
        /* 
        for(Account acc : DataBaseInterface.getAccounts()){
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
            
            // Grab the username and password from the fields.
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Print for testing.
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            // Check to see if the info matches a registered user.
            if(validate(username, password)){
                // Change the current user in Manager class.

                // Delete and clean up the current frame.
                // frame.dispose();

                // Proceed to home page.
                // Manager.proceed(homePageID);

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