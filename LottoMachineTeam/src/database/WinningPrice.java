package database;

import java.util.Random;

import Pages.BuyPage;

public class WinningPrice {
	private Random random = new Random();
	private final static int fifthWinningPrice = 50000;
	private final static int fourthWinningPrice = 500000;
	private int thirdWinningPrice = 50000;
	private int secondWinningPrice = 50000;
	private int firstWinningPrice = 50000;
	private long firstWinner;
	private long secondWinner;
	private long thirdWinner;
	private long fourthWinner;
	private long fifthWinner;

	private long NumOfPeople;
	private long totalPrice;

	public long totalFirstWinningPrice() {
		long totalFourthAndFifthWinnerPrice = totalFifthWinningPrice() + totalFourthWinningPrice();
		long totalSubForthFifthWinnerPrice = totalPrice() - totalFourthAndFifthWinnerPrice;
		long totalFirstWinningPrice = (long) (totalSubForthFifthWinnerPrice * (75 / 100));
		return totalFirstWinningPrice;
	}

	public long totalSecondWinningPrice() {
		long totalFourthAndFifthWinnerPrice = totalFifthWinningPrice() + totalFourthWinningPrice();
		long totalSubForthFifthWinnerPrice = totalPrice() - totalFourthAndFifthWinnerPrice;
		long totalSecondWinningPrice = (long) (totalSubForthFifthWinnerPrice * (12.5 / 100));
		return totalSecondWinningPrice;
	}

	public long totalThirdWinningPrice() {
		long totalFourthAndFifthWinnerPrice = totalFifthWinningPrice() + totalFourthWinningPrice();
		long totalSubForthFifthWinnerPrice = totalPrice() - totalFourthAndFifthWinnerPrice;
		long totalThirdWinningPrice = (long) (totalSubForthFifthWinnerPrice / (12.5 / 100));
		return totalThirdWinningPrice;

	}

	public long totalFourthWinningPrice() {
		return fourthWinner * fourthWinningPrice;
	}

	public long totalFifthWinningPrice() {
		return fifthWinner * fifthWinningPrice;
	}

	public long totalPrice() {
		NumOfPeople = random.nextLong(3000000) + 1000000;
		totalPrice = NumOfPeople * 10000;
		return NumOfPeople;
	}

	public void addPeople() {
		NumOfPeople += random.nextLong(10000) + 100;
	}

	private long fifthWinners() {
		fifthWinner = NumOfPeople / 45;
		return NumOfPeople /= 45;
	}

	private long fourthWinners() {
		fourthWinner = NumOfPeople / 733;
		return NumOfPeople /= 733;
	}

	private long thirdWinners() {
		thirdWinner = NumOfPeople / 35724;
		return NumOfPeople /= 35724;
	}

	private long secondWinners() {
		secondWinner = NumOfPeople / 1357510;
		return NumOfPeople /= 1357510;
	}

	private long firstWinners() {
		firstWinner = NumOfPeople / 8145060;
		return NumOfPeople /= 8145060;
	}

	public long firstWinningPrice() {
		return totalFirstWinningPrice() / firstWinners();
	}
	public long secondWinningPrice() {
		return totalSecondWinningPrice() /secondWinners();
	}
	public long thirdWinningPrice() {
		return totalThirdWinningPrice() / thirdWinners();
	}
}
