import java.util.Random;

/**
 * A deposit runnable makes periodic deposits to a bank account.
 */
public class PaymentRunnable implements Runnable
{
	private static final int DELAY = 3000;
	private LineOfCredit account;
	private double amount;
	private int count;
	private Random r = new Random();

	/**
	 * Constructs a deposit runnable.
	 * 
	 * @param anAccount
	 *            the account into which to deposit money
	 * @param anAmount
	 *            the amount to deposit in each repetition
	 * @param aCount
	 *            the number of repetitions
	 */
	public PaymentRunnable(LineOfCredit anAccount, int aCount)
	{
		account = anAccount;

		count = aCount;
	}

	public void run()
	{
		try
		{
			for (int i = 1; i <= count; i++)
			{
				amount = r.nextInt(501);
				account.payment(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception)
		{
		}
	}
}
