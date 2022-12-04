//saina
package Boundary;
import Control.*;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PayCancellationFeePage extends PaymentStrategy
{
    private static JFrame frame;
    private static JTextField userField;
    private static JTextField fnameField;
    private static JTextField lnameField;

    public static void display()
    {
        // To pay cancellation fee must not be registered
        if(Manager.currentAccount == null)
        {
            EventQueue.invokeLater(() -> {
                // Create the frame.
                frame = new JFrame("Pay Cancellation Fee Page");
                // Set the dimensions.
                frame.setSize(500, 500);
                // Exit the program when the window is closed.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Grab reference to the content pane.
                Container pane = frame.getContentPane();

                JLabel titleLabel = new JLabel("Please Confirm Payment of $2.25");
                titleLabel.setBounds(50, 25, 200, 30);
                
                JLabel titleLabel2 = new JLabel("Payment for Cancellation Fee");
                titleLabel2.setBounds(50, 25, 210, 30);

                // Label for first name field
                JLabel userLabelf = new JLabel("First Name");
                userLabelf.setBounds(50, 50, 200, 30);

                // Create a new text field object and set its location and dimensions
                fnameField = new JTextField();
                fnameField.setBounds(50, 75, 200, 30);

                // Label for last name field
                JLabel userLabell = new JLabel("Last Name");
                userLabell.setBounds(50, 100, 200, 30);

                // Create a new text field object and set its location and dimensions
                lnameField = new JTextField();
                lnameField.setBounds(50, 125, 200, 30);

    
                // Label for credit card number field
                JLabel userLabel = new JLabel("Card Number");
                userLabel.setBounds(50, 150, 200, 30);


                // Create a new text field object and set its location and dimensions
                userField = new JTextField();
                userField.setBounds(50, 175, 200, 30);
    
                // Create the pay button
                JButton submitButton = new JButton("PAY");
                submitButton.setBounds(50, 250, 100, 30);

                // Create the listener object and add it to the submit button.
                PayListener payListener = new PayListener();
                submitButton.addActionListener(payListener);

    
                // Add each element to the content 
                pane.add(titleLabel);
                pane.add(userLabelf);
                pane.add(fnameField);
                pane.add(userLabell);
                pane.add(lnameField);
                pane.add(userLabel);
                pane.add(userField);
                pane.add(submitButton);
                // Set the layout of the pane to null.
                pane.setLayout(null);
                // Set the frame to visible.
                frame.setVisible(true);

            });
        }
    }

    static class PayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {

            try (//Copy of recipt
            PrintWriter out = new PrintWriter("PayCancelFee.txt")) {
                out.println("Cancellation Fee Recipt");
                out.println("Date: " + java.time.LocalDate.now());
                out.println("Amount Paid: $2.50");
                out.println("Card Number Charged: " + Manager.currentAccount.getCardNumber());
                out.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            // Add to db
            String date = java.time.LocalDate.now().toString();
            
            Payment payment = new Payment(Manager.currentAccount.getFName(), Manager.currentAccount.getLName(), Manager.currentAccount.getCardNumber(), 15, date);
            DatabaseInterface.getPayments().add(payment);

            // Proceed to home page.
            frame.dispose();
            HomePage.display();
        }


    }

    
}
