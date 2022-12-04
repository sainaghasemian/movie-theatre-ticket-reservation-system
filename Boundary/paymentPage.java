//saina
package Boundary;
public class PaymentPage extends Page
{
    private static String paymentStrategy;

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

    public static void setPaymentStrategy(String newPaymentStrategy)
    {
        paymentStrategy = newPaymentStrategy;
    }
}
