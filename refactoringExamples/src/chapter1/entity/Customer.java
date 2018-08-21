package chapter1.entity;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * @author Administrator
 *
 */
public class Customer {
	
	private String name;
	private Vector<Rental> rentals = new Vector<>();

	Customer(String name) {
		this.name = name;
	}

	void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	private String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rent = rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rent.hasMoreElements()) {
			Rental each = rent.nextElement();
			frequentRenterPoints += each.getFrequentRentterPoints();

			result += "\t" + String.valueOf(getTotalcharge()) + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	

}
