package database;

import java.util.Collection;

public class WinningNum {
	Collection<Integer> winningNum;
	int bonusNum;
	
	public WinningNum(Collection<Integer> winningNum, int bonusNum) {
		this.winningNum = winningNum;
		this.bonusNum = bonusNum;
	}

	public Collection<Integer> getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(Collection<Integer> winningNum) {
		this.winningNum = winningNum;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}

	@Override
	public String toString() {
		return "WinningNum [winningNum=" + winningNum + ", bonusNum=" + bonusNum + "]";
	}
	
	
}
