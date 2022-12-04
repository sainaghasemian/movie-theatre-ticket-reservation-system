//saina
package Boundary;
import Control.*;
import Entity.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PayTicketPage extends PaymentStrategy
{
    private static JFrame frame;
    private static JTextField userField;
    private static JTextField fnameField;
    private static JTextField lnameField;
    private static int currentSeatID;
    private static int currentSeatNumber;
    private static int ticketID = DatabaseInterface.getTickets().size();

    public static void display(int seatID, int seatNumber)
    {
        currentSeatID = seatID;
        currentSeatNumber = seatNumber;
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
                PayListenerU payListener = new PayListenerU();
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
        else if(Manager.currentAccount != null) //If resgistered user
        {
            EventQueue.invokeLater(() -> {
                // Create the frame.
                frame = new JFrame("Registered User Pay Ticket Page");
                // Set the dimensions.
                frame.setSize(500, 500);
                // Exit the program when the window is closed.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Grab reference to the content pane.
                Container pane = frame.getContentPane();

                JLabel titleLabelc = new JLabel("Please Confirm Payment of $15");
                titleLabelc.setBounds(50, 25, 200, 30);

                // Label for credit card number on file for registered user
                JLabel userLabel = new JLabel("Card Number On File: " + Manager.currentAccount.getCardNumber());
                userLabel.setBounds(50, 50, 250, 30);
                
                // Create the pay button 
                JButton submitButton = new JButton("PAY WITH CARD ON FILE");
                submitButton.setBounds(50, 200, 280, 30);

                // Create the listener object 
                PayListenerR payListenerR = new PayListenerR();
                submitButton.addActionListener(payListenerR);

                // Add each element to the content pane.
                pane.add(titleLabelc);
                pane.add(userLabel);
                pane.add(submitButton);
                // Set the layout of the pane to null
                pane.setLayout(null);
                // Set the frame to visible
                frame.setVisible(true);
            });
        }
    }

    //Listener for PAY button - unregistered users
    static class PayListenerU implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            
            // Grab the first name, last name, and card number of unregistered user
            String fName = fnameField.getText();
            String lName = lnameField.getText();
            String cardNumber = userField.getText();

            try (//Copy of recipt
            PrintWriter out = new PrintWriter("UnregisteredUserRecipt.txt")) {
                out.println("Movie Ticket Recipt");
                out.println("Date: " + java.time.LocalDate.now());
                out.println("Amount Paid: $15.00");
                out.println("Card Number Charged: " + cardNumber);
                out.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            

            Ticket ticket = new Ticket(ticketID++, currentSeatID);
            DatabaseInterface.getTickets().add(ticket);

            String theatreName = "";
            String movieName = "";
            String showtimeTime = "";

            int showtimeID = -1;
            Showtime currentShowtime = null;

            for(Seat seat : DatabaseInterface.getSeats())
            {
                if(seat.getSeatID() == ticket.getSeatID())
                {
                    showtimeID = seat.getShowtimeID();
                }
            }

            for(Showtime showtime : DatabaseInterface.getShowtimes())
            {
                if(showtime.getShowtimeID() == showtimeID)
                {
                    showtimeTime = showtime.getTime();
                    currentShowtime = showtime;
                }
            }

            for(Movie movie : DatabaseInterface.getMovies())
            {
                if(currentShowtime.getMovieID() == movie.getMovieID())
                {
                    movieName = movie.getName();
                }
            }

            for(Theatre theatre : DatabaseInterface.getTheatres())
            {
                if(currentShowtime.getTheatreID() == theatre.getTheatreID())
                {
                    theatreName = theatre.getName();
                }
            }


            try (//Copy of ticket
            PrintWriter out2 = new PrintWriter("UnregisteredUserTicket.txt")) {
                out2.println("Movie Ticket Info"); 
                out2.println("Theatre: " + theatreName);
                out2.println("Movie: " + movieName);
                out2.println("Showtime: " + showtimeTime);
                out2.println("Ticket ID: " + ticket.getTicketID());
                out2.println("Seat Number: " + currentSeatNumber);
                out2.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            for(Seat seat : DatabaseInterface.getSeats())
            {
                if(seat.getSeatID() == ticket.getSeatID())
                {
                    seat.setVacant(0);
                }
            }

            // Add to db
            String date = java.time.LocalDate.now().toString();
            Payment payment = new Payment(fName, lName, cardNumber, 15, date);
            DatabaseInterface.getPayments().add(payment);

            // Proceed to home page.
            frame.dispose();
            HomePage.display();
        }

    }

    //Listener for PAY WITH CARD ON FILE - registered user
    static class PayListenerR implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {

            try (//Copy of recipt
            PrintWriter out = new PrintWriter("RegisteredUserRecipt.txt")) {
                out.println("Movie Ticket Recipt");
                out.println("Date: " + java.time.LocalDate.now());
                out.println("Amount Paid: $15.00");
                out.println("Card Number Charged: " + Manager.currentAccount.getCardNumber());
                out.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            Ticket ticket = new Ticket(ticketID++, currentSeatID);
            DatabaseInterface.getTickets().add(ticket);

            String theatreName = "";
            String movieName = "";
            String showtimeTime = "";

            int showtimeID = -1;
            Showtime currentShowtime = null;

            for(Seat seat : DatabaseInterface.getSeats())
            {
                if(seat.getSeatID() == ticket.getSeatID())
                {
                    showtimeID = seat.getShowtimeID();
                }
            }

            for(Showtime showtime : DatabaseInterface.getShowtimes())
            {
                if(showtime.getShowtimeID() == showtimeID)
                {
                    showtimeTime = showtime.getTime();
                    currentShowtime = showtime;
                }
            }

            for(Movie movie : DatabaseInterface.getMovies())
            {
                if(currentShowtime.getMovieID() == movie.getMovieID())
                {
                    movieName = movie.getName();
                }
            }

            for(Theatre theatre : DatabaseInterface.getTheatres())
            {
                if(currentShowtime.getTheatreID() == theatre.getTheatreID())
                {
                    theatreName = theatre.getName();
                }
            }


            try (//Copy of ticket
            PrintWriter out2 = new PrintWriter("RegisteredUserTicket.txt")) {
                out2.println("Movie Ticket Info"); 
                out2.println("Theater: " + theatreName);
                out2.println("Movie: " + movieName);
                out2.println("Showtime: " + showtimeTime);
                out2.println("Ticket ID: "+ ticket.getTicketID());
                out2.println("Seat Number: " + currentSeatNumber);
                out2.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            for(Seat seat : DatabaseInterface.getSeats())
            {
                if(seat.getSeatID() == ticket.getSeatID())
                {
                    seat.setVacant(0);
                }
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