package Pages;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BuyCheckPage extends JFrame {
	private JButton backBtn;
	private JButton yesBtn;
	private JButton noBtn;
	private ImageIcon buyCheckPage;
	private ImageIcon backIcon;
	private ImageIcon yesIcon;
	private ImageIcon noIcon;
	private JLabel buyCheckPageLabel;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyCheckPage frame = new BuyCheckPage();
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
	public BuyCheckPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 932); // 창의 크기를 설정
		setResizable(false); // 창 크기 변경을 비활성화

		// 이미지 아이콘 로드
		iconSettingBuyCheckPage();

		// JLayeredPane 생성 및 설정
		addLayeredPane(); // JLayeredPane의 크기 설정

		// 레이블 및 버튼 위치 설정
		btnBoundsBuy();
		// 레이블 및 버튼을 JLayeredPane에 추가
		addJLabelAndBtnInPane();

		btnUnVisuableBuyCheckPage();
		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
	}

	// 페이지라벨과 버튼 Pane에 추가
	private void addJLabelAndBtnInPane() {
		layeredPane.add(buyCheckPageLabel, new Integer(1));
		layeredPane.add(backBtn, new Integer(2));
		layeredPane.add(yesBtn, new Integer(3));
		layeredPane.add(noBtn, new Integer(4));
	}

	private void iconSettingBuyCheckPage() {
		buyCheckPage = new ImageIcon(getClass().getClassLoader().getResource("buycheck(BG).png"));
		backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
		yesIcon = new ImageIcon(getClass().getClassLoader().getResource("yesBtn.png"));
		noIcon = new ImageIcon(getClass().getClassLoader().getResource("noBtn.png"));

	}

	private void btnBoundsBuy() {
		buyCheckPageLabel = new JLabel(buyCheckPage);
		buyCheckPageLabel.setBounds(0, 0, buyCheckPage.getIconWidth(), buyCheckPage.getIconHeight());

		backBtn = new JButton(backIcon);
		backBtn.setBounds(19, 41, 33, 38);

		yesBtn = new JButton(yesIcon);
		yesBtn.setBounds(94, 459, 107, 41);

		noBtn = new JButton(noIcon);
		noBtn.setBounds(229, 459, 107, 41);

	}

	private void btnUnVisuableBuyCheckPage() {
		backBtn.setOpaque(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setBorderPainted(false);

		yesBtn.setOpaque(false);
		yesBtn.setContentAreaFilled(false);
		yesBtn.setBorderPainted(false);

		noBtn.setOpaque(false);
		noBtn.setContentAreaFilled(false);
		noBtn.setBorderPainted(false);
	}

	private void addLayeredPane() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(430, 890));
	}
}
