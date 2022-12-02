// Sam
package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryPage extends Page{
    
    public static void display(){

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Entry Page");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container pane = frame.getContentPane();

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(150, 50, 100, 50);

            JButton registerButton = new JButton("Register");
            registerButton.setBounds(150, 100, 100, 50);

            JButton skipButton = new JButton("Skip");
            skipButton.setBounds(150, 150, 100, 50);

            EntryListener buttonListener = new EntryListener();
            loginButton.addActionListener(buttonListener);
            registerButton.addActionListener(buttonListener);
            skipButton.addActionListener(buttonListener);

            pane.add(loginButton);
            pane.add(registerButton);
            pane.add(skipButton);
            pane.setLayout(null);
            frame.setVisible(true);
        });

    }

    // Nested class for event handling.
    static class EntryListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            // Perform desired operation for each button press.
            if(event.getActionCommand().equals("Login")){
                // Proceed to login page.

                // Print for testing.
                System.out.println("Login Pushed!");
            }else if(event.getActionCommand().equals("Register")){
                // Proceed to register page.

                // Print for testing.
                System.out.println("Register Pushed!");
            }else if(event.getActionCommand().equals("Skip")){
                // Proceed to home page.

                // Print for testing.
                System.out.println("Skip Pushed!");
            }
        }

    }

    
    // Main Method for testing.
    public static void main(String[] args){
        EntryPage.display();
    }
}
