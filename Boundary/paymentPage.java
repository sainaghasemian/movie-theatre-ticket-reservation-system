//saina
package Boundary;
public class PaymentPage extends Page
{
    private static String paymentStrategy;

    public static void performStrategy(int seatID)
    {
        if(paymentStrategy == "Ticket")
        {
            PayTicketPage.display(seatID);
        }
        else if(paymentStrategy == "Cancel")
        {
            PayCancellationFeePage.display();
        }
        else if(paymentStrategy == "Account")
        {
            PayAccountFeePage.display();
        }
    }

    public static void setPaymentStrategy(String newPaymentStrategy)
    {
        paymentStrategy = newPaymentStrategy;
    }
}
