package Pages;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BuyLimitPage extends JDialog {
	private JButton returnBtn;
	private ImageIcon buyLimitPage;
	private ImageIcon returnIcon;
	private JLayeredPane layeredPane;
	private JLabel buyLimitPageLabel;
	private MainPage mainPage;
	/**
	 * Create the frame.
	 */

	public BuyLimitPage() {
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
	public JButton getBoughtBtn() {
		return returnBtn;
	}

	private void addLayeredPane1() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(430, 890));
	}

	private void addLayeredPane2() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(430, 890));
		layeredPane.add(buyLimitPageLabel, new Integer(1));
		layeredPane.add(returnBtn, new Integer(2));

	}

	private void iconSetting() {
		buyLimitPage = new ImageIcon(getClass().getClassLoader().getResource("buyLimit(BG).png"));
		returnIcon = new ImageIcon(getClass().getClassLoader().getResource("returnBtn.png"));
	}

	private void btnBounds() {
		buyLimitPageLabel = new JLabel(buyLimitPage);
		buyLimitPageLabel.setBounds(0, 0, buyLimitPage.getIconWidth(), buyLimitPage.getIconHeight());

		returnBtn = new JButton(returnIcon);
		returnBtn.setBounds(161, 458, 107, 41);

	}

	private void btnUnVisuable() {
		returnBtn.setOpaque(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.setBorderPainted(false);
	}
	public void name() {
		
	}
}


