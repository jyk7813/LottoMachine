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

import database.WinningNumData;

public class MainPage extends JFrame {


	private JButton buyButton;
	private JButton myNumButton;
	private JButton makeLotteryButton;
	private JButton nextTurnButton;
	private ImageIcon icon;
	private ImageIcon buyIcon;
	private ImageIcon myNumIcon;
	private ImageIcon makeLotteryIcon;
	private ImageIcon nextTurnIcon;
	private WinningNumData winningNumData = new WinningNumData();
	private static Integer currentRound = 1;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		iconSetting();
		
		// 이미지 아이콘을 사용하는 레이블 생성
		JLabel label = new JLabel(icon);
		
		btnBounds();
	
		// JLayeredPane 생성 및 설정
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		// 레이블 및 버튼을 JLayeredPane에 추가
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
		layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(myNumButton, new Integer(2));
		layeredPane.add(makeLotteryButton, new Integer(2));
		layeredPane.add(nextTurnButton, new Integer(2));
		
		btnUnVisuable();

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyPage buyPage = new BuyPage();
				buyPage.setVisible(true);
				
			}
		});
		
		makeLotteryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentRound > winningNumData.getLastTurn()) {
					
				} else {
					
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
		
		
		pack();

	}
	/**
	 * 아이콘값 세팅
	 */
	private void iconSetting() {
		
		icon = new ImageIcon(getClass().getClassLoader().getResource("main(BG).png"));
		buyIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBigBtn.png"));
		myNumIcon = new ImageIcon(getClass().getClassLoader().getResource("myNumBtn.png"));
		makeLotteryIcon = new ImageIcon(getClass().getClassLoader().getResource("lotteryBtn.png"));
		nextTurnIcon = new ImageIcon(getClass().getClassLoader().getResource("nextBtn.png"));
		
	}
	/**
	 * 버튼 안보이게 만듬
	 */
	private void btnUnVisuable() {
		
		buyButton.setOpaque(false);
		buyButton.setContentAreaFilled(false);
		buyButton.setBorderPainted(false);
		myNumButton.setOpaque(false);
		myNumButton.setContentAreaFilled(false);
		myNumButton.setBorderPainted(false);
		makeLotteryButton.setOpaque(false);
		makeLotteryButton.setContentAreaFilled(false);
		makeLotteryButton.setBorderPainted(false);
		nextTurnButton.setOpaque(false);
		nextTurnButton.setContentAreaFilled(false);
		nextTurnButton.setBorderPainted(false);
	}
	/**
	 * 버튼 크기 및 위치 조정
	 */
	private void btnBounds() {
		buyButton = new JButton(buyIcon);
		buyButton.setBounds(76, 610, 280, 81); // 위치와 크기 설정
		myNumButton = new JButton(myNumIcon);
		myNumButton.setBounds(30, 780, 111, 36);
		makeLotteryButton = new JButton(makeLotteryIcon);
		makeLotteryButton.setBounds(160, 780, 111, 36);
		nextTurnButton = new JButton(nextTurnIcon);
		nextTurnButton.setBounds(290, 780, 111, 36);
	}
}
