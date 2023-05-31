package database;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WinningNumData {
	
	private static TreeMap<Integer,WinningNum> winningNumData = new TreeMap<>();
	private static Integer turn = 0;
	public WinningNumData() {
		
	}

	/**
     * 당첨 번호 맵을 가져오는 메서드.
     * 방어적 복사를 사용하여 외부 변경으로부터 보호.
     * 작성자 : 주하태 버젼 : 1.0.0
     * @return 당첨 번호 맵의 복사본
     */
	public void addWinningNum(Collection<Integer> winningNums, int bonusNum) {
		turn++;
		WinningNum winningNum = new WinningNum(winningNums, bonusNum);
		winningNumData.put(turn, winningNum);
	}
    public Map<Integer, WinningNum> getWinningNum() {
        return new LinkedHashMap<>(winningNumData);
    }

	
	/**
	 * 모든 턴 번호를 가져오는 메서드.
	 * 작성자 : 주하태 버젼 : 1.0.0
	 * @return 턴 번호의 집합
	 */
	public Set<Integer> getTurn() {
	    return winningNumData.keySet();
	}
	// 마지막 회차관련 메소드
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
	
	/**
	 * 마지막 턴에 대한 당첨 번호를 가져오는 메서드.
	 * 만약 마지막 턴이 없다면 null을 반환한다.
	 * 작성자 : 주하태 버젼 : 1.0.0
	 * @return 마지막 턴의 당첨 번호. 마지막 턴이 없으면 null
	 */
	public WinningNum getLastWinningNum() {
	    return winningNumData.get(getLastTurn());
	}

	@Override
	public String toString() {
		return "WinningNumData [getLastTurn()=" + getLastTurn() + ", getLastWinningNum()=" + getLastWinningNum() + "]";
	}


	

}
