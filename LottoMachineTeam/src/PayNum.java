import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JButton;

public class PayNum {
	
//나의결제 개수의 Key값,선택번호와 자동인지확인하는 번호인 [] value값
	private Map<Integer, Payment> paymentMap = new LinkedHashMap<>();
	
	/**
	 * 외부로부터 보호하면서 읽기전용으로 접근만 가능함
	 * 작성자 : 강청운 버전 : 1.0.0
	 * @return
	 */
	public Map<Integer, Payment> getPaymentMap(){
		
		return new LinkedHashMap<>(paymentMap);
		
	}
	//선택번호value값 [i] return
	public Integer[] getSelectNum() {
		Payment selectNum = new Payment();
		Integer[] allElements = new Integer[selectNum.getSelectNum().length];
		for(int i = 0; i < selectNum.getSelectNum().length; i++) {
			allElements[i] = selectNum.getSelectNum()[i];
		}
		return allElements;
	}
	
	//각 위치에 있는 취소버튼으로 remove 적용하기
	public void allRemove() {
		MainFrame callBtn = new MainFrame();
		JButton cancleBtn = callBtn.getBtn();
		paymentMap.remove(cancleBtn);
		//각 위치해 있는 취소버튼으로 값을 넣으면 됨
		
	}
}