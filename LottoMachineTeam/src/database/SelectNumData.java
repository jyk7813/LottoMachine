package database;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Pages.BuyErrorPage;
import Pages.BuyLimitPage;
import Pages.BuyPage;

public class SelectNumData {
	private List<SelectNum> selectNumList;
	private static final int MAX_SELECT_NUM_SIZE = 10;
	PaymentNumData paymentNumData = new PaymentNumData();
	
	public SelectNumData() {
		this.selectNumList = new ArrayList<SelectNum>();
	}

	public void addSelectNum(Collection<Integer> selNum, int autoValue) {
		if (selectNumList.size()+BuyPage.PAYMENT_NUM_DATA.getSize()<MAX_SELECT_NUM_SIZE) {
			SelectNum selectNum = new SelectNum(selNum, autoValue);
			selectNumList.add(selectNum);
		}else {
			System.out.println("데이터를 더이상 저장할 수 없습니다.");
			
			BuyLimitPage buyLimitPage = new BuyLimitPage();
			buyLimitPage.setAlwaysOnTop(true);
			buyLimitPage.setVisible(true);
		}
	}

	public List<SelectNum> getSelectNumData() {
		return selectNumList;
	}
	
	public void removeSelectNumData(int key) {
		selectNumList.remove(key);
	}

	
	public void clearList() {
		selectNumList.clear();
	}
	
	public int getLastIndex() {
	    return !selectNumList.isEmpty() ? selectNumList.size()-1 : -1;
	}
	public SelectNum getLastSelectNum() {
		if (getLastIndex()==-1) {
			return null;
		}
		return selectNumList.get(getLastIndex());
	}
	public SelectNum getSelectNum(int index) {
		if (selectNumList.size()-1<index) {
			return null;
		}
		return selectNumList.get(index);
	}

	@Override
	public String toString() {
		return "SelectNumData [selectNumHashMap=" + selectNumList + "]";
	}
	/**
	 * 계산시 count 수 만큼 연산하기
	 * @return
	 */
	
}
