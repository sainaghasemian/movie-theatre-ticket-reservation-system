package Entity;

public class Showtime 
{
    //Showtime data
    private int showtimeID;
    private String time;
    private int movieID;
    private int theatreID;

    //Constructor
    public Showtime(int showtimeID, String time, int movieID, int theatreID)
    {
        this.showtimeID = showtimeID;
        this.time = time;
        this.movieID = movieID;
        this.theatreID = theatreID;
    }

    //Getters
    public int getShowtimeID()
    {
        return showtimeID;
    }
    public String getTime()
    {
        return time;
    }

    public int getMovieID()
    {
        return movieID;
    }

    public int getTheatreID()
    {
        return theatreID;
    }

    //Setters
    public void setShowtimeID(int showtimeID)
    {
        this.showtimeID = showtimeID;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setMovieID(int movieID)
    {
        this.movieID = movieID;
    }

    public void setTheatreID(int theatreID)
    {
        this.theatreID = theatreID;
    }
}
