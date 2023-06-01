package database;

import java.util.Arrays;

public class PaymentNum {
	Integer[] selectNum;
	int autoStat;
	SelectNumData numData;
	
	public PaymentNum(Integer[] array, int autoValue) {
		this.selectNum = array;
		this.autoStat = autoValue;
	}
	public Integer[] getSelectNum() {
		return selectNum;
	}
	public int getAutoStat() {
		return autoStat;
	}

	public SelectNumData getNumberData() {
		return numData;
	}

	@Override
	public String toString() {
		return "PaymentNum [selectNum=" + Arrays.toString(selectNum) + ", autoStat=" + autoStat + "]";
	}

}
