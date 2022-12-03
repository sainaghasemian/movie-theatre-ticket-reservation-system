package Boundary;

import java.util.*;
import java.sql.*;
import Entity.*;

public class DatabaseInterface   //Singleton Pattern
{

    //Only instance
    private static DatabaseInterface onlyInstance;

    //Theatre data
    private static ArrayList<Movie> movies = new ArrayList<>();

    private static ArrayList<Theatre> theatres = new ArrayList<>();

    private static ArrayList<Showtime> showtimes = new ArrayList<>();

    private static ArrayList<Account> accounts = new ArrayList<>();

    private static ArrayList<Payment> payments = new ArrayList<>();

    private static ArrayList<Seat> seats = new ArrayList<>();

    //Database connection information
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;

    //Constructor
    private DatabaseInterface()
    {
        // Database URL
        this.DBURL = "jdbc:mysql://localhost/ensf480";

        //  Database credentials
        this.USERNAME = "root";
        this.PASSWORD = "";

        //Access database and fill arraylists
        initializeConnection();

        try 
        {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM movie");
            
            while (results.next())
            {
                Movie movie = new Movie(results.getInt("movieID"), results.getString("name"));
                movies.add(movie);
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        try 
        {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM theatre");
            
            while (results.next())
            {
                Theatre theatre = new Theatre(results.getInt("theatreID"), results.getString("name"));
                theatres.add(theatre);
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        try 
        {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM showtime");
            
            while (results.next())
            {
                Showtime showtime = new Showtime(results.getInt("showtimeID"), results.getString("time"), results.getInt("movieID"), results.getInt("theatreID"));
                showtimes.add(showtime);
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        try 
        {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM account");
            
            while (results.next())
            {
                Account account = new Account(results.getString("firstName"), results.getString("lastName"), results.getString("cardNumber"), results.getString("username"), results.getString("password"), results.getString("email"));
                accounts.add(account);
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        try 
        {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM payment");
            
            while (results.next())
            {
                Payment payment = new Payment(results.getString("fName"), results.getString("lName"), results.getString("cardNumber"), results.getDouble("amount"), results.getString("date"));
                payments.add(payment);
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        try 
        {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM seat");
            
            while (results.next())
            {
                Seat seat = new Seat(results.getInt("seatID"), results.getInt("showtimeID"), results.getInt("vacant"));
                seats.add(seat);
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        close();
    }

    //Getter for only instance
    public static DatabaseInterface getOnlyInstance()
    {
        if(onlyInstance == null)
        {
            onlyInstance = new DatabaseInterface();
        }
        return onlyInstance;
    }

    //Getters for theatre data

    public static ArrayList<Movie> getMovies()
    {
        return movies;
    }

    public static ArrayList<Theatre> getTheatres()
    {
        return theatres;
    }

    public static ArrayList<Showtime> getShowtimes()
    {
        return showtimes;
    }

    public static ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public static ArrayList<Payment> getPayments()
    {
        return payments;
    }

    public static ArrayList<Seat> getSeats()
    {
        return seats;
    }

    //Initializes the connection with the database
    public void initializeConnection()
    {
        try
        {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }

    //Closes the connection with the database
    public void close() 
    {
        try 
        {
            //results.close();
            dbConnect.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
