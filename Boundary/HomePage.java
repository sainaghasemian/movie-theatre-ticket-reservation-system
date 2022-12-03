// Sam
package Boundary;

import Control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends Page {

    private static JFrame frame;

    public static void display(){

        EventQueue.invokeLater(() -> {
            // Create the frame.
            frame = new JFrame("Home Page");
            // Set the dimensions.
            frame.setSize(400, 400);
            // Exit the program when the window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Grab reference to the content pane.
            Container pane = frame.getContentPane();

            // Create the 3 buttons and set their starting point and dimensions.
            JButton cancelButton = new JButton("Cancel Ticket");
            cancelButton.setBounds(125, 50, 150, 50);

            JButton movieButton = new JButton("Search Movies");
            movieButton.setBounds(125, 100, 150, 50);

            JButton logoutButton = new JButton("Logout");
            logoutButton.setBounds(150, 150, 100, 50);

            // Create the listener object and add it to each button.
            HomeListener homeListener = new HomeListener();
            cancelButton.addActionListener(homeListener);
            movieButton.addActionListener(homeListener);
            logoutButton.addActionListener(homeListener);

            // Add each button to the content pane.
            pane.add(cancelButton);
            pane.add(movieButton);
            pane.add(logoutButton);
            // Set the layout to null.
            pane.setLayout(null);
            // Make the frame visible.
            frame.setVisible(true);
        });

    }

    // Nested class for event handling.
    static class HomeListener implements ActionListener{

        // Overrided interface function.
        // Functionality for when a button press is detected.
        public void actionPerformed(ActionEvent event){
            // Perform desired operation for each button press.
            if(event.getActionCommand().equals("Search Ticket")){
                // Delete and clean up the current frame.
                frame.dispose();

                // Proceed to Cancel Ticket Page.
                // Manager.proceed(cancelTicketPageID);
                
                // Print for testing.
                System.out.println("Cancel Pushed!");
            }else if(event.getActionCommand().equals("Buy Ticket")){
                // Delete and clean up the current frame.
                frame.dispose();

                // Proceed to Select Ticket Page.
                // Manager.proceed(selectTicketPageID);

                // Print for testing.
                System.out.println("Movies Pushed!");
            }else if(event.getActionCommand().equals("Logout")){
                // Change the current user in manager class.
                Manager.currentAccount = null;
                // Delete and clean up the current frame.
                frame.dispose();

                // Proceed to Entry Page.
                // Manager.proceed(entryPageID);
                EntryPage.display();

                // Print for testing.
                System.out.println("Logout Pushed!");
            }
        }

    }

    
    // Main Method for testing.
    public static void main(String[] args){
        HomePage.display();
    }
    
}