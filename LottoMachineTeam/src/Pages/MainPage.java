package Pages;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import database.WinningNumData;
import utility.IconData;
import utility.Utility;

public class MainPage extends JFrame {

	private IconData iconData = new IconData();
	private Utility utility = new Utility();
	private JButton buyButton;
	private JButton myNumButton;
	private JButton makeLotteryButton;
	private JButton nextTurnButton;
	private WinningNumData winningNumData;
	private static Integer currentRound = 1;
	private JLabel[] lastWinningNums;
	private JLabel lastBonusNum;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		winningNumData = new WinningNumData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);

		// 이미지 아이콘을 사용하는 레이블 생성
		JLabel label = new JLabel(iconData.mainIcon());
		lastWinningNums = new JLabel[6];
		lastBonusNum = new JLabel(iconData.emptyIcon());

		btnBounds();

		// JLayeredPane 생성 및 설정
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(
				new Dimension(iconData.mainIcon().getIconWidth(), iconData.mainIcon().getIconHeight()));

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, iconData.mainIcon().getIconWidth(), iconData.mainIcon().getIconHeight());
		for (int i = 0; i < lastWinningNums.length; i++) {
			lastWinningNums[i] = new JLabel(iconData.emptyIcon());
			lastWinningNums[i].setBounds(33 + i * 50, 199, 40, 40);
		}
		lastBonusNum.setBounds(357, 199, 40, 40);

		// 레이블 및 버튼을 JLayeredPane에 추가
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
		layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(myNumButton, new Integer(2));
		layeredPane.add(makeLotteryButton, new Integer(2));
		layeredPane.add(nextTurnButton, new Integer(2));
		layeredPane.add(lastBonusNum, new Integer(2));
		for (int i = 0; i < lastWinningNums.length; i++) {
			layeredPane.add(lastWinningNums[i], new Integer(2));
		}

		btnUnVisuable();

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);

		buyButton.addActionListener(e -> {
			new BuyPage().setVisible(true); // pass this frame to the next one
		});

		myNumButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyNumCheckPage myNumCheckPage = new MyNumCheckPage();

				myNumCheckPage.setVisible(true);
			}
		});

		makeLotteryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentRound > winningNumData.getLastTurn()) {
					UnderLotteryPage underLotteryPage = new UnderLotteryPage();
					underLotteryPage.setVisible(true);
				} else {
					WinningNumPage winningNumPage = new WinningNumPage();
					winningNumPage.setVisible(true);
				}
			}
		});

		nextTurnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentRound++;
				System.out.println(currentRound);

			}
		});
		System.out.println(winningNumData);
		System.out.println(winningNumData.getLastTurn());
		System.out.println(winningNumData.getLastWinningNum());
		if (winningNumData.getLastWinningNum() != null) {
			showWinningNum();
		}

		pack();

	}
	private void showWinningNum() {
		System.out.println("진입");
		Collection<Integer> set = winningNumData.getLastWinningNum().getWinningNum();
		List<Integer> sortedList = new ArrayList<>(set);
		Collections.sort(sortedList);
		
		
		for (int i = 0; i < sortedList.size(); i++) {
		    int element = sortedList.get(i);
		    // 원하는 작업 수행
		    lastWinningNums[i].setIcon(iconData.LCIcons()[element]);
		    
		}
		lastBonusNum.setIcon(iconData.LCIcons()[winningNumData.getLastWinningNum().getBonusNum()]);
		
	}

	/**
	 * 버튼 안보이게 만듬
	 */
	private void btnUnVisuable() {

		utility.setButtonProperties(buyButton);
		utility.setButtonProperties(myNumButton);
		utility.setButtonProperties(makeLotteryButton);
		utility.setButtonProperties(nextTurnButton);
	}

	/**
	 * 버튼 크기 및 위치 조정
	 */
	private void btnBounds() {
		buyButton = new JButton(iconData.buyIcon());
		buyButton.setBounds(76, 610, 280, 81); // 위치와 크기 설정
		myNumButton = new JButton(iconData.myNumIcon());
		myNumButton.setBounds(30, 780, 111, 36);
		makeLotteryButton = new JButton(iconData.makeLotteryIcon());
		makeLotteryButton.setBounds(160, 780, 111, 36);
		nextTurnButton = new JButton(iconData.nextTurnIcon());
		nextTurnButton.setBounds(290, 780, 111, 36);
	}
}
