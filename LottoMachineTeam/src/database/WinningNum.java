package database;

import java.util.Collection;

public class WinningNum {
	Collection winningNum;
	int bonusNum;
	
	public WinningNum(Collection winningNum, int bonusNum) {
		this.winningNum = winningNum;
		this.bonusNum = bonusNum;
	}

	public Collection getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(Collection winningNum) {
		this.winningNum = winningNum;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}
	
	
}
