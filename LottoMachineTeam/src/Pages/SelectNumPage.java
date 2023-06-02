package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import database.SelectNum;
import database.SelectNumData;
import utility.IconData;
import utility.Utility;

public class SelectNumPage extends JDialog {

	SelectNumData selectNumHashMap = new SelectNumData();
	private JLabel[][] numLabels;
	private Utility utility = new Utility();
	private JLabel[] keyLabels;
	private int isAuto;
	public static final int AUTO = 1;
	public static final int SEMIAUTO = 2;
	public static final int MANUAL = 3;
	public static final SelectNumData SELECT_NUM_DATA = new SelectNumData();
	private List<Integer> selectList;
	private IconData iconData = new IconData();
	public BuyPage buyPage = new BuyPage();
	
	private void iconChange() {
		Map<Integer, SelectNum> map = BuyPage.SELECT_NUM_DATA.getSelectNumHashMap();
	      Set<Integer> set = map.keySet();
	      Iterator<Integer> hh = set.iterator();
	      int num2 = 0;
	      while (hh.hasNext()) {
	         Collection<Integer> selNum = map.get(hh.next()).getSelectNum();
	         Iterator<Integer> hhh = selNum.iterator();
	         int num = 0;
	         while (hhh.hasNext()) {
	            Integer putNum = hhh.next();
	            
	            numLabels[num][num2].setIcon(iconData.LCIcons()[putNum]);
	            num++;
	         }
	         num2++;
	      }		
	}
	
	/**
	 * Create the frame.
	 */
	public SelectNumPage() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false); // 창 크기 변경을 비활성화

		// 이미지 아이콘 로드
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("selectNum(BG).png"));
		ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
		ImageIcon buyIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
		ImageIcon numIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
		ImageIcon cancleBtn = new ImageIcon(getClass().getClassLoader().getResource("cancleBtn.png"));

		numLabels = new JLabel[6][10];
		keyLabels = new JLabel[10];
		JButton[] cancelButton = new JButton[10];
		Map<Integer, SelectNum> map;
		map = selectNumHashMap.getSelectNumHashMap();
		// 이미지 아이콘을 사용하는 레이블 생성
		JLabel label = new JLabel(icon); // 배경 Label

		for (int i = 0; i < numLabels.length; i++) { // 로또 번호 저장 Label
			for (int j = 0; j < numLabels[i].length; j++) {
				numLabels[i][j] = new JLabel();
			}
		}

		for (int i = 0; i < keyLabels.length; i++) { // key 저장 Label
			keyLabels[i] = new JLabel();

		}

		// 버튼 생성
		JButton backButton = new JButton(backIcon);
		backButton.setBounds(20, 41, 33, 38); // 위치와 크기 설정

		JButton buyButton = new JButton(buyIcon);
		buyButton.setBounds(90, 815, 251, 41); // 위치와 크기 설정

		for (int i = 0; i < cancelButton.length; i++) {
			cancelButton[i] = new JButton(cancleBtn);
		}

		for (int i = 0; i < cancelButton.length; i++) {
			cancelButton[i].setBounds(356, 119 + i * 70, 52, 36);
		}

		// JLayeredPane 생성 및 설정
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(430, 890)); // JLayeredPane의 크기 설정

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 배경 위치

		for (int i = 0; i < numLabels.length; i++) { // 로또 번호 저장소 위치
			for (int j = 0; j < numLabels[i].length; j++) {
				numLabels[i][j].setBounds(52 + i * 50, 117 + j * 70, 40, 40);
			}
		}

		for (int i = 0; i < numLabels.length; i++) {
			for (int j = 0; j < numLabels[i].length; j++) {
				layeredPane.add(numLabels[i][j], new Integer(2)); // 레이블은 앞쪽에 레이어에 추가
			}
		}

		for (int i = 0; i < keyLabels.length; i++) {
			keyLabels[i].setBounds(10, 117 + i * 70, 40, 40);
		}
		keyLabels[0].setText("1");
		keyLabels[1].setText("2");
		keyLabels[2].setText("3");
		keyLabels[3].setText("4");
		keyLabels[4].setText("5");
		keyLabels[5].setText("6");
		keyLabels[6].setText("7");
		keyLabels[7].setText("8");
		keyLabels[8].setText("9");
		keyLabels[9].setText("10");

		for (int i = 0; i < keyLabels.length; i++) {
			layeredPane.add(keyLabels[i], new Integer(2));
		}

		for (int i = 0; i < cancelButton.length; i++) {
			layeredPane.add(cancelButton[i], new Integer(2));
		}
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
		layeredPane.add(backButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);

		// 버튼숨기기
		utility.setButtonProperties(backButton);
		utility.setButtonProperties(buyButton);
		for (int i = 0; i < cancelButton.length; i++) {
			utility.setButtonProperties(cancelButton[i]);
		}

		// 버튼 ActionListener
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				BuyPage buyPage = new BuyPage();
				buyPage.setVisible(true);
				buyPage.setAlwaysOnTop(true);
				
			}
		});
		iconChange();

		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCheckPage buyCheckPage = new BuyCheckPage();
				dispose();

				buyCheckPage.setAlwaysOnTop(true);
				buyCheckPage.setVisible(true);

			}
		});
		pack();
		for (int i = 0; i < cancelButton.length; i++) {
			cancelButton[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					BuyPage.SELECT_NUM_DATA.getSelectNumHashMap();
				}
			});
		}
		
		for (int i = 0; i < cancelButton.length; i++) {
			cancelButton[i].addActionListener(new ActionListener() {
				Map<Integer, SelectNum> map = buyPage.SELECT_NUM_DATA.getSelectNumHashMap();
				Set<Integer> set = map.keySet();
				Iterator<Integer> bringKey = set.iterator();
				@Override
				public void actionPerformed(ActionEvent e) {
					while (bringKey.hasNext()) {
						Integer change = bringKey.next();
						map.remove(change);
						System.out.println(SELECT_NUM_DATA);
					}
					
				}
			});
		}
	}

	// 자동 여부
	public int autoStat() {
		if (isAuto == AUTO)
			return AUTO;
		if (isAuto == SEMIAUTO)
			return SEMIAUTO;
		if (isAuto == MANUAL)
			return MANUAL;
		return -1;
	}
	
}
