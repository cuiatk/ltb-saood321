package labTerminalB;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		/*
		 * TODO 4		20 Marks
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		/**
		 * TODO 3		10 Marks
		 * Provide suitable specification for statement method 
		 */
		
		/*
		 * This method calculates totalamount of movies rent and frequentRenterPoints
		 * @param: nothing
		 * @return: result which contain the name of Customers,each movie and their bill,total amount,and renterPints
		 */
		public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			//determine amounts for each line
			thisAmount = each.rentCalculation(thisAmount);
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&&
					each.getDaysRented() > 1) frequentRenterPoints ++;
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result = display(totalAmount, frequentRenterPoints, result);
		
		return result;
	}
		
		/*
		 * This method will insert all data of customer and movies into result.
		 * @param: totalamount which contain totalAmount of movies.
		 * 			frequentRenterPoint which contain bonus points for customers.
		 * 			result which contain data about previous customer.
		 * @return: result contain data about customers,movies,rents and frequentRenterPoint
		 */
		private String display(double totalAmount, int frequentRenterPoints, String result) {
			result += "Amount owed is " + String.valueOf(totalAmount) +
					"\n";
			result += "You earned " + String.valueOf(frequentRenterPoints)
			+
			" frequent renter points";
			return result;
		}
}
