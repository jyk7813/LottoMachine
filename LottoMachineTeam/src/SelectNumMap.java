import java.util.LinkedHashMap;

public class SelectNumMap {
	private LinkedHashMap<Integer, SelectNum> selectNumMap;
	
	/**
	 * n번째 추가한 로또 번호 정보 저장
	 * 작성자 : 장명근 버젼 : 1.0.0
	 * @return Map 생성
	 */
	public LinkedHashMap<Integer, SelectNum> getSelectNumMap() {
		return selectNumMap = new LinkedHashMap<>();
	}
	
	/**
	 * Map에 데이터 추가 메서드
	 * 작성자 : 장명근 버젼 : 1.0.0
	 * @param selectNum 내가 선택한 번호 값들을 저장한 class
	 * @return 추가 여부 : 되었으면 true 안 되었으면 false
	 */
	public boolean addLinkedHashMap(SelectNum selectNum) {
		if (selectNumMap.size() < 10) {
			selectNumMap.put(selectNumMap.size() + 1, selectNum);	
			return true;
		} else {
			return false;
		}
	}
	
 
	/**
	 * key 제거 및 map 순서 재배치
	 * 작성자 : 장명근 버젼 : 1.0.0
	 * @param idx LinkedHashMap의 Key값
	 */
	public void cancelData(int idx) {
		Integer i = new Integer(idx);
		selectNumMap.remove(i);
		relocationData(idx);
	}
	
	/**
	 * key을 재배치
	 * 작성자 : 장명근 버젼 : 1.0.0
	 * @param idx LinkedHashMap의 Key값
	 */
	public void relocationData(int idx) {
		Integer i;
		for (int j = idx + 1; j < selectNumMap.size() + 1; j++) {
			i = new Integer(j);
			// 값을 key-1에 넣는다
			selectNumMap.put(j-1, selectNumMap.get(j)); 
			// key를 삭제한다
			selectNumMap.remove(j);
		}
	}
}
