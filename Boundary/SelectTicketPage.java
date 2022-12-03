//isaiah

package Boundary;

import javax.swing.*;

import Entity.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SelectTicketPage extends Page{

    private static Container pane;
    private static JFrame frame;
    private static TicketListener ticketListener;
    private static int currentTheatre;
    private static int currentShowtime;
    private static int currentMovie;
    private static int currentSeat;

    // public SelectTicketPage(){

    // }

    public static void display()
    {
        frame = new JFrame("Select Movie Ticket Page");
        frame.setSize(1250, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = frame.getContentPane();

        ticketListener = new TicketListener();

        JLabel theatreLabel = new JLabel("Please select a theatre.");
        theatreLabel.setBounds(50, 25, 175, 30);

        ArrayList<JButton> theatreButtons = new ArrayList<JButton>();
        ArrayList<Theatre> theatres = DatabaseInterface.getTheatres();
        int y = 65;

        for (int i = 0; i < theatres.size(); i++){
            theatreButtons.add(new JButton(theatres.get(i).getName()));
            theatreButtons.get(i).setBounds(50, y, 100, 50);
            theatreButtons.get(i).addActionListener(ticketListener);
            pane.add(theatreButtons.get(i));
            y += 60;
        }

        pane.add(theatreLabel);
        pane.setLayout(null);
        frame.setVisible(true);
    }

    public static void displayMovies(int theatreID){
        JLabel movieLabel = new JLabel("Please select a movie.");
        movieLabel.setBounds(225, 25, 175, 30);

        ArrayList<JButton> movieButtons = new ArrayList<JButton>();
        ArrayList<Integer> moviesAdded = new ArrayList<Integer>();
        ArrayList<Movie> movies = DatabaseInterface.getMovies();
        ArrayList<Showtime> showtimes = DatabaseInterface.getShowtimes();

        int y = 65;
        int m = 0;

        for (int i = 0; i < showtimes.size(); i++){
            if (showtimes.get(i).getTheatreID() == theatreID && !(moviesAdded.contains(showtimes.get(i).getMovieID()))){
                moviesAdded.add(showtimes.get(i).getMovieID());
                for (int j = 0; j < movies.size(); j++){
                    if(movies.get(j).getMovieID() == showtimes.get(i).getMovieID()){
                        movieButtons.add(new JButton(movies.get(j).getName()));
                        movieButtons.get(m).setBounds(225, y, 100, 50);
                        movieButtons.get(m).addActionListener(ticketListener);
                        pane.add(movieButtons.get(m));
                        m++;
                        y += 60;
                    }
                }
                
            }
        }

        pane.add(movieLabel);
        frame.repaint();
    }

    public static void displayShowtimes(int movieID){
        JLabel showtimeLabel = new JLabel("Please select a showtime. (YYYY-MM-DD)");
        showtimeLabel.setBounds(400, 25, 275, 30);

        ArrayList<JButton> showtimeButtons = new ArrayList<JButton>();
        ArrayList<Showtime> showtimes = DatabaseInterface.getShowtimes();
        int y = 65;
        int s = 0;

        for (int i = 0; i < showtimes.size(); i++){
            if (showtimes.get(i).getMovieID() == movieID && showtimes.get(i).getTheatreID() == currentTheatre){
                showtimeButtons.add(new JButton(showtimes.get(i).getTime()));
                showtimeButtons.get(s).setBounds(400, y, 175, 50);
                showtimeButtons.get(s).addActionListener(ticketListener);
                pane.add(showtimeButtons.get(s));
                s++;
                y += 60;
            }
        }

        pane.add(showtimeLabel);
        frame.repaint();
    }

    public static void displaySeats(int showtimeID){
        JLabel seatLabel = new JLabel("Please select a seat. Green seats are available. Red seats are unavailable.");
        seatLabel.setBounds(700, 25, 500, 30);

        JLabel screen = new JLabel("S C R E E N", SwingConstants.CENTER);
        screen.setBounds(700, 65, 500, 30);
        screen.setOpaque(true);
        screen.setBackground(Color.black);
        screen.setForeground(Color.white);

        ArrayList<JButton> seatButtons = new ArrayList<JButton>();
        ArrayList<Seat> seats = DatabaseInterface.getSeats();

        int row = 0;
        int col = 0;
        int seatNum = 1;

        for (int i = 0; i < seats.size(); i++){
            if (seats.get(i).getShowtimeID() == showtimeID){
                if (col + 1 == 10){
                    col = 0;
                    row++;
                }
                else 
                    col++;
                seatButtons.add(new JButton(Integer.toString(seatNum)));
                seatButtons.get(seatNum - 1).setBounds((700 + (43 * col)), (105 + (60 * row)), 40, 40);
                seatButtons.get(seatNum - 1).setOpaque(true);
                if (seats.get(i).getVacant() == 1){
                    seatButtons.get(seatNum - 1).setBackground(Color.green);
                    seatButtons.get(seatNum - 1).addActionListener(ticketListener);
                }
                else
                    seatButtons.get(seatNum - 1).setBackground(Color.red);
                pane.add(seatButtons.get(seatNum - 1));
                seatNum++;
            }
        }

        pane.add(seatLabel);
        pane.add(screen);
        frame.repaint();
    }

    public static void displaySubmit(int seatNum){
        JLabel submitLabel = new JLabel("Seat Selected: " + seatNum, SwingConstants.CENTER);
        submitLabel.setBounds(550, 510, 150, 30);

        JButton payButton = new JButton("Pay for Ticket");
        payButton.setBounds(550, 550, 150, 50);
        payButton.setOpaque(true);
        payButton.setBackground(Color.blue);
        payButton.setForeground(Color.black);
        payButton.addActionListener(ticketListener);

        pane.add(submitLabel);
        pane.add(payButton);
        frame.repaint();
    }

    static class TicketListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            // Perform desired operation for each button press.
            ArrayList<Theatre> theatres = DatabaseInterface.getTheatres();
            ArrayList<Showtime> showtimes = DatabaseInterface.getShowtimes();
            ArrayList<Movie> movies = DatabaseInterface.getMovies();
            ArrayList<Seat> seats = DatabaseInterface.getSeats();

            if (event.getActionCommand().equals("Pay for Ticket")){
                frame.dispose();
                PaymentPage.setPaymentStrategy("Ticket");
                PaymentPage.performStrategy(currentSeat);
            }

            int i;

            for (i = 0; i < theatres.size(); i++){
                if (event.getActionCommand().equals(theatres.get(i).getName())){
                    currentTheatre = theatres.get(i).getTheatreID();
                    displayMovies(currentTheatre);
                }
            }

            for (i = 0; i < movies.size(); i++){
                if (event.getActionCommand().equals(movies.get(i).getName())){
                    currentMovie = movies.get(i).getMovieID();
                    displayShowtimes(currentMovie);
                }
            }

            for (i = 0; i < showtimes.size(); i++){
                if (event.getActionCommand().equals(showtimes.get(i).getTime()) && showtimes.get(i).getMovieID() == currentMovie){
                    currentShowtime = showtimes.get(i).getShowtimeID();
                    displaySeats(currentShowtime);
                }
            }

            if (event.getActionCommand().length() <= 2){
                int seatNumber;
                for (seatNumber = 0; !(String.valueOf(seatNumber).equals(event.getActionCommand())); seatNumber++){}
                
                int seatCounter = 0;
                for (i = 0; i < seats.size(); i++){
                    if (seats.get(i).getShowtimeID() == currentShowtime){
                        if (++seatCounter == seatNumber){
                            currentSeat = seats.get(i).getSeatID();
                            displaySubmit(seatNumber);
                        }
                    }
                }
            }
        }
    }

    

    public static void main(String[] args){
        DatabaseInterface db = DatabaseInterface.getOnlyInstance();
        // SelectTicketPage page = new SelectTicketPage();
        display();
    }
}