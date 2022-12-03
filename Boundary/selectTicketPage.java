//isaiah

package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectTicketPage extends Page{

    private static Container pane;
    private static JFrame frame;
    private static TicketListener ticketListener;

    public SelectTicketPage(){
        frame = new JFrame("Select Movie Ticket Page");
        frame.setSize(2000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = frame.getContentPane();

        ticketListener = new TicketListener();
    }

    public static void display(){
        JLabel theatreLabel = new JLabel("Please select a theatre.");
        theatreLabel.setBounds(50, 25, 175, 30);

        //search database for theatre name first, this will become the name of the button
        JButton theatreButton1 = new JButton("Theatre 1");
        theatreButton1.setBounds(50, 65, 100, 50);

        theatreButton1.addActionListener(ticketListener);

        pane.add(theatreLabel);
        pane.add(theatreButton1);
        pane.setLayout(null);
        frame.setVisible(true);
    }

    public static void displayMovies(String theatre){
        JLabel movieLabel = new JLabel("Please select a movie.");
        movieLabel.setBounds(250, 25, 175, 30);

        //search database for theatre name first, this will become the name of the button
        JButton movieButton1 = new JButton("Movie 1");
        movieButton1.setBounds(250, 65, 100, 50);

        JButton movieButton2 = new JButton("Movie 2");
        movieButton2.setBounds(250, 125, 100, 50);

        JButton movieButton3 = new JButton("Movie 3");
        movieButton3.setBounds(250, 185, 100, 50);

        movieButton1.addActionListener(ticketListener);
        movieButton2.addActionListener(ticketListener);
        movieButton3.addActionListener(ticketListener);

        pane.add(movieLabel);
        pane.add(movieButton1);
        pane.add(movieButton2);
        pane.add(movieButton3);
        frame.repaint();
    }

    public static void displayShowtimes(String movie){
        JLabel showtimeLabel = new JLabel("Please select a showtime.");
        showtimeLabel.setBounds(450, 25, 175, 30);

        //search database for theatre name first, this will become the name of the button
        JButton  showtimeButton1 = new JButton("Showtime 1");
        showtimeButton1.setBounds(450, 65, 100, 50);

        JButton showtimeButton2 = new JButton("Showtime 2");
        showtimeButton2.setBounds(450, 125, 100, 50);

        JButton showtimeButton3 = new JButton("Showtime 3");
        showtimeButton3.setBounds(450, 185, 100, 50);

        showtimeButton1.addActionListener(ticketListener);
        showtimeButton2.addActionListener(ticketListener);
        showtimeButton3.addActionListener(ticketListener);

        pane.add(showtimeLabel);
        pane.add(showtimeButton1);
        pane.add(showtimeButton2);
        pane.add(showtimeButton3);
        frame.repaint();
    }

    public static void displaySeats(String showtime){
        JLabel seatLabel = new JLabel("Please select a seat. Green seats are available. Red seats are unavailable.");
        seatLabel.setBounds(650, 25, 500, 30);

        // JLabel screen = new JLabel("Screen");
        // screen.setBounds(650, )

        JButton  seat1 = new JButton("1");
        seat1.setBounds(650, 65, 50, 50);
        seat1.setOpaque(true);
        seat1.setBackground(Color.red);

        JButton seat2 = new JButton("2");
        seat2.setBounds(710, 65, 50, 50);
        seat2.setOpaque(true);
        seat2.setBackground(Color.red);

        JButton  seat3 = new JButton("3");
        seat3.setBounds(770, 65, 50, 50);
        seat3.setOpaque(true);
        seat3.setBackground(Color.green);

        JButton  seat4 = new JButton("4");
        seat4.setBounds(650, 125, 50, 50);
        seat4.setOpaque(true);
        seat4.setBackground(Color.green);

        JButton  seat5 = new JButton("5");
        seat5.setBounds(710, 125, 50, 50);
        seat5.setOpaque(true);
        seat5.setBackground(Color.green);

        JButton  seat6 = new JButton("6");
        seat6.setBounds(770, 125, 50, 50);
        seat6.setOpaque(true);
        seat6.setBackground(Color.red);

        seat1.addActionListener(ticketListener);
        seat2.addActionListener(ticketListener);
        seat3.addActionListener(ticketListener);
        seat4.addActionListener(ticketListener);
        seat5.addActionListener(ticketListener);
        seat6.addActionListener(ticketListener);

        pane.add(seatLabel);
        pane.add(seat1);
        pane.add(seat2);
        pane.add(seat3);
        pane.add(seat4);
        pane.add(seat5);
        pane.add(seat6);
        frame.repaint();
    }

    static class TicketListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            // Perform desired operation for each button press.
            if(event.getActionCommand().equals("Theatre 1")){
                displayMovies("Theatre 1");
            }else if(event.getActionCommand().equals("Movie 1")){
                displayShowtimes("Movie 1");
            }else if(event.getActionCommand().equals("Movie 2")){
                displayShowtimes("Movie 2");
            }else if(event.getActionCommand().equals("Movie 3")){
                displayShowtimes("Movie 3");
            }else if(event.getActionCommand().equals("Showtime 1")){
                displaySeats("Showtime 1");
            }else if(event.getActionCommand().equals("Showtime 2")){
                displaySeats("Showtime 2");
            }else if(event.getActionCommand().equals("Showtime 3")){
                displaySeats("Showtime 3");
            }
        }
    }

    // public static void main(String[] args){
    //     SelectTicketPage page = new SelectTicketPage();
    //     display();
    // }
}
