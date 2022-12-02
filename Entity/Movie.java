package Entity;

public class Movie 
{
    //Movie data
    private int movieID;
    private String name;

    //Constructor
    public Movie(int movieID, String name)
    {
        this.movieID = movieID;
        this.name = name;
    }

    //Getters
    public int getMovieID()
    {
        return movieID;
    }

    public String getName()
    {
        return name;
    }

    //Setters
    public void setMovieID(int movieID)
    {
        this.movieID = movieID;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
