package Pages;
import java.awt.Dimension;


import database.SelectNum;
import database.SelectNumHashMap;

import java.awt.EventQueue;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {

    private JPanel contentPane;
    SelectNumHashMap selectNumHashMap = new SelectNumHashMap();
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SelectNumPage frame = new SelectNumPage();
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
    public Test() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 890); // 창의 크기를 설정
        setResizable(false); // 창 크기 변경을 비활성화

      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        int[] intarr = {1, 55, 33, 28, 6, 19};
        SelectNum selNum = new SelectNum(intarr, 1);
        selectNumHashMap.addMap(1, selNum);
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // 이미지 아이콘 로드
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("selectNum(BG).png"));
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
        ImageIcon buyIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
        ImageIcon numIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
        
        

        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon);
        
        
        
        

        // 버튼 생성
        JButton backButton = new JButton(backIcon);
        backButton.setBounds(20, 41, 33, 38); // 위치와 크기 설정
        JButton buyButton = new JButton(buyIcon);
        buyButton.setBounds(89, 812, 251, 41); // 위치와 크기 설정

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(430, 890)); // JLayeredPane의 크기 설정

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        

        // 레이블 및 버튼을 JLayeredPane에 추가
        JLabel[][] numLabel = new JLabel[7][10];
        JLabel[][] numLabel2 = new JLabel[7][10];
        Map<Integer, SelectNum> map;
        SelectNum selectNum;
        int[] arr;
            for (int j = 0; j < 10; j++) {
            	map = selectNumHashMap.getSelectNumHashMap();
            	for (int i = 0; i < 7; i++) {
            	if (i == 0) {
            		  numLabel[i][j] = new JLabel();
				} else {
					  numLabel[i][j] = new JLabel(numIcon);
				}
                
                numLabel[i][j].setBounds(20 + i * 55, 115 + j * 71, 40, 40);
                
                numLabel2[i][j] = new JLabel();
                numLabel2[i][j].setBounds(33 + i * 55, 115 + j * 71, 40, 40);
                if (i == 0) {
          		  	numLabel2[i][j].setText(Integer.toString(j + 1));
				} else {
					if (map.size() > 0) {
						selectNum = map.get(j + 1);
						arr = selectNum.getSelectNum();
						numLabel2[i][j].setText(Integer.toString(arr[i - 1]));						
					}
				}
                layeredPane.add(numLabel2[i][j], new Integer(1));
                layeredPane.add(numLabel[i][j], new Integer(1));
            }
        }
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        // 버튼숨기기
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(true);
        buyButton.setOpaque(false);
        buyButton.setContentAreaFilled(false);
        buyButton.setBorderPainted(true);
        
       

       
    }
}