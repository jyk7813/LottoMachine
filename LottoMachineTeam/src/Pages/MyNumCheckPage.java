package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import database.SelectNum;
import database.SelectNumMap;
import utility.IconData;
import utility.Utility;

public class MyNumCheckPage extends JDialog{
	private IconData icon = new IconData();
	private JLayeredPane layeredPane; 
	private LinkedHashMap<Integer, SelectNum> map = new LinkedHashMap<>();
	private SelectNumMap selectNum = new SelectNumMap();
	private SelectNum nums;
	private Collection<Integer> selecteNums;
	java.util.List<Integer> number;
	private Utility utility = new Utility();
	
	
    /**
     * Create the frame.
     */
    public MyNumCheckPage() {
    	
    	selecteNums = nums.getSelectNum();
    	

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화

        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon.myNumCheckIcon());
        
        JLabel[][] lottoNum = new JLabel[8][10];
        JLabel[][] lottoNum2 = new JLabel[8][10];
        JLabel[] lottoAuto = new JLabel[10];
        JLabel[] winnerNum = new JLabel[10];
        
        JLabel bonusNum = new JLabel(icon.emptyBtn());
        bonusNum.setBounds(357, 225, 40, 40);
        
        
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight()));
        
        int[] arr = new int[6];
        
        	for (int j = 0; j < 10; j++) {
        		for (int i = 0; i < 7; i++) {
        			if(i == 0) {
        				lottoNum[i][j] = new JLabel();
        				
        			} else {
        				lottoNum[i][j] = new JLabel(icon.emptySBtn());
        				if(j == 0) {
        				//SelectNumMap 에 저장된 번호들만 이미지가 저장됩니다
        					map = selectNum.getSelectNumMap();
                	    	for (int k = 0; i < map.size(); k++) {
                	    		SelectNum value = map.get(k);
                	    		for(Integer number : value.getSelectNum()) {
                	    			if(number == (i - 1)) {
//                	    				lottoNum[i][j].setIcon(icon.LCIcons[]); //icon 은 변경할 이미지파일을 넣으면 됩니다.
//                	    				//이제 icon데이터베이스에 LC파일명들을 반복순환하며 파일명들을 변경하면 됩니다. 아마도?..ㅈㅅ
                	    				break;
                	    				
                	    			}
                	    			
                	    		}
                	    			
                	    	}
        				}
        				
        			}
        			
        			lottoNum[i][j].setBounds(28 + i * 44, 340 + j * 50, 36, 36);
        			layeredPane.add(lottoNum[i][j], new Integer(2));
        			
        				
        			
        	
        		
        		} 
        	}
        	//자동 반자동 수동
        	for (int i = 0; i < 10; i++) {
        		lottoAuto[i]= new JLabel(icon.emptyLBtn());
        		lottoAuto[i].setBounds(337, 340 + i * 50, 52, 36);
        		layeredPane.add(lottoAuto[i], new Integer(2));
        	}
        	//당첨된 번호
        	for (int i = 0; i < 6; i++) {
        		winnerNum[i]= new JLabel(icon.emptyBtn());
        		winnerNum[i].setBounds(33 + (i * 50), 225, 40, 40);
        		layeredPane.add(winnerNum[i], new Integer(2));
        	}
        	
        	
        	
        
        // 버튼 생성
        JButton backBtn = new JButton(icon.backIcon());
        backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정


        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(bonusNum, new Integer(2));
        
        
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        pack();
        
        backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        utility.setButtonProperties(backBtn);
        
    }
   
}
