// 해야할 것
// 언더로터리에서 숫자 다 만들어지면 바로 위닝넘 페이지로 넘겨주기
// 넘겨주는 과정에서 셋을 리스트로 바꾼다음 위닝넘으로 넘겨줘야 한다.
// 맵에 넘기면은 숫자 체크를 할 수 있도록 맵 키를 만들고 (보너스넘이랑 리스트랑 맵에 넘겨줘야한다)

package Pages;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import utility.IconData;
import utility.Utility;

public class WinningNumPage extends JDialog {
	private IconData icon = new IconData();
	private JLayeredPane layeredPane;
	private Utility utility = new Utility();
	private MainPage mainPage;
	private JLabel label;
	private JLabel[][] lottoNums;
	private JLabel[] lottoAutos;
	private JLabel[] winnerNums;
	private JLabel bonusNum;
	private JButton backBtn;
	


  
    /**
     * Create the frame.
     */
    public WinningNumPage() {
    	
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화

		label = new JLabel(icon.winningNumIcon());
        
        lottoNums = new JLabel[8][10];
        lottoAutos = new JLabel[10];
        winnerNums = new JLabel[10];
        
        bonusNum = new JLabel(icon.emptyBtn());
        bonusNum.setBounds(357, 225, 40, 40);
        
        
        
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight()));
        
        
        	for (int j = 0; j < 10; j++) {
        		for (int i = 0; i < 7; i++) {
        			if(i == 0) {
        				lottoNums[i][j] = new JLabel();
        				
        			} else {
        				lottoNums[i][j] = new JLabel();
        			}
        			
        			lottoNums[i][j].setBounds(28 + i * 44, 340 + j * 50, 36, 36);
        			layeredPane.add(lottoNums[i][j], new Integer(2));	
        		}
        	}
        	
        	for (int i = 0; i < 10; i++) {
        		lottoAutos[i]= new JLabel(icon.emptyLBtn());
        		lottoAutos[i].setBounds(337, 340 + i * 50, 52, 36);
        		layeredPane.add(lottoAutos[i], new Integer(2));
        	}
        	
        	for (int i = 0; i < 6; i++) {
        		winnerNums[i]= new JLabel();
        		winnerNums[i].setBounds(33 + (i * 50), 225, 40, 40);
        		layeredPane.add(winnerNums[i], new Integer(2));
        	}
        
        backBtn = new JButton(icon.backIcon());
        backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정


        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(bonusNum, new Integer(2));
        
        
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        showWinningNum();
        
        backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
        pack();
        
        utility.setButtonProperties(backBtn);
        
        
    }
    private void showWinningNum() {
		System.out.println("진입");
		Collection<Integer> set = mainPage.WINNING_NUM_DATA.getLastWinningNum().getWinningNum();
		List<Integer> sortedList = new ArrayList<>(set);
		Collections.sort(sortedList);
		System.out.println(sortedList);
		
		for (int i = 0; i < sortedList.size(); i++) {
		    int element = sortedList.get(i);
		    winnerNums[i].setIcon(icon.LCIcons()[element]);
		}
		bonusNum.setIcon(icon.LCIcons()[mainPage.WINNING_NUM_DATA.getLastWinningNum().getBonusNum()]);
		
	}
   
}