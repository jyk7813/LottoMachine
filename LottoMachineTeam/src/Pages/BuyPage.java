package Pages;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;

public class BuyPage extends JDialog {

	private int count = 0;
	private ImageIcon buyPageIcon;
	private ImageIcon initBtnIcon;
	private ImageIcon autoBtnIcon;
	private ImageIcon addBtnIcon;
	private ImageIcon longBuyBtnIcon;
	private ImageIcon emptyIcon;
	private ImageIcon moreIcon;
	private ImageIcon backIcon;
	private ImageIcon cancleIcon;
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
		layeredPane.setPreferredSize(new Dimension(buyPageIcon.getIconWidth(), buyPageIcon.getIconHeight()));
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
				selectNumPage.setAlwaysOnTop(true);
				selectNumPage.setVisible(true);

			}
		});
	}

	private void autoActionListener() {
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
		label.setBounds(0, 0, buyPageIcon.getIconWidth(), buyPageIcon.getIconHeight());
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i].setBounds(52 + i * 50, 680, 40, 40);

		}

	}

	private void makeButten() {
		resetButton = new JButton(initBtnIcon);
		resetButton.setBounds(40, 523, 80, 37); // 위치와 크기 설정
		autoButton = new JButton(autoBtnIcon);
		autoButton.setBounds(140, 523, 80, 37);
		addButton = new JButton(addBtnIcon);
		addButton.setBounds(240, 523, 152, 36);
		lbuyButton = new JButton(longBuyBtnIcon);
		lbuyButton.setBounds(90, 815, 251, 41);
		moreButton = new JButton(moreIcon);
		moreButton.setBounds(195, 740, 40, 45);
		backButton = new JButton(backIcon);
		backButton.setBounds(20, 42, 33, 38);
		cancleButton = new JButton(cancleIcon);
		cancleButton.setBounds(356, 682, 52, 36);
		selectNum = new JToggleButton[45];

	}

	private void makeLabel() {
		label = new JLabel(buyPageIcon);
		selectEmptyJLabels = new JLabel[6];
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i] = new JLabel(emptyIcon);
		}

	}

	private void makeIcon() {
		buyPageIcon = new ImageIcon(getClass().getClassLoader().getResource("buy(BG).png"));
		initBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("initButten.png"));
		autoBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("autoBtn.png"));
		addBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("addBtn.png"));
		longBuyBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
		emptyIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
		moreIcon = new ImageIcon(getClass().getClassLoader().getResource("moreBtn.png"));
		backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
		cancleIcon = new ImageIcon(getClass().getClassLoader().getResource("cancleBtn.png"));
		numIcons = new ImageIcon[45];
		for (int i = 0; i < numIcons.length; i++) {
			String filename = "LC" + (i + 1) + ".png";
			numIcons[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}

	}

	private void setButtonProperties(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}

	private void removeButtonVisualEffects() {
		setButtonProperties(resetButton);
		setButtonProperties(autoButton);
		setButtonProperties(addButton);
		setButtonProperties(lbuyButton);
		setButtonProperties(moreButton);
		setButtonProperties(backButton);
		setButtonProperties(cancleButton);
	}

}
