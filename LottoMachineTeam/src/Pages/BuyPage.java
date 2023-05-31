package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;

import database.SelectNumData;
import utility.IconData;
import utility.Utility;

public class BuyPage extends JDialog {
	private IconData icon = new IconData();
	private Utility utility = new Utility();
	private int count = 0;
	private ImageIcon[] numIcons;
	private JLabel label;
	private JLabel[] selectEmptyJLabels;
	private JButton resetButton;
	private JButton autoButton;
	private JButton addButton;
	private JButton lbuyButton;
	private JButton moreButton;
	private JButton backButton;
	private JButton cancleButton;
	private JToggleButton[] selectNum;
	private JLayeredPane layeredPane;
	private int maxSelected;
	private AtomicInteger selectedCount;
	private Random random = new Random();
	private int autoCount;
	private int isAuto;
	public static final SelectNumData SELECT_NUM_DATA = new SelectNumData(); 	 

	/**
	 * Create the frame.
	 */
	public BuyPage() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		// 아이콘 세팅
		makeIcon();
		// label만들기
		makeLabel();
		// 버튼만들기
		makeButten();
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(icon.buyPageIcon().getIconWidth(), icon.buyPageIcon().getIconHeight()));
		// 레이블 및 버튼 위치 설정
		labelBounds();
		// 레이블 및 버튼을 JLayeredPane에 추가
		addLableAndBtn();
		// 숫자 선택개수 6개 제한
		maxSelect();
		// 버튼 안보이게 하기
		removeButtonVisualEffects();
		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);

		resetActionListener();
		autoActionListener();
		moreActionListener();
		backActionListener();
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Integer> selectList = new ArrayList<Integer>();
				for (int i = 0; i < selectNum.length; i++) {
					if (selectNum[i].isSelected()) {
						selectList.add(i + 1);
					}
				}
				System.out.println(selectList);
				if (autoCount==6) isAuto = 1;
				if (0<autoCount&&autoCount<6) isAuto = 2;
				if (autoCount==0) isAuto = 3;
				
				SELECT_NUM_DATA.getLastKey();
			}
		});
		lbuyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCheckPage buyCheckPage = new BuyCheckPage();
				dispose();
				buyCheckPage.setAlwaysOnTop(true);
				buyCheckPage.setVisible(true);
				
			}
		});
		
		pack();
	}

	private void backActionListener() {
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});		
	}

	private void moreActionListener() {
		moreButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SelectNumPage selectNumPage = new SelectNumPage();
				setVisible(false);
				selectNumPage.setAlwaysOnTop(true);
				selectNumPage.setVisible(true);

			}
		});
	}

	public void autoActionListener() {
		autoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] num = new int[6 - selectedCount.get()];
				int i = 0;
				autoCount = 0;
				while (i < num.length) {
					int randomNum = random.nextInt(45);
					if (!selectNum[randomNum].isSelected()) {
						selectNum[randomNum].setSelected(true);
						selectNum[randomNum].setIcon(numIcons[randomNum]);
						selectedCount.incrementAndGet();
						i++;
						autoCount++;
					}
				}
			}
		});

	}

	private void resetActionListener() {
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton toggleButton : selectNum) {
					toggleButton.setSelected(false);
					toggleButton.setIcon(null); // 선택이 해제되었으므로 아이콘도 초기화합니다.
				}
				// 선택한 버튼 수도 초기화해야 합니다.
				selectedCount.set(0);
			}
		});

	}

	private void maxSelect() {
		maxSelected = 6;
		selectedCount = new AtomicInteger(0);

		IntStream.range(0, selectNum.length).forEach(i -> {
			selectNum[i].addActionListener(e -> {
				JToggleButton btn = (JToggleButton) e.getSource();
				if (btn.isSelected()) {
					if (selectedCount.get() < maxSelected) {
						selectedCount.incrementAndGet();
						btn.setIcon(numIcons[i]);
					} else {
						btn.setSelected(false);
					}
				} else {
					selectedCount.decrementAndGet();
					btn.setIcon(null);
				}
			});
		});

	}

	private void addLableAndBtn() {
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가a

		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			layeredPane.add(selectEmptyJLabels[i], new Integer(2));
		}

		layeredPane.add(resetButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(autoButton, new Integer(2));
		layeredPane.add(addButton, new Integer(2));
		layeredPane.add(lbuyButton, new Integer(2));
		layeredPane.add(moreButton, new Integer(2));
		layeredPane.add(backButton, new Integer(2));
		layeredPane.add(cancleButton, new Integer(2));

		for (int i = 0; i < selectNum.length; i++) {
			selectNum[i] = new JToggleButton();
			selectNum[i].setBounds(39 + (i % 7) * 52, 142 + count * 52, 40, 40);
			selectNum[i].setOpaque(false);
			selectNum[i].setContentAreaFilled(false);
			selectNum[i].setBorderPainted(false);
			layeredPane.add(selectNum[i], new Integer(2));
			if (i % 7 == 6) {
				count++;
			}
		}

	}

	private void labelBounds() {
		label.setBounds(0, 0, icon.buyPageIcon().getIconWidth(), icon.buyPageIcon().getIconHeight());
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i].setBounds(52 + i * 50, 680, 40, 40);

		}

	}

	private void makeButten() {
		resetButton = new JButton(icon.initBtnIcon());
		resetButton.setBounds(40, 523, 80, 37); // 위치와 크기 설정
		autoButton = new JButton(icon.autoBtnIcon());
		autoButton.setBounds(140, 523, 80, 37);
		addButton = new JButton(icon.addBtnIcon());
		addButton.setBounds(240, 523, 152, 36);
		lbuyButton = new JButton(icon.longBuyBtnIcon());
		lbuyButton.setBounds(90, 815, 251, 41);
		moreButton = new JButton(icon.moreIcon());
		moreButton.setBounds(195, 740, 40, 45);
		backButton = new JButton(icon.backIcon());
		backButton.setBounds(20, 42, 33, 38);
		cancleButton = new JButton(icon.cancleIcon());
		cancleButton.setBounds(356, 682, 52, 36);
		selectNum = new JToggleButton[45];

	}

	private void makeLabel() {
		label = new JLabel(icon.buyPageIcon());
		selectEmptyJLabels = new JLabel[6];
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i] = new JLabel();
		}

	}

	private void makeIcon() {
		
		numIcons = new ImageIcon[45];
		for (int i = 0; i < numIcons.length; i++) {
			String filename = "LC" + (i + 1) + ".png";
			numIcons[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}

	}


	private void removeButtonVisualEffects() {
		utility.setButtonProperties(resetButton);
		utility.setButtonProperties(autoButton);
		utility.setButtonProperties(addButton);
		utility.setButtonProperties(lbuyButton);
		utility.setButtonProperties(moreButton);
		utility.setButtonProperties(backButton);
		utility.setButtonProperties(cancleButton);
	}

}
