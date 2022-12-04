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
            pane.setBackground(Color.white);
            // Create the 3 buttons and set their starting point and dimensions.
            JButton searchButton = new JButton("Cancel Ticket");
            searchButton.setBounds(125, 50, 150, 50);

            JButton buyButton = new JButton("Buy Ticket");
            buyButton.setBounds(125, 100, 150, 50);

            JButton logoutButton = new JButton("Logout");
            logoutButton.setBounds(150, 150, 100, 50);

            // Create the listener object and add it to each button.
            HomeListener homeListener = new HomeListener();
            searchButton.addActionListener(homeListener);
            buyButton.addActionListener(homeListener);
            logoutButton.addActionListener(homeListener);

            // Add each button to the content pane.
            pane.add(searchButton);
            pane.add(buyButton);
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
            if(event.getActionCommand().equals("Cancel Ticket")){
                // Delete and clean up the current frame.
                frame.dispose();

                // Proceed to Cancel Ticket Page.
                // Manager.proceed(cancelTicketPageID);
                DisplayTicketPage.display();
                
                // Print for testing.
                System.out.println("Cancel Pushed!");
            }else if(event.getActionCommand().equals("Buy Ticket")){
                // Delete and clean up the current frame.
                frame.dispose();

                // Proceed to Select Ticket Page.
                // Manager.proceed(selectTicketPageID);
                SelectTicketPage.display();

                // Print for testing.
                System.out.println("Buy Pushed!");
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