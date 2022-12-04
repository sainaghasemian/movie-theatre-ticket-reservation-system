package Entity;

public class Payment 
{
    //Payment data
    private String fName;
    private String lName;
    private String cardNumber;
    private double amount;
    private String date;

    //Constructor
    public Payment(String fName, String lName, String cardNumber, double amount, String date)
    {
        this.fName = fName;
        this.lName = lName;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.date = date;
    }

    //Getters
    public String getFName()
    {
        return fName;
    }

    public String getLName()
    {
        return lName;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getDate()
    {
        return date;
    }

    //Setters
    public void setFName(String fName)
    {
        this.fName = fName;
    }

    public void setLName(String lName)
    {
        this.lName = lName;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
