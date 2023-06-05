// 해야할 것
// 언더로터리에서 숫자 다 만들어지면 바로 위닝넘 페이지로 넘겨주기
// 넘겨주는 과정에서 셋을 리스트로 바꾼다음 위닝넘으로 넘겨줘야 한다.
// 맵에 넘기면은 숫자 체크를 할 수 있도록 맵 키를 만들고 (보너스넘이랑 리스트랑 맵에 넘겨줘야한다)

package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import database.PaymentNum;
import utility.IconData;
import utility.Utility;

public class WinningNumPage extends JDialog {
	private IconData iconData = new IconData();
	private JLayeredPane layeredPane;
	private Utility utility = new Utility();
	private JLabel label;
	private JLabel bonusNum;
	private JLabel[][] lottoNums;
	private JLabel[] lottoAutos;
	private JLabel[] winnerNums;
	private JLabel[] rankingLabels;
	private JButton backBtn;
	private boolean secondCheck;

	/**
	 * Create the frame.
	 */
	public WinningNumPage() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false); // 창 크기 변경을 비활성화

		label = new JLabel(iconData.winningNumIcon());

		lottoNums = new JLabel[8][10];
		lottoAutos = new JLabel[10];
		winnerNums = new JLabel[10];
		rankingLabels = new JLabel[10];

		bonusNum = new JLabel();
		bonusNum.setBounds(357, 225, 40, 40);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(
				new Dimension(iconData.winningNumIcon().getIconWidth(), iconData.winningNumIcon().getIconHeight()));

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 6; i++) {
				lottoNums[i][j] = new JLabel();

				lottoNums[i][j].setBounds(71 + i * 44, 340 + j * 50, 36, 36);
				layeredPane.add(lottoNums[i][j], new Integer(2));
			}
		}

		for (int i = 0; i < lottoAutos.length; i++) {
			lottoAutos[i] = new JLabel();
			lottoAutos[i].setBounds(337, 340 + i * 50, 52, 36);
			layeredPane.add(lottoAutos[i], new Integer(2));
		}

		for (int i = 0; i < winnerNums.length; i++) {
			winnerNums[i] = new JLabel();
			winnerNums[i].setBounds(33 + (i * 50), 225, 40, 40);
			layeredPane.add(winnerNums[i], new Integer(2));
		}

		for (int i = 0; i < rankingLabels.length; i++) {
			rankingLabels[i] = new JLabel();
			rankingLabels[i].setBounds(25, 338 + (i * 50), 375, 50);
			layeredPane.add(rankingLabels[i], new Integer(2));
		}

		backBtn = new JButton(iconData.backIcon());
		backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, iconData.winningNumIcon().getIconWidth(), iconData.winningNumIcon().getIconHeight());

		// 레이블 및 버튼을 JLayeredPane에 추가
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
		layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(bonusNum, new Integer(2));

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
		showWinningNum();

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		checkRank();
		showPaymentNum();
		pack();

		utility.setButtonProperties(backBtn);

	}

	private void showWinningNum() {
		System.out.println("진입");
		Collection<Integer> set = MainPage.WINNING_NUM_DATA.getLastWinningNum().getWinningNum();
		List<Integer> sortedList = new ArrayList<>(set);
		Collections.sort(sortedList);
		System.out.println("winningNum : " + sortedList);

		for (int i = 0; i < sortedList.size(); i++) {
			int element = sortedList.get(i);
			winnerNums[i].setIcon(iconData.LCIcons()[element]);
		}
		bonusNum.setIcon(iconData.LCIcons()[MainPage.WINNING_NUM_DATA.getLastWinningNum().getBonusNum()]);

	}
	

	private void showPaymentNum() {
		System.out.println("진입 showPaymentNum ");
		Set<PaymentNum> set = new HashSet(BuyPage.PAYMENT_NUM_DATA.getPaymentData());
		Iterator<PaymentNum> iterator = set.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			PaymentNum paymentNum = (PaymentNum) iterator.next();
			int rank = getRank(paymentNum);
			System.out.println(paymentNum);
			int numCount = 0;
			for (Integer integer : paymentNum.getNum()) {
				if (MainPage.WINNING_NUM_DATA.getLastWinningNum().getWinningNum().contains(integer)) {
	                lottoNums[numCount][count].setIcon(iconData.SCIcons()[integer]);
	            } else {
	                lottoNums[numCount][count].setIcon(iconData.SIcons()[integer]);
	            }
				if (rank == 2 && MainPage.WINNING_NUM_DATA.getLastWinningNum().getBonusNum() == integer) {
					   lottoNums[numCount][count].setIcon(iconData.SCIcons()[integer]);
				}
				numCount++;
			}
			if (paymentNum.getAutoStat() == 1) {
				lottoAutos[count].setIcon(iconData.autoIcon());
			}
			if (paymentNum.getAutoStat() == 2) {
				lottoAutos[count].setIcon(iconData.semiAutoIcon());
			}
			if (paymentNum.getAutoStat() == 3) {
				lottoAutos[count].setIcon(iconData.manualIcon());
			}
			count++;
		}

	}

	private void checkRank() {
		System.out.println("진입 checkRank ");
		Set<PaymentNum> set = new HashSet(BuyPage.PAYMENT_NUM_DATA.getPaymentData());
		Iterator<PaymentNum> iterator = set.iterator();
		int count = 0;
		
		while (iterator.hasNext()) {
			PaymentNum paymentNum = (PaymentNum) iterator.next();
			if (isFirstPlace(paymentNum)) {
				System.out.println("1등 확인?");
				rankingLabels[count].setIcon(iconData.rankingIcon1());
			} else {
				int rank = getRank(paymentNum);
				if (rank == 2) {
					System.out.println("2등 확인?");
					rankingLabels[count].setIcon(iconData.rankingIcon2());
				} else if (rank == 3) {
					System.out.println("3등 확인?");
					rankingLabels[count].setIcon(iconData.rankingIcon3());
				} else if (rank == 4) {
					System.out.println("4등 확인?");
					rankingLabels[count].setIcon(iconData.rankingIcon4());
				} else if (rank == 5) {
					System.out.println("5등 확인?");
					rankingLabels[count].setIcon(iconData.rankingIcon5());
				} else {
					System.out.println("낙첨");
					rankingLabels[count].setIcon(iconData.rankingIconFail());
				}
			}
			count++;
		}
		
	}

	private boolean isFirstPlace(PaymentNum paymentNum) {
		Collection<Integer> winningNum = MainPage.WINNING_NUM_DATA.getLastWinningNum().getWinningNum();
		return winningNum.containsAll(paymentNum.getPaymentNumCollection());
	}

	private int getRank(PaymentNum paymentNum) {
		Collection<Integer> winningNum = MainPage.WINNING_NUM_DATA.getLastWinningNum().getWinningNum();
		int matchCount = 0;
		for (Integer num : paymentNum.getPaymentNumCollection()) {
			if (winningNum.contains(num)) {
				matchCount++;
			}
		}
		if (matchCount == 6) {
			return 1; // 1등
		} else if (matchCount == 5) {
			int bonusNum = MainPage.WINNING_NUM_DATA.getLastWinningNum().getBonusNum();
			if (paymentNum.getPaymentNumCollection().contains(bonusNum)) {
				return 2; // 2등
			} else {
				return 3; // 3등
			}
		} else if (matchCount == 4) {
			return 4; // 기타 등수
		} else if (matchCount == 3) {
			return 5;
		} else {
			return 6;
		}
	}

}