package Pages;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.SelectNum;

public class MyNumCheckPage extends JFrame {

    private JPanel contentPane;
	private JLayeredPane layeredPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyNumCheckPage frame = new MyNumCheckPage();
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
    public MyNumCheckPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // 창 크기 변경을 비활성화

        // 이미지 아이콘 로드
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("winningNum(BG).png"));;
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));;
        ImageIcon bNumber = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));;
        ImageIcon sNumber = new ImageIcon(getClass().getClassLoader().getResource("emptySBtn.png"));;
        ImageIcon lBtn = new ImageIcon(getClass().getClassLoader().getResource("emptyLBtn.png"));;

        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon);
        
        JLabel[][] lottoNum = new JLabel[8][10];
        JLabel[][] lottoNum2 = new JLabel[8][10];
        JLabel[] lottoAuto = new JLabel[10];
        JLabel[] winnerNum = new JLabel[10];
        
        JLabel bonusNum = new JLabel(bNumber);
        bonusNum.setBounds(357, 225, 40, 40);
        
        
        
        Map<Integer, SelectNum> map;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        
        int[] arr = new int[6];
        
        	for (int j = 0; j < 10; j++) {
        		for (int i = 0; i < 7; i++) {
        			if(i == 0) {
        				lottoNum[i][j] = new JLabel();
        				
        			} else {
        				lottoNum[i][j] = new JLabel(sNumber);
        			}
        			
        			lottoNum[i][j].setBounds(28 + i * 44, 340 + j * 50, 36, 36);
        			layeredPane.add(lottoNum[i][j], new Integer(2));	
        		}
        	}
        	
        	for (int i = 0; i < 10; i++) {
        		lottoAuto[i]= new JLabel(lBtn);
        		lottoAuto[i].setBounds(337, 340 + i * 50, 52, 36);
        		layeredPane.add(lottoAuto[i], new Integer(2));
        	}
        	
        	for (int i = 0; i < 6; i++) {
        		winnerNum[i]= new JLabel(bNumber);
        		winnerNum[i].setBounds(33 + (i * 50), 225, 40, 40);
        		layeredPane.add(winnerNum[i], new Integer(2));
        	}
        	
        	
        	
        	
        
        // 버튼 생성
        JButton backBtn = new JButton(backIcon);
        backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정


        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(bonusNum, new Integer(2));
        
        
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        pack();
        
        backBtn.setOpaque(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
    }
}
