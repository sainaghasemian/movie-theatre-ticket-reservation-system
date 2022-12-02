package Boundary;

import java.util.*;
import java.sql.*;
import Entity.*;

public class DatabaseInterface   //Singleton Pattern
{
    //Theatre data
    private ArrayList<Movie> movies = new ArrayList<>();

    private ArrayList<Theatre> theatres = new ArrayList<>();

    private ArrayList<Showtime> showtimes = new ArrayList<>();

    private ArrayList<Account> accounts = new ArrayList<>();

    private ArrayList<Payment> payments = new ArrayList<>();

    private ArrayList<Seat> seats = new ArrayList<>();

    //Database connection information
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;


    public DatabaseInterface()
    {
        // Database URL
        this.DBURL = "ensf480";

        //  Database credentials
        this.USERNAME = "root";
        this.PASSWORD = "";

        //Access database and fill arraylists
        initializeConnection();

        // try 
        // {                    
        //     Statement myStmt = dbConnect.createStatement();
        //     results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");
            
        //     while (results.next())
        //     {
        //         Client client = new Client(results.getString("Client"), results.getInt("WholeGrains"), results.getInt("FruitVeggies"), results.getInt("Protein"), results.getInt("Other"), results.getInt("Calories"));
        //         clientList.add(client);
        //     }
            
        //     myStmt.close();
        // } catch (SQLException ex) {
        //     ex.printStackTrace();
        // }

        // try 
        // {                    
        //     Statement myStmt = dbConnect.createStatement();
        //     results = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            
        //     int i = 1;
        //     while (results.next())
        //     {
        //         Food food = new Food(i, results.getString("Name"), results.getInt("GrainContent"), results.getInt("FVContent"), results.getInt("ProContent"), results.getInt("Other"), results.getInt("Calories"));
        //         foodList.add(food);
        //         i++;
        //     }
            
        //     myStmt.close();
        // } catch (SQLException ex) {
        //     ex.printStackTrace();
        // }

        close();
    }

    //Getters for theatre data

    public ArrayList<Movie> getMovies()
    {
        return movies;
    }

    public ArrayList<Theatre> getTheatres()
    {
        return theatres;
    }

    public ArrayList<Showtime> getShowtimes()
    {
        return showtimes;
    }

    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public ArrayList<Payment> getPayments()
    {
        return payments;
    }

    public ArrayList<Seat> getSeats()
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
            results.close();
            dbConnect.close();
        } catch (SQLException e) 
        {
        e.printStackTrace();
        }
    }
}
