import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author cjohns25
 *
 */
public class LineOfCreditTest
{

	
	LineOfCredit loc;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		loc = new LineOfCredit();
	}

	/**
	 * Test method for {@link LineOfCredit#LineOfCredit()}.
	 */
	@Test
	public void testLineOfCredit()
	{
		double expectedBalance = 0;
		assertEquals(expectedBalance, loc.getBalance(), 0.0001);
	}

	/**
	 * Test method for {@link LineOfCredit#purchase(double)}.
	 */
	@Test
	public void testPurchase()
	{
		LineOfCredit loc2 = new LineOfCredit();
		double result = loc2.purchase(200);
		assertEquals(200, loc2.getBalance(), 0.001);
		result = loc2.purchase(5500);
		assertEquals(4800, result, 0.0001);
		assertEquals(5000, loc2.getBalance(), 0.0001);
		
	}

	/**
	 * Test method for {@link LineOfCredit#payment(double)}.
	 */
	@Test
	public void testPayment() throws InterruptedException
	{
		LineOfCredit loc2 = new LineOfCredit();
	    loc2.purchase(200);
	    loc2.payment(100);
	    assertEquals(100, loc2.getBalance(), 0.001);
	    loc2.payment(300);
	    assertEquals(0, loc2.getBalance(), 0.001);
	    
		
	}



}
