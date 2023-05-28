package database;
import java.util.HashMap;
import java.util.Map;

public class SelectNumHashMap {
	private Map<Integer, SelectNum> selectNumHashMap;

	
	public SelectNumHashMap() {
		this.selectNumHashMap = new HashMap();
	}

	public Map<Integer, SelectNum> getSelectNumHashMap() {
		return selectNumHashMap;
	}
	
	/**
	 * 추가하기
	 * @param idx
	 * @param selNum
	 * @return 추가 여부 : 되었으면 true 안 되었으면 false
	 */
	public boolean addMap(int idx, SelectNum selNum) {
		Integer i = new Integer(idx);
		if (selectNumHashMap.size() < 10) {
			selectNumHashMap.put(i, selNum);
			return true;
		} else {
			return false;
		}		
	}
	/**
	 * 제거하기
	 * @param idx
	 */
	public void cancleMap(int idx) {
		Integer i = new Integer(idx);
		selectNumHashMap.remove(i);
	}
}
