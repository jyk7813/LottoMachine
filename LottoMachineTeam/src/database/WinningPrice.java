package database;

import java.util.Random;


public class WinningPrice {
	private Random random = new Random();
	public final static int FIFTH_WINNING_PRICE = 50000;
	public final static int FOURTH_WINNING_PRICE = 500000;

	private long NumOfPeople;
	private long totalPrice;
	
	public WinningPrice() {
		NumOfPeople = random.nextInt(10000) + 8200000;
	}


	public long totalFourthANdFifthWinnerPrice() {
		return totalFifthWinningPrice() + totalFourthWinningPrice();
	}
	public long totalPriceSubTotalFourthAndFifthWinnerPrice() {
		return totalPrice() - totalFourthANdFifthWinnerPrice();
	}

	public long totalFourthWinningPrice() {
		return fourthWinners() * FOURTH_WINNING_PRICE;
	}

	public long totalFifthWinningPrice() {
		return fifthWinners() * FIFTH_WINNING_PRICE;
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
		totalPrice = NumOfPeople * 10000;
		return totalPrice;
	}
	public void resetWinningPrice() {
		NumOfPeople = random.nextInt(10000) + 8200000;
	}

	public void addPeople() {
		NumOfPeople += random.nextInt(100);
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
    
    public long getNumOfPeople() {
		return NumOfPeople;
	}

   

}
