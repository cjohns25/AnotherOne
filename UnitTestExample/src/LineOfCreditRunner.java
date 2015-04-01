/**
 * This program runs threads that deposit and withdraw money from the same bank
 * account.
 */
public class LineOfCreditRunner
{
	public static void main(String[] args)
	{
		LineOfCredit account = new LineOfCredit();

		final int REPETITIONS = 100;

		PurchaseRunnable d = new PurchaseRunnable(account, REPETITIONS);
		PaymentRunnable w = new PaymentRunnable(account, REPETITIONS);

		Thread dt = new Thread(d);
		Thread wt = new Thread(w);

		dt.start();
		wt.start();
	}
}
