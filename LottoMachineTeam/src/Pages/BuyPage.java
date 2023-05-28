package Pages;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;

public class BuyPage extends JFrame {

	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyPage frame = new BuyPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		// 이미지 아이콘 로드
		ImageIcon buyPageIcon = new ImageIcon(getClass().getClassLoader().getResource("buy(BG).png"));
		ImageIcon initBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("initButten.png"));
		ImageIcon autoBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("autoBtn.png"));
		ImageIcon addBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("addBtn.png"));
		ImageIcon longBuyBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
		ImageIcon emptyIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
		ImageIcon moreIcon = new ImageIcon(getClass().getClassLoader().getResource("moreBtn.png"));
		ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
		ImageIcon cancleIcon = new ImageIcon(getClass().getClassLoader().getResource("cancleBtn.png"));
		ImageIcon[] numIcon = new ImageIcon[45];
		for (int i = 0; i < numIcon.length; i++) {
			String filename = "LC" + (i + 1) + ".png";
			numIcon[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}

		// 이미지 아이콘을 사용하는 레이블 생성
		JLabel label = new JLabel(buyPageIcon);
		JLabel[] selectEmptyJLabels = new JLabel[6];
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i] = new JLabel(emptyIcon);
		}

		// 버튼 생성
		JButton resetButton = new JButton(initBtnIcon);
		resetButton.setBounds(40, 523, 80, 37); // 위치와 크기 설정
		JButton autoButton = new JButton(autoBtnIcon);
		autoButton.setBounds(140, 523, 80, 37);
		JButton addButton = new JButton(addBtnIcon);
		addButton.setBounds(240, 523, 152, 36);
		JButton lbuyButton = new JButton(longBuyBtnIcon);
		lbuyButton.setBounds(90, 815, 251, 41);
		JButton moreButton = new JButton(moreIcon);
		moreButton.setBounds(195, 740, 40, 45);
		JButton backButton = new JButton(backIcon);
		backButton.setBounds(20, 42, 33, 38);
		JButton cancleButton = new JButton(cancleIcon);
		cancleButton.setBounds(356, 682, 52, 36);
		JToggleButton[] empty = new JToggleButton[45];
		// JLayeredPane 생성 및 설정
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(buyPageIcon.getIconWidth(), buyPageIcon.getIconHeight()));

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, buyPageIcon.getIconWidth(), buyPageIcon.getIconHeight());
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i].setBounds(52 + i * 50, 680, 40, 40);

		}

		// 레이블 및 버튼을 JLayeredPane에 추가
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
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
		for (int i = 0; i < empty.length; i++) {
			empty[i] = new JToggleButton();
			empty[i].setBounds(39 + (i % 7) * 52, 142 + count * 52, 40, 40);
			layeredPane.add(empty[i], new Integer(2));
			if (i % 7 == 6) {
				count++;
			}
			empty[i].setOpaque(false);
			empty[i].setContentAreaFilled(false);
			empty[i].setBorderPainted(false);
		}

		for (int i = 0; i < empty.length; i++) {
			empty[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < empty.length; j++) {
						if (empty[j].isSelected()) {
							empty[j].setIcon(numIcon[j]);
						} else {
							empty[j].setIcon(null);
						}

					}
				}
			});
		}

		resetButton.setOpaque(false);
		resetButton.setContentAreaFilled(false);
		resetButton.setBorderPainted(false);
		autoButton.setOpaque(false);
		autoButton.setContentAreaFilled(false);
		autoButton.setBorderPainted(false);
		addButton.setOpaque(false);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		lbuyButton.setOpaque(false);
		lbuyButton.setContentAreaFilled(false);
		lbuyButton.setBorderPainted(false);
		moreButton.setOpaque(false);
		moreButton.setContentAreaFilled(false);
		moreButton.setBorderPainted(false);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		cancleButton.setOpaque(false);
		cancleButton.setContentAreaFilled(false);
		cancleButton.setBorderPainted(false);

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
		pack();
	}
}
