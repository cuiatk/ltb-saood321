package labTerminalB;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest2 {

	@Test
	public void test() {
		Movie m1 = new Movie("TeesMaarKhan", 0);
		Movie m2 = new Movie("Undesputed", 1);
		Customer me = new Customer("Ali");
		Customer me2 = new Customer("kamran");
		Rental r1 = new Rental(m1, 10);
		Rental r2 = new Rental(m2,10);
		
		/**
		 * Test 1 Customer rented two movies one REGULAR and one NEW_RELEASE
		 */
		
			me.addRental(r1);
			me.addRental(r2);
			//fail("Not yet implemented");
			String output1 = "Rental Record for Ali\r\n" + 
					"	TeesMaarKhan	14.0\r\n" + 
					"	undesputed	30.0";
			if(output1.equals(me.statement()))
			{
				assert true;
			}
	}

}
