package database;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SelectNumData {
	private Map<Integer, SelectNum> selectNumHashMap;
	private static Integer count = 0;
	
	
	public SelectNumData() {
		this.selectNumHashMap = new HashMap();
	}

	public void addSelectNumHashMap(Collection<Integer> selNum, int autoValue) {
		count++;
		SelectNum selectNum = new SelectNum(selNum, autoValue);
		selectNumHashMap.put(count, selectNum);
	}

	public Map<Integer, SelectNum> getSelectNumHashMap() {
		return selectNumHashMap;
	}
	
//	/**
//	 * 추가하기
//	 * @param idx
//	 * @param selNum
//	 * @return 추가 여부 : 되었으면 true 안 되었으면 false
//	 */
//	public boolean addMap(int idx, SelectNum selNum) {
//		Integer i = new Integer(idx);
//		if (selectNumHashMap.size() < 10) {
//			selectNumHashMap.put(i, selNum);
//			return true;
//		} else {
//			return false;
//		}		
//	}
//	/**
//	 * 제거하기
//	 * @param idx
//	 */
//	public void cancleMap(int idx) {
//		Integer i = new Integer(idx);
//		selectNumHashMap.remove(i);
//	}
	
	public int getKey(Integer key) {
		return key;
	}
}
