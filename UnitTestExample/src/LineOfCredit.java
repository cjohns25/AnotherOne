// This is a test stub class of Line of Credit for unit testing PaymentRunnable and PurchaseRunnable
public class LineOfCredit
{

	// test stub method payment
	public void payment(double amount)
	{
		
		System.out.println("called payment wiht amount of $" + amount);
	}
	
	public double purchase(double amount)
	{
		System.out.println("called purchase with amount of $" + amount);
		return amount;
	}
}
