//rachel
package Control;
import Boundary.*;
import Entity.*;

public class Manager 
{

    public static Account currentAccount;

    public static void main(String[] args)
    {
        DatabaseInterface databaseInterface = DatabaseInterface.getOnlyInstance();
        EntryPage.display();
    }
}
