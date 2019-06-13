package labTerminalB;

public class Main {

	public static void main(String[] args) {
		Movie m1 = new Movie("TeesMaarKhan", 0);
		Movie m2 = new Movie("Undesputed", 1);
		Customer me = new Customer("Ali");
		Customer me2 = new Customer("kamran");
		Rental r1 = new Rental(m1, 2);
		Rental r2 = new Rental(m2,3);
		
		/**
		 * Test 1 Customer rented two movies one REGULAR and one NEW_RELEASE
		 */
		
			me.addRental(r1);
			me.addRental(r2);
			System.out.println(me.statement());
			
			

	}

}
