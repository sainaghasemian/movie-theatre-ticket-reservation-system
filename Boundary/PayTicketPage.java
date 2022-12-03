//saina
package Boundary;
import Control.*;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PayTicketPage extends PaymentStrategy
{
    private static JFrame frame;
    private static JTextField userField;
    private static JPasswordField passField;
  
    private static Ticket ticketID;
    private static String cardNumber;
    // public static void display(){
      


    // }

    public static void display(int seatID)
    {
        if(Manager.currentAccount == null) //If user is unregistered
        {
            EventQueue.invokeLater(() -> {
                // Create the frame.
                frame = new JFrame("Pay Ticket Page");
                // Set the dimensions.
                frame.setSize(500, 500);
                // Exit the program when the window is closed.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                // Grab reference to the content pane.
                Container pane = frame.getContentPane();
    
                JLabel titleLabel = new JLabel("Please Pay For Ticket");
                titleLabel.setBounds(50, 25, 200, 30);
    
                // Label for credit card number field
                JLabel userLabel = new JLabel("Card Number");
                userLabel.setBounds(50, 50, 200, 30);
    
                // Create a new text field object and set its location and dimensions.
                userField = new JTextField();
                userField.setBounds(50, 75, 200, 30);
    
                // Create a new password field object and set its location and dimensions.
                passField = new JPasswordField();
                passField.setBounds(50, 150, 200, 30);
    
                // Create the submit button and set its location and dimensions.
                JButton submitButton = new JButton("SUBMIT");
                submitButton.setBounds(50, 200, 100, 30);
    
                // Add each element to the content pane.
                pane.add(titleLabel);
                pane.add(userLabel);
                pane.add(userField);
                pane.add(passField);
                pane.add(submitButton);
                // Set the layout of the pane to null.
                pane.setLayout(null);
                // Set the frame to visible.
                frame.setVisible(true);
            });
        }
        else
        {
            //display page for registered users
        }
    }

    private static boolean validate(String cardNumber)
    {
        for(Account acc : DatabaseInterface.getAccounts())
        {
            if(acc.getCardNumber().equals(cardNumber))
            {
                Manager.currentAccount = acc;
                return true;
            }
        }
        return false;
    }

    // public PayTicketPage(String cardNumber)
    // {
    //     this.cardNumber = cardNumber;


    // }

    public void makeTransaction()
    {
        Payment payment = new Payment(this.cardNumber, this.ticketID);
    }

    public static void main(String[] args){
        PayTicketPage.display(0);
    }
}