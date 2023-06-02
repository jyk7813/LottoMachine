package database;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PaymentNum {
	Integer[] Num;
	int autoStat;
	SelectNumData numData;
	
	public PaymentNum(Integer[] array, int autoValue) {
		this.Num = array;
		this.autoStat = autoValue;
	}
	public Integer[] getNum() {
		return Num;
	}
	public int getAutoStat() {
		return autoStat;
	}
	public Collection<Integer> getPaymentNumCollection() {
        return Collections.unmodifiableCollection(Arrays.asList(Num));
    }

	public SelectNumData getNumberData() {
		return numData;
	}

	@Override
	public String toString() {
		return "PaymentNum [paymentNum=" + Arrays.toString(Num) + ", autoStat=" + autoStat + "]";
	}
	public void name() {
		
	}

}
