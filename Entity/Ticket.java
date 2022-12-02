package Entity;

public class Ticket 
{
    //Ticket data
    private int ticketID;
    private int seatID;

    //Constructor
    public Ticket(int ticketID, int seatID)
    {
        this.ticketID = ticketID;
        this.seatID = seatID;
    }

    //Getters
    public int getTicketID()
    {
        return ticketID;
    }

    public int getSeatID()
    {
        return seatID;
    }

    //Setters
    public void setTicketID(int ticketID)
    {
        this.ticketID = ticketID;
    }

    public void setSeatID(int seatID)
    {
        this.seatID = seatID;
    }
}
