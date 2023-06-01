package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import database.PaymentNumData;
import database.SelectNum;
import database.SelectNumData;
import utility.IconData;
import utility.Utility;

public class MyNumCheckPage extends JDialog {
	private IconData icon = new IconData();
	private JLayeredPane layeredPane;
	private Map<Integer, SelectNum> map;
	private SelectNumData selectNum = new SelectNumData();
	private Utility utility = new Utility();
	private JLabel[][] lottoNum2;
	public static final SelectNum SELECT_NUM_DATA = new SelectNum();

	/**
	 * Create the frame.
	 */
	public MyNumCheckPage() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false); // 창 크기 변경을 비활성화

		// 이미지 아이콘을 사용하는 레이블 생성
		JLabel label = new JLabel(icon.myNumCheckIcon());
		lottoNum2 = new JLabel[8][10];
		// JLabel[][] lottoNum = new JLabel[8][10];
		JLabel[] lottoAuto = new JLabel[10];
		JLabel[] winnerNum = new JLabel[10];

		JLabel bonusNum = new JLabel(icon.emptyBtn());
		bonusNum.setBounds(357, 225, 40, 40);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(
				new Dimension(icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight()));

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 7; i++) {
				if (i == 0) {
					lottoNum2[i][j] = new JLabel();

				} else {
					lottoNum2[i][j] = new JLabel(icon.emptySBtn());

				}
				lottoNum2[i][j].setBounds(28 + i * 44, 340 + j * 50, 36, 36);
				layeredPane.add(lottoNum2[i][j], new Integer(2));

			}
		}
		// 반복문을 종료한 후 선택된 숫자의 이미지를 변경함
		showSelectedNum();
		getChangeNumsImage();

		// 자동 반자동 수동 //할 일 자동 반자동 이미지 수정하기ㅁ
		for (int i = 0; i < 10; i++) {
			lottoAuto[i] = new JLabel(icon.emptyLBtn());
			lottoAuto[i].setBounds(337, 340 + i * 50, 52, 36);
			layeredPane.add(lottoAuto[i], new Integer(2));
		}
		// 당첨된 번호
		for (int i = 0; i < 6; i++) {
			winnerNum[i] = new JLabel(icon.emptyBtn());// 각 배열원소는 라벨이미지
			winnerNum[i].setBounds(33 + (i * 50), 225, 40, 40);// 위치
			layeredPane.add(winnerNum[i], new Integer(2));// 레이어드패널에 추가 각 배열원소
		}

		// 버튼 생성
		JButton backBtn = new JButton(icon.backIcon());
		backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight());

		// 레이블 및 버튼을 JLayeredPane에 추가
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
		layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(bonusNum, new Integer(2));

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
		pack();
		// showSelectedNum();

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		utility.setButtonProperties(backBtn);
	}

//SelectNumMap에 저장된 번호들에 해당하는 lottoNum 배열의 원소에 이미지가 설정됩니다. 
	public void getChangeNumsImage() {
		int j = 0;
		map = selectNum.getSelectNumHashMap();
		for (SelectNum value : map.values()) {
			int i = 0;
			for (Integer integerNum : value.getSelectNum()) {
				int selectedNumbers = integerNum.intValue();
				if (selectedNumbers >= 1 && selectedNumbers <= 45) {
					// for문의 i,j는 0 부터 시작하기 때문에 배열인덱스값 : [선택된 번호 - 1]
					lottoNum2[i + 1][j].setIcon(icon.LCIcons()[selectedNumbers]);
					// icon 은 변경할 이미지파일 넣으면 됩니다.
					break;

				}
				i++;
			}
			j++;
		}
	}

	private void showSelectedNum() {
		int isAuto = 0;
		List<Integer> selectList = new ArrayList<Integer>();
		for (int i = 0; i < lottoNum2.length - 1; i++) {
			selectList.add(i);
		}
		selectNum.addSelectNumHashMap(selectList, isAuto);
		System.out.println(selectNum);
		Collection<Integer> set = SELECT_NUM_DATA.getSelectNum();
		List<Integer> sortedList;
		if (set != null) {
			sortedList = new ArrayList<>(set);
		} else {
			sortedList = new ArrayList<>();
		}

		Collections.sort(sortedList);
		System.out.println(sortedList);
		for (int i = 0; i < sortedList.size(); i++) {
			for (int j = 0; j <= i; j++) {
				int element = sortedList.get(i);
				lottoNum2[i][j].setIcon(icon.LCIcons()[element]);

			}
		}
	}

}
