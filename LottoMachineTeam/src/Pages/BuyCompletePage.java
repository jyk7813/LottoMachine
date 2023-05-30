package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BuyCompletePage extends JDialog {
	private JButton returnBtn;
	private ImageIcon buyCompletePage;
	private ImageIcon returnIcon;
	private JLayeredPane layeredPane;
	private JLabel buyCompletePageLabel;
	private MainPage mainPage;
	/**
	 * Create the frame.
	 */
	public BuyCompletePage() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		// 이미지 아이콘 로드
		iconSetting();

		// 이미지 아이콘 생성 및 크기위치 설정
		btnBounds();

		// JLayeredPane 생성 및 설정
		addLayeredPane1();
		addLayeredPane2();

		// 버튼 숨기기
		btnUnVisuable();

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
		returnBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			    dispose();
			}
		});
		pack();
	}

	private void addLayeredPane1() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(430, 890));
	}

	private void addLayeredPane2() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(430, 890));
		layeredPane.add(buyCompletePageLabel, new Integer(1));
		layeredPane.add(returnBtn, new Integer(2));

	}

	private void iconSetting() {
		buyCompletePage = new ImageIcon(getClass().getClassLoader().getResource("buyComplete(BG).png"));
		returnIcon = new ImageIcon(getClass().getClassLoader().getResource("returnBtn.png"));
	}

	private void btnBounds() {
		buyCompletePageLabel = new JLabel(buyCompletePage);
		buyCompletePageLabel.setBounds(0, 0, buyCompletePage.getIconWidth(), buyCompletePage.getIconHeight());

		returnBtn = new JButton(returnIcon);
		returnBtn.setBounds(161, 458, 107, 41);

	}

	private void btnUnVisuable() {
		returnBtn.setOpaque(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.setBorderPainted(false);
	}
}
