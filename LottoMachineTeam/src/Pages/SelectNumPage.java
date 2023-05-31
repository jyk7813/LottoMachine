package Pages;
import java.awt.Container;

import java.awt.Dimension;

import database.SelectNum;
import database.SelectNumData;
import jdk.nashorn.internal.ir.WhileNode;
import utility.IconData;
import utility.Utility;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectNumPage extends JDialog {

    SelectNumData selectNumHashMap = new SelectNumData();
	private JLabel[][] numLabels;
    private Utility utility = new Utility();
	private JLabel[] keyLabels;
	private int isAuto;
	public static final int AUTO = 1;
	public static final int SEMIAUTO = 2;
	public static final int MANUAL = 3;
	
	
   
    /**
     * Create the frame.
     */
    public SelectNumPage() {
    	
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화
        
        // 이미지 아이콘 로드
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("selectNum(BG).png"));
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
        ImageIcon buyIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
        ImageIcon numIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
        ImageIcon cancleBtn = new ImageIcon(getClass().getClassLoader().getResource("cancleBtn.png"));
        
        numLabels = new JLabel[6][10];
        keyLabels = new JLabel[10];
        JButton[] cancelButton = new JButton[10];
        Map<Integer, SelectNum> map;
        map = selectNumHashMap.getSelectNumHashMap();
        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon); // 배경 Label
        
        for (int i = 0; i < numLabels.length; i++) { // 로또 번호 저장 Label
			for (int j = 0; j < numLabels[i].length; j++) {
				numLabels[i][j] = new JLabel(numIcon);
			}
		}
        
        for (int i = 0; i < keyLabels.length; i++) { // key 저장 Label
			keyLabels[i] = new JLabel();
			
		}

        // 버튼 생성
        JButton backButton = new JButton(backIcon);
        backButton.setBounds(20, 41, 33, 38); // 위치와 크기 설정
       
        JButton buyButton = new JButton(buyIcon);
        buyButton.setBounds(90, 815, 251, 41); // 위치와 크기 설정
        
        for (int i = 0; i < cancelButton.length; i++) {
			cancelButton[i] = new JButton(cancleBtn);
		}
        
        for (int i = 0; i < cancelButton.length; i++) {
        	cancelButton[i].setBounds(356, 119 + i * 70, 52, 36);
		}

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(430, 890)); // JLayeredPane의 크기 설정

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 배경 위치
        
        for (int i = 0; i < numLabels.length; i++) { // 로또 번호 저장소 위치
			for (int j = 0; j < numLabels[i].length; j++) {
				numLabels[i][j].setBounds(52 + i * 50, 117 + j * 70, 40, 40);
			}
		}

        for (int i = 0; i < numLabels.length; i++) { 
			for (int j = 0; j < numLabels[i].length; j++) {
				layeredPane.add(numLabels[i][j], new Integer(2)); // 레이블은 앞쪽에 레이어에 추가 
			}
		}
        
        for (int i = 0; i < keyLabels.length; i++) {
			keyLabels[i].setBounds(10, 117 + i * 70, 40, 40);
		}
        
        for (int i = 0; i < keyLabels.length; i++) {
			layeredPane.add(keyLabels[i], new Integer(2));
		}
        
        for (int i = 0; i < cancelButton.length; i++) {
        	layeredPane.add(cancelButton[i], new Integer(2));
		}
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        // 버튼숨기기
        utility.setButtonProperties(backButton);
        utility.setButtonProperties(buyButton);
        for (int i = 0; i < cancelButton.length; i++) {
        	utility.setButtonProperties(cancelButton[i]);
		}
        
        // 버튼 ActionListener
        for (int i = 0; i < cancelButton.length; i++) {
            final int index = i; // ActionListener 내에서 사용하기 위한 인덱스 변수

            cancelButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("이벤트 발생" + index);
                    map.clear();
                }
            });
        }
        
        backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 dispose();
				  BuyPage buyPage = new BuyPage();
				  buyPage.setVisible(true);
				  buyPage.setAlwaysOnTop(true);
				
			}
		});
        
        buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCheckPage buyCheckPage = new BuyCheckPage();
				dispose();
				
				buyCheckPage.setAlwaysOnTop(true);
				buyCheckPage.setVisible(true);
				
			}
		});
        pack(); 
        
		// 저장되는 곳
		List<Integer> selList = new ArrayList<>();
		while (selList.size() < 6) {
			
			
		}
    }
    
    // 자동 여부
    public int autoStat() {
    	if (isAuto == AUTO) return AUTO;
    	if (isAuto == SEMIAUTO) return SEMIAUTO; 
    	if (isAuto == MANUAL) return MANUAL;
    	return -1;
	}    
}
