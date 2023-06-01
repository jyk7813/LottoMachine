package database;
import java.util.LinkedHashMap;
import java.util.Map;



public class PaymentNumData {
	//나의결제 개수의 Key값,선택번호와 자동인지확인하는 번호인 [] value값
	 Map<Integer, PaymentNum> paymentMap = new LinkedHashMap<>();
	 
	
	/**
	 * 외부로부터 보호하면서 읽기전용으로 접근만 가능함
	 * 작성자 : 강청운 버전 : 1.0.0
	 * @return
	 */
	public Map<Integer, PaymentNum> getPaymentMap(){
		return new LinkedHashMap<>(paymentMap);
		
	}
	//선택번호value값 [i] return
	
	
	//각 위치에 있는 취소버튼으로 remove 적용하기
	//  수정 인트값 받기
	public void allRemove(Integer key) {
		paymentMap.remove(key);
		//각 위치해 있는 취소버튼으로 값을 넣으면 됨
		
	}
	
	public void clearData() {
		paymentMap.clear();
	}

	//로또개수만큼 계산
	


	public void addMap(Integer key, PaymentNum paymentNum) {
		paymentMap.put(key, paymentNum);
		
	}


	@Override
	public String toString() {
		return "PaymentNumData [paymentMap=" + paymentMap + "]";
	}
	
	
}

