//isaiah

package Boundary;

import javax.swing.*;

import Entity.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SelectTicketPage extends Page{

    //member variables used for functionality
    private static Container pane;
    private static JFrame frame;
    private static TicketListener ticketListener;
    private static int currentTheatre;
    private static int currentShowtime;
    private static int currentMovie;
    private static int currentSeat;
    private static int currentSeatNumber;

    //display function to display SelectTicketPage frame
    public static void display()
    {
        //add frame label
        frame = new JFrame("Select Movie Ticket Page");
        frame.setSize(1250, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = frame.getContentPane();

        ticketListener = new TicketListener();

        //add column label
        JLabel theatreLabel = new JLabel("Please select a theatre.");
        theatreLabel.setBounds(50, 25, 175, 30);

        //button to reset SelectTicketPage frame
        JButton reselect = new JButton("Re-select");
        reselect.setBounds(50, 550, 100, 50);
        reselect.addActionListener(ticketListener);

        //arraylist of buttons for all theatres in database
        ArrayList<JButton> theatreButtons = new ArrayList<JButton>();

        //arraylist of theatres for reference
        ArrayList<Theatre> theatres = DatabaseInterface.getTheatres();
        int y = 65;

        //create buttons for each of the theatres in the database
        for (int i = 0; i < theatres.size(); i++){
            theatreButtons.add(new JButton(theatres.get(i).getName()));
            theatreButtons.get(i).setBounds(50, y, 100, 50);
            theatreButtons.get(i).addActionListener(ticketListener);
            pane.add(theatreButtons.get(i));
            y += 60;
        }

        //add remaining components to the JFrame
        pane.add(theatreLabel);
        pane.add(reselect);
        pane.setLayout(null);

        //display JFrame
        frame.setVisible(true);
    }

    //display function to display all the movies playing at a given theatre 
    public static void displayMovies(int theatreID){

        //add column label
        JLabel movieLabel = new JLabel("Please select a movie.");
        movieLabel.setBounds(225, 25, 175, 30);

        //arraylist of buttons for all the movies in the database
        ArrayList<JButton> movieButtons = new ArrayList<JButton>();

        //arraylist to keep track of movie buttons already made
        ArrayList<Integer> moviesAdded = new ArrayList<Integer>();

        //arraylist of movies for reference
        ArrayList<Movie> movies = DatabaseInterface.getMovies();

        //arraylist of showtimes for reference
        ArrayList<Showtime> showtimes = DatabaseInterface.getShowtimes();

        int y = 65;
        int m = 0;

        //creates a button for each movie playing at the theatre
        for (int i = 0; i < showtimes.size(); i++){
            if (showtimes.get(i).getTheatreID() == theatreID && !(moviesAdded.contains(showtimes.get(i).getMovieID()))){
                moviesAdded.add(showtimes.get(i).getMovieID());
                for (int j = 0; j < movies.size(); j++){
                    if(movies.get(j).getMovieID() == showtimes.get(i).getMovieID()){
                        movieButtons.add(new JButton(movies.get(j).getName()));
                        movieButtons.get(m).setBounds(225, y, 150, 50);
                        movieButtons.get(m).addActionListener(ticketListener);
                        pane.add(movieButtons.get(m));
                        m++;
                        y += 60;
                    }
                }
                
            }
        }

        //add remaining components
        pane.add(movieLabel);

        //update JFrame
        frame.repaint();
    }

    //function to display all the showtimes for a given movie at a given theatre
    public static void displayShowtimes(int movieID){
        //add column label
        JLabel showtimeLabel = new JLabel("Please select a showtime. (YYYY-MM-DD)");
        showtimeLabel.setBounds(400, 25, 275, 30);

        //arraylist of buttons for all the showtimes
        ArrayList<JButton> showtimeButtons = new ArrayList<JButton>();

        //arraylist of showtimes for reference
        ArrayList<Showtime> showtimes = DatabaseInterface.getShowtimes();
        int y = 65;
        int s = 0;

        //creates buttons for each of the showtimes
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

        //add remaining components
        pane.add(showtimeLabel);

        //update JFrame
        frame.repaint();
    }

    //function to display all the seats for a given showtime
    public static void displaySeats(int showtimeID){
        //add column label
        JLabel seatLabel = new JLabel("Please select a seat. Green seats are available. Red seats are unavailable.");
        seatLabel.setBounds(700, 25, 500, 30);

        //show were screen is in relation to seats
        JLabel screen = new JLabel("S C R E E N", SwingConstants.CENTER);
        screen.setBounds(700, 65, 345, 30);
        screen.setOpaque(true);
        screen.setBackground(Color.black);
        screen.setForeground(Color.white);

        //arraylist of buttons for all the seats
        ArrayList<JButton> seatButtons = new ArrayList<JButton>();

        //arraylist of all the seats for reference
        ArrayList<Seat> seats = DatabaseInterface.getSeats();

        //variables used to print the seat buttons in a grid style
        int row = 0;
        int col = 0;
        int seatNum = 1;

        //creates button for each seat in the showtime, places in a 4 X 8 grid style
        //green seats signifying vacant seats and red seats signifying seats that are unavailable
        for (int i = 0; i < seats.size(); i++){
            if (seats.get(i).getShowtimeID() == showtimeID){
                seatButtons.add(new JButton(Integer.toString(seatNum)));
                seatButtons.get(seatNum - 1).setBounds((700 + (43 * col)), (105 + (60 * row)), 40, 40);
                seatButtons.get(seatNum - 1).setOpaque(true);
                
                //if a seat is available, make it green and make it pressable
                if (seats.get(i).getVacant() == 1){
                    seatButtons.get(seatNum - 1).setBackground(Color.green);
                    seatButtons.get(seatNum - 1).addActionListener(ticketListener);
                }

                //otherwise make it red and unpressable
                else
                    seatButtons.get(seatNum - 1).setBackground(Color.red);
                pane.add(seatButtons.get(seatNum - 1));
                seatNum++;

                //update positioning
                if (col + 1 == 8){
                    col = 0;
                    row++;
                }
                else 
                    col++;
            }
        }

        //add remaining components
        pane.add(seatLabel);
        pane.add(screen);

        //update JFrame
        frame.repaint();
    }

    //function to create submit button once seat is selected
    public static void displaySubmit(int seatNum){
        JLabel submitLabel = new JLabel("Seat Selected: " + seatNum, SwingConstants.CENTER);
        submitLabel.setBounds(550, 510, 150, 30);

        //create "Pay for Ticket" button
        JButton payButton = new JButton("Pay for Ticket");
        payButton.setBounds(550, 550, 150, 50);
        payButton.setOpaque(true);
        payButton.setBackground(Color.blue);
        payButton.setForeground(Color.black);
        payButton.addActionListener(ticketListener);

        //add components to JFrame
        pane.add(submitLabel);
        pane.add(payButton);

        //update JFrame
        frame.repaint();
    }

    //listener for all buttons in JFrame
    static class TicketListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            // Perform desired operation for each button press.
            ArrayList<Theatre> theatres = DatabaseInterface.getTheatres();
            ArrayList<Showtime> showtimes = DatabaseInterface.getShowtimes();
            ArrayList<Movie> movies = DatabaseInterface.getMovies();
            ArrayList<Seat> seats = DatabaseInterface.getSeats();

            //if the user has selected a seat and presses the "Pay for Ticket" button
            if (event.getActionCommand().equals("Pay for Ticket")){
                frame.dispose();
                PaymentPage.setPaymentStrategy("Ticket");
                PaymentPage.performStrategy(currentSeat, currentSeatNumber);
            }

            //if the user presses the "Re-select" button
            if (event.getActionCommand().equals("Re-select")){
                frame.dispose();
                display();
            }

            int i;

            //go through all possible theatre buttons that could've been pressed
            for (i = 0; i < theatres.size(); i++){
                if (event.getActionCommand().equals(theatres.get(i).getName())){
                    //if the button is found, display all the movies for this theare
                    currentTheatre = theatres.get(i).getTheatreID();
                    displayMovies(currentTheatre);
                }
            }

            //go through all possible movie buttons that could've been pressed
            for (i = 0; i < movies.size(); i++){
                if (event.getActionCommand().equals(movies.get(i).getName())){
                    //if the button is found, display all the showtimes for this movie
                    currentMovie = movies.get(i).getMovieID();
                    displayShowtimes(currentMovie);
                }
            }

            //go through all possible showtime buttons that could've been pressed
            for (i = 0; i < showtimes.size(); i++){
                if (event.getActionCommand().equals(showtimes.get(i).getTime()) && showtimes.get(i).getMovieID() == currentMovie){
                    //if the button is found, display all seats for this showtime
                    currentShowtime = showtimes.get(i).getShowtimeID();
                    displaySeats(currentShowtime);
                }
            }

            //if the button being pressed is a seat button
            if (event.getActionCommand().length() <= 2){
                int seatNumber;

                //find the value of the seat number that was selected
                for (seatNumber = 0; !(String.valueOf(seatNumber).equals(event.getActionCommand())); seatNumber++){}
                
                int seatCounter = 0;

                //find the xth seat in the showtime and send the seatID to the display submit button
                for (i = 0; i < seats.size(); i++){
                    if (seats.get(i).getShowtimeID() == currentShowtime){
                        if (++seatCounter == seatNumber){
                            currentSeatNumber = seatNumber;
                            currentSeat = seats.get(i).getSeatID();
                            displaySubmit(seatNumber);
                        }
                    }
                }
            }
        }
    }
}