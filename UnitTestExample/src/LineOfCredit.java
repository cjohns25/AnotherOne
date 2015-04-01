import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class LineOfCredit
{
	private double creditLimit;
	private double balance;
	private Lock balanceChangeLock;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public LineOfCredit()
	{
		balance = 0;
		balanceChangeLock = new ReentrantLock();
		creditLimit = 5000;
	}

	/**
	 * Purchase something with line of credit.
	 * 
	 * @param amount
	 *            the amount of purchase
	 */
	public double purchase(double amount)
	{
		double approvedAmount = amount;
		balanceChangeLock.lock();
		try
		{
			System.out.print("Attempting to make purchase of $" + amount);
			double newBalance = balance + amount;
			if (newBalance < creditLimit)
			{
				System.out.println(",Purchase approved, new balance is $"
				        + newBalance);
				balance = newBalance;

			} else
			{
				approvedAmount = creditLimit - balance;
				balance = creditLimit;
				System.out
				        .println(" Purchase overflows credit limit, approved amount = $"
				                + approvedAmount);
			}

		} finally
		{
			balanceChangeLock.unlock();

		}
		return approvedAmount;
	}

	/**
	 * Make Payment
	 * 
	 * @param amount
	 *            the amount to withdraw
	 */
	public void payment(double amount) throws InterruptedException
	{
		balanceChangeLock.lock();
		try
		{

			System.out.print("Making payment of  $" + amount);
			double newBalance = balance - amount;
			if (newBalance >= 0)
			{
				System.out.println(", new balance is $" + newBalance);
				balance = newBalance;
			} else
			{
				System.out.println(", Overpayment - accepting $" + balance);
				balance = 0;
			}
		} finally
		{
			balanceChangeLock.unlock();
		}
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}
}
