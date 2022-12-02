package Entity;

public class Seat 
{
    //Seat data
    private int seatID;
    private int showtimeID;
    private int vacant; // 1 = vacant, 0 = available

    //Constructor
    public Seat(int seatID, int showtimeID, int vacant)
    {
        this.seatID = seatID;
        this.showtimeID = showtimeID;
        this.vacant = vacant;
    }

    //Getters
    public int getSeatID()
    {
        return seatID;
    }

    public int getShowtimeID()
    {
        return showtimeID;
    }

    public int getVacant()
    {
        return vacant;
    }

    //Setters
    public void setSeatID(int seatID)
    {
        this.seatID = seatID;
    }

    public void setShowtimeID(int showtimeID)
    {
        this.showtimeID = showtimeID;
    }

    public void setVacant(int vacant)
    {
        this.vacant = vacant;
    }
}
