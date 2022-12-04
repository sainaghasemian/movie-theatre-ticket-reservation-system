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
public class PayAccountFeePage extends PaymentStrategy
{
    private static JFrame frame;

    public static void display()
    {
        // MUST be registered user to pay account
        if(Manager.currentAccount != null) 
        {
            EventQueue.invokeLater(() -> {
                // Create the frame.
                frame = new JFrame("Pay Account Fee Page");
                // Set the dimensions.
                frame.setSize(500, 500);
                // Exit the program when the window is closed.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Grab reference to the content pane.
                Container pane = frame.getContentPane();

                JLabel titleLabel = new JLabel("Please Confirm Payment of $20");
                titleLabel.setBounds(50, 25, 200, 30);
                
                JLabel titleLabel2 = new JLabel("Payment for Annual Account Fee");
                titleLabel2.setBounds(50, 50, 210, 30);

                // Label for credit card number on file for registered user
                JLabel userLabel = new JLabel("Card Number On File: " + Manager.currentAccount.getCardNumber());
                userLabel.setBounds(50, 75, 250, 30);
                
                // Create the pay button 
                JButton submitButton = new JButton("PAY WITH CARD ON FILE");
                submitButton.setBounds(50, 200, 280, 30);

                // Create the listener object 
                PayListener payListener = new PayListener();
                submitButton.addActionListener(payListener);

                // Add each element to the content pane.
                pane.add(titleLabel);
                pane.add(titleLabel2);
                pane.add(userLabel);
                pane.add(submitButton);
                // Set the layout of the pane to null
                pane.setLayout(null);
                // Set the frame to visible
                frame.setVisible(true);
            });
        }
    }

    static class PayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {

            try (//Copy of recipt
            PrintWriter out = new PrintWriter("RegisteredUserAccountFee.txt")) {
                out.println("Annual Fee Recipt");
                out.println("Date: " + java.time.LocalDate.now());
                out.println("Amount Paid: $20.00");
                out.println("Card Number Charged: " + Manager.currentAccount.getCardNumber());
                out.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            // Add to db
            String date = java.time.LocalDate.now().toString();
            
            Payment payment = new Payment(Manager.currentAccount.getFName(), Manager.currentAccount.getLName(), Manager.currentAccount.getCardNumber(), 20, date);
            DatabaseInterface.getPayments().add(payment);

            // Proceed to home page.
            frame.dispose();
            HomePage.display();
        }


    }

    
}
