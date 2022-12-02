package Entity;

public class Theatre 
{
    //Theatre data
    private int theatreID;
    private String name;

    //Constructor
    public Theatre(int theatreID, String name)
    {
        this.theatreID = theatreID;
        this.name = name;
    }

    //Getters
    public int getMovieID()
    {
        return theatreID;
    }

    public String getName()
    {
        return name;
    }

    //Setters
    public void setTheatreID(int theatreID)
    {
        this.theatreID = theatreID;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
