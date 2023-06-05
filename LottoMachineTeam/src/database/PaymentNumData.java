package database;
import java.util.Collection;
import java.util.HashSet;

public class PaymentNumData {
	//나의결제 개수의 Key값,선택번호와 자동인지확인하는 번호인 [] value값
	Collection<PaymentNum> paymentset = new HashSet<>();
	 private final static int MAX_SIZE = 10;
	
	/**
	 * 외부로부터 보호하면서 읽기전용으로 접근만 가능함
	 * 작성자 : 강청운 버전 : 1.0.0
	 * @return
	 */
	public Collection<PaymentNum> getPaymentData(){
		return paymentset;
		
	}
	//선택번호value값 [i] return
	
	
	//각 위치에 있는 취소버튼으로 remove 적용하기
	//  수정 인트값 받기
	
	public void clearData() {
		paymentset.clear();
	}

	//로또개수만큼 계산

	public void addSet(PaymentNum paymentNum) {
		if (paymentset.size()<MAX_SIZE) {
			paymentset.add(paymentNum);
		} else {
			System.out.println("더 이상 추가할 수 없습니다.");
		}
	}
	
	public int getSize() {
		return paymentset.size();
	}
	
	@Override
	public String toString() {
		return "PaymentNumData [paymentset=" + paymentset + "]";
	}
	
}

