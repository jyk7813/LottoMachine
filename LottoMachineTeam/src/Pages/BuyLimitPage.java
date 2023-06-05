package Pages;


import java.awt.Color;
import java.awt.Component;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

import utility.FontData;
import utility.Utility;

public class BuyLimitPage extends JDialog {
	private JButton returnBtn;
	private ImageIcon buyLimitPage;
	private ImageIcon returnIcon;
	private JLayeredPane layeredPane;
	private JLabel buyLimitPageLabel;
	private Utility utility = new Utility();
	private JLabel buyLimitLabel;
	private FontData fontData = new FontData();
	
	/**
	 * Create the frame.
	 */	
	public BuyLimitPage() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		
		Font customFont = fontData.nanumFont38();
		Color customColor = Color.WHITE;
		
		buyLimitLabel = new JLabel("회차 당 구매제한");
		buyLimitLabel.setBounds(72, 312, 300, 80);
		buyLimitLabel.setFont(customFont);
		buyLimitLabel.setForeground(customColor);
		buyLimitLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		// 이미지 아이콘 로드
		iconSetting();

		// 이미지 아이콘 생성 및 크기위치 설정
		btnBounds();

		// JLayeredPane 생성 및 설정
		addLayeredPane1();
		addLayeredPane2();

		// 버튼 숨기기
		utility.setButtonProperties(returnBtn);

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
		layeredPane.add(buyLimitLabel, new Integer(2));
		layeredPane.add(returnBtn, new Integer(2));
		

	}

	private void iconSetting() {
		buyLimitPage = new ImageIcon(getClass().getClassLoader().getResource("buyLimit.png"));
		returnIcon = new ImageIcon(getClass().getClassLoader().getResource("returnBtn.png"));
	}

	private void btnBounds() {
		buyLimitPageLabel = new JLabel(buyLimitPage);
		buyLimitPageLabel.setBounds(0, 0, buyLimitPage.getIconWidth(), buyLimitPage.getIconHeight());

		returnBtn = new JButton(returnIcon);
		returnBtn.setBounds(161, 458, 107, 41);

	}
}


