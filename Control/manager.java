//rachel
package Control;
import Boundary.*;
import Entity.*;
import java.util.*;

//Need to make this singleton
public class Manager 
{
    private static Manager onlyInstance;

    public static Account currentAccount;

    private static HashMap<Integer, Page> pageMapping = new HashMap<>();

    private Manager() 
    {
        Page entryPage = new EntryPage();
        Page loginPage = new LoginPage();
        Page registerPage = new RegisterPage();
        Page homePage = new HomePage();
        Page selectTicketPage = new SelectTicketPage();
        Page searchMoviePage = new SearchMoviePage();
        Page selectShowtimePage = new SelectShowtimePage();
        Page searchTicketPage = new SearchTicketPage();
        Page payTicketPage = new PayTicketPage();
        Page payAccountFeePage = new PayAccountFeePage();
        Page payCancellationFeePage = new PayCancellationFeePage();
        Page displayTicketPage = new DisplayTicketPage();

        pageMapping.put(0, entryPage);
        pageMapping.put(1, loginPage);
        pageMapping.put(2, registerPage);
        pageMapping.put(3, homePage);
        pageMapping.put(4, selectTicketPage);
        pageMapping.put(5, searchMoviePage);
        pageMapping.put(6, selectShowtimePage);
        pageMapping.put(7, searchTicketPage);
        pageMapping.put(8, payTicketPage);
        pageMapping.put(9, payAccountFeePage);
        pageMapping.put(10, payCancellationFeePage);
        pageMapping.put(11, displayTicketPage);
    }

    public static void proceed(int nextPageID)
    {
        pageMapping.get(nextPageID).display();
    }

    public static void main(String[] args)
    {
        DatabaseInterface databaseInterface = new DatabaseInterface();
        //System.out.print(databaseInterface.getMovies().get(0).getName()); //Tests if database retrieval is working!
        onlyInstance = new Manager();
        proceed(0);
    }
}
