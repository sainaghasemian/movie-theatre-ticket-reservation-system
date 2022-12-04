//saina
package Boundary;
public class PaymentPage extends Page
{
    //Current payment strategy
    private static String paymentStrategy;

    //Perform current strategy
    public static void performStrategy(int seatID, int seatNumber)
    {
        if(paymentStrategy.equals("Ticket"))
        {
            PayTicketPage.display(seatID, seatNumber);
        }
        else if(paymentStrategy.equals("Cancel"))
        {
            PayCancellationFeePage.display();
        }
        else if(paymentStrategy.equals("Account"))
        {
            PayAccountFeePage.display();
        }
    }

    //Set payment strategy
    public static void setPaymentStrategy(String newPaymentStrategy)
    {
        paymentStrategy = newPaymentStrategy;
    }
}