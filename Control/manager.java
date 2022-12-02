//rachel
package Control;
import Boundary.*;
import java.util.*;

//Need to make this singleton
public class Manager 
{
    private static Manager onlyInstance;

    private static HashMap<Integer, Page> pageMapping = new HashMap<>();

    private Manager() 
    {
        Page entryPage = new EntryPage();
        //etc. I will add the other pages once they're created
        pageMapping.put(0, entryPage);
        //etc.
    }

    public static void proceed(int nextPageID)
    {
        pageMapping.get(nextPageID).display();
    }



    public static void main(String[] args)
    {
        DatabaseInterface databaseInterface = new DatabaseInterface();
        //onlyInstance = new Manager();
        //proceed(0);
    }
}
