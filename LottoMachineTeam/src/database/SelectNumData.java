package database;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
	
	public void removeSelectNumHashMAp(int key) {
		selectNumHashMap.remove(key);
	}

	public Set<Integer> getKey() {
		return selectNumHashMap.keySet();
	}
	public void clearMap() {
		selectNumHashMap.clear();
	}
	
	public int getLastKey() {
	    TreeSet<Integer> SelectNumKeySet = new TreeSet<>(getKey());
	    // TreeSet이 비어있지 않다면 가장 마지막 값을 반환하고, 그렇지 않다면 -1을 반환
	    return !SelectNumKeySet.isEmpty() ? SelectNumKeySet.last() : -1;
	}
	public SelectNum getLastMap() {
		return selectNumHashMap.get(getLastKey());
	}
	public SelectNum getSelectNum(int key) {
		return selectNumHashMap.get(key);
	}

	@Override
	public String toString() {
		return "SelectNumData [selectNumHashMap=" + selectNumHashMap + "]";
	}
	/**
	 * 계산시 count 수 만큼 연산하기
	 * @return
	 */
	public int getCount() {
		return count;
	}
}
