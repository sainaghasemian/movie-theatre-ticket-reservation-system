package Entity;

public class Account 
{
    //Payment data
    private String fName;
    private String lName;
    private String cardNumber;
    private String username;
    private String password;
    private String email;

    //Constructor
    public Account(String fName, String lName, String cardNumber, String username, String password, String email)
    {
        this.fName = fName;
        this.lName = lName;
        this.cardNumber = cardNumber;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
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

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
