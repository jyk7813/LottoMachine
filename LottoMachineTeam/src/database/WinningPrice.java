package database;

import java.util.Random;


public class WinningPrice {
	private Random random = new Random();
	private final static int fifthWinningPrice = 50000;
	private final static int fourthWinningPrice = 500000;

	private long NumOfPeople;
	private long totalPrice;


	public long totalFourthANdFifthWinnerPrice() {
		return totalFifthWinningPrice() + totalFourthWinningPrice();
	}
	public long totalPriceSubTotalFourthAndFifthWinnerPrice() {
		return totalPrice() - totalFourthANdFifthWinnerPrice();
	}

	public long totalFourthWinningPrice() {
		return fourthWinners() * fourthWinningPrice;
	}

	public long totalFifthWinningPrice() {
		return fifthWinners() * fifthWinningPrice;
	}
	public long firstWinnersPrice() {
		return (long)(totalPriceSubTotalFourthAndFifthWinnerPrice()*75/100/firstWinners());
	}
	public long secondWinnersPrice() {
		return (long)(totalPriceSubTotalFourthAndFifthWinnerPrice()*12.5/100/secondWinners());
	}
	public long thirdWinnersPrice() {
		return (long)(totalPriceSubTotalFourthAndFifthWinnerPrice()*12.5/100/thirdWinners());
	}

	public long totalPrice() {
		NumOfPeople = random.nextInt(10000) + 8200000;
		totalPrice = NumOfPeople * 10000;
		return totalPrice;
	}

	public void addPeople() {
		NumOfPeople += random.nextInt(10000) + 100L;
	}

	private long fifthWinners() {
        return (long)(NumOfPeople / 45.0);
    }

    private long fourthWinners() {
        return (long)(NumOfPeople / 733.0);
    }

    private long thirdWinners() {
        return (long)(NumOfPeople / 35724.0);
    }

    private long secondWinners() {
        return (long)(NumOfPeople / 1357510.0);
    }

    private long firstWinners() {
        return (long)(NumOfPeople / 8145060.0);
    }
    

   

}
