package database;

import java.util.Arrays;

public class PaymentNum {
	Integer[] paymentNum;
	int autoStat;
	
	public PaymentNum(Integer[] array, int autoValue) {
		this.paymentNum = array;
		this.autoStat = autoValue;
	}
	public Integer[] getPaymentNum() {
		return paymentNum;
	}
	public int getAutoStat() {
		return autoStat;
	}
	@Override
	public String toString() {
		return "PaymentNum [selectNum=" + Arrays.toString(paymentNum) + ", autoStat=" + autoStat + "]";
	}
	
}
