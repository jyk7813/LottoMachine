import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WinningNum {
	private Map<Integer, Integer[]> winningNum;
	

	public WinningNum() {
		
		this.winningNum = new LinkedHashMap<>();
	}

	public Map<Integer, Integer[]> getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(Map<Integer, Integer[]> winningNum) {
		this.winningNum = winningNum;
	}
	
	public Set<Integer> getTurn() {
		return winningNum.keySet();
	}
	/**
	 * 마지막 턴을 가져오는 메서드. 
	 * 만약 TreeSet이 비어있다면 -1을 반환한다.
	 * 작성자 : 주하태 버젼 : 1.0.0
	 * @return 마지막 턴의 값. 턴이 없으면 -1
	 */
	public int getLastTurn() {
	    TreeSet<Integer> winningNumKeySet = new TreeSet<>(getTurn());
	    // TreeSet이 비어있지 않다면 가장 마지막 값을 반환하고, 그렇지 않다면 -1을 반환
	    return !winningNumKeySet.isEmpty() ? winningNumKeySet.last() : -1;
	}
	
	@Override
	public String toString() {
		return "WinningNum [winningNum=" + winningNum + "]";
	}
	
}
