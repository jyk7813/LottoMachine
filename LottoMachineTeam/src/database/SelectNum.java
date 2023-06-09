package database;
import java.util.Collection;

public class SelectNum {
	private Collection<Integer> selectNum;
	private int isAuto;
	
	public SelectNum(Collection<Integer> selectNum, int isAuto) {
		this.selectNum = selectNum;
		this.isAuto = isAuto;	
	}
	
	/**
	 * 선택한 로또 번호 호출
	 * 작성자 : 장명근 버젼 : 1.0.0
	 * @return 로또 번호 6개의 배열
	 */
	public Collection<Integer> getSelectNum() {
		return selectNum;
	}
	
	/**
	 * 자동 모드 판별(1 : 자동, 2: 반자동, 3: 수동)
	 * 작성자 : 장명근 버젼 : 1.0.0
	 * @return 선택한 번호에 따른 모드
	 */
	public int getIsAuto() {
		return isAuto;
	}
	public SelectNum() {
		
	}
	@Override
	public String toString() {
		return "SelectNum [selectNum=" + selectNum + ", isAuto=" + isAuto + "]";
	}

	public int getAutoValue() {
		// TODO Auto-generated method stub
		return isAuto;
	}	
	public Integer[] convertToArray(Collection<Integer> collection) {
	    Integer[] array = new Integer[collection.size()];
	    int index = 0;
	    for (Integer num : collection) {
	        array[index] = num;
	        index++;
	    }
	    return array;
	}

	public Integer[] getSelectNumArray() {
	    return convertToArray(selectNum);
	}

	
}
