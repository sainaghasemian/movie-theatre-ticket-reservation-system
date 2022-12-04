//saina
package Boundary;
import Control.*;
import Entity.*;

abstract public class PaymentStrategy extends Page //Strategy Pattern
{

    //Retrieve account that matches entered card number
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
}
