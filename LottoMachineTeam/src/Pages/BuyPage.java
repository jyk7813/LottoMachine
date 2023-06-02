package Pages;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.Color;

import database.PaymentNumData;
import database.SelectNumData;
import utility.FontData;
import utility.IconData;
import utility.Utility;

public class BuyPage extends JDialog {
	private IconData icon = new IconData();
	private Utility utility = new Utility();
	private int count = 0;
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
	public static final PaymentNumData PAYMENT_NUM_DATA = new PaymentNumData();
	private FontData fontData = new FontData();
	private int currentCount;

	private JLabel currentCountLabel;
	private JLabel currentPriceLabel;
	private final static int PRICE = 10000;
	private String currentPrice;

	/**
	 * Create the frame.
	 */
	public BuyPage() {
		currentCount = SELECT_NUM_DATA.getSelectNumData().size();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);

		// label만들기
		makeLabel();
		// 버튼만들기
		makeButten();
		layeredPane = new JLayeredPane();
		layeredPane
				.setPreferredSize(new Dimension(icon.buyPageIcon().getIconWidth(), icon.buyPageIcon().getIconHeight()));

		Font customFont = fontData.nanumFont18();
		Font customFontForPrice = fontData.nanumFont18();

		Color customColor = Color.BLACK;
		Color customColorForPrice = Color.WHITE;

		currentCountLabel.setFont(customFont);
		currentPriceLabel.setFont(customFontForPrice);

		currentCountLabel.setForeground(customColor);
		currentPriceLabel.setForeground(customColorForPrice);

		currentCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
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

		// 로또개수와 가격표시
		showCurrentCountPrice();
		// 추가하기버튼 액션메소드
		addBtnAction();

		if (SELECT_NUM_DATA.getLastIndex() != -1) {
			showSelectNum();
		}

		lbuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (SELECT_NUM_DATA.getSelectNumData().size()!=0) {
					BuyCheckPage buyCheckPage = new BuyCheckPage();
					dispose();
					buyCheckPage.setAlwaysOnTop(true);
					buyCheckPage.setVisible(true);
					
				}

			}
		});
		cancleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = SELECT_NUM_DATA.getLastIndex();
				SELECT_NUM_DATA.removeSelectNumData(index);
				showSelectNum();
				showCurrentCountPrice();
			}
		});

		pack();
	}

	private void showSelectNum() {
		if (SELECT_NUM_DATA.getLastSelectNum() == null) {
			for (int i = 0; i < selectEmptyJLabels.length; i++) {
				selectEmptyJLabels[i].setIcon(null);
			}
		} else {
			List<Integer> sortedList = (List<Integer>) SELECT_NUM_DATA.getLastSelectNum().getSelectNum();
			Collections.sort(sortedList);
			System.out.println(sortedList);
			for (int i = 0; i < sortedList.size(); i++) {
				int element = sortedList.get(i);
				selectEmptyJLabels[i].setIcon(icon.LCIcons()[element]);
			}
		}

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
				if (selectedCount.get() == 6) {
					for (JToggleButton toggleButton : selectNum) {
						toggleButton.setSelected(false);
						toggleButton.setIcon(null); // 선택이 해제되었으므로 아이콘도 초기화합니다.
					}
					// 선택한 버튼 수도 초기화해야 합니다.
					selectedCount.set(0);
					autoCount = 0;
				}
				int[] num = new int[6 - selectedCount.get()];
				int i = 0;
				autoCount = 0;
				while (i < num.length) {
					int randomNum = random.nextInt(45);
					if (!selectNum[randomNum].isSelected()) {
						selectNum[randomNum].setSelected(true);
						selectNum[randomNum].setIcon(icon.LCIcons()[randomNum]);
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
				autoCount = 0;
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
						btn.setIcon(icon.LCIcons()[i]);
					} else {
						btn.setSelected(false);
					}
				} else {
					selectedCount.decrementAndGet();
					btn.setIcon(null);
					autoCount--;
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
		layeredPane.add(currentCountLabel, new Integer(3));
		layeredPane.add(currentPriceLabel, new Integer(3));

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
			currentCountLabel.setBounds(105, 13, 100, 100);
			currentPriceLabel.setBounds(250, 13, 125, 100);

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
		currentCountLabel = new JLabel(currentCount + "개");
		currentPriceLabel = new JLabel(currentPrice + " 원");

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

	private void showCurrentCountPrice() {
		currentCount = SELECT_NUM_DATA.getSelectNumData().size();
		currentCountLabel.setText(currentCount + "개");
		currentPriceLabel.setText(currentCount * PRICE + "원");
	}

	public void addBtnAction() {
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedCount.get() == 6) {
					List<Integer> selectList = new ArrayList<>();
					for (int i = 0; i < selectNum.length; i++) {
						if (selectNum[i].isSelected()) {
							selectList.add(i);
						}
					}
					autoCountCheck();

					BuyPage.SELECT_NUM_DATA.addSelectNum(selectList, isAuto);
					showSelectNum();
					showCurrentCountPrice();
				}
			}

			private void autoCountCheck() {
				if (autoCount == 6)
					isAuto = 1;
				if (0 < autoCount && autoCount < 6)
					isAuto = 2;
				if (autoCount == 0)
					isAuto = 3;

			}

		});
	}

}
