import java.util.Random;

/**
 * A purchase runnable makes periodic purchasess from a line of credit account.
 */
public class PurchaseRunnable implements Runnable
{
	private static final int DELAY = 2000;
	private LineOfCredit account;
	private double amount;
	private int count;
	private Random r = new Random();

	/**
	 * Constructs a withdraw runnable.
	 * 
	 * @param anAccount
	 *            the account from which to withdraw money
	 * @param anAmount
	 *            the amount to deposit in each repetition
	 * @param aCount
	 *            the number of repetitions
	 */
	public PurchaseRunnable(LineOfCredit anAccount, int aCount)
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
				double actual = account.purchase(amount);
				System.out.println("Actual Purchase $" + actual);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception)
		{
		}
	}
}
