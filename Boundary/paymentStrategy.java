//saina
package Boundary;
import Control.*;
import Entity.*;
import java.util.ArrayList;

abstract public class PaymentStrategy extends Page //Strategy Pattern
{

    private static boolean validate(String cardNumber)
    {
        for(Account acc : DatabaseInterface.getAccounts())
        {
            if(acc.getCardNumber().equals(cardNumber))
            {
                Manager.currentAccount = acc;
                return true;
            }
        }
        return false;
    }

    abstract public void makeTransaction();
}
