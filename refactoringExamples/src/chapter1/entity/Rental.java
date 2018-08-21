package chapter1.entity;

import java.util.Enumeration;

public class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public double getCharge() {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (getDaysRented() > 2) {
					thisAmount += (getDaysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += getDaysRented() * 3;
				break;
			case Movie.CHILDRENs:
				thisAmount += 1.5;
				if (getDaysRented() > 3) {
					thisAmount += (getDaysRented() - 3) * 1.5;
				}
				break;
			default :
				break;
		}
		return thisAmount;
	}
	
	public int getFrequentRentterPoints() {
		if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
			return 2;
		}
		return 1;
	}
	
	public double getTotaIFrequentRentterPoints() {
		double result = 0;
		Enumeration<Rental> rent = rentals.elements();
		while (rent.hasMoreElements()) {
			Rental each = rent.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

}
