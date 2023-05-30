package database;

public class WinningNum {
	int[] winningNum;
	int bonusNum;
	
	public WinningNum(int[] winningNum, int bonusNum) {
		this.winningNum = winningNum;
		this.bonusNum = bonusNum;
	}

	public int[] getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(int[] winningNum) {
		this.winningNum = winningNum;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}
	
	
}
