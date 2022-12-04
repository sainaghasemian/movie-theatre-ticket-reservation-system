//isaiah

package Boundary;

import javax.swing.*;

import Control.Manager;
import Entity.*;

import java.awt.*;
import java.awt.event.*;

public class DisplayTicketPage extends Page 
{

    private static JFrame frame;
    private static JTextField ticketField;

    public static void display()
    {
       EventQueue.invokeLater(() -> {
            // Create the frame.
            frame = new JFrame("Cancel Ticket Page");
            // Set the dimensions.
            frame.setSize(500, 500);
            // Exit the program when the window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Grab reference to the content pane.
            Container pane = frame.getContentPane();

            JLabel titleLabel = new JLabel("Please Enter Ticket ID");
            titleLabel.setBounds(50, 25, 200, 30);

            // Label for ticket ID field
            JLabel ticketLabel = new JLabel("Ticket ID");
            ticketLabel.setBounds(50, 50, 200, 30);

            // Create a new text field object and set its location and dimensions.
            ticketField = new JTextField();
            ticketField.setBounds(50, 75, 200, 30);

            // Create the cancel button and set its location and dimensions.
            JButton cancelButton = new JButton("CANCEL");
            cancelButton.setBounds(50, 200, 100, 30);

            DisplayTicketListener displayTicketListener = new DisplayTicketListener();
            cancelButton.addActionListener(displayTicketListener);

            // Add each element to the content pane.
            pane.add(titleLabel);
            pane.add(ticketLabel);
            pane.add(ticketField);
            pane.add(cancelButton);
            // Set the layout of the pane to null.
            pane.setLayout(null);
            // Set the frame to visible.
            frame.setVisible(true);
        });
    }

    // Nested class for event handling.
    static class DisplayTicketListener implements ActionListener
    {

        // Overrided interface function.
        // Functionality for when a button press is detected.
        public void actionPerformed(ActionEvent event)
        {
            // Perform desired operation for each button press.
            if(event.getActionCommand().equals("CANCEL"))
            {
                String ticketID = ticketField.getText();
                if(validate(ticketID))
                {
                    // Delete and clean up the current frame.
                    frame.dispose();
                    if(Manager.currentAccount == null) //If user is not registered
                    {
                        PaymentPage.setPaymentStrategy("Cancel");
                        PaymentPage.performStrategy(0,0);
                    }
                    else //If user is registered
                    {
                        System.out.print("\n Your ticket with ID: " + ticketID + " has been cancelled.");
                        HomePage.display();
                    }

                }
            }
        }
    }

    //Remove ticket from databaseInterface and make associated seat vacant
    private static boolean validate(String ticketID)
    {
        for(Ticket ticket : DatabaseInterface.getTickets())
        {
            if (ticketID.equals(Integer.toString(ticket.getTicketID())))
            {
                DatabaseInterface.getTickets().remove(ticket);
                for(Seat seat : DatabaseInterface.getSeats())
                {
                    if(seat.getSeatID() == ticket.getSeatID())
                    {
                        seat.setVacant(1);
                    }
                }
                return true;
            }
        }

        //If ticket is not found, stay on display ticket page
        System.out.print("\n Please enter a valid ticket ID");

        return false;
    }
}
