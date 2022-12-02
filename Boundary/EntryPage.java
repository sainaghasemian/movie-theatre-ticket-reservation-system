// Sam
package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryPage extends Page{

    private static JFrame frame;
    
    public static void display(){

        EventQueue.invokeLater(() -> {
            // Create the frame.
            frame = new JFrame("Entry Page");
            // Set the dimensions.
            frame.setSize(400, 400);
            // Exit the program when the window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Grab reference to the content pane.
            Container pane = frame.getContentPane();

            // Create the 3 buttons and set their starting point and dimensions.
            JButton loginButton = new JButton("Login");
            loginButton.setBounds(150, 50, 100, 50);

            JButton registerButton = new JButton("Register");
            registerButton.setBounds(150, 100, 100, 50);

            JButton skipButton = new JButton("Skip");
            skipButton.setBounds(150, 150, 100, 50);

            // Create the listener object and add it to each button.
            EntryListener buttonListener = new EntryListener();
            loginButton.addActionListener(buttonListener);
            registerButton.addActionListener(buttonListener);
            skipButton.addActionListener(buttonListener);

            // Add each button to the content pane.
            pane.add(loginButton);
            pane.add(registerButton);
            pane.add(skipButton);
            // Set the layout to null.
            pane.setLayout(null);
            // Make the frame visible.
            frame.setVisible(true);
        });

    }

    // Nested class for event handling.
    static class EntryListener implements ActionListener{

        // Overrided interface function.
        // Functionality for when a button press is detected.
        public void actionPerformed(ActionEvent event){
            // Perform desired operation for each button press.
            if(event.getActionCommand().equals("Login")){
                // Delete and clean up the current frame.
                // frame.dispose();

                // Proceed to login page.
                // Manager.proceed(loginPageID);

                // Print for testing.
                System.out.println("Login Pushed!");
            }else if(event.getActionCommand().equals("Register")){
                // Delete and clean up the current frame.
                // frame.dispose();

                // Proceed to register page.
                // Manager.proceed(registerPageID);

                // Print for testing.
                System.out.println("Register Pushed!");
            }else if(event.getActionCommand().equals("Skip")){
                // Delete and clean up the current frame.
                // frame.dispose();

                // Proceed to home page.
                // Manager.proceed(homePageID);

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
